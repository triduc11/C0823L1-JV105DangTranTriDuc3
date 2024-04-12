<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
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
    <title>Add</title>
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
    <form action="/product?action=add" method="post">
        <h1>TRANG THÊM MỚI SẢN PHẨM</h1>
        <div class="form-floating mb-3">
            <input type="text" name="name" id="name" class="form-control" placeholder="Enter Product Name" required>
            <label for="name" class="form-label">Tên sản phầm</label>
        </div>
        <div class="form-floating mb-3">
            <input type="number" id="price" name="price" class="form-control" placeholder="Enter Product Price"
                   required>
            <label for="price" class="form-label">Giá</label>
        </div>
        <div class="form-floating mb-3">
            <input type="number" id="amount" name="amount" class="form-control" placeholder="Enter Product Price"
                   required>
            <label for="amount" class="form-label">Số lượng</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" name="color" id="color" class="form-control" placeholder="Enter Product Color" required>
            <label for="color" class="form-label">Màu sắc sản phẩm</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" name="description" id="description" class="form-control" placeholder="Enter Product Description" required>
            <label for="description" class="form-label">Mô tả sản phẩm</label>
        </div>
        <div class="mb-3">
            <label for="category" class="form-label">Loại sản phầm</label>
            <select name="category" id="category" value="">
                <c:forEach var="category" items="${productCategoryList}">
                    <option value="${category.getId()}">${category.getCategory()}</option>
                </c:forEach>
                --Choose category--
            </select>
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
