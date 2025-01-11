package web;

import domain.Item;
import domain.Product;
import service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SearchServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String itemId = req.getParameter("keyword");
        CatalogService catalogService =new CatalogService();
        Item item =catalogService.getItem(itemId);
        HttpSession session = req.getSession();
        if(item==null){
            session.setAttribute("errorMsg","NO FIND");
            req.getRequestDispatcher("/WEB-INF/jsp/common/error.jsp").forward(req, resp);
        }
        else {
            Product product = item.getProduct();

            session.setAttribute("product", product);
            session.setAttribute("item", item);
            session.setAttribute("logItem", item.getItemId());
            req.getRequestDispatcher("/WEB-INF/jsp/category/item.jsp").forward(req, resp);
        }

    }
}
