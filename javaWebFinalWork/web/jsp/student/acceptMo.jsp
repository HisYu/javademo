<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>接收班长消息</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        h1 {
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 8px;
            border-bottom: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
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
<h1>接收班长消息</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>标题</th>
        <th>内容</th>
    </tr>
    </thead>
    <tbody id="tbody"></tbody>
    <script>
        $(function () {
            $.ajax({
                type: "get",
                url: "/javaWebFinalWork/ServletseeTongzhi",
                dataType: "json",
                success: function (data) {
                    console.log(data);
                    var tbody = $('#tbody');
                    for (var i = 0; i < data.length; i++) {
                        var str = "<tr>";
                        str += "<td>" + data[i].id + "</td>";
                        str += "<td>" + data[i].title + "</td>";
                        str += "<td>" + data[i].content + "</td>";
                        str += "</tr>";
                        tbody.append(str);
                    }
                }
            });
        });
    </script>
</table>
<script>
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/student/studentMenu.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>
