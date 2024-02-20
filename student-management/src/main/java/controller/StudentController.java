package controller;

import service.student.IStudentDAO;
import service.student.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
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
}
