<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息管理</title>
    <script src="/jquery/jquery-3.6.0.js"></script>
    <meta charset="UTF-8">
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

        .delect, .update {
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
        <th>性别</th>
        <th>电话</th>
        <th>地址</th>
        <th>操作</th>
    </tr>
    </tbody>
</table>

<script>
    $(document).ready(function() {
        var tbody = $('#tbody');
        $.ajax({
            type: "post",
            url: "/javaWebFinalWork/Servletinfor",
            dataType: "json",
            success: function(data) {
                console.log(data);
                for (var i = 0; i < data.length; i++) {
                    var str = "<tr>";
                    str += "<td>" + data[i].id + "</td>";
                    str += "<td>" + data[i].name + "</td>";
                    str += "<td>" + data[i].sex + "</td>";
                    str += "<td>" + data[i].tell + "</td>";
                    str += "<td>" + data[i].address + "</td>";
                    str += "<td><button class='delect' value='" + data[i].id + "'>删除学生</button>" +
                        "<button class='update' value='" + data[i].id + "'>修改学生</button></td>";
                    str += "</tr>";
                    tbody.append(str);
                }

                $('.delect').click(function() {
                    var studentId = $(this).val();
                    $.ajax({
                        type: "post",
                        url: "/javaWebFinalWork/ServletdelectStu",
                        data: { studentId: studentId },
                        success: function(response) {},
                        error: function(error) {}
                    });
                });

                $('.update').click(function() {
                    var studentId = $(this).val();
                    window.location.href = "/javaWebFinalWork/jsp/counselor/updateStudent.jsp?studentId=" + studentId;
                });
            }
        });
    });
</script>
<button><a href="/javaWebFinalWork/jsp/counselor/addStudent.jsp">添加学生</a></button>
<script>
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/counselor/counselorMenu.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>
