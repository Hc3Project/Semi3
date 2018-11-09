<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>포스터 크롤링 테스트</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
</head>
<body>
	<h1>포스터 크롤링 테스트</h1>
	<!-- 실제 기능 구현시 이 페이지를 거치지 않고 바로 서블릿으로 넘어가도록 함 -->
	<!-- 클릭시 어떤 정보가 서블릿으로 넘어가는지 확인 후 쿼리부터 전부 수정 -->
	<form action="/semi/gPoster.do">
		<input type="text" name="txt" id="txtSearch" placeholder="anything...">
		<input type="submit" value="Search" name="aa" id="btnNaver">
		<div id="results"></div>
	</form>
</body>
</html>