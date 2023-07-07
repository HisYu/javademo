<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生报修</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
        }

        h1 {
            text-align: center;
            margin-top: 50px;
            margin-bottom: 30px;
        }

        .button-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 30px;
        }

        button {
            width: 250px;
            padding: 15px 20px;
            border: none;
            border-radius: 5px;
            background-color: #4CAF50;
            color: white;
            font-size: 16px;
            text-align: center;
            text-decoration: none;
            cursor: pointer;
            margin-bottom: 15px;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h1>学生功能</h1>
<div class="button-container">
    <button><a href="/javaWebFinalWork/jsp/student/repair_form.jsp">报修</a></button>
    <button><a href="/javaWebFinalWork/jsp/student/seeBaoxiu.jsp">查看报修</a></button>
    <button><a href="/javaWebFinalWork/jsp/student/accept.jsp">接收通知</a></button>
</div>
</body>
</html>
