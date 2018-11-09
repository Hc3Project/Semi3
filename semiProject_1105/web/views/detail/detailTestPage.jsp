<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>디테일뷰테스트페이지</title>
</head>
<body>
	<form action="/semi/dView.do">
	<!-- 여기에 보낼 값을 추가하면서 테스트해보셈 -->
	비디오아이디 : <input type="text" name="videoId"/><br>
	앰코드  : <input type="text" name="mCode"/><br>
	<button type="submit">제출</button>
	</form>
</body>
</html>