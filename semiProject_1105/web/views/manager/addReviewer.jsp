<%@
	page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>리뷰어 추가하기</title>
</head>
<body>
	<h1>리뷰어 추가</h1>
	<div>
		리뷰어명 : <input type="text" name="" id="rvrSearch" placeholder="리뷰어를 입력하세요">
		<input type="button" value="검색하기" id="rvrBtn">	
	</div>
	<div id="getRvrList">
		<table>
			<thead>
				<tr>
					<th>리뷰어명</th>
					<th>리뷰어코드</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		<input type="button" value="항목 더 보기" id="moreList" disabled>
	</div>
	<div id="inputRvr">
		<table>
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
						<textarea name="" id="" cols="30" rows="10"></textarea>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4">
						<input type="button" value="추가하기" id="addRvrBtn">
						<input type="button" value="뒤로가기" id="backBtn">
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
<script src="../../resources/js/jquery-3.3.1.min.js"></script>
<script src="../../resources/js/manager/addReviewer.js"></script>
</html>