<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Exception e=(Exception)request.getAttribute("exception");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>movie traveler</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/semi/resources/css/style.css">
<script src="/semi/resources/js/common.js"></script>
</head>
<body>
	<header>
		<div style="height: 80px;">
			<%@ include file="../common/header.jsp"%>
		</div>
	</header>
	<div>
		<img src="/semi/resources/image/errorLogo.png" alt="error" />
		
		<h3><%=e.getMessage() %></h3>
		<div><br /></div>
		<%if(e.getMessage().substring(0, 4).trim().equals("관리자")) {%>
		<h4>권한이 없는 사용자는 접근하실 수 없습니다!</h4>
		<%} else {%>
		<h4>다른 리뷰를 보며 잠시 기다려주시고, 차후에도 문제가 발생한다면 관리자에게 문의바랍니다!</h4>
		<%} %>
		
	</div>
</body>
</html>