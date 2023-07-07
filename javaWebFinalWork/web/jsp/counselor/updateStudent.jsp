<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生信息</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"] {
            width: 100%;
            padding: 5px;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin-top: 10px;
            cursor: pointer;
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
<form method="post" action="/javaWebFinalWork/Servletupdate">
    <input type="hidden" name="studentId" value="<%= studentId %>">
    <label for="name">姓名:</label>
    <input type="text" id="name" name="name" required><br>

    <label for="sex">性别:</label>
    <input type="text" id="sex" name="sex" required><br>

    <label for="tell">电话:</label>
    <input type="text" id="tell" name="tell" required><br>

    <label for="address">地址:</label>
    <input type="text" id="address" name="address" required><br>

    <input type="submit" value="确认修改">${requestScope.sugs}
</form>
<script>
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/counselor/counselorMenu.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>
