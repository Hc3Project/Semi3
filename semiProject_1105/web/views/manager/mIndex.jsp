<%@
	page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인</title>
<script src="/semi/resources/js/jquery-3.3.1.min.js"></script>
</head>
<body class="mBody">
	<%@include file="../common/header.jsp"%>
	<% if(m!=null && m.getUserId().equals("admin")){ %>
	<%@include file="common/sidebar.jsp" %>
	<div class="mDiv">
		<div id="RotateXAxisTickText"></div>
	</div>
	<%}  else {
		String path = "/views/common/errorPage.jsp";
		request.setAttribute("exception", new Exception("관리자 권한이 없습니다."));
		request.getRequestDispatcher(path).forward(request, response);
	}%>
</body>
<script src="../../resources/js/manager/mIndex.js"></script>
<script src="https://d3js.org/d3.v5.min.js"></script>
<script src="/semi/resources/js/manager/billboard.min.js"></script>
<link rel="stylesheet" href="/semi/resources/css/manager/billboard.css">
</html>