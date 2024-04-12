<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/22/2024
  Time: 6:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:import url="../layout/head.jsp"></c:import>
<body>
<c:import url="../layout/navbar.jsp"></c:import>
<h1>DANH SÁCH SẢN PHẨM</h1>
<table class="table table-dark table-strip">
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Price</th>
        <th>Amount</th>
        <th>Size</th>
    </tr>
    <c:forEach var="product" items="${productList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getAmount()}</td>
            <td>${product.getSize()}</td>
            <td>
                <button onclick="deleteInfo('${product.id}','${product.name}')" type="button" class="btn btn-sm btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>

</table>
<%--<script>--%>
<%--    function deleteInfo(id,name){--%>
<%--        document.getElementById("deleteId").value = id;--%>
<%--        document.getElementById("deleteName").innerText = name;--%>
<%--    }--%>
<%--</script>--%>
</body>
</html>
