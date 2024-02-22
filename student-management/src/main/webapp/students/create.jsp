<%--
  Created by IntelliJ IDEA.
  User: nhat0
  Date: 2/20/2024
  Time: 11:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm mới học sinh</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
<input type="hidden" name="action" value="create">
    <div class="row justify-content-center mt-4">
        <form class="col-md-6" method="post">
            <h1 class="">Thêm mới học sinh</h1>
            <div class="form-group">
                <label for="id">dID</label>
                <input type="text" class="form-control" name="id" id="id">
            </div>
            <div class="form-group">
                <label for="nameStudent">Tên học sinh</label>
                <input type="text" class="form-control" name="nameStudent" id="nameStudent">
            </div>
            <div class="form-group">
                <label for="dayofbirth">Ngày sinh</label>
                <input type="text" class="form-control" name="dayofbirth" id="dayofbirth">
            </div>
            <div class="form-group">
                <label for="address">Địa chỉ</label>
                <input type="text" class="form-control" name="address" id="address">
            </div>
            <div class="form-group">
                <label for="nameClass">Lớp</label>
                <select id="nameClass" class="form-control" name="nameClass">
                    <c:forEach items="${classes}" var="c">
                        <option value="${c.idClass}">${c.nameClass}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group mt-2">
                <button class="btn btn-success" role="button" type="submit">Thêm mới</button>
                <a class="btn btn-warning" role="button" href="/students">Quay lại</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>