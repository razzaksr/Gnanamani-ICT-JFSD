<%@ page import="java.util.List" %>
<%@ page import="explore.Patient" %><%--
  Created by IntelliJ IDEA.
  User: SRDB
  Date: 22-08-2025
  Time: 12:02 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="gct" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/health.tld" prefix="richard" %>
<%--    <% List<data> records = (List<data>) request.getAttribute("people");%>--%>
    <a href="admit.jsp"> Admit new Via Servlet</a>
<%--    <a href="admitbean.jsp"> Admit new Via JSP</a>--%>
<%--    <a href="disable">Logout</a>--%>
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Weight</th>
                <th>BMI</th>
                <th>QR</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <gct:choose>
                <gct:when test="${not empty sessionScope.people}">
                    <gct:forEach var="temp" items="${sessionScope.people}">
                        <tr>
                            <td>${temp.patientId}</td>
                            <td style="color: brown">
                                <a href="edit.jsp?key=${temp.patientId}">${temp.patientName}</a>
                            </td>
                            <td style="color: blue">
                                <fmt:formatNumber pattern="##.##" value="${temp.weight}" />
<%--                                        <fmt:formatNumber type="currency" value="${temp.weight}" />--%>
                            </td>
                            <td>
                                <richard:bmi height="${temp.height}" weight="${temp.weight}"/>
                            </td>
                            <td>${temp.qrCode}</td>
                            <td>
                                <a href="delete?key=${temp.patientId}">Delete</a>
                            </td>
                        </tr>
                    </gct:forEach>
                </gct:when>
                <gct:otherwise>
                    <p>No Patients are available</p>
                </gct:otherwise>
            </gct:choose>

<%--            <% if (records.size() > 0) {%>--%>
<%--                <%for(data temp : records){%>--%>
<%--                <tr>--%>
<%--                    <td><% out.print(temp.getPatientId());%></td>--%>
<%--                    <td><% out.print(temp.getPatientName());%></td>--%>
<%--                    <td><% out.print(temp.getContactNo());%></td>--%>
<%--                </tr>--%>
<%--                <%}%>--%>
<%--                <%}else{%>--%>
<%--                    <p>No PAtients to be listed</p>--%>
<%--                <%}%>--%>
<%--            <% if (records.size() > 0) {%>--%>
<%--                <%for(data temp : records){%>--%>
<%--                    <tr>--%>
<%--                        <td><%=temp.getPatientId()%></td>--%>
<%--                        <td><%=temp.getPatientName()%></td>--%>
<%--                        <td><%=temp.getContactNo()%></td>--%>
<%--                    </tr>--%>
<%--                <%}%>--%>
<%--            <%}else{%>--%>
<%--            <p>No PAtients to be listed</p>--%>
<%--            <%}%>--%>
        </tbody>
    </table>
<%--    cookies display--%>
<%--    <%--%>
<%--        Cookie[] cookies = request.getCookies();--%>
<%--        for(Cookie each:cookies)--%>
<%--            out.print(each.getName()+" "+each.getValue());--%>
<%--    %>--%>
</body>
</html>
