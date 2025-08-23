<%@ page import="java.util.List" %>
<%@ page import="explore.Patient" %><%--
  Created by IntelliJ IDEA.
  User: SRDB
  Date: 22-08-2025
  Time: 02:59 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session Check</title>
</head>
<body>
    <h1>data Count</h1>
    <%
        List<Patient> temp = (List<Patient>)session.getAttribute("people");
        out.print(temp.size());
    %>
</body>
</html>
