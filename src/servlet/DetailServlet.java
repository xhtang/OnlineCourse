package servlet;

import entity.CourseDetails;
import entity.User;
import service.CourseService;
import service.impl.CourseServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailServlet extends HttpServlet {

    private CourseService courseService = new CourseServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        int userId = user.getId();

        int courseId = Integer.parseInt(request.getParameter("courseId"));

        CourseDetails courseDetails = courseService.getCourseDetails(courseId);

        request.setAttribute("courseDetail", courseDetails);

        String userstate = courseService.getUserAndCourseState(userId, courseId);
        request.setAttribute("userState", userstate);

        RequestDispatcher dispatcher = request.getRequestDispatcher("page/detail.jsp");
        dispatcher.forward(request, response);
    }
}
