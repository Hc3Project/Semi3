<%@
	page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>영화 추가</title>
</head>
<body>
	<h1 align="center">영화 추가</h1>
	<div align="center">
		<label for="">영화명 : </label>
		<input type="text" name="" id="movieName" placeholder="영화를 입력하세요~!">
		<input type="button" value="영화 검색하기" id="movieBtn">
	</div>
	<div id="searchMovie" align="center" style="display:none">
		<table id="movieList">
			<thead align="center">
				<tr>
					<th>영화코드</th>
					<th>영화이름</th>
					<th>감독</th>
					<th>국가</th>
					<th>개봉날짜</th>
					<th>장르</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody align="center">
			</tbody>
		</table>
		<input type="button" value="항목 더보기" id="more"disabled>
	</div>
	
	<div id="insertMovie" align="center" style="display:none">
		<table id="addDetail" border=1>
			<thead>
				<tr>
					<th>영화코드</th>
					<th>MovieCode001</th>
					<th>영화제목</th>
					<th>Title001</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>개요</td>
					<td colspan="3">
						<textarea cols=50 rows="10" placeholder="최대 1300자 입력 가능합니다."></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center">
						<input type="button" value="추가하기" onclick="addDetail(this);">
						<input type="button" value="뒤로가기" onclick="backList();">
					</td>
					
				</tr>
			</tbody>
		</table>
	</div>
	
</body>
<script src="../../resources/js/jquery-3.3.1.min.js"></script>
<script src="../../resources/js/manager/addMovie.js"></script>
</html>