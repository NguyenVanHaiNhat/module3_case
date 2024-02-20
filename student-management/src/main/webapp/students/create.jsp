<%--
  Created by IntelliJ IDEA.
  User: nhat0
  Date: 2/20/2024
  Time: 11:50 AM
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
                <h2>Add New Student</h2>
            </caption>
            <tr>
                <th>id student:</th>
                <td>
                    <input type="text" name="id" id="id" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Name Student:</th>
                <td>
                    <input type="text" name="nameStudent" id="nameStudent" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Day of brith:</th>
                <td>
                    <input type="text" name="dayofbirth" id="dayofbirth" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Class id:</th>
                <td>
                    <input type="text" name="id_class" id="id_class" size="15"/>
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
