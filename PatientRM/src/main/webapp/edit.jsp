<%--
  Created by IntelliJ IDEA.
  User: SRDB
  Date: 22-08-2025
  Time: 02:28 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Patient</title>
</head>
<body>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="gct" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="deva" %>
<%--    <h1>${param.key}</h1>--%>
    <deva:setDataSource var="ashish" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/gnanamani" user="root" password="Razak@123" />
    <deva:query var="extracted" dataSource="${ashish}" sql="select * from patient where patientid=?" >
        <deva:param value="${param.key}"/>
    </deva:query>
    <gct:forEach var="each" items="${extracted.rows}">
        <form action="update" method="post" enctype="multipart/form-data">
            <input type="text" readonly name="patientId" value="${each.patientid}"/>
            <input type="text" name="patientName" value="${each.patientname}" placeholder="entre the patient name" />
            <input type="text" name="weight" value="${each.weight}" placeholder="enter weight" />
            <input type="text" name="height" value="${each.height}" placeholder="entre the height" />
            <input type="text" name="age" value="${each.age}" placeholder="entre the age" />
            <input type="text" name="contact" value="${each.contact}" placeholder="entre the contact" />
            <input type="file" name="qrCode"/>
            <input type="submit" value="Update" />
        </form>
    </gct:forEach>
</body>
</html>
