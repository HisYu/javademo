<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程表</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
        }

        form {
            width: 300px;
            margin: 0 auto;
        }

        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
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
<%
    String studentId = request.getParameter("studentId");
    request.setAttribute("i", studentId);
%>

<form action="/javaWebFinalWork/ServletLessionCurr" method="post">
    <input type="hidden" name="studentId" value="<%= studentId %>">

    <label for="x1">星期一:</label>
    <input type="text" name="x1" value="<%= request.getAttribute("x1")%>"><br>

    <label for="x2">星期二:</label>
    <input type="text" name="x2" value="<%= request.getParameter("x2")%>"><br>

    <label for="x3">星期三:</label>
    <input type="text" name="x3" value="<%= request.getParameter("x3")%>"><br>

    <label for="x4">星期四:</label>
    <input type="text" name="x4" value="<%= request.getParameter("x4")%>"><br>

    <label for="x5">星期五:</label>
    <input type="text" name="x5" value="<%= request.getParameter("x5")%>"><br>

    <input type="submit" value="确认修改"><br>
</form>
<script>
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/counselor/counselorMenu.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>
