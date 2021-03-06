<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<script src="../../resources/js/myMovie.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/common.js"></script>


<link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
<link rel="stylesheet" href="../../resources/css/reset.css">
<link rel="stylesheet" href="../../resources/css/main.css">
<link rel="stylesheet" href="../../resources/css/myMovie.css">
<link rel="stylesheet" href="../../resources/css/style.css">




<title>movie traveler</title>
</head>
<body>
	<header>
		<%@ include file="../common/header.jsp"%>
	</header>
	<!--header-->

	<section class="container movieSection ">

		<div class="tabs">
			<span class="tab signin active"> <a href="#signin">최근 목록</a>
			</span> <span class="tab signup"> <a href="#signup">평가 영화</a>
			</span>
		</div>
		<div class="content">
			<div class="signin-cont cont">
				<div class="category-page" style="position: relative;">
					<div class="home-page__rec-list">
						<div class="rec-row" id="visitMovie">
							<div id="Progress_Loading">
								<!-- 로딩바 -->
								
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="signup-cont cont">
				<div class="category-page" style="position: relative;">
					<div class="home-page__rec-list">
						<div class="rec-row" id="evalMovie"></div>
					</div>
				</div>
			</div>
		</div>


	</section>






</body>
</html>