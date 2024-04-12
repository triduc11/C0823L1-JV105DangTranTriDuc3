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
<a href="hello-servlet">Hello Servlet</a>
<a href="/sum?n1=5&n2=10">Tổng</a>
<form action="/sum" method="post">
    <input name="n1" placeholder="Number1">
    <input name="n2" placeholder="Number2">
    <button >Tổng</button>
</form>
</body>
</html>