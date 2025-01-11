package web;

import domain.User;
import persistence.userDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ifUserNameExitedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname=req.getParameter("uname");
        userDao dao=new userDao();
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        try {
            if(dao.ifNameExit(uname)){
                resp.getWriter().write("uername has exited");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
