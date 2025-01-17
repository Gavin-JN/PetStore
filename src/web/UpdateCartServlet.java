package web;

import domain.Cart;
import domain.CartItem;
import persistence.CartDao;
import persistence.ItemDao;
import persistence.impl.CartDaoImpl;
import persistence.impl.ItemDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;

public class UpdateCartServlet extends HttpServlet {
    private static final String CART_FORM ="WEB-INF/jsp/cart/cart.jsp";
    CartDao cartDao = new CartDaoImpl();
    ItemDao itemDao = new ItemDaoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        Iterator<CartItem> cartItems =cart.getAllCartItems();

        while (cartItems.hasNext()) {
            CartItem cartItem = (CartItem) cartItems.next();
            String itemId = cartItem.getItem().getItemId();
            try {
                String quantityString = req.getParameter(itemId);
                System.out.println(quantityString);

                int quantity = Integer.parseInt(quantityString);

                cart.setQuantityByItemId(itemId, quantity);

                cartDao.updateNum(session.getAttribute("user").toString(),itemId,quantityString);
                if (quantity < 1) {
                    cartItems.remove();
                    cartDao.deleteCar(session.getAttribute("user").toString(),itemDao.getItem(itemId));
                }
            } catch (Exception e) {
                //ignore parse exceptions on purpose
            }
        }
        req.getRequestDispatcher(CART_FORM).forward(req,resp);
    }
}
