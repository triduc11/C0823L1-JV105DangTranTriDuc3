<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:import url="../layout/head.jsp"></c:import>
<style>
    input, select, button {
        margin-top: 10px;
    }
</style>
<body>
<c:import url="../layout/navbar.jsp"></c:import>
<div style="margin-left: 100px">
    <h1>Trang thêm mới</h1>
    <form action="/student?action=add" method="post" >
<%--        <input name="id" placeholder="Enter id"><br>--%>
        <input name="name" placeholder="Enter name"><br>
        <input  type="radio" name="gender" value="true">Nam
        <input  type="radio" name="gender" value="false">Nữ<br>
        <input  type="number" name="point"  value="0" placeholder="Enter Point"><br>
        <select name="classId">
            <option value="0">--Chọn lớp--</option>
            <c:forEach var="cls" items="${classList}">
                <option value="${cls.getId()}">${cls.getName()}</option>
            </c:forEach>
        </select><br>
        <button class="btn btn-sm btn-primary">Save</button>
    </form>
</div>

</body>
</html>
