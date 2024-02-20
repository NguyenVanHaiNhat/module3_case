package service.student;

import config.ConnectionDB;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDAO implements IStudentDAO{
    private static final String INSERT_STUDENT_SQL = "insert into student(id, nameStudent, dayofbirth, address, id_class) value (?, ?, ?, ?, ?);";
    private static final String SELECT_STUDENT_BY_ID_SQL = "select s.id, s.nameStudent, s.dayofbirth, s.address, c.nameClass \n" +
            "from student s join class c on s.id_class = c.id\n" +
            "where s.id = ?;";
    Connection c = ConnectionDB.getConnection();
    public StudentDAO() {
    }

    @Override
    public void insertStudent(Student student) {
        System.out.println(INSERT_STUDENT_SQL);
        try {
            PreparedStatement statement = c.prepareStatement(INSERT_STUDENT_SQL);
            statement.setString(1, student.getId());
            statement.setString(2, student.getNameStudent());
            statement.setString(3, student.getDayOfBirth());
            statement.setString(4, student.getAddress());
            statement.setInt(5, student.getId_class());
            statement.executeUpdate();
        } catch (SQLException e){
            e.getMessage();
        }
    }

    @Override
    public Student selectStudent(String id) {
        Student student = null;
        try {
            PreparedStatement statement = c.prepareStatement(SELECT_STUDENT_BY_ID_SQL);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                student = new Student();
                student.setId(resultSet.getString("id"));
                student.setNameStudent(resultSet.getString("nameStudent"));
                student.setDayOfBirth(resultSet.getString("dayofbirth"));
                student.setAddress(resultSet.getString("address"));
                student.setNameClass(resultSet.getString("nameClass"));
            }
        } catch (SQLException e){
            e.getMessage();
        }
        return student;
    }

    @Override
    public List<Student> selectAllStudent() {
        return null;
    }

    @Override
    public void deleteStudent(String id) throws SQLException {

    }

    @Override
    public void updateStudent(String id) throws SQLException {

    }
}
