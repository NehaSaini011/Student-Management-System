package web;

import model.Student;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class AddStudentServlet extends HttpServlet {
    private StudentService service;

    @Override
    public void init() {
        service = new StudentService();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String course = req.getParameter("course");
        double marks = Double.parseDouble(req.getParameter("marks"));

        service.addStudent(new Student(id, name, age, course, marks));

        resp.sendRedirect("index.html");
    }
}
