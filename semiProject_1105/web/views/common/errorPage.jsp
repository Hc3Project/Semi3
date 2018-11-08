<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Exception e=(Exception)request.getAttribute("exception");
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
		<h4><%=e.getMessage() %></h4>
	</div>
</body>
</html>