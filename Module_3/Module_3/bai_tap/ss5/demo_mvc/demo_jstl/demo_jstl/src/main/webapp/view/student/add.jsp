<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:import url="../layout/head.jsp"></c:import>
<body>
<c:import url="../layout/navbar.jsp"></c:import>
<h1>Trang thêm mới</h1>
<form action="/student?action=add" method="post">
    <input name="id" placeholder="Enter id">
    <input name="name" placeholder="Enter name">
    <input  type="radio" name="gender" value="true">Nam
    <input  type="radio" name="gender" value="false">Nữ
    <input  type="number" name="point"  value="0" placeholder="Enter Point">
    <select name="classId">
        <option value="0">--Chọn lớp--</option>
        <option value="1">--C03</option>
        <option value="2">--C04</option>
        <option value="3">--C05</option>
    </select>
    <button>Save</button>
</form>
</body>
</html>
