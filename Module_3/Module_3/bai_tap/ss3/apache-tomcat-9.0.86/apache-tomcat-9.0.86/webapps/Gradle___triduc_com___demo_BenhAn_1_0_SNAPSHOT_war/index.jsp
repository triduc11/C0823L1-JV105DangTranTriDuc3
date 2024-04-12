<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<c:redirect url="/benhAn/list.jsp"></c:redirect>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>