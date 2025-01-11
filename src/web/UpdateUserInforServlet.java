package web;

import domain.User;
import persistence.DatabaseManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateUserInforServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=new User();
        user.setUsername(req.getParameter("username"));
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setSex(req.getParameter("sex"));
        user.setAge(req.getParameter("age"));
        user.setFaverCategory(req.getParameter("faverCategory"));
        user.setEmail(req.getParameter("email"));
        user.setPhone(req.getParameter("phone"));
        user.setCountry(req.getParameter("country"));
        user.setAddress(req.getParameter("address"));

        HttpSession session = req.getSession();
        String usedName=session.getAttribute("user").toString();
        session.setAttribute("currentUser",user);
        DatabaseManager db = new DatabaseManager();
        boolean result;
        try {
           result= db.updateUserInformation(user,usedName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(result) {
           req.getRequestDispatcher("/WEB-INF/jsp/userIn.jsp").forward(req, resp);
        }
        else{
            System.out.println("error in updating user");
        }
    }
}
