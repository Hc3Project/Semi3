<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>하트</title>
<script src="../../resources/js/jquery-3.3.1.min.js"></script>
<style>
</style>
</head>
<body>

	<div class="heart">
		<img id=heartBtn alt="heart" src="../../resources/image/heartgr.png" width="30" height="30">
	</div>
	<script>
		$('#heartBtn').click(function() {
							var src = ($(this).attr('src') == '../../resources/image/heartgr.png') ? '../../resources/image/heartrd.png'
									: '../../resources/image/heartgr.png';
							$(this).attr('src', src);
						});
	</script>
</body>
</html>