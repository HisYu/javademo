<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>报修表单</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        h1 {
            text-align: center;
            margin-top: 20px;
        }

        .form-container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        form {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: inline-block;
            width: 120px;
        }

        input[type="text"],
        textarea,
        select,
        input[type="datetime-local"] {
            width: 300px;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-bottom: 10px;
        }

        textarea {
            height: 100px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
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
<h1>报修表单</h1>
<div class="form-container">
    <form action="/javaWebFinalWork/ServletBaoXiu" method="POST">
        <label for="name">姓名：</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="studentId">学号：</label>
        <input type="text" id="studentId" name="id" required><br><br>

        <label for="type">报修类型：</label>
        <select id="type" name="type">
            <option value="电器维修">电器维修</option>
            <option value="水管维修">水管维修</option>
            <option value="家具维修">家具维修</option>
        </select><br><br>

        <label for="content">报修内容：</label><br>
        <textarea id="content" name="leirong" rows="4" cols="50" required></textarea><br><br>

        <label for="date">报修日期：</label>
        <input type="datetime-local" id="date" name="time" required><br><br>

        <input type="submit" value="提交">
    </form>
</div>
<script>
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/student/studentMenu.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>
