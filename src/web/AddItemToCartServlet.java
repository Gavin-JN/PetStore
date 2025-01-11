package web;

import domain.Cart;
import domain.Item;
import persistence.CartDao;
import persistence.impl.CartDaoImpl;
import persistence.logWriter;
import service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

public class AddItemToCartServlet extends HttpServlet {
    private static final String CART_FORM = "/WEB-INF/jsp/cart/cart.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String workingItemId = req.getParameter("workingItemId");

        HttpSession session = req.getSession();
        Cart cart =(Cart) session.getAttribute("cart");

        if(cart == null){
            cart = new Cart();
        }

        int tips= (int) session.getAttribute("tips");
        if (cart.containsItemId(workingItemId)) {
            cart.incrementQuantityByItemId(workingItemId);
            CartDao cartDao = new CartDaoImpl();
            Item item = new Item();
            String n= null;
            try {
                n = cartDao.getNumByItemId(session.getAttribute("user").toString(),workingItemId);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            int num= Integer.parseInt(n);
            num++;
            n= String.valueOf(num);

            cartDao.updateNum(session.getAttribute("user").toString(),workingItemId,n);
        } else {
            // isInStock is a "real-time" property that must be updated
            // every time an item is added to the cart, even if other
            // item details are cached.

            CatalogService catalogService = new CatalogService();
            boolean isInStock = catalogService.isItemInStock(workingItemId);
            Item item = catalogService.getItem(workingItemId);
            String num= String.valueOf(item.getQuantity());
            //
            if(session.getAttribute("user")!=null) {
                CartDao cartDao= new CartDaoImpl();
                cartDao.saveCart(session.getAttribute("user").toString(),item);
                cartDao.updateNum(session.getAttribute("user").toString(),item.getItemId(),num);
            }
            cart.addItem(item, isInStock);

            session.setAttribute("addItem",item);
            tips++;
        }

        session.setAttribute("tips",tips);

        session.setAttribute("cart",cart);
//        req.getRequestDispatcher(CART_FORM).forward(req,resp);

        PrintWriter out =resp.getWriter();
        out.print(tips);
        out.flush();
    }
}
