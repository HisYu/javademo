<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>班费管理系统</title>
    <script src="/jquery/jquery-3.6.0.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }

        h1 {
            margin-bottom: 20px;
        }

        h2 {
            margin-top: 30px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        form {
            margin-top: 20px;
        }

        label {
            font-weight: bold;
        }

        input[type="text"],
        input[type="number"] {
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
<h1>班费管理系统</h1>

<h2>支出记录</h2>
<table>
    <thead>
    <tr>
        <th>编号</th>
        <th>描述</th>
        <th>金额</th>
        <th>剩余</th>
    </tr>
    </thead>
    <tbody id="tbody"></tbody>
</table>

<form action="/javaWebFinalWork/ServletaddExpense" method="POST">
    <label for="description">描述：</label>
    <input type="text" id="description" name="description" required><br>
    <label for="amount">金额：</label>
    <input type="number" id="amount" name="amount" required><br>
    <input type="submit" value="添加支出"><br>
</form>

<script>
    var totalAmount;
    var tbody = $('#tbody');
    $(function () {
        $.ajax({
            type: "post",
            url: "/javaWebFinalWork/ExpenseController",
            dataType: "json",
            success: function (data) {
                console.log(data)
                for (var i = 0; i < data.length; i++) {
                    var str = "<tr>";
                    str += "<td>" + data[i].id + "</td>";
                    str += "<td>" + data[i].description + "</td>";
                    str += "<td>" + data[i].amount + "</td>";
                    str += "<td>" + data[i].total_amount + "</td>";
                    str += "</tr>";
                    tbody.append(str);
                }
                totalAmount = data[data.length - 1].total_amount
            }
        })
    })
</script>
<script>
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/Committee/committeeMenu.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>
