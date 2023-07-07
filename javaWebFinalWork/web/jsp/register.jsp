<%--
  Created by IntelliJ IDEA.
  User: heyua
  Date: 2023/6/1
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
</head>
<style>

    a {
        text-decoration: none;
        color: black;
    }

</style>

<body>
<h1 style="text-align: center">欢迎来到班务管理系统</h1>

<form action="/javaWebFinalWork/controllerRegister" method="post">
    <p>姓名：<input type="text" name="rusername" value="${requestScope.rname}">
        <span class="error">${requestScope.rnameErro}</span>
        <span>${requestScope.noUserError}</span>

    </p>
    <p>密码：<input type="password" name="ruserpassword" value="${requestScope.upwd}">
        <span class="error">${requestScope.passwordError}</span>
    <p>职位：
        <label for="monitor">
            <input type="radio" id="monitor" name="positions" value="monitor">
            班长
        </label>

        <label for="prefect">
            <input type="radio" id="prefect" name="positions" value="prefect">
            学委
        </label>

        <label for="counselor">
            <input type="radio" id="counselor" name="positions" value="counselor">
            辅导员
        </label>

        <label for="committee">
            <input type="radio" id="committee" name="positions" value="committee">
            生活委员
        </label>

        <label for="student">
            <input type="radio" id="student" name="positions" value="student">
            学生
        </label>
    </p>
    <button style="margin: 0 auto" class="register">提交</button>


</form>
</body>
</html>
