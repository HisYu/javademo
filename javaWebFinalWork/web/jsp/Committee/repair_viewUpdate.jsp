<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生归寝情况</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
        }

        h1 {
            color: #333333;
        }

        form {
            margin-top: 20px;
        }

        label {
            font-weight: bold;
        }

        input[type="datetime-local"] {
            padding: 8px;
            border-radius: 4px;
            border: 1px solid #cccccc;
            width: 300px;
        }

        input[type="submit"] {
            padding: 8px 16px;
            border-radius: 4px;
            border: none;
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
<% String studentId = request.getParameter("studentId"); %>

<body>
<!-- 添加按钮容器和按钮 -->
<div id="buttonContainer">
    <button id="navigateButton" onclick="navigateToAnotherJsp()">回到首页</button>
</div>
<h1>修改归寝信息</h1>
<form action="/javaWebFinalWork/ServletUpdatLater" method="post">
    <input type="hidden" name="studentId" value="<%= studentId %>">

    <label for="returnTime">归寝时间:</label>
    <br>
    <input type="datetime-local" id="returnTime" name="returntime">
    <br>
    <input type="submit" value="点击修改">
</form>
<script>
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/Committee/committeeMenu.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>
