<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>接收考勤的情况</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
        }

        h1 {
            text-align: center;
            margin-top: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ccc;
        }

        th {
            background-color: #f5f5f5;
            font-weight: bold;
        }

        .delete {
            padding: 5px 10px;
            background-color: #f44336;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .delete:hover {
            background-color: #d32f2f;
        }

        button {
            display: block;
            margin-top: 20px;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            background-color: #4CAF50;
            color: white;
            text-align: center;
            text-decoration: none;
            cursor: pointer;
        }

        button:hover {
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
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
</table>

<button><a href="/javaWebFinalWork/jsp/counselor/addGonggao.jsp">公告</a></button>

<script>
    $(function () {
        $.ajax({
            type: "get",
            url: "/javaWebFinalWork/Servletcouninfor",
            dataType: "json",
            success: function (data) {
                console.log(data);
                var tbody = $('#tbody');
                for (var i = 0; i < data.length; i++) {
                    var str = "<tr>";
                    str += "<td>" + data[i].id + "</td>";
                    str += "<td>" + data[i].title + "</td>";
                    str += "<td>" + data[i].content + "</td>";
                    str += "<td>" + data[i].time + "</td>";
                    str += "<td><button class='delete' value='" + data[i].id + "'>删除</button></td>";
                    str += "</tr>";
                    tbody.append(str);
                }

                $('.delete').click(function () {
                    var studentId = $(this).val();
                    $.ajax({
                        type: "post",
                        url: "/javaWebFinalWork/ServletDelectInfor",
                        data: {studentId: studentId},
                        success: function (response) {
                            // 处理删除成功后的逻辑
                        },
                        error: function (error) {
                            // 处理错误
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
<script>
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/counselor/counselorMenu.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>
