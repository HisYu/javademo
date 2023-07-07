<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>班长-发布通知</title>
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

        form {
            margin: auto;
            width: 50%;
            max-width: 600px;
            background-color: #fff;
            padding: 30px;
            border-radius: 5px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        input[type=text],
        textarea {
            display: block;
            width: 100%;
            padding: 10px;
            font-size: 16px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        input[type=submit] {
            background-color: #4CAF50;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 18px;
            margin-top: 20px;
        }

        input[type=submit]:hover {
            background-color: #3e8e41;
        }

        button {
            border-radius: 5px;
            background-color: #337ab7;
            color: #ffffff;
            padding: 10px 20px;
            border: 1px solid #337ab7;
            box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
            cursor: pointer;
        }

        button:hover {
            background-color: blue;
        }

        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 20px;
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
<h1>请输入你要发布的通知</h1>
<form action="/javaWebFinalWork/NotificationServlet" method="post">
    <label for="title">标题</label>
    <input type="text" id="title" name="title" required>
    <label for="content">内容</label>
    <textarea id="content" name="content" rows="10" required></textarea>
    <input type="submit" value="发布通知">
</form>
<!-- 添加按钮容器和按钮 -->
<div id="buttonContainer">
    <button id="navigateButton" onclick="navigateToAnotherJsp()">回到首页</button>
</div>
<div class="container">
    <button onclick="window.location.href='/javaWebFinalWork/NotificationListServlet'">查看已发布的通知</button>
</div>
<script>
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/Monitor/main.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>
