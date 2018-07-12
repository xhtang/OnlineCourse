package servlet;

import entity.Chapter;
import entity.Course;
import entity.CourseDetails;
import service.CourseService;
import service.impl.CourseServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddChapterServlet")
public class AddChapterServlet extends HttpServlet {
    private CourseService courseService = new CourseServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CourseDetails courseDetails = (CourseDetails) request.getSession().getAttribute("courseDetail");
        Course course = courseDetails.getCourse();
        String chapterDescription = request.getParameter("chapterDescription");

        Chapter chapter = new Chapter();
        chapter.setCourseId(course.getId());
        chapter.setDescription(chapterDescription);
        courseService.addChapter(chapter);

        courseDetails = courseService.getCourseDetails(course.getId());
        request.getSession().setAttribute("courseDetail", courseDetails);

        RequestDispatcher dispatcher = request.getRequestDispatcher("page/detail.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
