package service.student;

import model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {
    void insertStudent(Student student) throws SQLException;
    Student selectStudent(String id);
    List<Student> selectAllStudent();
    void deleteStudent(String id) throws SQLException;
    void updateStudent(String id) throws SQLException;
}
