<%@
	page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>영화 선택하기</title>
</head>
<body>
	<h1>영화 선택하기</h1>
	<div>
		영화명 : <input type="text" name="" id="search">
		<input type="button" value="검색하기" id="selBtn">
	</div>
	<div id="showList">
		<table id="movieList">
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
			<tfoot>
				<tr>
					<td colspan="7"><input type="button" value="결과 더보기" id="moreList"></td>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
<script src="../../resources/js/jquery-3.3.1.min.js"></script>
<script src="../../resources/js/manager/choiceMovie.js"></script>
</html>