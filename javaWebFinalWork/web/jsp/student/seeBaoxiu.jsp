<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>报修</title>
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
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        input[type="text"],
        input[type="submit"] {
            padding: 8px;
            border-radius: 4px;
            border: 1px solid #cccccc;
        }

        input[type="submit"] {
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
<h1>请输入你的学号来查看报修</h1>
<form action="/javaWebFinalWork/ServletseeBaoxiu" method="post">
    <input type="text" name="id">
    <input type="submit" value="提交">
</form>

<table>
    <thead>
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>报修类型</th>
        <th>报修内容</th>
        <th>报修时间</th>
        <th>报修状态</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="it" items="${requestScope.repairBeans}">
        <tr>
            <td>${it.id}</td>
            <td>${it.name}</td>
            <td>${it.type}</td>
            <td>${it.leirong}</td>
            <td>${it.time}</td>
            <td>${it.statu}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<script>
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/student/studentMenu.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>
