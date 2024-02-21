<%--
  Created by IntelliJ IDEA.
  User: nhat0
  Date: 2/21/2024
  Time: 9:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Management Application</title>
</head>
<body>
<center>
    <h1>Student Management</h1>
    <h2>
        <a href="students?action=students">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit User
                </h2>
            </caption>
            <c:if test="${student != null}">
                <input type="hidden" name="id" value="<c:out value='${student.id}' />"/>
            </c:if>
            <tr>
                <th>Name Student:</th>
                <td>
                    <input type="text" name="nameStudent" size="45"
                           value="<c:out value='${student.nameStudent}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Day of brith:</th>
                <td>
                    <input type="text" name="dayofbirth" size="45"
                           value="<c:out value='${student.dayofbirth}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" size="15"
                           value="<c:out value='${student.address}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Class id:</th>
                <td>
                    <input type="text" name="id_class" size="15"
                           value="<c:out value='${student.id_class}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>