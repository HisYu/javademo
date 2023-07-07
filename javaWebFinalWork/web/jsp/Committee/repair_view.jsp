<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>报修列表</title>
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

        .button {
            padding: 6px 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        .button:hover {
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
<h1>报修列表</h1>
<table>
    <thead>
    <tr>
        <th>学号</th>
        <th>报修者</th>
        <th>报修类型</th>
        <th>报修内容</th>
        <th>处理状态</th>
        <th>报修时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody id="tbody"></tbody>
</table>

<script>
    var tbody = $('#tbody');
    $(function () {
        let studentid;
        $.ajax({
            type: "get",
            url: "/javaWebFinalWork/RepairManagement",
            dataType: "json",
            success: function (data) {
                console.log(data)
                for (var i = 0; i < data.length; i++) {
                    var str = "<tr>";
                    str += "<td>" + data[i].id + "</td>";
                    str += "<td>" + data[i].name + "</td>";
                    str += "<td>" + data[i].type + "</td>";
                    str += "<td>" + data[i].leirong + "</td>";
                    str += "<td>" + data[i].statu + "</td>";
                    str += "<td>" + data[i].time + "</td>";
                    str += "<td><button class='button delect' value='" + data[i].id + "'>修改状态</button></td>";
                    str += "</tr>";
                    tbody.append(str);
                }

                $('.delect').click(function (data) {
                    var studentId = $(this).val();
                    var statu = prompt("请输入状态");

                    $.ajax({
                        type: "post",
                        url: "/javaWebFinalWork/Servletresult",
                        data: {studentId: studentId, statu: statu},
                        success: function (response) {
                        },
                        error: function (error) {
                        }
                    });
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
