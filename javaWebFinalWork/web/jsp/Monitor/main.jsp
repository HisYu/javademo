<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>班长-主界面</title>
    <style>
        #BigBodyFrame{
            width: 100%;
            height: 120px;
            border: gray 2px solid;
            text-align: center;
        }

        li{
            padding-top: 10px;
            margin-bottom: 10px;
            list-style: none;
        }
        #daohang{
            width: 250px;
            float: left;
            border: gray 1px solid;
        }
        #file{
            width: 230px;
            height: 50px;
            margin-left: 10px;
            margin-top: 10px;
            border: gray 1px solid;
        }
        a:hover {
            color: black;
        }
        a{
            text-decoration:none;
            color: gray;
            font-size: 26px;
            margin-top: 25px;
            margin-left: 30px;
        }
    </style>
</head>
<body>
<div id="BigBodyFrame">
   <h1>欢迎来到班长主界面^_^</h1>
</div>
<br>

<br>
<div id="daohang">
    <%--    //班长--%>
        <li id="file"><a href="/javaWebFinalWork/jsp/Monitor/notification.jsp">发布通知</a></li>
        <li id="file"><a href="/javaWebFinalWork/jsp/Monitor/meeting.jsp">组织班会</a></li>
        <li id="file"><a href="/javaWebFinalWork/jsp/Monitor/attendance.jsp">统计出勤</a></li>
        <li id="file"><a href="/javaWebFinalWork/jsp/Monitor/report.jsp">汇报班级情况</a></li>
        <li id="file"><a href="/javaWebFinalWork/index.jsp">退出系统</a></li>
</div>
</body>
</html>
