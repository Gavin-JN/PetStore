package web.Filter;

import persistence.logWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class SignUpFilter  implements Filter {
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
        HttpSession session = request.getSession();
        String name=session.getAttribute("signUpUser").toString();
        logWriter logWriter = new logWriter();
        Date date = new Date();
        String log=name+" success sign up at "+date+"\n";
        logWriter.Writer(log);

    }
    // 销毁方法
    @Override
    public void destroy() {
    }
}
