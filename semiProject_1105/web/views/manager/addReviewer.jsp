<%@
	page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰어 추가하기</title>
<script src="../../resources/js/jquery-3.3.1.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
</head>
<body class="mBody">
	<%@include file="../common/header.jsp"%>
	<% if(m!=null && m.getUserId().equals("admin")){ %>
	<%@include file="common/sidebar.jsp" %>
	<div class="mDiv">
		<h1>리뷰어 추가</h1>
		<div class="search">
			<label for="">리뷰어명 : </label>
			<input type="text" name="" id="rvrSearch" placeholder="리뷰어를 입력하세요">
			<input type="button" value="검색하기" id="rvrBtn">	
		</div>
		<div id="getRvrList" style='display:none'>
			<table id="rvrList" class="hoverOpt aTable2">
				<thead>
					<tr>
						<th>리뷰어썸네일</th>
						<th>리뷰어 이름</th>
						<th>리뷰어 코드</th>
						<th>비고</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<input type="button" value="항목 더 보기" id="moreList" disabled>
		</div>
		<div id="inputRvr" style='display:none'>
			<table class="mTable">
				<thead>
					<tr>
						<th>리뷰어명</th>
						<th>reviewerName001</th>
						<th>리뷰어코드</th>
						<th>reviewerCode001</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>개요</td>
						<td colspan="3">
							<textarea name="" id="" cols="30" rows="10" placeholder='1300자까지 입력 가능합니다.'></textarea>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="4">
							<input type="button" value="등록하기" id="addRvrBtn">
							<input type="button" value="뒤로가기" id="backBtn">
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
	<%}  else {
		// request.setAttribute("msg", "회원만 가능한 서비스 입니다.");
		String path = "/views/common/errorPage.jsp";
		request.setAttribute("exception", new Exception("관리자 권한이 없습니다."));
		request.getRequestDispatcher(path).forward(request, response);
	}%>
</body>
<script src="../../resources/js/manager/addReviewer.js"></script>
</html>