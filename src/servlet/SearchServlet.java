package servlet;

import entity.Course;
import service.CourseService;
import service.impl.CourseServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {

    private CourseService courseService = new CourseServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String coursename = request.getParameter("coursename");

        if (coursename==null || "".equals(coursename)) {
            request.setAttribute("courses", courseService.getAll());
        } else {
            request.setAttribute("courses", courseService.getByName(coursename));
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("page/search.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String coursename = request.getParameter("coursename");

        if (coursename==null || "".equals(coursename)) {
            List<Course> courseList = courseService.getAll();
            System.out.println(courseList.size());
            request.setAttribute("courses", courseService.getAll());
        } else {
            request.setAttribute("courses", courseService.getByName(coursename));
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("page/search.jsp");
        dispatcher.forward(request, response);
    }
}
