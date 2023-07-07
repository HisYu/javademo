<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="bean.Committee.LaterReturn" %>
<%@ page import="Dao.CommitteeDao.StudentDAO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>晚归管理</title>
    <script src="/jquery/jquery-3.6.0.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }

        h1 {
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        form {
            margin-top: 20px;
        }

        label {
            font-weight: bold;
            display: inline-block;
            width: 120px;
        }

        input[type="text"],
        input[type="datetime-local"] {
            padding: 6px;
            width: 200px;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
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
<body>
<!-- 添加按钮容器和按钮 -->
<div id="buttonContainer">
    <button id="navigateButton" onclick="navigateToAnotherJsp()">回到首页</button>
</div>
<h1>晚归管理</h1>
<table>
    <thead>
    <tr>
        <th>序号</th>
        <th>学生姓名</th>
        <th>学号</th>
        <th>归寝时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody id="tbody"></tbody>
</table>

<h2>添加学生归寝信息</h2>
<form action="/javaWebFinalWork/ServletaddLater" method="post">
    <label for="name">姓名:</label>
    <input type="text" id="name" name="name" required><br>
    <label for="studentId">学号:</label>
    <input type="text" id="studentId" name="studentId" required><br>
    <label for="returnTime">预计归寝时间:</label>
    <input type="datetime-local" id="returnTime" name="returnTime" required><br>
    <input type="submit" value="添加">
</form>

<script>
    var tbody = $('#tbody');
    $(function () {
        let studentid;
        $.ajax({
            type: "get",
            url: "/javaWebFinalWork/LateReturnController",
            dataType: "json",
            success: function (data) {
                console.log(data)
                for (var i = 0; i < data.length; i++) {
                    var str = "<tr>";
                    str += "<td>" + data[i].id + "</td>";
                    str += "<td>" + data[i].name + "</td>";
                    str += "<td>" + data[i].studentId + "</td>";
                    var timestamp = data[i].returnTime;
                    var date = new Date(timestamp);
                    var formattedDate = date.toLocaleString();
                    str += "<td>" + formattedDate + "</td>";
                    str += "<td><button class='update' value='" + data[i].id + "'>修改</button></td>";
                    str += "</tr>";
                    tbody.append(str);
                }

                $('.update').click(function () {
                    var studentId = $(this).val();
                    console.log(studentId);
                    window.location.href = "/javaWebFinalWork/jsp/Committee/repair_viewUpdate.jsp?studentId=" + studentId;
                });
            }
        });
    });
</script>
<script>
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/Committee/committeeMenu.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>
