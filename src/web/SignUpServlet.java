package web;

import domain.CaptchaUtils;
import domain.User;
import service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

//处理注册操作
@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    private String firstName=null;
    private String lastName=null;
    private String sex=null;
    private String email=null;
    private String username=null;
    private String password=null;
    private String age=null;
    private String phone=null;
    private String address=null;
    private String country=null;
    private String faverCategory=null;

    private User user;
    private service.userService userService=new userService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理验证码
        String userInputCaptcha = request.getParameter("captcha");

        // 从Session中获取真正的验证码
        HttpSession session = request.getSession();
        String realCaptcha = (String) session.getAttribute("captcha");

        boolean signUpVarity=false;

        if(userInputCaptcha.equalsIgnoreCase(realCaptcha)) {
            signUpVarity=true;
        }

        if(!signUpVarity)
        {
            System.out.println("Captcha invalid");
            request.setAttribute("message","Verification code error!");
            request.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp").forward(request, response);
        }

        firstName=request.getParameter("firstName");
        lastName=request.getParameter("lastName");
        email=request.getParameter("email");
        sex=request.getParameter("sex");
        username=request.getParameter("username");
        password=request.getParameter("password");
        age=request.getParameter("age");
        phone=request.getParameter("phone");
        country=request.getParameter("country");
        address=request.getParameter("address");
        faverCategory=request.getParameter("favouriteCategory");

        user=new User(username,password);
        user.setAge(age);
        user.setPhone(phone);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setSex(sex);
        user.setAddress(address);
        user.setCountry(country);
        user.setFaverCategory(faverCategory);

        int result=-2;
        try {
            result=userService.signUp(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(result==-2) {
            System.out.println("error In signUp in servlet");
        }
        //数据库插入失败
        else if (result==0) {
            System.out.println("error In signUp in servlet (insert error)");
        }
        //信息成功插入，此时应返回登录界面并提示注册成功
        else {
            //此处还应提示用户注册成功
            session.setAttribute("SignUpUser", user.getUsername());

            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        }
    }
}
