<%@
	page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 선택하기</title>
<script src="../../resources/js/jquery-3.3.1.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
</head>
<body class="mBody">
	<%@include file="../common/header.jsp"%>
	<% if(m!=null && m.getUserId().equals("admin")){ %>
	<%@include file="common/sidebar.jsp" %>
	<div class="mDiv">
		<h1>영화 선택하기</h1>
		<div class="search">
			<label for="">영화명 </label>
			<input type="text" name="" id="search">
			<input type="button" value="검색하기" id="selBtn">
		</div>
		<div id="showList" style="display:none">
			<table id="movieList" class="hoverOpt aTable2">
				<thead>
					<tr>
						<th>영화코드</th>
						<th>영화명</th>
						<th>감독</th>
						<th>배우</th>
						<th>국가</th>
						<th>개봉일</th>
						<th>비고</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<input type="button" value="결과 더보기" id="moreList">	
		</div>
	</div>
	<%}  else {
		// request.setAttribute("msg", "회원만 가능한 서비스 입니다.");
		String path = "/views/common/errorPage.jsp";
		request.setAttribute("exception", new Exception("관리자 권한이 없습니다."));
		request.getRequestDispatcher(path).forward(request, response);
	}%>
</body>
<script src="../../resources/js/manager/choiceMovie.js"></script>
</html>