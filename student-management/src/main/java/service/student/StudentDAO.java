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
    private static final String INSERT_STUDENT_SQL = "insert into student(id, nameStudent, dayofbirth, address, id_class) value (?, ?, ?, ?, ?);";
    private static final String SELECT_STUDENT_BY_ID_SQL = "select s.id, s.nameStudent, s.dayofbirth, s.address, c.nameClass \n" +
            "from student s join class c on s.id_class = c.id\n" +
            "where s.id = ?;";
    private static final String SELECT_ALL_STUDENT = "SELECT s.id, \n" +
            "       s.nameStudent, \n" +
            "       c.nameClass, \n" +
            "       su.nameSubject, \n" +
            "       ROUND((p.testMark + p.testMark15 + p.testMark60 + p.midterm * 2 + p.final * 3) / 8, 2) AS 'avgPoint'\n" +
            "FROM student s \n" +
            "JOIN pointStudent p ON s.id = p.id_student\n" +
            "JOIN class c ON s.id_class = c.id\n" +
            "JOIN subject su ON p.id_subject = su.id;";
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
        List<Student> students = new ArrayList<>();

        try {
            PreparedStatement statement = c.prepareStatement(SELECT_ALL_STUDENT);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String nameStudent = resultSet.getString("nameStudent");
                String nameClass = resultSet.getString("nameClass");
                String nameSubject = resultSet.getString("nameSubject");
                float avgPoint = resultSet.getFloat("avgPoint");
                students.add(new Student(id, nameStudent, nameClass, nameSubject, avgPoint));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public void deleteStudent(String id) throws SQLException {

    }

    @Override
    public void updateStudent(String id) throws SQLException {

    }
}
