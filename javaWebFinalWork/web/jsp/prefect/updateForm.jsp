<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
        }

        h1 {
            margin-top: 0;
        }

        form {
            margin-top: 20px;
        }

        label {
            display: inline-block;
            width: 100px;
            font-weight: bold;
        }

        input[type="text"] {
            padding: 5px;
            width: 200px;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            padding: 5px 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        /* 添加按钮样式 */
        #buttonContainer {
            position: fixed;
            right: 30px;
            bottom: 30px;
        }

        #navigateButton {
            padding: 10px 20px;
            background-color: #3e8e41;
            color: #fff;
            border: none;
            cursor: pointer;
            font-size: 16px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<!-- 添加按钮容器和按钮 -->
<div id="buttonContainer">
    <button id="navigateButton" onclick="navigateToAnotherJsp()">回到首页</button>
</div>
<h1>修改表单</h1>

<% String studentId = request.getParameter("studentId"); %>

<!-- 修改表单 -->
<form action="/javaWebFinalWork/ControllerUpdate" method="post">
    <input type="hidden" name="studentId" value="<%= studentId %>">
    <label for="java1">Java:</label>
    <input type="text" id="java1" name="java1"><br>
    <label for="javaweb2">JavaWeb:</label>
    <input type="text" id="javaweb2" name="javaweb2"><br>
    <label for="datastruct3">DataStruct:</label>
    <input type="text" id="datastruct3" name="datastruct3"><br>
    <input type="submit" value="确认修改">
</form>
<script>
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/prefect/prefectMenu.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>
