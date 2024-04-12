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
<c:import url="../layout/head.jsp"></c:import>
<body>
<c:import url="../layout/navbar.jsp"></c:import>

<script>
    function displayToast(message, color) {
        document.getElementById("toastContent").innerHTML = message;
        document.getElementById("liveToast").style.background = color;
        let myAlert = document.getElementById('liveToast');//select id of toast
        let bsAlert = new bootstrap.Toast(myAlert);//inizialize it
        bsAlert.show();//show it
    }

</script>

<h3>${param.mess}</h3>

<h1>Danh sách sinh viên</h1>
<form action="/student" method="get" class="d-flex">
    <input name="action"  hidden value="search" placeholder="enter name">
    <input name="searchName" value="${searchName}" placeholder="enter name">
    <select name="className">
        <option value="">--Chọn lớp--</option>
        <c:forEach var="cls" items="${classList}">
            <option value="${cls.getName()}">${cls.getName()}</option>
        </c:forEach>
    </select><br>
    <button class="btn btn-success">Search</button>
</form>
<a class="btn btn-success" href="/student?action=add">Thêm mới</a>
<table class="table table-dark table-strip">
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Point</th>
        <th>Rank</th>
        <th>Class Name</th>
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
            <td>${student.getClassName()}</td>
            <td>
                <button onclick="deleteInfo('${student.id}','${student.name}')" type="button" class="btn btn-sm btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${studentList.isEmpty()}">
        <tr>
            <td colspan="7"><h4 style="color: red">Không có dữ liệu</h4></td>
        </tr>
    </c:if>

</table>


<!-- Modal xoá -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/student?action=delete" method="post">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input  id="deleteId" name="deleteId">
                    <span>Bạn có muốn xoá </span><span style="color:red;" id="deleteName"></span> không??
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </form>

        </div>
    </div>
</div>

<script>
    function deleteInfo(id,name){
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteName").innerText = name;
    }
</script>


<%--Hiển thị message lên toast --%>

<%--toast--%>
<div class="position-fixed top-0 end-5 p-3" style="z-index: 11;margin-left: 500px">
    <div id="liveToast" style="width: 230px; color: white; background:lightgreen ;border-radius:0%/0%;" class="toast"
         role="dialog" aria-live="assertive" aria-atomic="true">
        <div class="toast-body">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 48 48" width="30px" height="30px">
                <g id="surface1_4_">
                    <path style="fill:#4CAF50;"
                          d="M44,24c0,11.045-8.955,20-20,20S4,35.045,4,24S12.955,4,24,4S44,12.955,44,24z"/>
                    <path style="fill:#CCFF90;"
                          d="M34.602,14.602L21,28.199l-5.602-5.598l-2.797,2.797L21,33.801l16.398-16.402L34.602,14.602z"/>
                </g>
            </svg>
            <span id="toastContent">Nội dung hiển thị</span>
        </div>
    </div>
</div>
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
