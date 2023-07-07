<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/jquery/jquery-3.6.0.js"></script>
<html>
<head>
    <title>学委功能</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
        }

        h1 {
            text-align: center;
            margin-top: 50px;
        }

        button {
            display: block;
            margin: 10px auto;
            padding: 12px 24px;
            font-size: 16px;
            font-weight: bold;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        a {
            text-decoration: none;
            color: black;
        }
    </style>
</head>
<body>
<h1>欢迎来到学委功能</h1>
<button><a href="/javaWebFinalWork/jsp/prefect/student_form.jsp">操作学生成绩</a></button>
<button><a href="/javaWebFinalWork/jsp/prefect/bukao.jsp">补考学生成绩名单</a></button>
<button><a href="/javaWebFinalWork/jsp/prefect/seeLession.jsp">接收辅导员消息</a></button>
<button><a href="/javaWebFinalWork/jsp/prefect/kaoqing.jsp">考勤</a></button>
</body>
</html>
