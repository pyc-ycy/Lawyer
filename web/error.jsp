<%--
  Created by IntelliJ IDEA.
  User: 御承扬
  Date: 2020/1/12
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误页面</title>
</head>
<body>
<center>
    <h3>
        <%=request.getAttribute("msg")%>
    </h3>
    <a href="index.jsp">返回登录页面</a>
</center>
</body>
</html>
