<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>提交成功</title>
</head>
<style>
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
<body>
<!-- 添加按钮容器和按钮 -->
<div id="buttonContainer">
    <button id="navigateButton" onclick="navigateToAnotherJsp()">回到首页</button>
</div>
<h2>提交成功！</h2>
<p>汇报已成功提交。</p>
<script>
    // 返回首页
    function navigateToAnotherJsp() {
        window.location.href = "/javaWebFinalWork/jsp/Monitor/main.jsp"; // 修改为另一个 JSP 页面的路径
    }
</script>
</body>
</html>
