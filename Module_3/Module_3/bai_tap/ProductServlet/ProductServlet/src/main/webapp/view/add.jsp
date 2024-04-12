<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nghie
  Date: 20/03/2024
  Time: 7:04 CH
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
</head>
<html>


<body>
<div class="container">
    <form novalidate action="/product?action=add" method="post" class="w-50 ms-5">
        <h2>Thêm sản phẩm</h2>
<%--        <div class="form-floating mb-3">--%>
<%--            <input type="text" id="id" name="id" class="form-control" placeholder="Nhập Id" required>--%>
<%--            <label for="id">ID sản phẩm</label>--%>
<%--        </div>--%>
        <div class="form-floating mb-3">
            <input type="text" id="name" name="name" class="form-control" placeholder="Nhập tên" required>
            <label for="name" class="form-label">Tên sản phầm</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" id="price" name="price" class="form-control" placeholder="Nhập giá" required>
            <label for="price" class="form-label">Giá</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" id="desc" name="desc" class="form-control" placeholder="Mô tả" required>
            <label for="desc" class="">Mô tả</label>
        </div>
        <div class="mb-3">
            <label for="manufactor" class="form-label">Hãng sản xuất</label>
            <select name="manufactor" id="manufactor" value="">
                <c:forEach var="manufactor" items="${manufactors}">
                    <option value="${manufactor.getId()}">${manufactor.getName()}</option>
                </c:forEach>
                -- Chọn Nhà sản xuất --
            </select>
        </div>
        <button class="btn btn-success" type="submit">Thêm mới</button>
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
