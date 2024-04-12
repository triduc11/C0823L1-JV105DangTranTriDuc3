<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/22/2024
  Time: 6:49 PM
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
    <title>Product List</title>
</head>
<html>
<c:import url="../layout/head.jsp"></c:import>
<body>
<c:import url="../layout/navbar.jsp"></c:import>
<h1>DANH SÁCH SẢN PHẨM</h1>
<form action="/product" method="get" class="d-flex">
    <input name="action" hidden value="search" placeholder="Enter Product Name">
    <input name="searchName" value="${searchName}" placeholder="Enter Product Name">
    <select name="searchSize">
        <option value="0">--Choose Size--</option>
        <c:forEach var="size" items="${productSizeList}">
            <option value="${size.getSize()}">${size.getSize()}</option>
        </c:forEach>
    </select><br>
    <button class="btn btn-success">SEARCH</button>
</form>
<a class="btn btn-success" href="/product?action=add">THÊM MỚI</a>
<table class="table table-dark table-strip">
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Price</th>
        <th>Amount</th>
        <th>Size</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    <c:forEach var="product" items="${productDtoList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getAmount()}</td>
            <td>${product.getSize()}</td>
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
