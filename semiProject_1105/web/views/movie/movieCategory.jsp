<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.kh.semi.manager.video.model.vo.*"%>

<%
	ArrayList<MovieInfo> mList = (ArrayList<MovieInfo>) request.getAttribute("mList");
	String cCode = request.getParameter("cCode");
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script	src="<%=request.getContextPath()%>/resources/js/jquery-3.3.1.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
<script	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>


<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/category.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">

<title>모든 장르</title>
</head>
<body>
	<%@ include file="../common/header.jsp"%>

	<div class="select-menu">


		<div class="select-genre">
			<select class="genre">
				<option value="all" id="all" >모든 장르</option>
				<option value="G1" id="sf">SF</option>
				<option value="G2" id="family">가족</option>
				<option value="G3" id="horro"">공포/호러</option>
				<option value="G4" id="documentary">다큐멘터리</option>
				<option value="G5" id="drama">드라마</option>
				<option value="G6" id="ramance">멜로/로맨스</option>
				<option value="G7" id="adventure">어드벤처</option>
				<option value="G8" id="musical">뮤지컬</option>
				<option value="G9" id="crime">범죄</option>
				<option value="G10" id="action">액션</option>
				<option value="G11" id="comedy">코미디</option>
				<option value="G12" id="fantagy">판타지</option>
				<option value="G13" id="parady">패러디</option>
				<option value="G14" id="animation">애니메이션</option>
				<option value="G15" id="history">사극</option>
				<option value="G16" id="mystery">미스테리</option>
				<option value="G17" id="thriller">스릴러</option>
				<option value="G18" id="war">전쟁</option>
				<option value="G19" id="etc">기타</option>
			</select>
		</div>
		

		<div class="select-nation">
			<select class="nation">
				<option value="all" id="all">모든 국가</option>
				<option value="US" id="us">미국</option>
				<option value="FR" id="france">프랑스</option>
				<option value="IT" id="italy">이탈리아</option>
				<option value="KR" id="korea">한국</option>
				<option value="ES" id="spain">스페인</option>
				<option value="TW" id="tiwan">대만</option>
				<option value="IN" id="india">인도</option>
				<option value="JP" id="japan">일본</option>
				<option value="UK" id="england">영국</option>
				<option value="DE" id="german">독일</option>
				<option value="CN" id="china">중국</option>
				<option value="CA" id="canada">캐나다</option>
				<option value="HK" id="hongkong">홍콩</option>
				<option value="ETC" id="etc">기타</option>
			</select>
		</div>

		<div class="select-reviewer">
			<select class="reviewer">
				<option value="all" id="all">모든 리뷰어</option>
				<option value="UCIXvXBYSc9fQ7Ri5SM1r8xA" id="rvr1">라이너의 컬쳐쇼크</option>
				<option value="UCxlv4aOnrRTXMRSL8bVJqEw" id="rvr2">B-MAN</option>
				<option value="UCiOWYRzOTiUYi9pJ-kscIKw" id="rvr3">발 없는 새</option>
				<option value="UCJfthTE-ACoZJPVgwyw_hsw" id="rvr3">필름에 빠지다</option>
				<option value="UCpCiIDf9UrfRqte55FHWlYQ" id="rvr4">드림텔러</option>
				<option value="UCNR3K4HA6LyO9tz0oZoSJIA" id="rvr5">백수골방</option>
				<option value="UC79hJz6y1EEiIkwfHOuWC4w" id="rvr6">시선플레이</option>
				<option value="UCKvfTts0BCr0Zx6FWT_rtEw" id="rvr7">김스카이의 하늘담</option>
				<option value="UCu3BjLd03jxTVHXTPqZ77iQ" id="rvr8">천재이승국</option>
				<option value="UC8OTtjmmFp-NAypjj64ocmg" id="rvr9">뭅이</option>
				<option value="UCrBpV_pG2kyMMEHCMTNzjAQ" id="rvr10">리뷰엉이</option>
				<option value="UCBHXCaw_W6sxfgAB7rC-BYw" id="rvr11">소개해주는 남자</option>
				<option value="UCMguxwveCsLVpyKrLz-EFTg" id="rvr12">달빛뮤즈</option>
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
	




	<!-- 검색결과 -->
	<div class="category-page" style="position: relative;">
		<div class="home-page__rec-list">
			<div class="rec-row">

				<div class="rec-list clearfix" >
					<%
						for (MovieInfo mi : mList) {
					%>

					<div class = "mcode" value = "<%=mi.getmCode()%>">
						<h1>
							<%=mi.getmTitle()%>
						</h1>
						<img
							src="https://dhgywazgeek0d.cloudfront.net/watcha/image/upload/c_fill,h_264,q_80,w_470/x8hs3ctbkum162mpllyr.jpg"
							alt=""> <i class="hover-box hover-box--play"></i>
					</div>
					<%
						}
					%>
					<script type="text/javascript">
						$(function() {
							$(".mcode").click(function() {
								location.href = "/semi/dView.do?mCode="+$(this).attr("value");
							})
						});
					
					</script>
				</div>
			</div>
		</div>
	</div>
	
	
	<!-- 헤더의 카테고리 선택과 연결되는 셀렉트박스 액션 부분 -->
	<script>
		
		$(function() {
			
			var checked = "<%=cCode%>";
			
			console.log(checked.length);
			<%-- console.log("<%=cCode%>");--%>
			if(checked.length < 3 && checked.charAt(0) == 'G'){ // 장르코드 셀렉트
				
				$(".genre").val("<%=cCode%>").prop("selected","selected");
			
			}else if( checked.length == 2 || checked.length == 3 ){
				/*checked == "US" || "KR" || "TW" || "IN" || "CN" ||
				"US" || "JP" || "HK" || "DE" ||	"UK" || "FR" || 
				"CA" || "IT" || "ES" || "ETC" &&  */
				$(".nation").val("<%=cCode%>").prop("selected","selected");
			
			}else if( checked.length > 20 ){

			$(".reviewer").val("<%=cCode%>").prop("selected","selected");
			
			}
		});

	</script>
</body>
</html>