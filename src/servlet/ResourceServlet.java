package servlet;

import entity.Resource;
import entity.User;
import service.CourseService;
import service.ResourceService;
import service.impl.CourseServiceImpl;
import service.impl.ResourceServiceImpl;

import javax.jws.soap.SOAPBinding;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ResourceServlet")
public class ResourceServlet extends HttpServlet {
    private CourseService courseService = new CourseServiceImpl();
    private ResourceService resourceService = new ResourceServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("courseId"));

        List<Resource> resourceList = resourceService.getByCourse(courseId);
        request.setAttribute("resourceList", resourceList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("page/resource.jsp");
        dispatcher.forward(request, response);
    }
}
