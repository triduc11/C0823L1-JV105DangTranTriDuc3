<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMINzz
  Date: 4/1/2024
  Time: 5:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/styles.css">
    <title>List</title>
</head>
<html>
<c:import url="../layout/head.jsp"></c:import>
<body>
<c:import url="../layout/navbar.jsp"></c:import>
<h1>DANH SÁCH SẢN PHẨM</h1>
<form action="/product" method="get" class="d-flex">
    <input name="action" hidden value="search" placeholder="Enter Product Name">
    <input name="searchName" value="${searchName}" placeholder="Enter Product Name">
    <button class="btn btn-success">SEARCH</button>
</form>
<a class="btn btn-success" href="/product?action=add">THÊM MỚI</a>
<table class="table table-dark table-strip">
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Price</th>
        <th>Amount</th>
        <th>Color</th>
        <th>Category</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    <c:forEach var="product" items="${productDtoList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getAmount()}</td>
            <td>${product.getColor()}</td>
            <td>${product.getCategory()}</td>
            <td>
                <button onclick="deleteInfo('${product.id}','${product.name}')" type="button"
                        class="btn btn-sm btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>
            </td>
            <td>
                <form action="/product?action=update" method="get">
                    <button name="action" value="update" class="btn btn-success btn-sm">Update</button>
                    <input type="hidden" name="updateId" value="${product.getId()}">
                </form>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${productDtoList.isEmpty()}">
        <tr>
            <td colspan="7"><h4 style="color: red">Không có dữ liệu</h4></td>
        </tr>
    </c:if>
</table>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/product?action=delete" method="post">
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
    function deleteInfo(id, name) {
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteName").innerText = name;
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
