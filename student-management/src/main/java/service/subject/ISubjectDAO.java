package service.subject;

import model.Subject;

import java.util.List;

public interface ISubjectDAO {
    List<Subject> findAll();
}
