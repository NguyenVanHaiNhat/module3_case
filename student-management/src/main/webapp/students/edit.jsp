<%--
  Created by IntelliJ IDEA.
  User: nhat0
  Date: 2/21/2024
  Time: 9:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
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
    <div class="row justify-content-center mt-4">
        <form class="col-md-6" method="post">
            <h1 class="">Chỉnh sửa thông tin học sinh</h1>
            <div class="form-group">
                <label for="nameStudent">Tên học sinh</label>
                <input type="text" class="form-control" name="nameStudent" id="nameStudent" value="${requestScope["students"].getNameStudent()}">
            </div>
            <div class="form-group">
                <label for="dayofbirth">Ngày sinh</label>
                <input type="text" class="form-control" name="dayofbirth" id="dayofbirth" value="${requestScope["students"].getDayOfBirth()}">
            </div>
            <div class="form-group">
                <label for="address">Địa chỉ</label>
                <input type="text" class="form-control" name="address" id="address" value="${requestScope["students"].getAddress()}">
            </div>
            <div class="form-group">
                <label for="id_class">Lớp</label>
                <select id="id_class" class="form-control" name="id_class">
                    <c:forEach items="${classes}" var="c">
                        <option value="${c.idClass}">${c.nameClass}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group mt-2">
                <button class="btn btn-success" role="button" type="submit">Lưu thông tin</button>
                <button class="btn btn-warning" role="button">Quay lại</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>