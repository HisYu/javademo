<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加成绩</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 4px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 4px;
            background-color: #4CAF50;
            color: white;
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
<h1>添加成绩</h1>
<form action="/javaWebFinalWork/controlleradd" method="post">
    <label for="stuid">学号:</label>
    <input type="text" id="stuid" name="stuid" required>

    <label for="studentName">姓名:</label>
    <input type="text" id="studentName" name="studentName" required>

    <label for="java">Java:</label>
    <input type="text" id="java" name="java" required>

    <label for="javaweb">JavaWeb:</label>
    <input type="text" id="javaweb" name="javaweb" required>

    <label for="datastruct">数据结构:</label>
    <input type="text" id="datastruct" name="datastruct" required>

    <input type="submit" value="添加">
    <span>${requestScope.sugs}</span>
</form>
<script>
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/prefect/prefectMenu.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>
