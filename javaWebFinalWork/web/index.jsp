<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>班务管理系统</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        h1 {
            text-align: center;
        }

        .form {
            width: 300px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .form input[type="text"],
        .form input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .form .error {
            color: red;
        }

        .form button {
            display: block;
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .form button.register {
            background-color: #2196F3;
        }

        .form button a {
            text-decoration: none;
            color: black;
        }
    </style>
</head>
<body>
<h1>欢迎来到班级管理系统</h1>
<div class="form">
    <form action="/javaWebFinalWork/controllerLogin" method="post">
        <p>
            姓名：<input type="text" name="username" value="${requestScope.username}">
            <span class="error">${requestScope.nameError}</span>
            <span>${requestScope.noUserError}</span>
        </p>
        <p>
            密码：<input type="password" name="userpassword" value="${requestScope.upwd}">
            <span class="error">${requestScope.passwordError}</span>
        </p>
        <button class="login">登录</button>
        <button class="register"><a href="/javaWebFinalWork/jsp/register.jsp">注册</a></button>
    </form>
</div>
</body>
</html>
