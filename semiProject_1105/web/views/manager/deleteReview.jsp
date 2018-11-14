<%@
	page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="com.kh.semi.manager.reviewer.model.vo.ReviewerInfo, java.util.*"
%>
<%
	ArrayList<ReviewerInfo> rvrList = (ArrayList<ReviewerInfo>)request.getAttribute("rvrList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 삭제하기</title>
</head>
<body class="mBody">
	<%@include file="common/sidebar.jsp" %>
	<div class="mDiv">
		<h1>리뷰 삭제</h1>
		<div class="search">
			<select name="" id="rvrList">
				<option value="">모든 리뷰어</option>
				<%
				for(int i=0; i<rvrList.size(); i++){
				%>
				<option value="<%=rvrList.get(i).getRvrCode()%>"><%=rvrList.get(i).getrName()%></option>
				<%
				}
				%>
			</select>
			<input type="text" name="" id="search" placeholder="영화명을 입력하세요.">
			<input type="button" value="검색하기" id="rvBtn">
		</div>
		<div id="videoList">
		</div>
		<div>
			<input type="button" value="결과 더 보기" id="moreList">
		</div>
	</div>
</body>
<script src="<%=request.getContextPath()%>/resources/js/jquery-3.3.1.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/manager/deleteReview.js"></script>
</html>