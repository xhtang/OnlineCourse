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
        List<Course> heat = courseService.getFamousCourses();
        List<Course> fresh = courseService.getFreshCourses();

        if (heat.size() >= 3)
            heat = heat.subList(0,3);
        if (fresh.size() >= 3)
            fresh = fresh.subList(0,3);

        request.setAttribute("heat", heat);
        request.setAttribute("latest", fresh);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
