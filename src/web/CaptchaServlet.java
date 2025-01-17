package web;

import com.google.gson.Gson;
import domain.CaptchaUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/captcha")
public class CaptchaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建验证码图片并返回图片上的文本
        String captchaText = CaptchaUtils.createCaptchaImage(response);
        // 将验证码文本保存到Session中
        HttpSession session = request.getSession();
        session.setAttribute("captcha", captchaText);
    }

}
