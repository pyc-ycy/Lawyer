<%--
  Created by IntelliJ IDEA.
  User: 御承扬
  Date: 2020/1/12
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>彭友来律师事务所</title>
    <style type="text/css">
        .b{
            height:100px;
            width:100px;
            position:absolute;
            bottom:0;
            margin-left:-50px;/*div宽度的一半*/
            left:50%;
        }
    </style>
</head>
<body>
<center>
    <h1>
        <%=request.getAttribute("account")%>,欢迎访问彭友来律师事务所！！！！
    </h1>
</center>
<%
    String name = request.getAttribute("account").toString();
    session.setAttribute("username", name);
%>
<div class="b">
    <%@include file="copyright.jsp"%>
</div>
<p>当前用户为：<%=session.getAttribute("username")%></p>
</body>
</html>
