<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý học sinh</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
    <h1 class="my-3">Quản Lý Học Sinh</h1>
    <div class="row d-flex mx-3">
        <div class="col-8">
            <a class="btn btn-warning" role="button" href="/students?action=create">Thêm mới</a>
        </div>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">MSV</th>
            <th scope="col">Tên Học Sinh</th>
            <th scope="col">Ngày sinh</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Lớp</th>


            <th scope="col">Chỉnh sửa</th>
            <th scope="col">Xoá</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="s" items="${listStudent}" >
            <tr>
                <td>${s.id}</td>
                <td>${s.nameStudent}</td>
                <td>${s.dayOfBirth}</td>
                <td>${s.address}</td>
                <td>${s.nameClass}</td>

                <td>
                    <a class="btn btn-warning" href="/students?action=edit&id=${s.id}" role="button">Chỉnh
                        sửa</a>
                </td>
                <td>
                    <a class="btn btn-warning" href="/students?action=delete&id=${s.id}" role="button">Xoá</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="form-group mt-2" >
        <a class="btn btn-warning" href="/points" role="button">Return table Point</a>
    </div>
</div>
</body>
</html>