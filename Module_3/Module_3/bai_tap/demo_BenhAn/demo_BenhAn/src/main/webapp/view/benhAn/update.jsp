<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/1/2024
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/styles.css">
    <title>Update Benh An</title>
</head>
<html>
<c:import url="../layout/head.jsp"></c:import>
<body>
<C:import url="../layout/navbar.jsp"></C:import>

<div class="container" style="margin-left: 100px">
    <form action="/benhAn?action=add" method="post" class="w-50 ms-5">
        <h1>TRANG CHỈNH SỬA BỆNH ÁN</h1>
        <div class="form-floating mb-3">
            <input type="text" id="id" name="id" class="form-control" placeholder="Enter Id" value="${benhAn.getId()}" readonly>
            <label for="id">ID Bệnh Án</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" name="maBenhAn" id="maBenhAn" class="form-control" placeholder="Nhập Mã Bệnh Án " value="${benhAn.getMaBenhAn()}" required>
            <label for="maBenhAn" class="form-label">Mã Bệnh Án</label>
        </div>
        <div class=" mb-3">
            <label for="maBenhNhan" class="form-label">Tên Bệnh Nhân</label>
            <select name="maBenhNhan" id="maBenhNhan" value="">
                <c:forEach var="benhNhan" items="${tenBenhNhan}">
                    <option value="${benhNhan.getMaBenhNhan()}">${benhNhan.getTenBenhNhan()}</option>
                </c:forEach>
                --Choose--
            </select>
        </div>
        <div class="form-floating mb-3">
            <input type="date" name="ngayNhapVien" id="ngayNhapVien" class="form-control" value="${benhAn.getNgayNhapVien()}" required>
            <label for="ngayNhapVien" class="form-label">Nhập Ngày Nhập Viện</label>
        </div>
        <div class="form-floating mb-3">
            <input type="date" name="ngayRaVien" id="ngayRaVien" class="form-control" value="${benhAn.getNgayRaVien()}"  required>
            <label for="ngayRaVien" class="form-label">Nhập Ngày Ra Viện</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" name="lyDoNhapVien" id="lyDoNhapVien" class="form-control" placeholder="Nhập Lý Do Nhập Viện" value="${benhAn.getLyDoNhapVien()}" required>
            <label for="lyDoNhapVien" class="form-label">Nhập Lý Do Nhập Viện</label>
        </div>
        <button class="btn btn-sm btn-primary">SAVE</button>
    </form>

</div>
<script>
    const form = document.querySelector("form");
    form.addEventListener("submit", e => {
        if (!form.checkValidity()) {
            e.preventDefault();
        }
        form.classList.add("was-validated")
    })
</script>
</body>
</html>
