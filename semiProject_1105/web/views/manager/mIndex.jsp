<%@
	page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movie traveler</title>
<script src="/semi/resources/js/jquery-3.3.1.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
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
		
		<h3>장르별 평점 분포</h3>
		<div id="ratingDistribution"></div>
		
		<h3>좋아요가 많은 리뷰어</h3>
		<div id="rvrLikes"></div>
		
		<div>
			<div style="display:inline-block; width:500px; margin-left:150px;">
				<input type="number" style="width:50px; color:black;" min="1" max="365" value="10" id="dNum">
				일 이내 개봉한 영화 장르 <span id="num"></span>
				<div id="dGenre"></div>
				
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