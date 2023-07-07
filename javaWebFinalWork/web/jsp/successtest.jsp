<%--
  Created by IntelliJ IDEA.
  User: heyua
  Date: 2023/6/1
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--得到用户名--%>
<%
    String name = (String) request.getSession().getAttribute("loginName");

   request.getSession().setAttribute("loginName",name);
    response.sendRedirect("/javaWebFinalWork/controllerMenu");
%>

<script>

</script>
</body>
</html>
