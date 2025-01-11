<html>
<head>
    <meta charset="UTF-8">
    <title>userInformation</title>
</head>
<body>
<div id="BackLink">
    <a href="tomain">Return</a>
</div>
<div class="pDiv">
    <p class="pCss">User Information</p>
</div>
<div class="userDiv">
    <form action="updateUserInfor" method="post">
        <table class="tableCss">
            <tbody>
            <tr>
                <td>
                    Username:
                </td>
                <td id="uname">
                    <input type="text" class="textCss" name="username" id="username" value="${sessionScope.currentUser.getUsername()}">
                    <div id="exited">
                        <p class="errmassage" id="em"></p>
                    </div>
                </td>
                <td>
                    <input type="hidden" name="oname" value="${sessionScope.currentUser.getUsername()}" id="oname">
                </td>
            </tr>
            <tr>
                <td>
                    FirstName:
                </td>
                <td>
                    <input type="text" class="textCss" name="firstName" value="${sessionScope.currentUser.getFirstName()}">
                </td>
            </tr>
            <tr>
                <td>
                    LastName:
                </td>
                <td>
                    <input type="text" class="textCss" name="lastName" value="${sessionScope.currentUser.getLastName()}">
                </td>
            </tr>
            <tr>
                <td>
                    Sex:
                </td>
                <td>
                    <input type="text" class="textCss" name="sex" value="${sessionScope.currentUser.getSex()}">
                </td>
            </tr>
            <tr>
                <td>
                    Age:
                </td>
                <td>
                    <input type="text" class="textCss" name="age" value="${sessionScope.currentUser.getAge()}">
                </td>
            </tr>
            <tr>
                <td>
                    Favorite Category:
                </td>
                <td>
                    <input type="text" class="textCss" name="faverCategory" value="${sessionScope.currentUser.getFaverCategory()}">
                </td>
            </tr>
            <tr>
                <td>
                    Email:
                </td>
                <td>
                    <input type="text" class="textCss" name="email" value="${sessionScope.currentUser.getEmail()}">
                </td>
            </tr>
            <tr>
                <td>
                    Phone:
                </td>
                <td>
                    <input type="text" class="textCss" name="phone" value="${sessionScope.currentUser.getPhone()}">
                </td>
            </tr>
            <tr>
                <td>
                    Country:
                </td>
                <td>
                    <input type="text" class="textCss" name="country" value="${sessionScope.currentUser.getCountry()}">
                </td>
            </tr>
            <tr>
                <td>
                    Address:
                </td>
                <td>
                    <input type="text" class="textCss" name="address" value="${sessionScope.currentUser.getAddress()}">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Save" class="butCss">
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>

<style>
    /* 页面基础样式 */
    body {
        margin: 0;
        padding: 0;
        font-family: "Poppins", sans-serif; /* 更现代、可爱的字体 */
        background-color: #F8E5CB; /* 暖白色背景 */
        color: #2E3A47; /* 深棕色文字 */
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    /* 返回按钮样式 */
    #BackLink {
        position: absolute;
        top: 20px;
        left: 20px;
        font-size: 1.1rem;
        color: #2E3A47; /* 深棕色 */
        text-decoration: none;
        padding: 10px 20px;
        background-color: #F4C28E; /* 浅金色背景 */
        border-radius: 12px; /* 倒角 */
        border: 2px solid #D8A272; /* 深棕黄色边框 */
        transition: 0.3s ease;
    }

    #BackLink:hover {
        background-color: #D8A272; /* 悬停时更深的颜色 */
        color: white;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
    }

    /* 页面标题容器 */
    .pDiv {
        width: 100%;
        text-align: center;
        padding-top: 20px;
    }

    /* 页面标题 */
    .pCss {
        font-size: 2rem; /* 大字体 */
        color: #2E3A47; /* 深棕色文字 */
        font-weight: 700;
        margin-top: 10%;
        font-family: "Poppins", sans-serif; /* 更现代的字体 */
    }

    /* 用户信息表单容器 */
    .userDiv {
        width: 680px;
        padding: 20px;
        background-color: #F1F1F1; /* 浅灰色背景 */
        border-radius: 10px;
        box-shadow: 0 0 15px #F4C28E; /* 浅金色阴影 */
        margin-top: 30px;
    }

    /* 表格样式 */
    .tableCss {
        width: 100%;
        margin-top: 20px;
        border-radius: 8px;
        border: 2px solid #D8A272; /* 深棕黄色边框 */
        text-align: center;
    }

    .tableCss td {
        padding: 10px;
    }

    /* 输入框样式 */
    .textCss {
        width: 230px;
        height: 36px;
        background-color: #F4C28E; /* 浅金色背景 */
        border: 2px solid #D8A272; /* 深棕黄色边框 */
        color: #2E3A47; /* 深棕色文字 */
        border-radius: 8px;
        text-align: center;
    }

    /* 提交按钮样式 */
    .butCss {
        width: 200px;
        height: 40px;
        background-color: #D8A272; /* 深棕黄色背景 */
        color: white;
        border: none;
        font-size: 1.2rem;
        border-radius: 6px;
        margin-top: 30px;
        transition: 0.3s ease;
        cursor: pointer;
    }

    .butCss:hover {
        background-color: #F4C28E; /* 浅金色悬停背景 */
        box-shadow: 0 12px 16px rgba(244, 194, 142, 0.4);
    }

    /* 错误提示样式 */
    #exited {
        text-align: center;
        color: red;
    }

    #exited p {
        padding-top: 5px;
        font-size: 14px;
    }
</style>
</body>
<script src="js/jquery-3.7.1.min.js"></script>
<script src="js/userinfor.js"></script>
</html>
