<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg=(String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>에러페이지</title>
</head>
<body>
	<div>
		<h2>띠용?!</h2>
		<h4><%=msg %></h4>
	</div>
</body>
</html>