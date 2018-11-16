<%@
	page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.Arrays"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>당신의 영화 취향을 분석해드립니다!</title>
<script src="../../resources/js/jquery-3.3.1.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<link rel="stylesheet" href="../../resources/css/style.css">
<link rel="stylesheet" href="../../resources/css/manager/sidebar.css">
</head>
<body>
	<%@include file="../common/header.jsp"%>
	<div>
		<%
		if(m!=null){
			if(m.getRecList()!=null){
		%>
			<!-- 추천 목록이 존재한다면 -->
			
		<% 	} else {%>
			<!-- 추천 목록이 존재하지 않는다면 -->
			
		<%
			}
		} else {
			String strPath = "/views/common/errorPage.jsp";
			request.setAttribute("exception", new Exception("로그인을 하셔야 이용가능합니다."));
			request.getRequestDispatcher(strPath).forward(request, response);
		}
		%>
	</div>
</body>
<script src="../../resources/js/yourMovieAnalysis.js"></script>
<script src="https://d3js.org/d3.v5.min.js"></script>
<script src="/semi/resources/js/manager/billboard.min.js"></script>
<link rel="stylesheet" href="/semi/resources/css/manager/billboard.css">
</html>