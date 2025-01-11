
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="StyleSheet" href="css/signUp.css?v=1.8" type="text/css" media="screen" />
    <title>SignUp</title>
</head>
<body>
<%
    String message = (String) request.getAttribute("message");
    if (message != null) {
%>
<p style="color:red; text-align: center;position: relative;top: -248px;left: 532px; font-weight: 700"><%= message %></p>
<%
    }
%>
<div class="d1">

    <p class="p1">Sign Up</p>

    <form class="formCss" action="${pageContext.request.contextPath}/signUp" method="post" onsubmit="NULLFunction();">
        <table>
            <tbody class="tbody">
            <tr>
                <td>
                    First-name:
                </td>
                <td>
                    <input type="text" name="firstName" class="textCss" id="firstName">
                </td>
            </tr>
            <tr>
                <td>
                    Last-name:
                </td>
                <td>
                    <input type="text" name="lastName" class="textCss" id="lastName">
                </td>
            </tr>
            <tr>
                <td>
                    Sex:
                </td>
                <td>
                    <input type="radio" name="sex" value="man" id="man">
                    <label for="man">man</label>
                    <input type="radio" name="sex" value="woman" id="woman">
                    <label for="woman">woman</label>
                </td>
            </tr>
            <tr>
                <td>
                    Age:
                </td>
                <td>
                    <input type="text" name="age" class="textCss" id="age">
                </td>
            </tr>
            <tr>
                <td>
                    Favorite Category:
                </td>
                <td>
                    <input type="text" name="favouriteCategory" class="textCss" id="favouriteCategory">
                </td>
            </tr>
            <tr>
                <td>
                    Username(for login):
                </td>
                <td id="uexid">
                    <input type="text" name="username" class="textCss" id="username">
                    <div id="userexid">
                        <p class="eMassage" id="ifExid"></p>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    Password:
                </td>
                <td>
                    <input type="password" name="password" class="textCss" id="password">
                </td>
            </tr>
            <tr >
                <td>
                    Ensure password:
                </td>
                <td id="enpsw">
                    <input type="password" name="ensurepassword" class="textCss" id="ensurePassword">
                    <div  class="errorMassage">
                        <p class="eMassage" id="eMass"></p>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    Country:
                </td>
                <td>
                    <input type="text" name="country" class="textCss" id="country">
                </td>
            </tr>
            <tr>
                <td>
                    Address:
                </td>
                <td>
                    <input type="text" name="address" class="textCss" id="address">
                </td>
            </tr>
            <tr>
                <td>
                    Email:
                </td>
                <td>
                    <input type="email" name="email" class="textCss" id="email">
                </td>
            </tr>
            <tr>
                <td>
                    Phone(for verification):
                </td>
                <td>
                    <input type="text" name="phone" class="textCss" id="phone">
                </td>
            </tr>
            <tr>
                <td>
                    VarityCode:
                </td>
                <td>
                    <input type="text" name="captcha" class="textCss" id="captcha">
                </td>
                <td class="varityButDiv">
                    <a href="captcha" onclick="refreshCaptcha(); return false;">
                        <img src="captcha" id="captchaImage" alt="Captcha" />
                    </a>
                    <br>
                </td>
            </tr>
            <tr>
                <td  align="center" id="sub">
                    <input type="submit" name="sign up" value="sign up"  class="butCss">
                    <div class="emptyDiv">
                        <p class="eMassage" id="emptyMass"></p>
                    </div>
                </td>
            </tr>

            </tbody>
        </table>
    </form>


</div>
</body>
<script src="js/jquery-3.7.1.min.js"></script>
<script src="js/signUp.js"></script>
</html>
