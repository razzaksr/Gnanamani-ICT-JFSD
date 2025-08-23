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
    <title>data Admission</title>
</head>
<body>
    <form action="admit" method="post" enctype="multipart/form-data">
        <input type="text" name="patientName" placeholder="entre the patient name" />
        <input type="text" name="weight" placeholder="enter weight" />
        <input type="text" name="height" placeholder="entre the height" />
        <input type="text" name="age" placeholder="entre the age" />
        <input type="text" name="contact" placeholder="entre the contact" />
        <input type="file" name="qrCode"/>
        <input type="submit" value="admit" />
    </form>
</body>
</html>
