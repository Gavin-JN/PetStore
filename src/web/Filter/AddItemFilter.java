package web.Filter;

import domain.Item;
import persistence.logWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class AddItemFilter implements Filter {

    // 初始化方法
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    // 作出过滤的方法
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 放行请求,交给过滤器链继续进行过滤 最后到达资源
        filterChain.doFilter(servletRequest, servletResponse);

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Item item=new Item();
        HttpSession session=request.getSession();
        item=(Item)session.getAttribute("addItem");
        logWriter logWriter = new logWriter();
        Date date = new Date();
        String log=item.getItemId()+" add to cart at "+date+"\n";
        logWriter.Writer(log);

    }
    // 销毁方法
    @Override
    public void destroy() {
    }
}
