<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>title another level top top top top top</title>
<link rel="stylesheet" href="../resources/css/megabox.css" />
<link rel="stylesheet" href="../resources/css/theme.css" />
<link rel="stylesheet" href="../resources/css/theme2.css" />
<style>
        .starR1{
            background: url('http://www.escgo.com/wp-content/plugins/universal-star-rating/images/189/08.png') no-repeat -30px 0;
            background-size: auto 100%;
            width: 15px;
            height: 30px;
            float:left;
            text-indent: -9999px;
            cursor: pointer;
        }
        .starR2{
            background: url('http://www.escgo.com/wp-content/plugins/universal-star-rating/images/189/08.png') no-repeat right 0;
            background-size: auto 100%;
            width: 15px;
            height: 30px;
            float:left;
            text-indent: -9999px;
            cursor: pointer;
        }
        .starR1.on{background-position:0px 0;}
        .starR2.on{background-position:-15px 0;}
        
        
</style>
</head>
<body>
<div class="modal fade in" id="movie_detail" tabindex="0" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false" style="display: block;">
	<div class="wrapper">
		<div class="contents clearfix">
			


<!-- 기본정보// -->
<div class="popup_box row1 clearfix">
	<div class="left_wrap">
		<img src="http://image2.megabox.co.kr/mop/poster/2018/30/CC3DB2-3DDC-4A87-AEF4-A92A198C8C42.large.jpg" alt="신비한 동물들과 그린델왈드의 범죄">
		<div class="starRev">
                    <span class="starR1 on">별1_왼쪽</span>
                    <span class="starR2">별1_오른쪽</span>
                    <span class="starR1">별2_왼쪽</span>
                    <span class="starR2">별2_오른쪽</span>
                    <span class="starR1">별3_왼쪽</span>
                    <span class="starR2">별3_오른쪽</span>
                    <span class="starR1">별4_왼쪽</span>
                    <span class="starR2">별4_오른쪽</span>
                    <span class="starR1">별5_왼쪽</span>
                    <span class="starR2">별5_오른쪽</span>
                  </div>

                  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
                  <script type="text/javascript">
                  
                  $('.starRev span').hover(function(){
                  $(this).parent().children('span').removeClass('on');
                  $(this).addClass('on').prevAll('span').addClass('on');
                    return false;
                    });

                  </script>
	</div>
	<div class="right_wrap">
		<div class="title clearfix">
			<h2>신비한 동물들과 그린델왈드의 범죄</h2>
		</div>
		<div class="text">
			
			<ul class="info_wrap">
				
				<li><strong>개봉일</strong> : 2018.11.14</li>
				<li><strong>감독</strong> : 데이빗 예이츠</li>
				<li><strong>배우</strong> : 에디 레드메인</li>
				<li><strong>장르</strong> : 판타지</li>
				<li><strong>상영시간</strong> : 133분</li>
			</ul>
			
		</div>



<!-- //기본정보 -->
<!-- 줄거리// -->
<div class="popup_box row2">
	<h3>줄거리</h3>
	<div class="text">마법 세계의 운명을 건 대결이 시작된다!<br>‘뉴트 스캐맨더’(에디 레드메인)의 활약으로 <br>강력한 어둠의 마법사 ‘겔러트 그린델왈드’(조니 뎁)가 미합중국 마법의회 MACUSA에 붙잡히지만, <br>이내 장담했던 대로 탈출해 추종자를 모으기 시작한다. <br>순혈 마법사의 세력을 모아 마법을 사용하지 않는 사람들을 지배하려는 <br>그린델왈드의 야욕을 막기 위해 ‘알버스 덤블도어’(주드 로)는 제자였던 뉴트에게 도움을 요청한다. <br>마법사 사회는 점점 더 분열되어 가는 가운데, <br>앞날의 위험을 알지 못한 채 뉴트는 이를 승낙하는데… </div>
</div>
<!-- //줄거리 -->
</div></div></div></div></div>
</body>
</html>