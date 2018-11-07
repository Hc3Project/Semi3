<%@
	page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>리뷰어 수정 및 삭제</title>
</head>
<body>
	<h1>리뷰어 수정 및 삭제</h1>
	<div>
		리뷰어 : <input type="text" id="rvrSearch" placeholder="리뷰어를 입력해주세요.">
		<input type="button" value="검색하기" id="rvrBtn">
	</div>
	<div>
		<table>
			<thead>
				<tr>
					<th>리뷰어채널ID</th>
					<th>리뷰어명</th>
					<th>사이트 내 등록된 리뷰 수</th>
				</tr>
			</thead>
		</table>
		<tbody></tbody>
	</div>
	<div>
		<table>
			<thead>
				<tr>
					<th>리뷰어채널ID</th>
					<th>ReviewerChannelID</th>
					<th>리뷰어명</th>
					<th>ReviewerName</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>개요</td>
					<td colspan="3">
						<textarea name="" id="" cols="30" rows="10"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<input type="button" value="수정하기" id="modifyBtn">
						<input type="button" value="삭제하기" id="removeBtn">
						<input type="button" value="뒤로가기" id="backBtn">
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
<script src="../../resources/js/jquery-3.3.1.min.js"></script>
<script src="../../resources/js/manager/modifyDeleteReviewer.js"></script>
</html>