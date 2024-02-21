<%--
  Created by IntelliJ IDEA.
  User: nhat0
  Date: 2/20/2024
  Time: 11:50 AM
  To change this template use File | Settings | File Templates.
--%>
<<%@ page language="java" contentType="text/html; charset=UTF-8"
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
        <a href="/students?action=create">Add New Student</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Student</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>ClassName</th>
        </tr>
        <jsp:useBean id="listStudent" scope="request" type="java.util.List"/>
        <c:forEach var="student" items="${listStudent}">
            <tr>
                <td><c:out value="${student.id}"/></td>
                <td><c:out value="${student.nameStudent}"/></td>
                <td><c:out value="${student.dayOfBirth}"/></td>
                <td><c:out value="${student.address}"/></td>
                <td><c:out value="${student.nameClass}"/></td>
                <td>
                    <a href="/students?action=edit&id=${student.id}">Edit</a>
                    <a href="/students?action=delete&id=${student.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>


