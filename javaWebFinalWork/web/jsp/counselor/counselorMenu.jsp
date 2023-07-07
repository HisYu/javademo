<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>辅导员功能</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .button-container {
            text-align: center;
            margin-top: 20px;
        }

        .button-container a {
            display: inline-block;
            padding: 10px 20px;
            margin: 5px;
            background-color: #337ab7;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>欢迎来到辅导员功能</h1>
    <div class="button-container">
        <a href="/javaWebFinalWork/jsp/counselor/studentinfor.jsp">操作学生信息</a>
        <a href="/javaWebFinalWork/jsp/counselor/declear.jsp">发布消息</a>
        <a href="/javaWebFinalWork/jsp/counselor/classcurr.jsp">操作课程表</a>
        <a href="/javaWebFinalWork/jsp/counselor/seeKaoqing.jsp">请假管理</a>
        <a href="/javaWebFinalWork/jsp/counselor/look.jsp">班级事件</a>
    </div>
</div>
</body>
</html>
