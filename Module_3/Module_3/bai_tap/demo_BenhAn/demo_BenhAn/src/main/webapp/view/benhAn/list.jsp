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
<form action="/benhAn" method="get" class="d-flex">
    <input name="action" hidden value="search" placeholder="Nhập mã bệnh án:">
    <input name="searchMaBenhAn" value="${searchMaBenhAn}" placeholder="Nhập mã bệnh án:">
    <select name="searchTenBenhNhan">
        <option value="0">--Choose--</option>
        <c:forEach var="benhNhan" items="${tenBenhNhan}">
            <option value="${benhNhan.getTenBenhNhan()}">${benhNhan.getTenBenhNhan()}</option>
        </c:forEach>
    </select><br>
    <button class="btn btn-success">SEARCH</button>
</form>
<a class="btn btn-success" href="/benhAn?action=add">THÊM MỚI</a>
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
            <td>
                <button onclick="deleteInfo('${benhAn.id}','${benhAn.maBenhAn}')" type="button"
                        class="btn btn-sm btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>
            </td>
            <td>
                <form action="/benhAn?action=update" method="get">
                    <button name="action" value="update" class="btn btn-success btn-sm">Update</button>
                    <input type="hidden" name="updateId" value="${benhAn.getId()}">
                </form>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${benhAnDtoList.isEmpty()}">
        <tr>
            <td colspan="7"><h4 style="color: red">Không có dữ liệu</h4></td>
        </tr>
    </c:if>
</table>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/benhAn?action=delete" method="post">
<%--                chỉnh lại tên bài--%>
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input id="deleteId" name="deleteId">
                    <span>Bạn có muốn xoá </span><span style="color:red;" id="deleteName"></span> không??
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">DELETE</button>
                </div>
            </form>

        </div>
    </div>
</div>
<script>
    function deleteInfo(id, maBenhAn) {
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteName").innerText = maBenhAn;
    }
</script>

<script>
    <c:if test="${param.mess!=null}">
    displayToast("Thêm mới thành công", "orange")
    document.getElementById("new").style.display = "inline";
    </c:if>
    <c:if test="${param.deleteMessage=='OK'}">
    displayToast("Xoa thanh cong", "green")
    document.getElementById("new").style.display = "inline";
    </c:if>
    <c:if test="${param.deleteMessage=='NOT'}">
    displayToast("Xoa khong thanh cong", "red")
    document.getElementById("new").style.display = "inline";
    </c:if>
</script>
</body>
</html>