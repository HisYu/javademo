<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>生活委员公告</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        .delete {
            background-color: #ff0000;
            color: white;
            border: none;
            padding: 5px 10px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 12px;
            cursor: pointer;
        }

        .delete:hover {
            background-color: #cc0000;
        }

        a {
            text-decoration: none;
            color: black;
        }

        button {
            margin-top: 10px;
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
<h1>公告列表</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>标题</th>
        <th>内容</th>
        <th>时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody id="tbody"></tbody>

    <script>
        $(function () {
            $.ajax({
                type: "get",
                url: "/javaWebFinalWork/AnnouncementController",
                dataType: "json",
                success: function (data) {
                    console.log(data);
                    var tbody = $('#tbody');
                    for (var i = 0; i < data.length; i++) {
                        var str = "<tr>";
                        str += "<td>" + data[i].id + "</td>";
                        str += "<td>" + data[i].title + "</td>";
                        str += "<td>" + data[i].content + "</td>";
                        var timestamp = data[i].time;
                        var date = new Date(timestamp);
                        var formattedDate = date.toLocaleString();
                        str += "<td>" + formattedDate + "</td>";
                        str += "<td><button class='delete' value='" + data[i].id + "'>删除</button></td>";

                        str += "</tr>";
                        tbody.append(str);
                    }

                    $('.delete').click(function (data) {
                        var studentId = $(this).val();
                        $.ajax({
                            type: "post",
                            url: "/javaWebFinalWork/ServletdelectAnn",
                            data: {studentId: studentId},
                            success: function (response) {
                            },
                            error: function (error) {
                            }
                        });
                    });
                },
                error: function (xhr, status, error) {
                    console.error(error);
                }
            });
        });
    </script>
</table>
<button><a href="/javaWebFinalWork/jsp/Committee/addannounce.jsp">发布公告</a></button>
<script>
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/Committee/committeeMenu.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>
