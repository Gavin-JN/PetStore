package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignOutServlet extends HttpServlet {
    private static final String MAIN_FORM = "/WEB-INF/jsp/category/main.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String signOutUser=session.getAttribute("user").toString();
        req.getSession().invalidate();
        req.getRequestDispatcher(MAIN_FORM).forward(req, resp);
        HttpSession session2 = req.getSession();
        session2.setAttribute("signOutUser", signOutUser);
    }
}
