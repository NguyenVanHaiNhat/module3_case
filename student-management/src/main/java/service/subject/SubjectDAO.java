package service.subject;

import config.ConnectionDB;
import model.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO implements ISubjectDAO{
    @Override
    public List<Subject> findAll() {
        List<Subject> subjectList = new ArrayList<>();
        Connection connection;
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement("select * from subject;");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String nameSubject = resultSet.getString("nameSubject");
                subjectList.add(new Subject(id, nameSubject));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return subjectList;
    }
}
