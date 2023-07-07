<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>操作课程表</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
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

        .update {
            padding: 5px 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .update:hover {
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
    <script src="/jquery/jquery-3.6.0.js"></script>
    <meta charset="UTF-8">
</head>
<body>
<!-- 添加按钮容器和按钮 -->
<div id="buttonContainer">
    <button id="navigateButton" onclick="navigateToAnotherJsp()">回到首页</button>
</div>
<table>
    <tbody id="tbody">
    <tr>
        <th>时间</th>
        <th>星期一</th>
        <th>星期二</th>
        <th>星期三</th>
        <th>星期四</th>
        <th>星期五</th>
    </tr>
    </tbody>
</table>

<script>
    var tbody = $('#tbody');

    $(function () {
        $.ajax({
            type: "post",
            url: "/javaWebFinalWork/contrllorLession",
            dataType: "json",
            success: function (data) {
                console.log(data);
                for (var i = 0; i < data.length; i++) {
                    var str = "<tr>";
                    str += "<td>" + data[i].id + "</td>";
                    str += "<td>" + (data[i].x1 || '') + "</td>";
                    str += "<td>" + (data[i].x2 || '') + "</td>";
                    str += "<td>" + (data[i].x3 || '') + "</td>";
                    str += "<td>" + (data[i].x4 || '') + "</td>";
                    str += "<td>" + (data[i].x5 || '') + "</td>";
                    str += "<td><button class='update' value='" + data[i].id + "'>修改</button></td>";

                    str += "</tr>";
                    tbody.append(str);
                }


                $('.update').click(function () {
                    var studentId = $(this).val();
                    window.location.href = "/javaWebFinalWork/jsp/counselor/LessionCurr.jsp?studentId=" + studentId;
                });


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
