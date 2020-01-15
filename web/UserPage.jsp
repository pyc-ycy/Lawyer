<%--
  Created by IntelliJ IDEA.
  User: 御承扬
  Date: 2020/1/15
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户</title>
    <link rel="stylesheet" href="CSS/head.css" type="text/css">
</head>
<body>
<div id="home">
    <div id="header">
        <div id="pageTitle">
        </div>
        <div id="navigator">
            <ul id="navList">
                <li>
                    <a href="agentIndex.jsp">普罗米修</a>
                </li>
                <li>
                    <a href="LawyerIntroduce.jsp">律师简介</a>
                </li>
                <li>
                    <a href="DocumentList.jsp">精品文档</a>
                </li>
                <li>
                    <a href="Consume.jsp">咨询</a>
                </li>
                <li>
                    <a class="target" href="UserPage.jsp">用户</a>
                </li>
            </ul>
        </div>
    </div>
    <form method="post" action="${pageContext.request.contextPath}/SignOutServlet">
        <input type="submit" value="退出登录">
    </form>
</div>
<input type="button">
<div class="b">
    <%@include file="copyright.jsp"%>
</div>
</body>
</html>
