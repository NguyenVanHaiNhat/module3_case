package service.student;

import config.ConnectionDB;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO{
    private static final String INSERT_STUDENT_SQL = "insert into student"+ "(id, nameStudent, dayofbirth, address, id_class) value" +
            " (?, ?, ?, ?, ?);";
    private static final String SELECT_STUDENT_BY_ID_SQL = "select s.id, s.nameStudent, s.dayofbirth, s.address, c.nameClass \n" +
            "from student s join class c on s.id_class = c.id\n" +
            "where s.id = ?;";
    private static final String DELETE_STUDENT_SQL = "delete from student where id = ?";
    private static final String UPDATE_STUDENT_SQL = "update student set nameStudent = ?, dayofbirth = ?, address = ?, id_class = ? where id = ?";
    private static final String SELECT_ALL_STUDENTS_SQL = "select s.id, s.nameStudent, s.dayofbirth, s.address, c.nameClass\n" +
            "from student s join class c on s.id_class = c.id;";
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
            statement.setString(5, student.getNameClass());
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
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement statement = c.prepareStatement(SELECT_ALL_STUDENTS_SQL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getString("id"));
                student.setNameStudent(resultSet.getString("nameStudent"));
                student.setDayOfBirth(resultSet.getString("dayofbirth"));
                student.setAddress(resultSet.getString("address"));
                student.setNameClass(resultSet.getString("nameClass"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void deleteStudent(String id) throws SQLException {
        boolean rowDeteted;
            PreparedStatement statement = c.prepareStatement(DELETE_STUDENT_SQL);
            statement.setString(1, id);
            rowDeteted = statement.executeUpdate() > 0;
    }

    @Override
    public void updateStudent(Student student) throws SQLException {
        boolean rowUpdated;
        PreparedStatement statement = c.prepareStatement(UPDATE_STUDENT_SQL);
        statement.setString(1, student.getNameStudent());
        statement.setString(2, student.getDayOfBirth());
        statement.setString(3, student.getAddress());
        statement.setInt(4, student.getId_class());
        statement.setString(5, student.getId());

        rowUpdated = statement.executeUpdate() > 0;
    }
}
