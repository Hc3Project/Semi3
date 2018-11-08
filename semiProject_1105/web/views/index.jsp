<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="../resources/js/common.js"></script>
<script src="../resources/js/boxOffice.js"></script>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/css/reset.css">
<link rel="stylesheet" href="../resources/css/main.css">
<link rel="stylesheet" href="../resources/css/style.css">


<title>movie traveler</title>

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
				<div id="boxOffice">
					<div id="bo1">
					<div style="height: 45px;"></div>
						<img alt="boxoffice" src="../resources/image/h2_boxoffice.png"
							style="width: 200px; height: 15px; display: block; margin: auto;
							 ">
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
					<div class="carousel slide" data-ride="carousel" id="st2Carousel"
						data-interval="30000">
						<div class="carousel-inner ">
							
						<a class="carousel-control-prev" href="#st2Carousel" role="button"
							data-slide="prev"> <span class="carousel-control-prev-icon"
							aria-hidden="true"></span> <span class="sr-only">Previous</span>
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

	<!--  -->
 <script type="text/javascript">
    $(function() {
    	//st2Carousel 대상 div 지정
        $topDiv = $("#st2Carousel .carousel-inner");
        $.ajax({
            url : "/semi/rToday.re",
            success : function(data){
                
                for(var i in data){
                    $review= $("<div/>").attr("class" , "col-md-2").append(
                        $("<h1/>").text(data[i].Videoid )
                    ).append(
                        $("<img/>").attr("src","https://dhgywazgeek0d.cloudfront.net/watcha/image/upload/c_fill,h_264,q_80,w_470/x8hs3ctbkum162mpllyr.jpg")

                    ).append(
                        $("<i/>").attr("class","hover-box hover-box--play")
                    ).append(
                        $("<div/>").attr("class","hover-box").append(
                            $("<h2/>").text("호버시 제목")
                        ).append(
                            $("<p/>").text("호버시 텍스트")
                        )
                    );
                  
                    if(i>-1&&i<6){
                        if(i==0){
                        	$topDiv.append(
                                    $("<div>").attr("class","item active rec-list clearfix").append($review)
                                );
                        }
                        $("#st2Carousel div[class='item active rec-list clearfix']").append($review);
                    } else{
                    	if(i%6==0){
                    		 $topDiv.append(
                                     $("<div>").attr("class","item rec-list clearfix").append($review)
                                 );
                    	}
                    	$("#st2Carousel div[class='item rec-list clearfix']:last-child").append($review);
                    } 
                }
             // 썸네일 마우스 오버
                $(".rec-list>div").hover(function(){
                	
                    $(this).children(".hover-box").stop().fadeIn(); 
                    $(this).children("h1").stop().hide();
                }, function () { 
                    $(this).children(".hover-box").stop().fadeOut(); 
                    $(this).children("h1").stop().fadeIn();
                });
            },error : function(){
                console.log("실패");
            }
        });
        
    });
    
    </script>

</body>
</html>