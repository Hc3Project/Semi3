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
<script src="resources/js/common.js"></script>
<script src="resources/js/boxOffice.js"></script>
<script src="resources/js/reviewList.js"></script>
<script src="resources/js/recMovie.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/reset.css">
<link rel="stylesheet" href="resources/css/main.css">
<link rel="stylesheet" href="resources/css/style.css">
<title>movie traveler</title>
</head>
<body>
	<header>
		<div style="height: 80px;">
			<%@ include file="views/common/header.jsp"%>

		</div>
	</header>
	<!--header-->
	<section id="slideSection">
	<div id = "gradation"></div> 
		<div class="row">
			<div class="col-lg-4">
				<div id="boxOffice">
					<div id="bo1">
						<div style="height: 45px;"></div>
						<img alt="boxoffice" src="resources/image/h2_boxoffice.png"
							style="width: 260px; height: 70px; display: block; margin: auto;">
					</div>
					<div id="bo2">
						<div class="boxRank contaner"></div>
					</div>
					<div id="bo3"></div>
				</div>
			</div>

			<div class="col-lg-8">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators" style="float: right;">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
					</ol>
					<!-- Wrapper for slides -->
					<div class="carousel-inner">
						<div class="item active">
							<img src="resources/image/5.jpg" alt="Los Angeles">
						</div>

						<div class="item">
							<img src="resources/image/1.jpg" alt="Chicago">
						</div>

						<div class="item">
							<img src="resources/image/3.jpg" alt="New York">
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
					<div class="carousel slide" data-ride="carousel" id="st2Carousel"
						data-interval="0">
						<div class="carousel-inner ">

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

				</div>
				<!--rec-row-->

			</div>
			<!--home-page__rec-list-->
		</div>
		<!--homepage-->

	</section>
	<section class="listSection">
		<div class="home-page">
			<div class="home-page__rec-list">
				<div class="rec-row">
					<h5 class="rec-row__title">
						<span>TOP 리뷰 20</span> <a class="rec-row__show-more" href="javascript:;">
							<span>모두 보기 </span> <span class="glyphicon glyphicon-angle-right"></span>
						</a>
					</h5>
					<div class="carousel slide" data-ride="carousel" id="st3Carousel"
						data-interval="0">
						<div class="carousel-inner ">

							<a class="carousel-control-prev" href="#st3Carousel"
								role="button" data-slide="prev"> <span
								class="carousel-control-prev-icon" aria-hidden="true"></span> <span
								class="sr-only">Previous</span>
							</a> <a class="carousel-control-next" href="#st3Carousel"
								role="button" data-slide="next"> <span
								class="carousel-control-next-icon" aria-hidden="true"></span> <span
								class="sr-only">Next</span>
							</a>
						</div>
					</div>

				</div>
				<!--rec-row-->

			</div>
			<!--home-page__rec-list-->
		</div>
		<!--homepage-->

	</section>
	<%if(m!=null){ %>
	<section class="listSection">
		<input type="hidden" id="logChk" value='<%=(m!=null)%>'>
		<div class="home-page">
			<div class="home-page__rec-list">
				<div class="rec-row">
					<h5 class="rec-row__title">
						<span><font color="darkred"><%=m.getUserId()%></font>님 이러한 영화는 어떠신가요?</span> <a class="rec-row__show-more" href="javascript:;">
							<span>모두 보기 </span> <span class="glyphicon glyphicon-angle-right"></span>
						</a>
					</h5>
					<div class="carousel slide" data-ride="carousel" id="st4Carousel"
						data-interval="0">
						<div class="carousel-inner ">
							<a class="carousel-control-prev" href="#st4Carousel"
								role="button" data-slide="prev"> <span
								class="carousel-control-prev-icon" aria-hidden="true"></span> <span
								class="sr-only">Previous</span>
							</a> <a class="carousel-control-next" href="#st4Carousel"
								role="button" data-slide="next"> <span
								class="carousel-control-next-icon" aria-hidden="true"></span> <span
								class="sr-only">Next</span>
							</a>
						</div>
					</div>

				</div>
				<!--rec-row-->
			</div>
			<!--home-page__rec-list-->
		</div>
	</section>
	<%}%>
</body>
</html>