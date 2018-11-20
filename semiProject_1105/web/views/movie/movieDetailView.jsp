<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.sql.Date, com.kh.semi.user.movie.model.vo.MovieDetailInfo, com.kh.semi.user.member.model.vo.Member"%>
<%
	String getPage = (String) request.getAttribute("page");
	MovieDetailInfo mov = (MovieDetailInfo) request.getAttribute("mov");
	String mtitle = mov.getMtitle();
	String mcode=mov.getMcode();
	String director = mov.getDirector();
	String actor = mov.getActor();
	int showtime = mov.getShowtime();
	String opendate = String.valueOf(mov.getOpendate());
	String gname1 = mov.getGname1();
	String gname2 = mov.getGname2();
	String nname = mov.getNname();
	int counts = mov.getCounts();
	String synopsis = mov.getSynopsis();
	Member member=(Member)session.getAttribute("member");
	int score=(int)request.getAttribute("score");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>포오스터어어어!!!</title>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="resources/js/common.js"></script>
<script src="resources/js/detailReviewList.js"></script>



<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/reset.css">
<link rel="stylesheet" href="resources/css/main.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/detail.css" />


<!--유튜브 팝업  -->
 <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <link type="text/css"
        href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/redmond/jquery-ui.css" rel="stylesheet" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>


<script src="resources/js/jquery.youtubepopup.min.js"></script>

