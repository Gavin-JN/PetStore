package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class NewOrderFormServlet extends HttpServlet {
    private static final String SIGN_ON_FORM="/WEB-INF/jsp/order/newOrder.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String username=(String)session.getAttribute("user");
        List myList =(List)session.getAttribute("myList");
        int num=myList.size();
        if(username==null){
            resp.sendRedirect("tologin");
        }
        else{
            if(num==0)
            {
                session.setAttribute("errorMsg","The cart is empty");
            }
            req.getRequestDispatcher(SIGN_ON_FORM).forward(req, resp);
        }
    }
}
