<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Look Data</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
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
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f5f5f5;
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
<h1>查看班级事件</h1>
<table id="lookTable">
    <tr>
        <th>事件序号</th>
        <th>发生时间</th>
        <th>事件</th>
    </tr>
</table>

<script>
    // 创建XMLHttpRequest对象
    var xhr = new XMLHttpRequest();

    // 指定请求的URL和请求方式（这里使用GET请求）
    xhr.open("GET", "/javaWebFinalWork/LookServlet", true);

    // 指定响应的数据类型为JSON
    xhr.responseType = "json";

    // 注册请求完成的回调函数
    xhr.onload = function() {
        if (xhr.status === 200) {
            var lookList = xhr.response;

            // 获取表格元素
            var table = document.getElementById("lookTable");

            // 循环遍历数据并添加到表格中
            for (var i = 0; i < lookList.length; i++) {
                var look = lookList[i];

                var row = table.insertRow(i + 1);
                var idCell = row.insertCell(0);
                var timeCell = row.insertCell(1);
                var contentCell = row.insertCell(2);

                idCell.innerHTML = look.id;
                timeCell.innerHTML = look.reptime;
                contentCell.innerHTML = look.repevent;
            }
        }
    };

    // 发送请求
    xhr.send();
</script>
<script>
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/counselor/counselorMenu.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>