</head>
<body>

	<header>
		<div style="height: 80px;">
			<%@ include file="../common/header.jsp"%>
		</div>
	</header>

	<section class="movieInfo" style="background-image: url(<%=getPage%>);">
		<div>
			<div>
				<div class="row">
					<div class="col-lg-2" data-exact-height="306.02294792586054"
						data-content-padding-horizontal="0"
						data-content-padding-vertical="0" id="imgFrameF">
						<div id="imgFrameS">
							<div data-style="" id="imgFrameT">
								<img id="PosterImg" alt="" data-type="image" src="<%=getPage%>">
							</div>
						</div>
					</div>
					<div class="col-lg-10">

						<ul>
							<li><h4>
									<b id="mtitle"><%=mtitle%></b>
								</h4></li>
							<li><p class="font_8">&nbsp;</p></li>
							<li><p class="font_8" id="pf">
									<span id="spf"><span class="color_17"><strong>감독:
												&nbsp;</strong></span><span class="color_8"><%=director%></span></span>
								</p></li>
							<li><p class="font_8" id="ps">
									<span id="sps"><span class="color_17"><strong>배우:
												&nbsp;</strong></span><span class="color_8"><%=actor%></span></span>
								</p></li>
							<li><p class="font_8" id="pt">
									<span id="spt"><span class="color_17"><strong>장르:
												&nbsp;</strong></span><span class="color_8"><%=gname1%>, <%=gname2%></span></span>
								</p></li>
							<li><p class="font_8" id="pfo">
									<span id="spfo"><span class="color_17"><strong>개봉일:
												&nbsp;</strong></span><span class="color_8"><%=opendate%>, <%=nname%></span></span>
								</p></li>
							<li><p class="font_8" id="pfi">
									<span id="spfi"><span class="color_17"><strong>상영시간:
												&nbsp;</strong></span><span class="color_8"><%=showtime%>분</span></span>
								</p></li>
							<li><p class="font_8">&nbsp;</p></li>
							<li>
								<div class="starRev">
									<span class="starR1">1</span> <span class="starR2">2</span>
									<span class="starR1">3</span> <span class="starR2">4</span>
									<span class="starR1">5</span> <span class="starR2">6</span>
									<span class="starR1">7</span> <span class="starR2">8</span>
									<span class="starR1">9</span> <span class="starR2">10</span>
								</div>
								<div>
									<h6 class="average"></h6>
								</div>
							</li>
							
							<li><p class="font_8">&nbsp;</p></li>
							<li>
								<div class="color_21">
									<p class="font_6"><%=synopsis%></p>
								</div>
							</li>
						</ul>

					</div>
					<div class="col-lg-3"></div>
				</div>
			</div>
		</div>

	</section>
	<section id="reviewList" class=" movieReview">
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

							<a class="carousel-control-prev" href="#rlCarousel" role="button"
								data-slide="prev"> <span class="carousel-control-prev-icon"
								aria-hidden="true"></span> <span class="sr-only">Previous</span>
							</a> <a class="carousel-control-next" href="#rlCarousel"
								role="button" data-slide="next"> <span
								class="carousel-control-next-icon" aria-hidden="true"></span> <span
								class="sr-only">Next</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>

	</section>
	<section id="reviewNeighborList" class=" movieReview">
		<div class="home-page">
			<div class="home-page__rec-list">
				<div class="rec-row">
					<h5 class="rec-row__title">
						<span>이 영화의 리뷰를 본 사람들이 많이 본 리뷰예요</span> <a class="rec-row__show-more"
							href="javascript:;"> <span>모두 보기 </span> <span
							class="glyphicon glyphicon-angle-right"></span>
						</a>
					</h5>
					<div class="carousel slide" data-ride="carousel" id="rnCarousel"
						data-interval="0">
						<div class="carousel-inner ">

							<a class="carousel-control-prev" href="#rnCarousel" role="button"
								data-slide="prev"> <span class="carousel-control-prev-icon"
								aria-hidden="true"></span> <span class="sr-only">Previous</span>
							</a> <a class="carousel-control-next" href="#rnCarousel"
								role="button" data-slide="next"> <span
								class="carousel-control-next-icon" aria-hidden="true"></span> <span
								class="sr-only">Next</span>
							</a>
						</div>
					</div>

				</div>

			</div>
		</div>

	</section>
	<section id="reviewRecommendList " class="movieReview">
		<div class="home-page">
			<div class="home-page__rec-list">
				<div class="rec-row">
					<h5 class="rec-row__title">
						<span>이런 리뷰는 어떤가요?</span> <a class="rec-row__show-more"
							href="javascript:;"> <span>모두 보기 </span> <span
							class="glyphicon glyphicon-angle-right"></span>
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

			</div>
		</div>

	</section>



	<script type="text/javascript">
		
		var num=<%=score%>;
		var avg=0;
		
		// 공통사항
		$.ajax({
			url:"/semi/star.avg",
			data:{
				mCode:<%=mcode%>
			},
			success:function(data){
				avg=data;
				$('.average').html("이 영화의 평균 평점은 <font style='color: rgb(242, 198, 102)'>"+avg+"</font>점 입니다.");
			}
		});
		
		for(var i=0;i<num;i++){
			$('.starRev span').parent().children('span').eq(i).addClass('on');
		}
		
		$('.starRev span').hover(function() {
			$(this).parent().children('span').removeClass('on');
			$(this).addClass('on').prevAll('span').addClass('on');
		},function(){
			$(this).parent().children('span').removeClass('on');
			for(var i=0;i<num;i++){
				$(this).parent().children('span').eq(i).addClass('on');
			}
		});
		
		$('.starRev span').click(function(){
			<%if(member!=null){%>
				$.ajax({
					url:"/semi/sInsert.do",
					data:{
						mCode:<%=mcode%>,
						score:$(this).text()
					},
					success:function(data){
						alert(data+"점이 반영되었습니다.");
						num=data;
						for(var i=0;i<num;i++){
							$('.starRev span').parent().children('span').eq(i).addClass('on');
						}
					},
					error:{
						
					}
					
				});
				
				$.ajax({
					url:"/semi/star.avg",
					data:{
						mCode:<%=mcode%>
					},
					success:function(data){
						var avg=data;
						$('.average').text("이 영화의 평균 평점은 "+avg+"점 입니다.")
					}
				});
			<%}%>
		});
		
		
	</script>
</body>
</html>