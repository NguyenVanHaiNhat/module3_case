<%--
  Created by IntelliJ IDEA.
  User: nhat0
  Date: 2/21/2024
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chỉnh sửa điểm của học sinh</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row justify-content-center mt-4">
        <form class="col-md-6" method="post">
            <h1 class="">Chỉnh sửa điểm của học sinh</h1>
            <div class="form-group">
                <label for="testMark">Điểm kiểm tra</label>
                <input type="text" class="form-control" name="testMark" id="testMark" value="${requestScope["point"].getTestMark()}">
            </div>
            <div class="form-group">
                <label for="testMark15">Điểm kiểm tra 15 phút</label>
                <input type="text" class="form-control" name="testMark15" id="testMark15" value="${requestScope["point"].getTestMark15()}">
            </div>
            <div class="form-group">
                <label for="testMark60">Điểm kiểm tra 1 tiết</label>
                <input type="text" class="form-control" name="testMark60" id="testMark60" value="${requestScope["point"].getTestMark60()}">
            </div>
            <div class="form-group">
                <label for="midterm">Điểm kiểm tra giữa kì</label>
                <input type="text" class="form-control" name="midterm" id="midterm" value="${requestScope["point"].getMidterm()}">
            </div>
            <div class="form-group">
                <label for="final">Điểm kiểm tra cuối kì</label>
                <input type="text" class="form-control" name="final" id="final" value="${requestScope["point"].getFinalExam()}">
            </div>
            <div class="form-group mt-2">
                <button class="btn btn-success" role="button" type="submit">Lưu thông tin</button>
                <a class="btn btn-warning" role="button" href="/points">Quay lại</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>