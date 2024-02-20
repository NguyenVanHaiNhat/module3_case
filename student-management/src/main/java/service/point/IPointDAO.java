package service.point;

import model.Point;

import java.sql.SQLException;
import java.util.List;

public interface IPointDAO {
    void insertPoint(Point point) throws SQLException;
    Point selectPoint(String id_student);
    List<Point> selectAllPoint();
    void deletePoint(String id_student) throws SQLException;
    void updatePoint(String id_student) throws SQLException;
}
