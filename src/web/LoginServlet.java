package web;

import domain.Cart;
import domain.Item;
import domain.Product;
import domain.User;
import persistence.CartDao;
import persistence.DatabaseManager;
import persistence.impl.CartDaoImpl;
import persistence.userDao;
import service.CatalogService;
import service.userService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//处理登录操作
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private String username;
    private String password;
    private User user;
    private userService  userService=new userService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        username=request.getParameter("username");
        password=request.getParameter("password");
        user=new User(username,password);
        HttpSession session=request.getSession();
        session.setAttribute("ifSuccess","false");
        int result=-2;
        try {
            result=userService.login(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(result==-2){
            System.out.println("error In login in servlet");
        }
        //账户存在，密码错误
        else if (result==-1) {
            request.setAttribute("message", "Error in password!");
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        }
        //账户不存在
        else if(result==0){
            request.setAttribute("message", "user not exit!");
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        }
        //信息正确
        else {
            session.setAttribute("user", username);
            User currentUser=new User();
            userDao userDao=new userDao();
            try {
                currentUser=userDao.getUser(username);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            session.setAttribute("currentUser", currentUser);
            String faverImag=null;
            DatabaseManager databaseManager=new DatabaseManager();
            try {
                faverImag=databaseManager.getFavImage(currentUser.getFaverCategory());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            CatalogService catalogService=new CatalogService();
            List<Product> myList=catalogService.getProductListByCategory(currentUser.getFaverCategory());
            session.setAttribute("myList", myList);

            Cart cart=new Cart();
            session.setAttribute("cart",cart);
            CartDao cartDao=new CartDaoImpl();
            List<String> items=new ArrayList<>();
            items=cartDao.getCart(session.getAttribute("user").toString());

            int num=0;
            for(String workingItemId: items) {
                boolean isInStock = catalogService.isItemInStock(workingItemId);
                Item item = catalogService.getItem(workingItemId);
                cart.addItem(item, isInStock);
            }
            for(String itemId:items) {
                String quantity = null;
                try {
                    quantity = cartDao.getNumByItemId(session.getAttribute("user").toString(), itemId);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                int quantityInt = Integer.parseInt(quantity);
                cart.setQuantityByItemId(itemId, quantityInt);
            }

            num= cart.getNumberOfItems();
            session.setAttribute("tips", num);
            session.setAttribute("loginUser", user.getUsername());
            session.setAttribute("favImage", faverImag);
            request.getRequestDispatcher("/WEB-INF/jsp/category/main.jsp").forward(request, response);
            session.setAttribute("ifSuccess","true");

        }
    }

}


