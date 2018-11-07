<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../../resources/js/jquery-3.3.1.min.js"></script>
<!-- 슬라이더 -->
<script src="../../resources/js/common.js"></script>
<script src="../../resources/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
<link rel="stylesheet" href="../../resources/css/reset.css">
<link rel="stylesheet" href="../../resources/css/style.css">
<link rel="stylesheet" href="../../resources/css/main.css">
<link rel="stylesheet" href="../../resources/css/category.css">
<link rel="stylesheet" href="../../resources/css/watches.css">
<title>본 리뷰</title>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">
        

</head>
<body>
	<%@ include file="../common/header.jsp"%>

	<div class="watches" id="underlinemenu">
            <ul>
            
            <li><a href="">본 작품</a></li>
            <li><a href="">평가한 작품</a></li>
            
            </ul>
            </div>
            
            <section class="listSection">
		<div class="home-page">
			<div class="home-page__rec-list">
				<div class="rec-row">
					<div class="carousel slide" data-ride="carousel" id="st2Carousel"  data-interval="15000">
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


	
	
</body>
</html>