<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>하트</title>
<script src="../js/jquery-3.3.1.min.js"></script>
<style>
</style>
</head>
<body>

	<div class="heart">
		<img src="../image/heartgr.png">
	</div>
	<script>
		$('img').click(	function() {
							var src = ($(this).attr('src') == '../image/heartgr.png') ? '../image/heartrd.png'
									: '../image/heartgr.png';
							$(this).attr('src', src);
						});
	</script>
</body>
</html>