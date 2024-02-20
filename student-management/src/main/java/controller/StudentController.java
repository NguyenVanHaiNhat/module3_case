package controller;

import model.Student;
import service.student.IStudentDAO;
import service.student.StudentDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/students")
public class StudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IStudentDAO studentDAO;
    public void init(){
        studentDAO = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            if (action.equals("create")) {
                showNewForm(req, resp);
            } else {
                listStudent(req, resp);
            }
        } catch (SQLException ex){
            throw new ServletException(ex);
        }
    }

    private void insertStudent(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String id = req.getParameter("id");
        String nameStudent = req.getParameter("nameStudent");
        String dayofbirth = req.getParameter("dayofbirth");
        String address = req.getParameter("address");
        int id_class = req.getIntHeader("id_class");
        Student newStudent = new Student(id, nameStudent, dayofbirth, address, id_class);
        studentDAO.insertStudent(newStudent);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("students/create.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        if (action.equals("create")){
            try {
                insertStudent(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void listStudent(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        List<Student> listStudent = studentDAO.selectAllStudent();
        req.setAttribute("listStudent", listStudent);
        RequestDispatcher dispatcher = req.getRequestDispatcher("students/list.jsp");
        dispatcher.forward(req, resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("students/create.jsp");
        requestDispatcher.forward(req, resp);
    }
}
