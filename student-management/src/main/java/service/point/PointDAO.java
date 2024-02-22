package service.point;

import config.ConnectionDB;
import dto.PointDTO;
import model.Point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PointDAO implements IPointDAO {
    private static final String SELECT_ALL_STUDENT_POINT = "SELECT s.id, \n" +
            "\t\tsu.id as 'id_subject',\n" +
            "       s.nameStudent, \n" +
            "       su.nameSubject,\n" +
            "       p.testMark,\n" +
            "       p.testMark15,\n" +
            "       p.testMark60,\n" +
            "       p.midterm,\n" +
            "       p.final,\n" +
            "       ROUND((p.testMark + p.testMark15 + p.testMark60 + p.midterm * 2 + p.final * 3) / 8, 2) AS 'avgPoint'\n" +
            "FROM student s \n" +
            "JOIN pointStudent p ON s.id = p.id_student\n" +
            "JOIN subject su ON p.id_subject = su.id;";
    private static final String SELECT_POINT_STUDENT_BY_ID = "select s.id, su.id as 'id_subject', p.testMark, p.testMark15, p.testMark60, p.midterm, p.final\n" +
            "from pointStudent p join student s on p.id_student = s.id\n" +
            "join subject su on p.id_subject = su.id\n" +
            "where s.id = ? and su.id = ?;";
    private static final String INSERT_POINT = "insert into pointStudent (id_student, id_subject, testMark, testMark15, testMark60, midterm, final) " +
            "value (?, ?, ?, ?, ?, ?, ?);";
    private static final String DELETE_POINT = "delete from pointStudent where id_student = ? and id_subject = ?;\n";
    private static final String UPDATE_POINT = "update pointStudent set testMark = ?, testMark15 = ?, testMark60 = ?, midterm = ?, final = ? where id_student = ? and id_subject = ?;\n";
    private static final String SORT_BY_POINT = "SELECT s.id, \n" +
            "\t\tsu.id as 'id_subject',\n" +
            "       s.nameStudent, \n" +
            "       su.nameSubject,\n" +
            "       p.testMark,\n" +
            "       p.testMark15,\n" +
            "       p.testMark60,\n" +
            "       p.midterm,\n" +
            "       p.final,\n" +
            "       ROUND((p.testMark + p.testMark15 + p.testMark60 + p.midterm * 2 + p.final * 3) / 8, 2) AS 'avgPoint'\n" +
            "FROM student s \n" +
            "JOIN pointStudent p ON s.id = p.id_student\n" +
            "JOIN subject su ON p.id_subject = su.id\n" +
            "order by avgPoint desc;";
    private static final String SEARCH_BY_NAME = "SELECT s.id, \n" +
            "\t\tsu.id as 'id_subject',\n" +
            "       s.nameStudent, \n" +
            "       su.nameSubject,\n" +
            "       p.testMark,\n" +
            "       p.testMark15,\n" +
            "       p.testMark60,\n" +
            "       p.midterm,\n" +
            "       p.final,\n" +
            "       ROUND((p.testMark + p.testMark15 + p.testMark60 + p.midterm * 2 + p.final * 3) / 8, 2) AS 'avgPoint'\n" +
            "FROM student s \n" +
            "JOIN pointStudent p ON s.id = p.id_student\n" +
            "JOIN subject su ON p.id_subject = su.id\n" +
            "where s.nameStudent like ?;";
    public PointDAO() {
    }

    Connection c = ConnectionDB.getConnection();
    @Override
    public void insertPoint(Point point) {
        try {
            PreparedStatement statement = c.prepareStatement(INSERT_POINT);
            statement.setString(1, point.getId_student());
            statement.setInt(2, point.getId_subject());
            statement.setFloat(3, point.getTestMark());
            statement.setFloat(4, point.getTestMark15());
            statement.setFloat(5, point.getTestMark60());
            statement.setFloat(6, point.getMidterm());
            statement.setFloat(7, point.getFinalExam());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Point selectPoint(String id_student, int id_subject) {
        Point point = null;
        try {
            PreparedStatement statement = c.prepareStatement(SELECT_POINT_STUDENT_BY_ID);
            statement.setString(1, id_student);
            statement.setInt(2, id_subject);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String id_studentt = resultSet.getString("id");
                int id_subjectt = resultSet.getInt("id_subject");
                float testMark = resultSet.getFloat("testMark");
                float testMark15 = resultSet.getFloat("testMark15");
                float testMark60 = resultSet.getFloat("testMark60");
                float midterm = resultSet.getFloat("midterm");
                float finalExam = resultSet.getFloat("final");
                point = new Point(id_studentt, id_subjectt, testMark, testMark15, testMark60, midterm, finalExam);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return point;
    }

    @Override
    public List<PointDTO> findPointAll() {
        List<PointDTO> pointDTOS = new ArrayList<>();
        try {
            PreparedStatement statement = c.prepareStatement(SELECT_ALL_STUDENT_POINT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("id");
                int id_subject = resultSet.getInt("id_subject");
                String nameStudent = resultSet.getString("nameStudent");
                String nameSubject = resultSet.getString("nameSubject");
                float testMark = Float.parseFloat(resultSet.getString("testMark"));
                float testMark15 = Float.parseFloat(resultSet.getString("testMark15"));
                float testMark60 = Float.parseFloat(resultSet.getString("testMark60"));
                float midterm = Float.parseFloat(resultSet.getString("midterm"));
                float finalExam = Float.parseFloat(resultSet.getString("final"));
                float avgPoint = Float.parseFloat(resultSet.getString("avgPoint"));
                PointDTO pointDTO = new PointDTO(id, id_subject, nameStudent, nameSubject, testMark, testMark15, testMark60, midterm, finalExam, avgPoint);
                pointDTOS.add(pointDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pointDTOS;
    }

    @Override
    public List<PointDTO> sortByPoint() {
        List<PointDTO> pointDTOS = new ArrayList<>();
        try {
            PreparedStatement statement = c.prepareStatement(SORT_BY_POINT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("id");
                int id_subject = resultSet.getInt("id_subject");
                String nameStudent = resultSet.getString("nameStudent");
                String nameSubject = resultSet.getString("nameSubject");
                float testMark = Float.parseFloat(resultSet.getString("testMark"));
                float testMark15 = Float.parseFloat(resultSet.getString("testMark15"));
                float testMark60 = Float.parseFloat(resultSet.getString("testMark60"));
                float midterm = Float.parseFloat(resultSet.getString("midterm"));
                float finalExam = Float.parseFloat(resultSet.getString("final"));
                float avgPoint = Float.parseFloat(resultSet.getString("avgPoint"));
                PointDTO pointDTO = new PointDTO(id, id_subject, nameStudent, nameSubject, testMark, testMark15, testMark60, midterm, finalExam, avgPoint);
                pointDTOS.add(pointDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pointDTOS;
    }

    @Override
    public List<PointDTO> searchByName(String nameStudent) {
        List<PointDTO> pointDTOS = new ArrayList<>();
        try {
            PreparedStatement statement = c.prepareStatement(SEARCH_BY_NAME);
            statement.setString(1, "%" + nameStudent + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("id");
                int id_subject = resultSet.getInt("id_subject");
                String nameStudent1 = resultSet.getString("nameStudent");
                String nameSubject = resultSet.getString("nameSubject");
                float testMark = Float.parseFloat(resultSet.getString("testMark"));
                float testMark15 = Float.parseFloat(resultSet.getString("testMark15"));
                float testMark60 = Float.parseFloat(resultSet.getString("testMark60"));
                float midterm = Float.parseFloat(resultSet.getString("midterm"));
                float finalExam = Float.parseFloat(resultSet.getString("final"));
                float avgPoint = Float.parseFloat(resultSet.getString("avgPoint"));
                PointDTO pointDTO = new PointDTO(id, id_subject, nameStudent1, nameSubject, testMark, testMark15, testMark60, midterm, finalExam, avgPoint);
                pointDTOS.add(pointDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pointDTOS;
    }

    @Override
    public void deletePoint(String id_student, int id_subject) throws SQLException {
        PreparedStatement statement = c.prepareStatement(DELETE_POINT);
        statement.setString(1, id_student);
        statement.setInt(2, id_subject);
        statement.executeUpdate();
    }

    @Override
    public void updatePoint(Point point) throws SQLException {
        PreparedStatement statement = c.prepareStatement(UPDATE_POINT);
        statement.setFloat(1, point.getTestMark());
        statement.setFloat(2, point.getTestMark15());
        statement.setFloat(3, point.getTestMark60());
        statement.setFloat(4, point.getMidterm());
        statement.setFloat(5, point.getFinalExam());
        statement.setString(6, point.getId_student());
        statement.setInt(7, point.getId_subject());
        statement.executeUpdate();
    }
}
