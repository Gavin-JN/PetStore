package web;

import domain.Cart;
import domain.Item;
import persistence.CartDao;
import persistence.impl.CartDaoImpl;
import persistence.logWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class RemoveCartItemServlet extends HttpServlet {
    private static final String ERROR_FORM ="WEB-INF/jsp/common/error.jsp";
    private static final String CART_FORM = "WEB-INF/jsp/cart/cart.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Cart cart = (Cart)session.getAttribute("cart");

        String workingItemId =req.getParameter("workingItemId");
        Item item = cart.removeItemById(workingItemId);

        if(session.getAttribute("user")!=null) {
            CartDao cartDao = new CartDaoImpl();
            cartDao.deleteCar(session.getAttribute("user").toString(), item);
        }
        session.setAttribute("removeItem", item);
        logWriter logWriter = new logWriter();
        Date date = new Date();
        String log=item.getItemId()+" remove from cart "+date+"\n";
        logWriter.Writer(log);

        if (item == null) {
            session.setAttribute("errorMsg","Attempted to remove null CartItem from Cart.");
            req.getRequestDispatcher(ERROR_FORM).forward(req, resp);
        } else {
            int num= (int) session.getAttribute("tips");
            num--;
            session.setAttribute("tips", num);

            req.getRequestDispatcher(CART_FORM).forward(req,resp);
        }
    }
}
