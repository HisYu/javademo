<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生信息</title>
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

        input[type="text"] {
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
<body>
<!-- 添加按钮容器和按钮 -->
<div id="buttonContainer">
    <button id="navigateButton" onclick="navigateToAnotherJsp()">回到首页</button>
</div>
<h1>添加学生信息</h1>
<form method="post" action="/javaWebFinalWork/ServletAdd">
    <label for="id">学号:</label>
    <br>
    <input type="text" name="id" id="id">
    <br>
    <label for="name">姓名:</label>
    <br>
    <input type="text" name="name" id="name">
    <br>
    <label for="sex">性别:</label>
    <br>
    <input type="text" name="sex" id="sex">
    <br>
    <label for="tell">电话:</label>
    <br>
    <input type="text" name="tell" id="tell">
    <br>
    <label for="address">地址:</label>
    <br>
    <input type="text" name="address" id="address">
    <br>
    <input type="submit" value="添加">
    ${requestScope.sugs}
</form>
<script>
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/counselor/counselorMenu.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>
