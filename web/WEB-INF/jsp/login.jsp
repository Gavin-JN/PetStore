
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="StyleSheet" href="css/login.css?v=1.23" type="text/css" media="screen" />
    <title>login</title>
</head>
<body>

<div  class="loginCss" >
    <div style="height: 10px;margin-top: 4px">
    <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
    <p style="color:red; text-align: center;font-size: 20px;font-family: 宋体;    top: -16px;
    left: -1px;
    position: relative;"><%= message %></p>
    <%
        }
    %>
    </div>
    <p class="pCss">Sign    In</p>
    <form action="${pageContext.request.contextPath}/login" method="post" class="formCss" onsubmit="return errFunction();">
        <table>
            <tbody class="tableCss">
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username" class="textCss" id="usernameId"></td>

<%--                <td> <p id="errOfusername" style="font-size: 12px;color: red;font-family: Arial">&nbsp;</p></td>--%>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" class="textCss" id="passwordId"></td>
<%--                <td> <p id="errOfpassword" style="color: red ; font-size: 12px;font-family:Arial"> &nbsp;</p> </td>--%>
            </tr>
            <tr>
                <td></td>
                <td align="center"><input type="submit"value="Sign in" class="butCss" >&nbsp;</td>
            </tr>
            </tbody>
        </table>
    </form>
<%--    //显示用户信息的提示--%>
    <div class="errorOfUsername">
        <p id="errOfusername" style="font-size: 12px;color: red;font-family: Arial">&nbsp;</p>
    </div>
<%--    //显示用户密码的相关提示--%>
    <div class="errorOfPassword">
        <p id="errOfpassword" style="color: red ; font-size: 12px;font-family:Arial"> &nbsp;</p>
    </div>

    <div  class="upCss">
        <pre style="font-size:14px">Not the user yet <a href="tosign">sign up</a> now</pre>
    </div>

</div>
<script src="js/login.js"></script>
</body>
</html>
