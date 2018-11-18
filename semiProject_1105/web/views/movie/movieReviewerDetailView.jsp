<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.semi.manager.reviewer.model.vo.ReviewerInfo"%>
<%
	ReviewerInfo ri = (ReviewerInfo) request.getAttribute("ri");
	String rvrCode = request.getParameter("rvrCode");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<script	src="<%=request.getContextPath()%>/resources/js/jquery-3.3.1.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
<script	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>


<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/reviewerDetail.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">


<!--유튜브 팝업  -->
 <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <link type="text/css"
        href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/redmond/jquery-ui.css" rel="stylesheet" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>


<script src="resources/js/jquery.youtubepopup.min.js"></script>



<title>리뷰어 상세페이지</title>
</head>
<body>

<header>
		<%@ include file="../common/header.jsp"%>
	</header>
	<!--header-->
	
<div class="border-line">
        <div id="contents" class="style-scope ytd-item-section-renderer">
            <ytd-channel-renderer class="style-scope ytd-item-section-renderer">
            <a class="yt-simple-endpoint style-scope ytd-channel-renderer" href="">
            <div id="avatar" class="style-scope ytd-channel-renderer">
                <yt-img-shadow height="136" width="136" class="" loaded="" style="background-color: transparent;"></yt-img-shadow>
                    <img id="profile" alt="" width="136" height="136" src="https://yt3.ggpht.com/a-/AN66SAwVm7WA528o_GTVJTBQw7VyY9yvZzoB7COb7g=s176-c-k-c0x00ffffff-no-rj-mo">
                </yt-img-shadow>
            </div>
            <div id="info" class="style-scope ytd-channel-renderer">
                <h3 id="channel-title" class="style-scope ytd-channel-renderer">
                <span class="style-scope ytd-channel-renderer"><%= ri.getrName() %></span>
                <ytd-badge-supported-renderer class="style-scope ytd-channel-renderer" disable-upgrade="" hidden="">
                </ytd-badge-supported-renderer>
                </h3>
                <div id="metadata" class="style-scope ytd-channel-renderer">
                    <span></span>
                    <span></span>
                </div>
                <yt-formatted-string id="description" class="style-scope ytd-channel-renderer"><%= ri.getProfile() %></yt-formatted-string>
            </div>
            </a>
            <div id="subscribe-button" class="style-scope ytd-channel-renderer">
                <ytd-button-renderer button-renderer="" class="style-scope ytd-channel-renderer style-destructive size-default" is-paper-button="">
                    <a class="yt-simple-endpoint style-scope ytd-button-renderer" tabindex="-1" href="https://www.youtube.com/channel/UCIXvXBYSc9fQ7Ri5SM1r8xA">
                        <paper-button role="button" tabindex="0" animated="" aria-disabled="false" elevation="0" id="button" class="style-scope ytd-button-renderer style-destructive size-default"><yt-formatted-string id="text" class="style-scope ytd-button-renderer style-destructive size-default">Youtube 채널 바로 가기</yt-formatted-string>
                        </paper-button>
                    </a></ytd-button-renderer>
            </div>
            </ytd-channel-renderer>
        </div>
   </div>
   <br><br>
   <section class="listSection">
		<div class="home-page">
			<div class="home-page__rec-list">
				<div class="rec-row">
					<h5 class="rec-row__title">
						<span><%= ri.getrName() %>의 인기 리뷰</span>
					</h5>
					<div class="carousel slide" data-ride="carousel" id="rvrCarousel"
						data-interval="30000">
						<div class="carousel-inner ">

							<a class="carousel-control-prev" href="#rvrCarousel"
								role="button" data-slide="prev"> <span
								class="carousel-control-prev-icon" aria-hidden="true"></span> <span
								class="sr-only">Previous</span>
							</a> <a class="carousel-control-next" href=#rvrCarousel
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
						<span>???</span> <a class="rec-row__show-more" href="javascript:;">
							<span>모두 보기 </span> <span class="glyphicon glyphicon-angle-right"></span>
						</a>
					</h5>
					<div class="carousel slide" data-ride="carousel" id="st3Carousel"
						data-interval="30000">
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
<script type="text/javascript">
var $todayDiv = $("#rvrCarousel .carousel-inner");
	$.ajax({
		url : "rList.rv"
		,data : {
				rvrCode : "<%=rvrCode%>",
				rsql : "rvrReviewList"
		},
		success : function(data) {
			var count = 0;
			for ( var i in data) {
				$review = $("<div/>")
						.attr("class", "col-md-2 youtube")
						.attr("rel", data[i].Videoid)
						.append($("<h1/>").text(data[i].Movie))
						.append(
								$("<img/>").attr(
										"src",
										"https://img.youtube.com/vi/"
												+ data[i].Videoid + "/"
												+ "mqdefault.jpg")

						)
						.append(
								$("<i/>").attr("class",
										"hover-box hover-box--play"))
						.append(
								$("<div/>")
										.attr("class", "hover-box")
										.append(
												$("<h2/>")
														.text(
																data[i].Reviewer)))
						.attr("value", data[i].Videoid);

				if (i > -1 && i < 6) {
					if (i == 0) {
						$todayDiv.append($("<div>").attr("class",
								"item active rec-list clearfix")
								.append($review));
					}
					$(
							"#rvrCarousel div[class='item active rec-list clearfix']")
							.append($review);
				} else {
					if (i % 6 == 0) {
						$todayDiv.append($("<div>").attr("class",
								"item rec-list clearfix").append(
								$review));
					}
					$(
							"#rvrCarousel div[class='item rec-list clearfix']:last-child")
							.append($review);
				}
				count = i;

			}
			// 영상이 6개 이하면 페이지 넘기는 버튼 hidden
			if (count < 5) {

				$("#rlCarousel .carousel-inner>a").attr("hidden",
						"hidden");
			}
			// 썸네일 마우스 오버
			$(".rec-list>div").hover(function() {

				$(this).children(".hover-box").stop().fadeIn();
				$(this).children("h1").stop().hide();
			}, function() {
				$(this).children(".hover-box").stop().fadeOut();
				$(this).children("h1").stop().fadeIn();
			});
			$(".rec-list> div").click(function() {
				console.log($(this).attr("value"));
				
				
			})
		
				$("div.youtube").YouTubePopup({

					'youtubeId' : '',

					'title' : '',

					'idAttribute' : 'rel',

					'draggable' : false,

					'modal' : true,

					'width' : 1280,

					'height' : 720,

					'hideTitleBar' : true,

					'clickOutsideClose' : true,

					'overlayOpacity' : 0.7,

					'autohide' : 1,

					'autoplay' : 1,

					'color' : 'red ',

					'controls' : 1,

					'fullscreen' : 0,

					'loop' : 0,

					'hd' : 1,

					'showinfo' : 1,
					'showBorder' : false

				});
				
			
		},
		error : function(data) {
			console.log(data);
			console.log("실패");
		}
	});

</script>
	

</body>
</html>