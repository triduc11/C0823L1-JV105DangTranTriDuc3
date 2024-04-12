<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 3/13/2024
  Time: 8:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:import url="layout/head.jsp"></c:import>
<body>
<c:import url="layout/navbar.jsp"></c:import>
<h1>Danh sách sinh viên</h1>
<table class="table table-dark table-strip">
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Point</th>
        <th>Rank</th>
        <th>ClassId</th>
        <th>Action</th>
    </tr>
    <c:forEach var="student" items="${studentList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.getName()}</td>
            <c:if test="${student.isGender()}">
                <td>Nam</td>
            </c:if>
            <c:if test="${!student.isGender()}">
                <td>Nữ</td>
            </c:if>

            <td>${student.getPoint()}</td>
            <c:choose>
                <c:when test="${student.getPoint()>=8}">
                    <td>Giỏi</td>
                </c:when>
                <c:when test="${student.getPoint()>=7}">
                    <td>Khá</td>
                </c:when>
                <c:when test="${student.getPoint()>=5}">
                    <td>Trung bình</td>
                </c:when>
                <c:otherwise>
                    <td>Yếu sắc yếu</td>
                </c:otherwise>
            </c:choose>
            <td>${student.getClassId()}</td>
            <td>
                <button class="btn btn-sm btn-danger">Delete</button>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
