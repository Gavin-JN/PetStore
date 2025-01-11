package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tosign")
public class toSignUpServlet extends HttpServlet {
    private static final String LOGIN_FORM="/WEB-INF/jsp/signUp.jsp";

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(LOGIN_FORM).forward(req,resp);
    }
}
