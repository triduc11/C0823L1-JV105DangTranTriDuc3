<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nghie
  Date: 18/03/2024
  Time: 8:56 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
            integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<html>
<head>
    <title>List Products</title>
</head>
<body>
<div class="container">

    <h1>Danh mục sản phẩm</h1>
    <c:if test="${param.mess=='OK'}">
        <h2>Thành công !</h2>
    </c:if>
    <c:if test="${param.mess=='NOK'}">
        <h2>Thất bại !</h2>
    </c:if>
    <a href="/product?action=add" class="btn btn-primary mb-3">Thêm mới</a>

    <form action="/product?action=search" method="post">
        <div class="input-group">
            <span class="input-group-text mb-3">Tên sản phẩm</span>
            <input type="text" class="form-control mb-3 " id="search" name="searchName" placeholder="Tìm tên sản phầm">
        </div>
        <div class="mb-3">
            <label for="manufactor" class="form-label">Chọn hãng sản xuất</label>
            <select name="searchManufactor" id="manufactor" value="">
                <c:forEach var="manufactor" items="${manufactors}">
                    <option value="${manufactor.getId()}">${manufactor.getName()}</option>
                </c:forEach>
                -- Chọn Nhà sản xuất --
            </select>
        </div>
        <button type="submit" class="btn btn-primary ">Tìm kiếm</button>
    </form>

    <table class="table ">
        <tr>
            <th>STT</th>
            <th>Tên sản phẩm</th>
            <th>Giá</th>
            <th>Mô tả sản phẩm</th>
            <th>Nhà sản xuất</th>
            <th>Sửa</th>
            <th>Xóa</th>
        </tr>

        <c:forEach var="product" items="${products}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${product.getName()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getDescription()}</td>
                <td>${product.getManufactor()}</td>
                <td>
                    <form action="/product?action=edit" method="get">
                        <button name="action" value="edit" class="btn btn-warning btn-sm">Sửa</button>
                        <input type="hidden" name="editId" value="${product.getId()}">
                    </form>
                </td>

                <td>
                    <button onclick="deleteInfo('${product.id}','${product.name}')" type="button"
                            class="btn btn-danger btn-sm"
                            data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                        Xóa
                    </button>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>
<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/product?action=delete" method="post">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">Xác nhận xóa sản phẩm</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Bạn có muốn xóa sản phẩm <span id="delete-name"></span> có Id là <span id="delete-id"></span> ?
                </div>
                <input type="hidden" id="hidden-input-id" name="deleteId">
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                    <button type="submit" class="btn btn-primary">Đồng ý</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    function deleteInfo(id, name) {
        document.getElementById("delete-id").innerHTML = id;
        document.getElementById("hidden-input-id").value = id;
        document.getElementById("delete-name").innerHTML = name;
    }
</script>
</body>
</html>
