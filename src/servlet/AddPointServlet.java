package servlet;

import entity.Chapter;
import entity.Course;
import entity.CourseDetails;
import entity.Point;
import service.CourseService;
import service.impl.CourseServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddPointServlet")
public class AddPointServlet extends HttpServlet {
    private CourseService courseService = new CourseServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseDetails courseDetails = (CourseDetails) request.getSession().getAttribute("courseDetail");
        Course course = courseDetails.getCourse();
        String pointDescription = request.getParameter("pointDescription");
        int chapterId = Integer.parseInt(request.getParameter("chapterId"));

        Point point = new Point();
        point.setChapterId(chapterId);
        point.setDescription(pointDescription);
        courseService.addPoint(point);

        RequestDispatcher dispatcher = request.getRequestDispatcher("detail?courseId="+ course.getId());
        dispatcher.forward(request, response);
    }
}
