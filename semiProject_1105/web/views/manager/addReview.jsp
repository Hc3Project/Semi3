<%@
	page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	import="com.kh.semi.manager.reviewer.model.vo.ReviewerInfo, java.util.*"
%>
<%
	ArrayList<ReviewerInfo> rvrList = (ArrayList<ReviewerInfo>)request.getAttribute("rvrList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>리뷰 추가</title>
</head>
<body>
	<h1>리뷰 추가</h1>
	<div>
		<label for="">리뷰어 : </label>
		<select name="" id="rvrList">
			<option value="">선택하세요</option>
			<%
			for(int i=0; i<rvrList.size(); i++){
			%>
			<option value="<%=rvrList.get(i).getRvrCode()%>"><%=rvrList.get(i).getrName()%></option>
			<%
			}
			%>
		</select>
		<input type="text" name="" id="rvKeyword" placeholder="키워드를 입력하세요.">
		<input type="button" value="검색하기" id="rvBtn">
	</div>
	<div id="videoList">
	</div>
	<div>
		<input type="button" value="결과 더보기" id="moreList">
	</div>
	
</body>
<script src="<%=request.getContextPath()%>/resources/js/jquery-3.3.1.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/manager/addReview.js"></script>
</html>