<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="bean.Monitor.Notification" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>班长-通知列表</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        h1 {
            text-align: center;
            margin-top: 50px;
            margin-bottom: 30px;
        }
        table {
            margin: auto;
            width: 80%;
            max-width: 800px;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ccc;
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
<h1>通知列表</h1>
<!-- 添加按钮容器和按钮 -->
<div id="buttonContainer">
    <button id="navigateButton" onclick="navigateToAnotherJsp()">回到首页</button>
</div>
<table>
    <tr>
        <th>ID</th>
        <th>标题</th>
        <th>内容</th>
    </tr>
    <%
        List<Notification> notificationList = (List<Notification>) request.getAttribute("notificationList");
        if (notificationList != null && !notificationList.isEmpty()) {
            for (Notification notification : notificationList) {
    %>
    <tr>
        <td><%= notification.getId() %></td>
        <td><%= notification.getTitle() %></td>
        <td><%= notification.getContent() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="3">暂无通知</td>
    </tr>
    <%
        }
    %>
</table>
<script>
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/Monitor/main.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>