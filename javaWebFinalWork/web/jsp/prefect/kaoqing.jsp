<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>考勤管理</title>
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

        a {
            text-decoration: none;
            color: black;
        }

        button {
            margin-top: 10px;
            padding: 8px 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
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
<table>
    <tbody id="tbody">
    <tr>
        <th>ID</th>
        <th>学生</th>
        <th>时间</th>
        <th>事件</th>
        <th>操作</th>
    </tr>
    <script>
        var tbody = $('#tbody');

        $.ajax({
            type: "post",
            url: "/javaWebFinalWork/controllerkaoqing",
            dataType: "json",
            success: function (data) {
                console.log(data);
                for (var i = 0; i < data.length; i++) {
                    var str = "<tr>";
                    str += "<td>" + data[i].id + "</td>";
                    str += "<td>" + (data[i].studentName || '') + "</td>";
                    str += "<td>" + (data[i].datetime || '') + "</td>";
                    str += "<td>" + (data[i].text || '') + "</td>";
                    str += "<td><button class='update' value='" + data[i].id + "'>修改考勤</button></td>";
                    str += "</tr>";
                    tbody.append(str);
                }
                $('.update').click(function () {
                    var id = $(this).val();
                    window.location.href = "/javaWebFinalWork/jsp/prefect/updatekq.jsp?id=" + id;
                });
            }
        });

    </script>
    </tbody>
</table>
<button><a href="/javaWebFinalWork/jsp/prefect/addKaoqing.jsp">添加考勤</a></button>
<script>
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/prefect/prefectMenu.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>
