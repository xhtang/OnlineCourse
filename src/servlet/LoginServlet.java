package servlet;


import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //String str_url = request.getRequestURI();

        if (userService.exist(username)) {
            if (userService.login(username,password) != null) {
                request.getSession().setAttribute("user", userService.login(username,password));

                response.getWriter().print("{\"existed\": \"TRUE\",\"password\": \"TRUE\"}");
            }
            else {
                response.getWriter().print("{\"existed\": \"TRUE\",\"password\": \"FALSE\"}");
            }
        }
        else {
            response.getWriter().print("{\"existed\": \"FALSE\"}");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRequest(request, response);
    }
}
