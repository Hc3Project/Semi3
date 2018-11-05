<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>

<script src="../js/common.js"></script>

<link rel="stylesheet" href="../css/reset.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/main.css">

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">


<link rel="stylesheet" href="../css/style.css">


<title>movie traveler</title>
<style type="text/css">
#slideSection div {
	height: 600px;
}

#slideSection {
	margin-bottom: 50px;
}

section {
	height: 600px;
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
}
#ThumbnailCarousel img {

}

#ThumbnailCarousel div {
    height:250px;
    width:100%;
}

#ThumbnailCarousel.carousel {
    padding-top:30px;
    text-align:center;
}

.col-md-3 .img-thumbnail {
    height:100%;
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
							<img src="../image/2.jpg" alt="Los Angeles">
						</div>

						<div class="item">
							<img src="../image/1.jpg" alt="Chicago">
						</div>

						<div class="item">
							<img src="../image/3.jpg" alt="New York">
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
	<div id="ThumbnailCarousel" class="carousel slide col-xs-12"
		data-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<div class="row">
					<div class="col-md-3 col-sm-6">
						<a href="#x" class="thumbnail"><img
							src="http://placehold.it/250x250" alt="Image"
							class="img-fluid img-thumbnail"></a>
					</div>
					<div class="col-md-3 col-sm-6">
						<a href="#x" class="thumbnail"><img
							src="http://placehold.it/500x500" alt="Image"
							class="img-fluid img-thumbnail"></a>
					</div>
					<div class="col-md-3">
						<a href="#x" class="thumbnail"><img
							src="http://placehold.it/250x250" alt="Image"
							class="img-fluid img-thumbnail"></a>
					</div>
					<div class="col-md-3">
						<a href="#x" class="thumbnail"><img
							src="http://placehold.it/250x250" alt="Image"
							class="img-fluid img-thumbnail"></a>
					</div>
				</div>
			</div>
			<div class="carousel-item">
				<div class="row">
					<div class="col-sm-3">
						<a href="#x" class="thumbnail"><img
							src="http://placehold.it/250x250" alt="Image"
							class="img-fluid img-thumbnail"></a>
					</div>
					<div class="col-sm-3">
						<a href="#x" class="thumbnail"><img
							src="http://placehold.it/500x500" alt="Image"
							class="img-fluid img-thumbnail"></a>
					</div>
					<div class="col-sm-3">
						<a href="#x" class="thumbnail"><img
							src="http://placehold.it/250x250" alt="Image"
							class="img-fluid img-thumbnail"></a>
					</div>
					<div class="col-sm-3">
						<a href="#x" class="thumbnail"><img
							src="http://placehold.it/250x250" alt="Image"
							class="img-fluid img-thumbnail"></a>
					</div>
				</div>
			</div>
			<div class="carousel-item">
				<div class="row">
					<div class="col-sm-3">
						<a href="#x" class="thumbnail"><img
							src="http://placehold.it/250x250" alt="Image"
							class="img-fluid img-thumbnail"></a>
					</div>
					<div class="col-sm-3">
						<a href="#x" class="thumbnail"><img
							src="http://placehold.it/500x500" alt="Image"
							class="img-fluid img-thumbnail"></a>
					</div>
					<div class="col-sm-3">
						<a href="#x" class="thumbnail"><img
							src="http://placehold.it/250x250" alt="Image"
							class="img-fluid img-thumbnail"></a>
					</div>
					<div class="col-sm-3">
						<a href="#x" class="thumbnail"><img
							src="http://placehold.it/250x250" alt="Image"
							class="img-fluid img-thumbnail"></a>
					</div>
				</div>
			</div>
		</div>
		<a class="carousel-control-prev" href="#ThumbnailCarousel"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#ThumbnailCarousel"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>


<!--  -->
	<div class="home-page">
		<div class="home-page__rec-list">
			<div class="rec-row">
				<h5 class="rec-row__title">
					<span>오늘 이 리뷰 어때요?</span> <a class="rec-row__show-more"
						href="javascript:;"> <span>모두 보기 </span> <span
						class="glyphicon glyphicon-angle-right"></span>
					</a>
				</h5>
				<div class="rec-list clearfix">
					<div>
						<h1>투유 프로젝트-슈가맨</h1>
						<img
							src="https://dhgywazgeek0d.cloudfront.net/watcha/image/upload/c_fill,h_264,q_80,w_470/x8hs3ctbkum162mpllyr.jpg"
							alt=""> <i class="hover-box hover-box--play"></i>
						<div class="hover-box">
							<h2>호버시 제목</h2>
							<p>호버시 텍스트</p>
						</div>
					</div>
					<div>
						<h1>퍼스트 어벤져</h1>
						<img
							src="https://dhgywazgeek0d.cloudfront.net/watcha/image/upload/c_fill,h_264,q_80,w_470/ebc7musgzzd9vykpsrpf.jpg"
							alt=""> <i class="hover-box hover-box--play"></i>
						<div class="hover-box">
							<h2>호버시 제목</h2>
							<p>호버시 텍스트</p>
						</div>
					</div>
					<div>
						<h1>제목</h1>
						<img
							src="https://dhgywazgeek0d.cloudfront.net/watcha/image/upload/c_fill,h_264,q_80,w_470/uzwk0o2ykeqrhlvuuabr.jpg"
							alt=""> <i class="hover-box hover-box--play"></i>
						<div class="hover-box">
							<h2>호버시 제목</h2>
							<p>호버시 텍스트</p>
						</div>
					</div>
					<div>
						<h1>제목</h1>
						<img
							src="https://dhgywazgeek0d.cloudfront.net/watcha/image/upload/c_fill,h_264,q_80,w_470/ebc7musgzzd9vykpsrpf.jpg"
							alt=""> <i class="hover-box hover-box--play"></i>
						<div class="hover-box">
							<h2>호버시 제목</h2>
							<p>호버시 텍스트</p>
						</div>
					</div>
					<div>
						<h1>제목</h1>
						<img
							src="https://dhgywazgeek0d.cloudfront.net/watcha/image/upload/c_fill,h_264,q_80,w_470/uzwk0o2ykeqrhlvuuabr.jpg"
							alt=""> <i class="hover-box hover-box--play"></i>
						<div class="hover-box">
							<h2>호버시 제목</h2>
							<p>호버시 텍스트</p>
						</div>
					</div>
				</div>
			</div>
			<!--rec-row-->
			<div class="rec-row">
				<h5 class="rec-row__title">
					<span>새로 올라온 리뷰</span> <a class="rec-row__show-more"
						href="javascript:;"> <span>모두 보기 </span> <span
						class="glyphicon glyphicon-angle-right"></span>
					</a>
				</h5>
				<div class="rec-list clearfix">
					<div>
						<h1>제목</h1>
						<img
							src="https://dhgywazgeek0d.cloudfront.net/watcha/image/upload/c_fill,h_264,q_80,w_470/uzwk0o2ykeqrhlvuuabr.jpg"
							alt=""> <i class="hover-box hover-box--play"></i>
						<div class="hover-box">
							<h2>호버시 제목</h2>
							<p>호버시 텍스트</p>
						</div>
					</div>
					<div>
						<h1>제목</h1>
						<img
							src="https://dhgywazgeek0d.cloudfront.net/watcha/image/upload/c_fill,h_264,q_80,w_470/ebc7musgzzd9vykpsrpf.jpg"
							alt=""> <i class="hover-box hover-box--play"></i>
						<div class="hover-box">
							<h2>호버시 제목</h2>
							<p>호버시 텍스트</p>
						</div>
					</div>
					<div>
						<h1>제목</h1>
						<img
							src="https://dhgywazgeek0d.cloudfront.net/watcha/image/upload/c_fill,h_264,q_80,w_470/uzwk0o2ykeqrhlvuuabr.jpg"
							alt=""> <i class="hover-box hover-box--play"></i>
						<div class="hover-box">
							<h2>호버시 제목</h2>
							<p>호버시 텍스트</p>
						</div>
					</div>
					<div>
						<h1>제목</h1>
						<img
							src="https://dhgywazgeek0d.cloudfront.net/watcha/image/upload/c_fill,h_264,q_80,w_470/ebc7musgzzd9vykpsrpf.jpg"
							alt=""> <i class="hover-box hover-box--play"></i>
						<div class="hover-box">
							<h2>호버시 제목</h2>
							<p>호버시 텍스트</p>
						</div>
					</div>
					<div>
						<h1>제목</h1>
						<img
							src="https://dhgywazgeek0d.cloudfront.net/watcha/image/upload/c_fill,h_264,q_80,w_470/uzwk0o2ykeqrhlvuuabr.jpg"
							alt=""> <i class="hover-box hover-box--play"></i>
						<div class="hover-box">
							<h2>호버시 제목</h2>
							<p>호버시 텍스트</p>
						</div>
					</div>
				</div>
			</div>
			<!--rec-row-->
			<div class="rec-row">
				<h5 class="rec-row__title">
					<span>무트 최고의 인기 리뷰</span> <a class="rec-row__show-more"
						href="javascript:;"> <span>모두 보기 </span> <span
						class="glyphicon glyphicon-angle-right"></span>
					</a>
				</h5>
				<div class="rec-list clearfix">
					<div>
						<h1>제목</h1>
						<img
							src="https://dhgywazgeek0d.cloudfront.net/watcha/image/upload/c_fill,h_264,q_80,w_470/uzwk0o2ykeqrhlvuuabr.jpg"
							alt=""> <i class="hover-box hover-box--play"></i>
						<div class="hover-box">
							<h2>호버시 제목</h2>
							<p>호버시 텍스트</p>
						</div>
					</div>
					<div>
						<h1>제목</h1>
						<img
							src="https://dhgywazgeek0d.cloudfront.net/watcha/image/upload/c_fill,h_264,q_80,w_470/ebc7musgzzd9vykpsrpf.jpg"
							alt=""> <i class="hover-box hover-box--play"></i>
						<div class="hover-box">
							<h2>호버시 제목</h2>
							<p>호버시 텍스트</p>
						</div>
					</div>
					<div>
						<h1>제목</h1>
						<img
							src="https://dhgywazgeek0d.cloudfront.net/watcha/image/upload/c_fill,h_264,q_80,w_470/uzwk0o2ykeqrhlvuuabr.jpg"
							alt=""> <i class="hover-box hover-box--play"></i>
						<div class="hover-box">
							<h2>호버시 제목</h2>
							<p>호버시 텍스트</p>
						</div>
					</div>
					<div>
						<h1>제목</h1>
						<img
							src="https://dhgywazgeek0d.cloudfront.net/watcha/image/upload/c_fill,h_264,q_80,w_470/ebc7musgzzd9vykpsrpf.jpg"
							alt=""> <i class="hover-box hover-box--play"></i>
						<div class="hover-box">
							<h2>호버시 제목</h2>
							<p>호버시 텍스트</p>
						</div>
					</div>
					<div>
						<h1>제목</h1>
						<img
							src="https://dhgywazgeek0d.cloudfront.net/watcha/image/upload/c_fill,h_264,q_80,w_470/uzwk0o2ykeqrhlvuuabr.jpg"
							alt=""> <i class="hover-box hover-box--play"></i>
						<div class="hover-box">
							<h2>호버시 제목</h2>
							<p>호버시 텍스트</p>
						</div>
					</div>
				</div>
			</div>
			<!--rec-row-->
		</div>
		<!--home-page__rec-list-->
	</div>
	<!--homepage-->
	</div>
</body>
</html>