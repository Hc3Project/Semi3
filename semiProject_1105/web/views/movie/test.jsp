<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/reset.css">
<link rel="stylesheet" href="resources/css/main.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/detail.css" />
	
	<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>

<link type="text/css"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/redmond/jquery-ui.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>
<script type="text/javascript" src="../../resources/js/jquery.youtubepopup.min.js"></script>

<title>Insert title here</title>

<script>
	$(function() {
		$("a.youtube").YouTubePopup({

			'youtubeId' : '',

			'title' : '',

			'idAttribute' : 'rel',

			'draggable' : false,

			'modal' : true,

			'width' : 640,

			'height' : 480,

			'hideTitleBar' : true,

			'clickOutsideClose' : false,

			'overlayOpacity' : 0.7,

			'autohide' : 2,

			'autoplay' : 1,

			'color' : 'red',

			'color1' : '191919',

			'color2' : '191919',

			'controls' : 1,

			'fullscreen' : 1,

			'loop' : 0,

			'hd' : 1,

			'showinfo' : 0,

			'theme' : 'light'
		});
	});
</script>

</head>
<body>
	<a class="youtube" href="#" rel="ivup7P6_RN4"
		title="jQuery YouTube Popup Player Plugin TEST">Test Me</a>


</body>
</html>