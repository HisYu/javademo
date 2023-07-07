<%@ page import="bean.prefect.Score" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生成绩管理</title>
    <script src="/jquery/jquery-3.6.0.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
        }

        h1, h2 {
            margin-top: 0;
        }

        a {
            text-decoration: none;
            color: black;
        }

        .addbut {
            margin-bottom: 10px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f5f5f5;
            font-weight: bold;
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
<h1>学生成绩管理</h1>

<h2>成绩列表</h2>
<button class="addbut"><a href="/javaWebFinalWork/jsp/prefect/addScore.jsp">添加</a></button>

<table>
    <tbody id="tbody">
    <tr>
        <th>ID</th>
        <th>学生</th>
        <th>数据结构</th>
        <th>Java</th>
        <th>JavaWeb</th>
    </tr>
    </tbody>
    <script>
        var tbody = $('#tbody');
        $(function () {
            let studentid;
            $.ajax({
                type: "get",
                url: "/javaWebFinalWork/controllerScore",
                dataType: "json",
                success: function (data) {
                    console.log(data)
                    for (var i = 0; i < data.length; i++) {
                        var str = "<tr>";
                        str += "<td>" + data[i].studentid + "</td>";
                        str += "<td>" + data[i].studentsName + "</td>";
                        str += "<td>" + data[i].java + "</td>";
                        str += "<td>" + data[i].javaweb + "</td>";
                        str += "<td>" + data[i].datastruct + "</td>";
                        str += "<td><button class='delect' value='" + data[i].studentid + "'>删除</button>" +
                            "<button class='update' value='" + data[i].studentid + "' onclick='updateScore(" + data[i].studentid + ")'>修改</button></td>";
                        str += "</tr>";
                        tbody.append(str);
                    }

                    $('.delect').click(function (data) {
                        var studentId = $(this).val();
                        $.ajax({
                            type: "post",
                            url: "/javaWebFinalWork/controllerScore",
                            data: {studentId: studentId},
                            success: function (response) {
                            },
                            error: function (error) {
                            }
                        });
                    });

                    $('.update').click(function (data) {
                        var studentId = $(this).val();
                        console.log(data);
                        window.location.href = "/javaWebFinalWork/jsp/prefect/updateForm.jsp?studentId=" + studentId;
                    });
                }
            });
        });

        function updateScore(studentId) {
            window.location.href = "/javaWebFinalWork/jsp/prefect/updateForm.jsp?studentId=" + studentId;
        }
    </script>
</table>
<script>
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/prefect/prefectMenu.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>
