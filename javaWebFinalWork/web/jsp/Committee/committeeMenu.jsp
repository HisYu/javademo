<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>生活委员功能</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        padding: 20px;
        text-align: center;
    }

    h1 {
        margin-bottom: 20px;
    }

    button {
        margin: 10px;
        padding: 10px 20px;
        font-size: 16px;
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
    }

    button a {
        text-decoration: none;
        color: white;
    }
</style>

<body>
<h1>欢迎来到生活委员功能界面</h1>
<button><a href="/javaWebFinalWork/jsp/Committee/repair_view.jsp">查看维修</a></button>
<button><a href="/javaWebFinalWork/jsp/Committee/announcement.jsp">发布公告</a></button>
<button><a href="/javaWebFinalWork/jsp/Committee/lateReturn.jsp">查看归寝</a></button>
<button><a href="/javaWebFinalWork/jsp/Committee/ExpenseManager.jsp">班费管理</a></button>
</body>
</html>
