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
		<h3>장르별 영화 수</h3>
		<div id="genreCnt"></div>
		
		<h3>국가별 영화 수</h3>
		<div id="nationCnt"></div>
		<div>
			<div style="display:inline-block; width:500px; margin-rigth:150px;">
				<h3>최근 개봉한 영화 장르</h3>
				<input type="number" style="width:50px; color:black;" min="10" max="100" value="10" id="num">
				<input type="button" value="조회" style="width:50px;" id="numBtn">
				<div id="pie1"></div>
			</div>
			
			<div style="display:inline-block; width:500px; margin-left:150px;">
				<h3>최근 개봉한 영화 장르</h3>
				<div id="pie2"></div>
			</div>
		</div>
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