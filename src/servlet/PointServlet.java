package servlet;

import entity.CourseDetails;
import entity.Point;
import entity.User;
import entity.Video;
import service.CourseService;
import service.impl.CourseServiceImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PointServlet")
public class PointServlet extends HttpServlet {
    private CourseService courseService = new CourseServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pointId = Integer.parseInt(request.getParameter("pointId"));

        Point point = courseService.getPoint(pointId);
        request.setAttribute("point", point);

        List<Video> videoList = courseService.getVideoByPoint(pointId);
        request.setAttribute("videoList",videoList);

        User user = (User) request.getSession().getAttribute("user");
        int userId = user.getId();
        CourseDetails courseDetails = (CourseDetails) request.getSession().getAttribute("courseDetail");
        String userstate = courseService.getUserAndCourseState(userId, courseDetails.getCourse().getId());
        request.setAttribute("userState", userstate);

        RequestDispatcher dispatcher = request.getRequestDispatcher("page/point.jsp");
        dispatcher.forward(request, response);
    }
}
