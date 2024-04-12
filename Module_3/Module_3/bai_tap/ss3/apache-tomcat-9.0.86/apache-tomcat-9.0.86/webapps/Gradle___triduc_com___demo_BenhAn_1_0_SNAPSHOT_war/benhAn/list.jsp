<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/1/2024
  Time: 8:40 PM
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
    <title>List Benh An</title>
</head>
<html>
<c:import url="../layout/head.jsp"></c:import>
<body>
<c:import url="../layout/navbar.jsp"></c:import>
<h1>DANH SÁCH BỆNH ÁN</h1>
<table class="table table-dark table-strip">
    <tr>
        <th>STT</th>
        <th>Mã Bệnh Án</th>
        <th>Mã Bệnh Nhân</th>
        <th>Tên Bệnh Nhân</th>
        <th>Ngày Nhập Viện</th>
        <th>Ngày Ra Viện</th>
        <th>Lý Do Nhập Viện</th>
        <th>Xóa</th>
        <th>Chỉnh sửa</th>
    </tr>
    <c:forEach var="benhAn" items="${benhAnDtoList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${benhAn.getMaBenhAn()}</td>
            <td>${benhAn.getMaBenhNhan()}</td>
            <td>${benhAn.getTenBenhNhan()}</td>
            <td>${benhAn.getNgayNhapVien()}</td>
            <td>${benhAn.getNgayRaVien()}</td>
            <td>${benhAn.getLyDoNhapVien()}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>