<%@
	page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>영화 수정 및 삭제</title>
</head>
<body>
	<h1>영화 수정 및 삭제</h1>
	<div>
		<select id="selList">
			<option value="">선택하세요</option>
			<option value="mCode">영화코드</option>
			<option value="mTitle">제목</option>
			<option value="director">감독</option>
		</select>
		<input type="text" name="" id="search" placeholder="키워드를 입력하세요.">
		<input type="button" value="검색" id="searchBtn">
	</div>
	<div id="getList" style="display:none">
		<table id="movieList">
			<thead>
				<tr>
					<th>영화코드</th>
					<th>영화제목</th>
					<th>감독</th>
					<th>배우</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody id=tbodyList></tbody>
		</table>
		<input type="button" value="결과 더보기" id="moreList" disabled>
	</div>
	<div id="modifyInfo" style="display:none">
		<table id=modifyTable border=1>
			<thead>
				<tr>
					<th>영화코드</th>
					<th>movieCode001</th>
					<th>영화제목</th>
					<th><input type="text" name="" id="" value="movieTitle001"></th>
				</tr>
				<tr>
					<th>감독명</th>
					<th><input type="text" name="" id="" value="Director001"></th>
					<th>주연배우</th>
					<th><input type="text" name="" id="" value="Actor001"></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>개요</td>
					<td colspan=3>
						<textarea name="" id="" cols="30" rows="10"></textarea>
					</td>
				</tr>
				<tr align="center">
					<td colspan="4">
						<input type="button" value="수정하기" id="modifyBtn">
						<input type="button" value="삭제하기" id="delBtn">
						<input type="button" value="뒤로가기" id="backBtn">
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
<script src="../../resources/js/jquery-3.3.1.min.js"></script>
<script src="../../resources/js/manager/modifyDeleteMovie.js"></script>
</html>