<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../../resources/js/jquery-3.3.1.min.js"></script>

<script src="../../resources/js/common.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../../resources/css/bootstrap.min.css">


<link rel="stylesheet" href="../../resources/css/reset.css">
<link rel="stylesheet" href="../../resources/css/style.css">
<link rel="stylesheet" href="../../resources/css/main.css">
<link rel="stylesheet" href="../../resources/css/myMovie.css">
<title>My Movie</title>
</head>
<body>
	<header>
		<%@ include file="../common/header.jsp"%>
	</header>
	<!--header-->

	<section class="container">

		<div class="tabs">
			<span class="tab signin active"> <a href="#signin">최근 목록</a>
			</span> <span class="tab signup"> <a href="#signup">평가 영화</a>
			</span>
		</div>
		<div class="content">
			<div class="signin-cont cont">
				<div class="category-page" style="position: relative;">
					<div class="home-page__rec-list">
						<div class="rec-row" id="visitMovie"></div>
					</div>
				</div>
			</div>
			<div class="signup-cont cont"></div>
		</div>


	</section>



	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script type="text/javascript">
		$('.tabs .tab').click(function() {
			if ($(this).hasClass('signin')) {
				$('.tabs .tab').removeClass('active');
				$(this).addClass('active');
				$('.cont').hide();
				$('.signin-cont').show();
			}
			if ($(this).hasClass('signup')) {
				$('.tabs .tab').removeClass('active');
				$(this).addClass('active');
				$('.cont').hide();
				$('.signup-cont').show();
			}
		});
		$(function() {
			$ajax({
				url : "/mVisit.do",
				type : post,
					success : {function(data) {
	                    var $top = $("#visitMovie")
							for ( var i in data) {
								var $list= $("<div>")
		                        .append(
		                            $("<h1>").text()
		                        ).append(
		                            $("<img>").attr("src","https://dhgywazgeek0d.cloudfront.net/watcha/image/upload/c_fill,h_264,q_80,w_470/x8hs3ctbkum162mpllyr.jpg")
		                        ).append(
		                            $("<i>").attr("class","hover-box hover-box--play")
		                        );
		
			                        if(i%6==0){
			                            $top.append($("<div>").attr("class","rec-list clearfix"))
			                                                  .append($ilst);
			                        }else{
			                            $("#visitMovie div[class='item rec-list clearfix']:last-child");
			                        }
						        }
	                    }
				
                }});
		});
		
		
		
	</script>

</body>
</html>