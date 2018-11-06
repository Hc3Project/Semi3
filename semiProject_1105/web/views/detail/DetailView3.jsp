<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String getPage=(String)request.getAttribute("page");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>포오스터어어어!!!</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
</head>
<body>
	<p><%=getPage %></p>
	<img src="<%=getPage %>" alt="" />
</body>
</html>