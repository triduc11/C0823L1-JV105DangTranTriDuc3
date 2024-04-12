<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 3/11/2024
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
        rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
        crossorigin="anonymous">
</head>
<body>
<fieldset>
  <legend style="padding: 20px">Product Information</legend>
  <form  action="/BenhAnServlet?action=edit" method="post" style="padding: 20px">
    <input name="id" id="id" type="hidden" value="${requestScope["list"].getId()}">
    <div class="col-6">
      <label for="maBA" class="form-label">ma benh an: </label>
      <input type=text class="form-control" id="maBA"  width="90px" name="maBA" value="${requestScope["list"].getMaBenhAn()}" readonly>
    </div>
    <div class="col-6">
      <label for="maBN" class="form-label">ma benh nhan: </label>
      <input type="text" class="form-control" id="maBN"  name="maBN" value="${requestScope["list"].getMaBenhNhan()}"readonly>
    </div>
    <div class="col-6">
      <label for="tenBN" class="form-label">ten benh nhan: </label>
      <input type="text" class="form-control" id="tenBN" name="tenBN" value="${requestScope["list"].getTenBenhNhan()}">
    </div>
    <div class="col-6">
      <label for="ngayNhapVien" class="form-label">ngay nhap vien: </label>
      <input type="date" class="form-control" id="ngayNhapVien" name="ngayNhapVien" value="${requestScope["list"].getNgayNhapVien()}">

    </div>
    <div class="col-6">
      <label for="ngayRaVien" class="form-label">ngay ra vien: </label>
      <input type="date" class="form-control" id="ngayRaVien" name="ngayRaVien" value="${requestScope["list"].getNgayRaVien()}">

    </div>
    </div>
    <div class="col-6">
      <label for="lyDo" class="form-label">ly do nhap vien: </label>
      <input type="text" class="form-control" id="lyDo" name="lyDo" value="${requestScope["list"].getLyDoNhapVien()}">

    </div>

    </div>
    <button type="submit" class="btn btn-primary" style="width: 150px; margin:20px">Submit</button>
  </form>
</fieldset>
</body>
</html>
