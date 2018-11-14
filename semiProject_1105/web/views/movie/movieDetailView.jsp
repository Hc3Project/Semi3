<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	import="java.sql.Date, com.kh.semi.user.movie.model.vo.MovieDetailInfo"
%>
<%
	String getPage=(String)request.getAttribute("page");
	MovieDetailInfo mov=(MovieDetailInfo)request.getAttribute("mov");
	String mtitle=mov.getMtitle();
	String director=mov.getDirector();
	String actor=mov.getActor();
	int showtime=mov.getShowtime();
	String opendate=String.valueOf(mov.getOpendate());
	String gname1=mov.getGname1();
	String gname2=mov.getGname2();
	String nname=mov.getNname();
	int counts=mov.getCounts();
	String synopsis=mov.getSynopsis();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>포오스터어어어!!!</title>
<!-- 뭐가 많은데 뭘 지워야할지 몰라서 냅둠 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/underscore.js/1.7.0/underscore-min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/detail.css" />
</head>
<body>

	<header>
	
	</header>
	<!-- 공사중 -->
	<section class = "movieInfo">
	<div data-exact-height="306.02294792586054" data-content-padding-horizontal="0" data-content-padding-vertical="0" id="imgFrameF">
		<div id="imgFrameS">
			<div data-style="" id="imgFrameT">
				<img id="PosterImg" alt="" data-type="image" src="<%=getPage %>">
			</div>
		</div>
	</div>
	
	<div class="c2" id="cff">
		<div id="Cntnr1cbg" class="c2bg"></div>
		<div id="Cntnr1cinlineContent" class="c2inlineContent">
			<div class="c1" id="cfs">
				<div id="Cntnr1dbg" class="c1bg"></div>
				<div id="Cntnr1dinlineContent" class="c1inlineContent"></div>
			</div>
			<div data-packed="true" class="txtNew" id="cft">
				<h2 style="line-height:1.4em;" class="font_6"><span style="line-height:1.4em;"><b><%=mtitle %></b></span></h2>
			</div>
			<div data-packed="true" class="txtNew" id="WRchTxt2j" style="left: 30px; width: 680px; position: absolute; pointer-events: none; top: 55px;">
				<p class="font_8" id="pf"><span id="spf"><span class="color_17"><strong>감독: &nbsp;</strong></span><span class="color_8"><%=director %></span></span></p>
				<p class="font_8" id="ps"><span id="sps"><span class="color_17"><strong>배우: &nbsp;</strong></span><span class="color_8"><%=actor %></span></span></p>
				<p class="font_8" id="pt"><span id="spt"><span class="color_17"><strong>장르: &nbsp;</strong></span><span class="color_8"><%=gname1 %>, <%=gname2 %></span></span></p>
				<p class="font_8" id="pfo"><span id="spfo"><span class="color_17"><strong>개봉일: &nbsp;</strong></span><span class="color_8"><%=opendate %>, <%=nname %></span></span></p>
				<p class="font_8" id="pfi"><span id="spfi"><span class="color_17"><strong>상영시간: &nbsp;</strong></span><span class="color_8"><%=showtime %>분</span></span></p>

				<p class="font_8">&nbsp;</p>

				<p class="font_8"><span class="color_21"><%=synopsis %></span></p>

			</div>
		</div>
	</div>
	<div>
		<div class="starRev">
    		<span class="starR1 on">별1_왼쪽</span>
            <span class="starR2 on">별1_오른쪽</span>
            <span class="starR1 on">별2_왼쪽</span>
            <span class="starR2 on">별2_오른쪽</span>
            <span class="starR1 on">별3_왼쪽</span>
            <span class="starR2">별3_오른쪽</span>
            <span class="starR1">별4_왼쪽</span>
            <span class="starR2">별4_오른쪽</span>
            <span class="starR1">별5_왼쪽</span>
            <span class="starR2">별5_오른쪽</span>
        </div>
	</div>
	</section>
	<section id= "reviewList"class =" movieReview">
		<div class="home-page">
			<div class="home-page__rec-list">
				<div class="rec-row">
					<h5 class="rec-row__title">
						<span>리 뷰</span> <a class="rec-row__show-more" href="javascript:;">
							<span>모두 보기 </span> <span class="glyphicon glyphicon-angle-right"></span>
						</a>
					</h5>
					<div class="carousel slide" data-ride="carousel" id="rlCarousel"
						data-interval="0">
						<div class="carousel-inner ">

							<a class="carousel-control-prev" href="#rlCarousel"
								role="button" data-slide="prev"> <span
								class="carousel-control-prev-icon" aria-hidden="true"></span> <span
								class="sr-only">Previous</span>
							</a> <a class="carousel-control-next" href="#rlCarousel"
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
	<section id = "reviewNeighborList" class =" movieReview">
		<div class="home-page">
			<div class="home-page__rec-list">
				<div class="rec-row">
					<h5 class="rec-row__title">
						<span>이 영화를 본 사람들이 많이 본 리뷰에요</span> <a class="rec-row__show-more" href="javascript:;">
							<span>모두 보기 </span> <span class="glyphicon glyphicon-angle-right"></span>
						</a>
					</h5>
					<div class="carousel slide" data-ride="carousel" id="rnCarousel"
						data-interval="0">
						<div class="carousel-inner ">

							<a class="carousel-control-prev" href="#rnCarousel"
								role="button" data-slide="prev"> <span
								class="carousel-control-prev-icon" aria-hidden="true"></span> <span
								class="sr-only">Previous</span>
							</a> <a class="carousel-control-next" href="#rnCarousel"
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
	<section id = "reviewRecommendList "class ="movieReview">
		<div class="home-page">
			<div class="home-page__rec-list">
				<div class="rec-row">
					<h5 class="rec-row__title">
						<span>이런 리뷰는 어떤가요?</span> <a class="rec-row__show-more" href="javascript:;">
							<span>모두 보기 </span> <span class="glyphicon glyphicon-angle-right"></span>
						</a>
					</h5>
					<div class="carousel slide" data-ride="carousel" id="rrcCarousel"
						data-interval="0">
						<div class="carousel-inner ">

							<a class="carousel-control-prev" href="#rrcCarousel"
								role="button" data-slide="prev"> <span
								class="carousel-control-prev-icon" aria-hidden="true"></span> <span
								class="sr-only">Previous</span>
							</a> <a class="carousel-control-next" href="#rrcCarousel"
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
		
		

	<script type="text/javascript">
		// 별점 이벤트 관리하는 부분(ajax)
		// 현재 별점이 있으면  update서블릿
		// 현재 별점이 없으면 insert 서블릿
    	$('.starRev span').hover(function(){
        	$(this).parent().children('span').removeClass('on');
            $(this).addClass('on').prevAll('span').addClass('on');
            return false;
        });
    </script>
</body>
</html>