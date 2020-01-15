<%--
  Created by IntelliJ IDEA.
  User: 御承扬
  Date: 2020/1/15
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>精品文档</title>
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
                    <a class="target" href="DocumentList.jsp">精品文档</a>
                </li>
                <li>
                    <a href="Consume.jsp">咨询</a>
                </li>
                <li>
                    <a href="UserPage.jsp">用户</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<%
    String user = session.getAttribute("user").toString();
%>
<%=user%>
<div class="b">
    <%@include file="copyright.jsp"%>
</div>
</body>
</html>
