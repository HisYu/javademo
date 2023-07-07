<%--
  Created by IntelliJ IDEA.
  User: heyua
  Date: 2023/6/19
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/jquery/jquery-3.6.0.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f5f5f5;
        }

        .delect {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 5px 10px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            margin: 2px 2px;
            cursor: pointer;
            border-radius: 4px;
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
<table>
    <tbody id="tbody">
    <tr>
        <th>ID</th>
        <th>学生</th>
        <th>时间</th>
        <th>事件</th>
    </tr>
    </tbody>
</table>

<script>
    $(document).ready(function() {
        var tbody = $('#tbody');

        $.ajax({
            type: "post",
            url: "/javaWebFinalWork/ServletseeKaoqing",
            dataType: "json",
            success: function(data) {
                console.log(data);
                for (var i = 0; i < data.length; i++) {
                    var str = "<tr>";
                    str += "<td>" + data[i].id + "</td>";
                    str += "<td>" + (data[i].studentName || '') + "</td>";
                    str += "<td>" + (data[i].datatime || '') + "</td>";
                    str += "<td>" + (data[i].text || '') + "</td>";
                    if (data[i].text === "请假") {
                        str += "<td><button class='delect' value='" + data[i].id + "' onclick='updateScore(" + data[i].id + ")'>同意请假</button></td>";
                    }
                    str += "</tr>";
                    tbody.append(str);
                }

                $('.delect').click(function() {
                    var studentId = $(this).val();
                    hideRow(studentId); // 调用隐藏行的函数
                    $.ajax({
                        type: "post",
                        url: "/javaWebFinalWork/ServletdelectInfor",
                        data: { studentId: studentId },
                        success: function(response) {},
                        error: function(error) {}
                    });
                });
            }
        });

        function hideRow(id) {
            $('#tbody tr').each(function() {
                var rowId = $(this).find('td:first').text();
                if (rowId === id) {
                    $(this).hide(); // 隐藏对应的行
                    return false; // 结束循环
                }
            });
        }
    });
</script>
<script>
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/counselor/counselorMenu.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>
