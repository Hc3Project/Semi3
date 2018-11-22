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
<title>movie traveler</title>
<script src="<%=request.getContextPath()%>/resources/js/jquery-3.3.1.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
</head>
<body class="mBody">
	<%@include file="../common/header.jsp"%>
	<% if(m!=null && m.getUserId().equals("admin")){ %>
	<%@include file="common/sidebar.jsp" %>
	<div class="mDiv">
		<h1>리뷰 추가</h1>
		<div class="search">
			<table>
				<tr>
					<td><label for="">리뷰어 </label></td>
					<td>
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
					</td>
					<td><input type="text" name="" id="rvKeyword" placeholder="youtube영상 제목 입력, 미입력시 전체 출력"></td>
					<td><input type="button" value="검색하기" id="rvBtn"></td>
				</tr>
			</table>
		</div>
		
		<div id="videoList">
		</div>
		<div>
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

<script src="<%=request.getContextPath()%>/resources/js/manager/addReview.js"></script>
</html>