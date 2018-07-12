package servlet;

import entity.User;
import service.CourseService;
import service.impl.CourseServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SelectServlet")
public class SelectServlet extends HttpServlet {
    private CourseService courseService = new CourseServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        int userId = user.getId();
        int courseId = Integer.parseInt(request.getParameter("courseId"));

        courseService.selectCourse(userId, courseId);

        RequestDispatcher dispatcher = request.getRequestDispatcher("myspace?state=1");
        dispatcher.forward(request, response);

    }
}
