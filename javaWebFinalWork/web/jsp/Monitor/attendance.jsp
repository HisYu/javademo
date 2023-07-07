<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>班长出勤统计</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 50px;
            background-color: #f2f2f2;
        }

        h1, h2 {
            color: #333;
            margin-bottom: 20px;
        }

        form {
            margin-bottom: 30px;
        }

        label {
            display: inline-block;
            width: 120px;
            font-weight: bold;
            color: #333;
            margin-bottom: 10px;
        }

        input[type="text"], input[type="date"], select {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 20px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: greenyellow;
            color: #fff;
            border: none;
            cursor: pointer;
            font-size: 18px;
            margin-top: 20px;
            border-radius: 5px;
        }

        input[type="submit"]:hover {
            background-color: #3e8e41;
        }

        #statisticsResult {
            margin-top: 20px;
            color: #333;
            font-size: 16px;
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
<h1>班长出勤统计</h1>

<h2>输入出勤记录</h2>
<form id="attendanceForm" method="post">
    <label for="studentId">学生ID:</label>
    <input type="text" id="studentId" name="studentId" required><br>

    <label for="attendanceDate">出勤日期:</label>
    <input type="date" id="attendanceDate" name="attendanceDate" required><br>

    <label for="attendanceStatus">出勤状态:</label>
    <select id="attendanceStatus" name="attendanceStatus" required>
        <option value="出勤">出勤</option>
        <option value="缺勤">缺勤</option>
        <option value="迟到">迟到</option>
    </select><br>

    <input type="submit" value="保存出勤记录">
</form>

<hr>

<h2>出勤统计</h2>
<form id="statisticsForm" method="get">
    <label for="fromDate">起始日期:</label>
    <input type="date" id="fromDate" name="fromDate" required><br>

    <label for="toDate">结束日期:</label>
    <input type="date" id="toDate" name="toDate" required><br>

    <input type="submit" value="统计出勤">
</form>

<div id="statisticsResult"></div>
<!-- 添加按钮容器和按钮 -->
<div id="buttonContainer">
    <button id="navigateButton" onclick="navigateToAnotherJsp()">回到首页</button>
</div>
<script>
    // 保存出勤记录
    $('#attendanceForm').submit(function (event) {
        event.preventDefault();

        $.ajax({
            url: '/javaWebFinalWork/AttServlet', // 修改为你的Servlet映射路径
            method: 'POST',
            data: $(this).serialize(),
            success: function (response) {
                alert("保存出勤记录成功！"); // 显示保存成功消息
                $('#attendanceForm')[0].reset();
            },

            error: function () {
                alert('保存出勤记录时出现错误！');
            }
        });
    });

    // 统计出勤
    $('#statisticsForm').submit(function (event) {
        event.preventDefault();

        $.ajax({
            url: '/javaWebFinalWork/AttServlet', // 修改为你的Servlet映射路径
            method: 'GET',
            data: $(this).serialize(),
            success: function (data) {
                var result = "";
                for (var i = 0; i < data.length; i++) {
                    result += "学生ID: " + data[i].studentId + ", ";
                    result += "出勤日期: " + data[i].attendanceDate + ", ";
                    result += "出勤状态: " + data[i].attendanceStatus + "<br>";
                }
                $('#statisticsResult').html(result);
            },
            error: function () {
                alert('统计出勤时出现错误！');
            }
        });
    });
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/Monitor/main.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>
