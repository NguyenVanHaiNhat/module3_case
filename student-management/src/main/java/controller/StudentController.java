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
            switch (action){
                case "create":
                    showNewForm(req, resp);
                    break;
                case "edit":
                    showEditForm(req, resp);
                    break;
                case "delete":
                    deleteStudent(req, resp);
                    break;
                default:
                    listStudent(req, resp);
                    break;
            }
        } catch (SQLException ex){
            throw new ServletException(ex);
        }
    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String id = req.getParameter("id");
        studentDAO.deleteStudent(id);

        List<Student> listStudent = studentDAO.selectAllStudent();
        req.setAttribute("listStudent", listStudent);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("students/list.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String id = req.getParameter("id");
        Student existingStudent = studentDAO.selectStudent(id);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("students/edit.jsp");
        req.setAttribute("students", existingStudent);
        requestDispatcher.forward(req, resp);
    }

    private void insertStudent(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String id = req.getParameter("id");
        String nameStudent = req.getParameter("nameStudent");
        String dayofbirth = req.getParameter("dayofbirth");
        String address = req.getParameter("address");
        int id_class = Integer.parseInt(req.getParameter("id_class"));
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
        try {
            switch (action) {
                case "create":
                    insertStudent(req, resp);
                    break;
                case "edit":
                    updateStudent(req, resp);
                    break;
            }
        } catch (SQLException ex){
            throw new ServletException(ex);
        }
        }

    private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        String id = req.getParameter("id");
        String nameStudent = req.getParameter("nameStudent");
        String dayofbirth = req.getParameter("dayofbirth");
        String address = req.getParameter("address");
        int id_class = Integer.parseInt(req.getParameter("id_class"));

        Student student = new Student(id, nameStudent, dayofbirth, address, id_class);
        studentDAO.updateStudent(student);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("students/edit.jsp");
        requestDispatcher.forward(req, resp);
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
