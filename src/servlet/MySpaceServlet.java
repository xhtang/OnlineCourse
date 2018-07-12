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

@WebServlet(name = "MySpaceServlet")
public class MySpaceServlet extends HttpServlet {

    private CourseService courseService = new CourseServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        String state = request.getParameter("state");

        if ("1".equals(state)) {
            request.setAttribute("courses", courseService.getByStudent(user.getId()));
        } else {
            request.setAttribute("courses", courseService.getByTeacher(user.getId()));
        }

        request.setAttribute("state", state);

        RequestDispatcher dispatcher = request.getRequestDispatcher("page/myspace.jsp");
        dispatcher.forward(request, response);
    }
}
