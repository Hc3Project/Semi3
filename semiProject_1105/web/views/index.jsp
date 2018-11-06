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
<script src="../resources/js/common.js"></script>

<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="../resources/css/reset.css">
<link rel="stylesheet" href="../resources/css/main.css">
<link rel="stylesheet" href="../resources/css/style.css">


<title>movie traveler</title>
<style type="text/css">
#slideSection div {
	height: 600px;
}

#slideSection {
	margin-bottom: 50px;
	height: 600px;
}

.listSection {
	height: 300px;
}

/* body {
	background: black;
} */
nav {
	height: 80px;
}

footer {
	height: 150px;
}

#item {
	width: 100%;
	height: 100px;
	background: black;
}

img {
	width: 100%;
	height: 100%;
	background: white;
}

.listSection .carousel-inner .item div {
	width: 300px;
	height: 200px;
	padding: 0px 3px 0px 3px;
}

.listSection .carousel-inner .item {
	margin: 50px;
}

#ThumbnailCarousel img {
	
}

#ThumbnailCarousel div {
	height: 250px;
	width: 100%;
}

#ThumbnailCarousel.carousel {
	padding-top: 30px;
	text-align: center;
}

.col-md-3 .img-thumbnail {
	height: 100%;
}

a[href="#st2Carousel"] {
	width: 150px;
}
</style>
</head>
<body>

	<header>
		<div style="height: 80px;">
			<%@ include file="common/header.jsp"%>
		</div>
	</header>

	<!--header-->

	<section id="slideSection">
		<div class="row ">

			<div class="col-lg-4">
				<div style="float: right; width: 400px; background: white;">
					<div style="background: black; height: 120px;"></div>
					<div style="background: white; height: 400px;"></div>
					<div style="background: black; height: 80px;"></div>
				</div>
			</div>

			<div class="col-lg-8">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner">
						<div class="item active">
							<img src="../resources/image/2.jpg" alt="Los Angeles">
						</div>

						<div class="item">
							<img src="../resources/image/1.jpg" alt="Chicago">
						</div>

						<div class="item">
							<img src="../resources/image/3.jpg" alt="New York">
						</div>
					</div>

					<a class="carousel-control-prev" href="#myCarousel" role="button"
						data-slide="prev"> <span class="carousel-control-prev-icon"
						aria-hidden="true"></span> <span class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#myCarousel" role="button"
						data-slide="next"> <span class="carousel-control-next-icon"
						aria-hidden="true"></span> <span class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div>
	</section>
	<!--  -->
	<section class="listSection">
		<div class="home-page">
			<div class="home-page__rec-list">
				<div class="rec-row">
					<h5 class="rec-row__title">
						<span>오늘 이 리뷰 어때요?</span> <a class="rec-row__show-more"
							href="javascript:;"> <span>모두 보기 </span> <span
							class="glyphicon glyphicon-angle-right"></span>
						</a>
					</h5>
					<div class="carousel slide" data-ride="carousel" id="st2Carousel">
						<div class="carousel-inner ">
							<div class="item active rec-list clearfix">

								<%
									for (int i = 0; i < 6; i++) {
								%>
								<div class="col-md-2">
									<h1>투유 프로젝트-슈가맨</h1>
									<img
										src="https://dhgywazgeek0d.cloudfront.net/watcha/image/upload/c_fill,h_264,q_80,w_470/x8hs3ctbkum162mpllyr.jpg"
										alt=""> <i class="hover-box hover-box--play"></i>
									<div class="hover-box">
										<h2>호버시 제목</h2>
										<p>호버시 텍스트</p>
									</div>
								</div>

								<%
									}
								%>
								</div>
								<div class="item rec-list clearfix">

										<%
									for (int i = 0; i < 6; i++) {
								%>
								<div class="col-md-2">
									<h1>투유 프로젝트-슈가맨</h1>
									<img
										src="https://dhgywazgeek0d.cloudfront.net/watcha/image/upload/c_fill,h_264,q_80,w_470/x8hs3ctbkum162mpllyr.jpg"
										alt=""> <i class="hover-box hover-box--play"></i>
									<div class="hover-box">
										<h2>호버시 제목</h2>
										<p>호버시 텍스트</p>
									</div>
								</div>

								<%
									}
								%>

										
								</div>

							</div>
							<a class="carousel-control-prev" href="#st2Carousel"
								role="button" data-slide="prev"> <span
								class="carousel-control-prev-icon" aria-hidden="true"></span> <span
								class="sr-only">Previous</span>
							</a> <a class="carousel-control-next" href="#st2Carousel"
								role="button" data-slide="next"> <span
								class="carousel-control-next-icon" aria-hidden="true"></span> <span
								class="sr-only">Next</span>
							</a>
						</div>

					</div>
					<!--rec-row-->
				</div>
				<!--home-page__rec-list-->
			</div>
			<!--homepage-->
	</section>

	<!--  -->


</body>
</html>