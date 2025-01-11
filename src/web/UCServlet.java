package web;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
import java.io.PrintWriter;
import java.util.Iterator;

public class UCServlet extends HttpServlet {
    CartDao cartDao = new CartDaoImpl();
    ItemDao itemDao = new ItemDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        Iterator<CartItem> cartItems =cart.getAllCartItems();

        JsonObject alltotal=new JsonObject();
        JsonArray newItems=new JsonArray();

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

                JsonObject itemJson=new JsonObject();
                itemJson.addProperty("itemId", itemId);
                itemJson.addProperty("productId",cartItem.getItem().getProduct().getProductId());
                itemJson.addProperty("Description", cartItem.getItem().getAttribute1().toString()+cartItem.getItem().getProduct().getName());
                itemJson.addProperty("instock", cartItem.isInStock());
                itemJson.addProperty("quantity", cartItem.getQuantity());
                itemJson.addProperty("listprice", cartItem.getItem().getListPrice());
                itemJson.addProperty("totalcost",cartItem.getTotal());

                newItems.add(itemJson);

            } catch (Exception e) {
                //ignore parse exceptions on purpose
            }
        }

        alltotal.addProperty("total",cart.getSubTotal());
        alltotal.addProperty("cartNum",cart.getNumberOfItems());
        alltotal.add("newItems",newItems);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        try(PrintWriter out = resp.getWriter()) {
            out.print(alltotal.toString());
            out.flush();
        }
    }

}
