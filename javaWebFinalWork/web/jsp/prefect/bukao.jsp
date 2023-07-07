<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生成绩</title>
    <script src="/jquery/jquery-3.6.0.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
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
            background-color: #f5f5f5;
            font-weight: bold;
        }

        .hidden {
            display: none;
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
    <thead>
    <tr>
        <th>Name</th>
        <th>Java</th>
        <th>JavaWeb</th>
        <th>Data Structure</th>
    </tr>
    </thead>
    <tbody id="scoresTableBody"></tbody>
</table>

<script>
    $(function () {
        $.ajax({
            type: "post",
            url: "/javaWebFinalWork/ServletSelectFaildScore",
            dataType: "json",
            success: function (data) {
                console.log(data);
                var tbody = $('#scoresTableBody');
                for (var i = 0; i < data.length; i++) {
                    var str = "<tr>";
                    str += "<td>" + data[i].studentsName + "</td>";

                    if (data[i].java < 60) {
                        str += "<td>" + data[i].java + " (需要补考)</td>";
                    } else {
                        str += "<td>" + data[i].java + "</td>";
                    }

                    if (data[i].javaweb < 60) {
                        str += "<td>" + data[i].javaweb + " (需要补考)</td>";
                    } else {
                        str += "<td>" + data[i].javaweb + "</td>";
                    }

                    if (data[i].datastruct < 60) {
                        str += "<td>" + data[i].datastruct + " (需要补考)</td>";
                    } else {
                        str += "<td>" + data[i].datastruct + "</td>";
                    }

                    str += "</tr>";
                    tbody.append(str);
                }
            },
            error: function (xhr, status, error) {
                console.error("Failed to retrieve scores. Status: " + xhr.status + ", Error: " + error);
            }
        });
    });
</script>
<script>
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/prefect/prefectMenu.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>
