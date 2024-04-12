<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/22/2024
  Time: 6:49 PM
  To change this template use File | Settings | File Templates.
--%>
<head>
    <title>Product Update</title>
</head>
<html>
<c:import url="../layout/head.jsp"></c:import>
<style>
    input, select, button {
        margin-top: 10px;
    }
</style>
<body>
<C:import url="../layout/navbar.jsp"></C:import>
<div class="container" style="margin-left: 100px">
    <form action="/product?action=update" method="post" class="w-50 ms-5">
        <h1>TRANG CHỈNH SỬA THÔNG TIN SẢN PHẨM</h1>
        <div class="form-floating mb-3">
            <input type="text" id="id" name="id" class="form-control" placeholder="Enter Id" value="${product.getId()}"
                   readonly>
            <label for="id">ID sản phẩm</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" id="name" name="name" class="form-control" placeholder="Enter Product Name"
                   value="${product.getName()}" required>
            <label for="name" class="form-label">Tên sản phầm</label>
        </div>
        <div class="form-floating mb-3">
            <input type="number" id="price" name="price" class="form-control" placeholder="Enter Product Price"
                   value="${product.getPrice()}" required>
            <label for="price" class="form-label">Giá</label>
        </div>
        <div class="form-floating mb-3">
            <input type="number" id="amount" name="amount" class="form-control" placeholder="Enter Product Price"
                   value="${product.getAmount()}" required>
            <label for="amount" class="form-label">Số lượng</label>
        </div>
        <div class="mb-3">
            <label for="size" class="form-label">Loại kích thước</label>
            <select name="size" id="size" value="">
                <c:forEach var="size" items="${productSizeList}">
                    <option value="${size.getId()}">${size.getSize()}</option>
                </c:forEach>
                --Choose Size--
            </select>
        </div>
        <button class="btn btn-sm btn-primary" type="submit">SUBMIT</button>
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
