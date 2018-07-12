package servlet;

import entity.Course;
import entity.User;
import service.CourseService;
import service.impl.CourseServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeServlet extends HttpServlet {
    private CourseService courseService = new CourseServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        User user = (User) request.getSession().getAttribute("user");
//        if (user == null) {
//            request.setAttribute("user", null);
//        }
//        request.getSession().setAttribute("user", null);

        List<Course> heat = courseService.getFamousCourses();
        List<Course> fresh = courseService.getFreshCourses();

//        List<Course> heat = courseService.getFamousCourses().subList(0, 3);
//        List<Course> fresh = courseService.getFreshCourses().subList(0, 3);

        request.setAttribute("heat", heat);
        request.setAttribute("latest", fresh);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
