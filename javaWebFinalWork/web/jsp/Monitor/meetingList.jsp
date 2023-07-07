<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>班会列表</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h1 {
            color: #333;
            text-align: center;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 10px;
        }

        h3 {
            margin: 0;
        }

        p {
            margin: 5px 0;
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        $(document).ready(function() {
            // 页面加载完成后，通过 Ajax 请求获取班会列表数据
            $.ajax({
                url: "/javaWebFinalWork/MeetingListServlet",
                type: "GET",
                dataType: "json",
                success: function(data) {
                    // 请求成功后，处理返回的班会列表数据
                    if (data && data.length > 0) {
                        // 遍历班会列表数据，生成列表项并添加到页面
                        $.each(data, function(index, meeting) {
                            var listItem = "<li>" +
                                "<h3>" + meeting.title + "</h3>" +
                                "<p>时间：" + meeting.time + "</p>" +
                                "<p>地点：" + meeting.spot + "</p>" +
                                "</li>";
                            $("#meetingList").append(listItem);
                        });
                    } else {
                        // 没有班会数据时显示提示信息
                        $("#meetingList").append("<li>暂无班会记录</li>");
                    }
                },
                error: function() {
                    // 请求失败时显示错误信息
                    $("#meetingList").append("<li>获取班会列表失败</li>");
                }
            });
        });
    </script>
</head>
<body>
<h1>班会列表</h1>
<!-- 添加按钮容器和按钮 -->
<div id="buttonContainer">
    <button id="navigateButton" onclick="navigateToAnotherJsp()">回到首页</button>
</div>
<ul id="meetingList"></ul>
<script>
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/Monitor/main.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>
