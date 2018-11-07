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
<title>모든 장르</title>
</head>
<body>
	<%@ include file="../common/header.jsp"%>

	<div class="select-menu">
	
		<h5 style="padding-bottom:5px;">보고싶은 작품을 찾아보세요.</h5>
		<div class="select-genre" >
		  <select>
		    <option value="all">모든 장르</option>
		    <option value="sf">SF</option>
		    <option value="family">가족</option>
		    <option value="horror">공포/호러</option>
		    <option value="documentary">다큐멘터리</option>
		    <option value="drama">드라마</option>
		    <option value="romance">멜로/로맨스</option>
		    <option value="adventure">어드벤처</option>
		    <option value="musical">뮤지컬</option>
		    <option value="crime">범죄</option>
		    <option value="action">액션</option>
		    <option value="comedy">코미디</option>
		    <option value="fantagy">판타지</option>
		    <option value="parady">패러디</option>
		    <option value="animation">애니메이션</option>
		    <option value="history">사극</option>
		    <option value="mystery">미스테리</option>
		    <option value="thriller">스릴러</option>
		    <option value="war">전쟁</option>
		    <option value="etc">기타</option>
		  </select>
		</div>
		
		<div class="select-nation">
		<select>
		    <option value="all">모든 국가</option>
		    <option value="us">미국</option>
		    <option value="france">프랑스</option>
		    <option value="italy">이탈리아</option>
		    <option value="korea">한국</option>
		    <option value="spain">스페인</option>
		    <option value="tiwan">대만</option>
		    <option value="india">인도</option>
		    <option value="japan">일본</option>
		    <option value="england">영국</option>
		    <option value="german">독일</option>
		    <option value="china">중국</option>
		    <option value="canada">캐나다</option>
		    <option value="hongkong">홍콩</option>
		    <option value="etc">기타</option>
		  </select>
		</div>
		
		<div class="select-reviewer">
		<select>
		    <option value="all">모든 리뷰어</option>
		    <option value="rvr1">라이너의 컬쳐쇼크</option>
		    <option value="rvr2">발 없는 새</option>
		    <option value="rvr3">필름에 빠지다</option>
		    <option value="rvr4">드림텔러</option>
		    <option value="rvr5">백수골방</option>
		    <option value="rvr6">시선플레이</option>
		    <option value="rvr7">김스카이의 하늘담</option>
		    <option value="rvr8">천재이승국</option>
		    <option value="rvr9">뭅이</option>
		    <option value="rvr10">리뷰엉이</option>
		    <option value="rvr11">소개해주는 남자</option>
		    <option value="rvr12">달빛뮤즈</option>
		  </select>
		</div>
		
		
		<div class="select-order">
		<select>
		    <option value="all">추천순</option>
		    <option value="rvr1">평균별점 순</option>
		    <option value="rvr2">최신작품 순</option>
		    <option value="rvr3">러닝타임 짧은 순</option>
		  </select>
		</div>
	</div>
	
	
	</div>
	
	<!-- 검색결과 -->
	<div class="category-page" style="position:relative;">
		<div class="home-page__rec-list">
			<div class="rec-row">
				<h5 class="rec-row__title">
					<!-- <span>오늘 이 리뷰 어때요?</span> <a class="rec-row__show-more"
						href="javascript:;"> <span>모두 보기 </span> <span
						class="glyphicon glyphicon-angle-right"></span>
					</a> -->
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
					<!-- <span>새로 올라온 리뷰</span> <a class="rec-row__show-more"
						href="javascript:;"> <span>모두 보기 </span> <span
						class="glyphicon glyphicon-angle-right"></span>
					</a> -->
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
					<!-- <span>무트 최고의 인기 리뷰</span> <a class="rec-row__show-more"
						href="javascript:;"> <span>모두 보기 </span> <span
						class="glyphicon glyphicon-angle-right"></span>
					</a> -->
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
			</div>
			</div>
</body>
</html>