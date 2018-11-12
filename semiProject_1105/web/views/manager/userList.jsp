<%@
	page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원 목록</title>
</head>
<body>
	<h1>회원 목록</h1>
	<div>
		<select id="selOpt">
			<option value="">선택하세요</option>
			<option value="userId">아이디</option>
			<option value="email">이메일</option>
		</select>
		<input type="text" id="search" placeholder="미입력시 전체 검색">
		<input type="button" value="검색하기" id="userBtn">
	</div>
	<div id="divList">
		<table id="userList">
			<thead>
				<tr>
					<th>사용자 아이디</th>
					<th>사용자 이메일</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
		<input type="button" value="결과 더 보기" id="moreList">
	</div>
</body>
<script src="../../resources/js/jquery-3.3.1.min.js"></script>
<script src="../../resources/js/manager/userList.js"></script>
</html>