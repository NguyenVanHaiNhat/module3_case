<%--
  Created by IntelliJ IDEA.
  User: nhat0
  Date: 2/20/2024
  Time: 11:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý Điểm học sinh</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
    <h1 class="my-3">Quản Lý Điểm Học Sinh</h1>
    <div class="row d-flex mx-3">
        <div class="col-8">
            <a class="btn btn-warning" role="button" href="/points?action=create">Thêm mới</a>
        </div>
        <div class="col-4">
            <form class="d-flex" role="search" action="#" method="post">
                <input name="action" value="find" hidden="">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="country">
                <button class="btn btn-outline-secondary" type="submit">Tìm</button>
            </form>
        </div>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">MHS</th>
            <th scope="col">Tên Học Sinh</th>
            <th scope="col">Tên môn học</th>
            <th scope="col">Điểm kiểm tra</th>
            <th scope="col">Điểm kiểm tra 15 phút</th>
            <th scope="col">Điểm kiểm tra 1 tiết</th>
            <th scope="col">Điểm kiểm tra giữa kì</th>
            <th scope="col">Điểm kiểm tra cuối kì</th>
            <th scope="col">Điểm trung bình môn</th>


            <th scope="col">Chỉnh sửa</th>
            <th scope="col">Xoá</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="l" items="${listPoint}" >
            <tr>
                <td>${l.id}</td>
                <td>${l.nameStudent}</td>
                <td>${l.nameSubject}</td>
                <td>${l.testMark}</td>
                <td>${l.testMark15}</td>
                <td>${l.testMark60}</td>
                <td>${l.midterm}</td>
                <td>${l.finalExam}</td>
                <td>${l.avgPoint}</td>

                <td>
                    <a class="btn btn-warning" href="/points?action=edit&id_student=${l.id}&idSubject=${l.idSubject}" role="button">Chỉnh
                        sửa</a>
                </td>
                <td>
                    <a class="btn btn-warning" href="/points?action=delete&id_student=${l.id}&idSubject=${l.idSubject}" role="button">Xoá</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>