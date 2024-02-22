package service.point;

import dto.PointDTO;
import model.Point;

import java.sql.SQLException;
import java.util.List;

public interface IPointDAO {
    void insertPoint(Point point) throws SQLException;
    Point selectPoint(String id_student, int id_subject);
    List<PointDTO> findPointAll();


    void deletePoint(String id_student, int id_subject) throws SQLException;
    void updatePoint(String id_student, int id_subject) throws SQLException;
}
