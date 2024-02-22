package controller;

import dto.PointDTO;
import model.Point;
import model.Student;
import model.Subject;
import service.point.IPointDAO;
import service.point.PointDAO;
import service.student.IStudentDAO;
import service.student.StudentDAO;
import service.subject.ISubjectDAO;
import service.subject.SubjectDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PointController", urlPatterns = "/points")
public class PointController extends HttpServlet {
    private IPointDAO pointDAO = new PointDAO();
    private IStudentDAO studentDAO = new StudentDAO();
    private ISubjectDAO subjectDAO = new SubjectDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }try {

            switch (action) {
                case "delete":
                    deletePoint(request, response);
                    break;
                case "create":
                    showCreate(request, response);
                    break;
                case "edit":
                    showEdit(request, response);
                    break;
                default:
                    showPointList(request, response);
                    break;
            }
        }catch (SQLException e){
            e.getMessage();
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_student = request.getParameter("id_student");
        int id_subject = Integer.parseInt(request.getParameter("idSubject"));
        Point point = this.pointDAO.selectPoint(id_student, id_subject);
        List<Student> studentList = this.studentDAO.selectAllStudent();
        List<Subject> subjectList = this.subjectDAO.findAll();
        request.setAttribute("student", studentList);
        request.setAttribute("subject", subjectList);
        request.setAttribute("point", point);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("point/edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = this.studentDAO.selectAllStudent();
        request.setAttribute("student", studentList);
        List<Subject> subjectList = this.subjectDAO.findAll();
        request.setAttribute("subject", subjectList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("point/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void deletePoint(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String id_student = request.getParameter("id_student");
        int id_subject = Integer.parseInt(request.getParameter("idSubject"));
        this.pointDAO.deletePoint(id_student, id_subject);

        List<PointDTO> pointDTOS = pointDAO.findPointAll();
        request.setAttribute("listPoint", pointDTOS);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("point/list.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showPointList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PointDTO> pointDTOS = pointDAO.findPointAll();
        request.setAttribute("listPoint" , pointDTOS);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("point/list.jsp");
        requestDispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {

            switch (action) {
                case "edit":
                    editPoint(request, response);
                    break;
                case "create":
                    createPoint(request, response);
                    break;
                default:
                    showPointList(request, response);
                    break;
            }
        } catch (SQLException e){
            e.getMessage();
        }
    }
    private void createPoint(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        String id_student = request.getParameter("nameStudent");
        int id_subject = Integer.parseInt(request.getParameter("nameSubject"));
        float testMark = Float.parseFloat(request.getParameter("testMark"));
        float testMark15 = Float.parseFloat(request.getParameter("testMark15"));
        float testMark60 = Float.parseFloat(request.getParameter("testMark60"));
        float midterm = Float.parseFloat(request.getParameter("midterm"));
        float finalExam = Float.parseFloat(request.getParameter("final"));
        Point point = new Point(id_student, id_subject, testMark, testMark15, testMark60, midterm, finalExam);
        this.pointDAO.insertPoint(point);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("point/create.jsp");
        requestDispatcher.forward(request, response);
    }

    private void editPoint(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String id_student = request.getParameter("id_student");
        int id_subject = Integer.parseInt(request.getParameter("idSubject"));
        float testMark = Float.parseFloat(request.getParameter("testMark"));
        float testMark15 = Float.parseFloat(request.getParameter("testMark15"));
        float testMark60 = Float.parseFloat(request.getParameter("testMark60"));
        float midterm = Float.parseFloat(request.getParameter("midterm"));
        float finalExam = Float.parseFloat(request.getParameter("final"));
        Point point = new Point(id_student, id_subject, testMark, testMark15, testMark60, midterm, finalExam);
        this.pointDAO.updatePoint(point);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("point/edit.jsp");
        requestDispatcher.forward(request, response);
    }
}
