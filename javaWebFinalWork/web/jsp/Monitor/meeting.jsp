<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>组织班会</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 50px auto;
            max-width: 500px;
            background-color: #f2f2f2;
            padding: 20px;
            border-radius: 10px;
        }

        h1 {
            color: #FF4500;
            text-align: center;
            margin-bottom: 30px;
        }

        form {
            margin-top: 20px;
        }

        label {
            display: inline-block;
            width: 80px;
            font-weight: bold;
            color: #333;
            margin-bottom: 10px;
        }

        input[type="text"], input[type="datetime-local"] {
            padding: 10px;
            width: 100%;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 20px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: #FF4500;
            color: #fff;
            border: none;
            cursor: pointer;
            font-size: 18px;
            margin-top: 20px;
            border-radius: 5px;
        }

        input[type="submit"]:hover {
            background-color: #FF6347;
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
<h1>组织班会</h1>
<!-- 添加按钮容器和按钮 -->
<div id="buttonContainer">
    <button id="navigateButton" onclick="navigateToAnotherJsp()">回到首页</button>
</div>
<form action="${pageContext.request.contextPath}/MeetingServlet" method="post">
    <label for="title">标题：</label>
    <input type="text" id="title" name="title" required><br><br>
    <label for="time">时间：</label>
    <input type="datetime-local" id="time" name="time" required><br><br>
    <label for="spot">地点：</label>
    <input type="text" id="spot" name="spot" required><br><br>
    <input type="submit" value="发布班会">
</form>
<script>
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/Monitor/main.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>
