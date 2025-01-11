package web;

import persistence.DatabaseManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class flotwindowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseManager db = new DatabaseManager();
        String category=req.getParameter("category");
        List<String> petName=new ArrayList<String>();
        try {
            petName=db.getNameByCategory(category.toUpperCase());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        StringBuilder wr=new StringBuilder();
        for(int i=0;i<petName.size();i++){
            String name=petName.get(i);
            wr.append("<li><p>").append(name).append("</p></li>");
            System.out.println(name);
        }
        resp.getWriter().write(wr.toString());
    }
}
