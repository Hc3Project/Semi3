<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.semi.manager.reviewer.model.vo.ReviewerInfo, com.kh.semi.user.member.model.vo.Member"%>
<%
	ReviewerInfo ri = (ReviewerInfo) request.getAttribute("ri");
	String rvrCode = (String)request.getAttribute("rvrCode");
	String prfImg=(String)request.getAttribute("prfImg");
	System.out.println("이미지주소:"+prfImg);
	Member member= (Member) session.getAttribute("member");
	String list=(String)request.getAttribute("list");
	String[] rvr=list.split(", ");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<script	src="<%=request.getContextPath()%>/resources/js/jquery-3.3.1.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
<script	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<script src="resources/js/common.js"></script>
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
 <script	src="<%=request.getContextPath()%>/resources/js/jquery.youtubepopup.min.js"></script>



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
                    <img id="profile" alt="" width="136" height="136" src="https://yt3.ggpht.com/a-/<%=prfImg%>">
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
            <span class="likes">
            	<img class="heartBtn" id="<%=rvrCode %>" src="/semi/resources/image/grheart.png" alt="grey">
            </span>
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
						<span>모든 리뷰</span> 
					</h5>
					<div  id="rvrAllCarousel">
						<div class="rvrAll">
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
$(function() {
	
var $todayDiv = $("#rvrCarousel .carousel-inner");
page =0;
	$.ajax({
		url : "rList.rv"
		,data : {
				rvrCode : "<%=rvrCode%>",
				rsql : "rvrReviewList",
				
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
			
			hover();
			youtubePopup();
			
		},
		error : function(data) {
			console.log(data);
			console.log("실패");
		}
		
	});
	$todayDivAll = $("#rvrAllCarousel .rvrAll");
	
	$.ajax({
		url : "rAll.rv"
		,data : {
				rvrCode : "<%=rvrCode%>",
				rsql : "rvrReviewAll",
				page: page++
		},
		success : function(data) {
			
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

			
					
				if (i % 6 == 0) {
						$todayDivAll.append($("<div>").attr("class",
								"item rec-list clearfix").append(
								$review));
					}
					$(
							"#rvrAllCarousel div[class='item rec-list clearfix']:last-child")
							.append($review);
	

			}
			$("div.youtube").click(function() {
				$.ajax({
					url:"rCount.rv",
					data:{
						videoId : $(this).attr("value")
					},success: function (data) {
						console.log($(this).attr("value"));
					}
				});
			});
			hover();
			youtubePopup();
		},
		error : function(data) {
			console.log(data);
			console.log("실패");
		}
		
	});
	
});




$(window).scroll(function() {
    if ($(window).scrollTop() == $(document).height() - $(window).height()) {
     
      $.ajax({
  		url : "rAll.rv"
  		,data : {
  				rvrCode : "<%=rvrCode%>",
  				rsql : "rvrReviewAll",
  				page : page++
  		},
  		success : function(data) {
  			var count = 0;
  			for ( var i in data) {
  				console.log(page);
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

  				
  					if (i % 6 == 0) {
  						$todayDivAll.append($("<div>").attr("class",
  								"item rec-list clearfix").append(
  								$review));
  					}
  					$(
  							"#rvrAllCarousel div[class='item rec-list clearfix']:last-child")
  							.append($review);
  				
  				count = i;

  			}
  			// 영상이 6개 이하면 페이지 넘기는 버튼 hidden
  			
  			hover();
  			youtubePopup();
  		},
  		error : function(data) {
  			console.log(data);
  			console.log("실패");
  		}
  		
  	});

    }
});
function youtubePopup() {
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
	
};
function hover() {
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
};

<%if(member!=null){%>
	
	<%if(list.length()>0){%>
		<%for(int i=0;i<rvr.length;i++){%>
			$('#<%=rvr[i]%>').attr({
				src:'/semi/resources/image/rdheart.png',
				alt:'red'
			});
		<%}%>
	<%}%>
	
	$('.heartBtn').click(function(){
		var color=$(this).attr('alt');
		if(color=='grey'){
			$.ajax({
				url:"/semi/insert.rvr",
				data:{
					userId:"<%=member.getUserId()%>",
					rvrCode:$(this).attr('id')
				},
				success:function(data){
					console.log(data+" 좋아요");
				}
			});
			$(this).attr({
				src:'/semi/resources/image/rdheart.png',
				alt:'red'
			});
			
		}else{
			$.ajax({
				url:"/semi/delete.rvr",
				data:{
					userId:"<%=member.getUserId()%>",
					rvrCode:$(this).attr('id')
				},
				success:function(data){
					console.log(data+" 싫어요");
				}
			});
			$(this).attr({
				src:'/semi/resources/image/grheart.png',
				alt:'grey'
			});
		}
	});
<%}else{%>
	$('.heartBtn').click(function(){
		alert("로그인을 하시면 리뷰어 좋아요 기능이 활성화됩니다.");
	});
<%}%>

</script>

	

</body>
</html>