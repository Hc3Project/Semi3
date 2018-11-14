<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.semi.user.member.model.vo.Member"%>
<%
	Member m = (Member) session.getAttribute("member");
%>

<!DOCTYPE html>

<div class="wrap">
	<nav class="gnb gnb--home gnb--scrolled">
		<a class="logo active" href="/semi/index.jsp"></a>
		<ul class="gnb__left-navs">
			
			<li class="gnb__category-list"><a class="gnb__nav-category"
				href="<%request.getContextPath();%>/semi/sCategory.se?cCode=all">영화 카테고리</a> 
			<span>
					<div class="gnb-category-list">
						<div class="gnb-category-list__filters">
							<button class="category-filter-item category-filter-item--active">
								<span class="category-filter-item__text">장르</span>
							</button>
							<button class="category-filter-item">
								<span class="category-filter-item__text">국가</span>
							</button>
							<button class="category-filter-item">
								<span class="category-filter-item__text">리뷰어</span>
							</button>
						</div>
						<ul class="gnb-category-list__filtered-list">
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=all">모든 장르</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=G1">SF</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=G2">가족</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=G3">공포/호러</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=G4">다큐멘터리</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=G5">드라마</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=G6">멜로/로맨스</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=G7">어드벤처</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=G8">뮤지컬</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=G9">범죄</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=G10">액션</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=G11">코미디</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=G12">판타지</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=G13">패러디</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=G14">애니메이션</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=G15">사극</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=G16">미스터리</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=G17">스릴러</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=G18">전쟁</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=G19">기타</a></li>
						</ul>
						<ul class="gnb-category-list__filtered-list" style="display: none">
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=all">모든
									국가</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=US">미국</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=FR">프랑스</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=IT">이탈리아</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=KR">한국</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=ES">스페인</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=TW">대만</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=IN">인도</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=JP">일본</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=UK">영국</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=DE">독일</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=CN">중국</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=CA">캐나다</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=HK">홍콩</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=ETC">기타</a></li>
						</ul>
						<ul class="gnb-category-list__filtered-list" style="display: none">
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=all">모든 리뷰어</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=UCIXvXBYSc9fQ7Ri5SM1r8xA">라이너의컬쳐쇼크</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=UCxlv4aOnrRTXMRSL8bVJqEw">B-MAN</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=UCiOWYRzOTiUYi9pJ-kscIKw">발 없는 새</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=UCJfthTE-ACoZJPVgwyw_hsw">필름에 빠지다</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=UCpCiIDf9UrfRqte55FHWlYQ">드림텔러</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=UCNR3K4HA6LyO9tz0oZoSJIA">백수골방</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=UC79hJz6y1EEiIkwfHOuWC4w">시선플레이</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=UCKvfTts0BCr0Zx6FWT_rtEw">김스카이의하늘담</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=UCu3BjLd03jxTVHXTPqZ77iQ">천재이승국</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="../views/category/movieCategory.jsp">뭅이</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="../views/category/movieCategory.jsp">리뷰엉이</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="../views/category/movieCategory.jsp">소개해주는 남자</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="../views/category/movieCategory.jsp">달빛뮤즈</a></li>
						</ul>
					</div>
			</span>
			</li>
			
			<li class="gnb__category-list"><a class="gnb__nav-category"
				href="<%request.getContextPath();%>/semi/sCategory.se?cCode=all">리뷰어</a> 
			<span>
					<div class="gnb-category-list">
						<div class="gnb-category-list__filters">
							<button class="category-filter-item">
								<span class="category-filter-item__text">리뷰어</span>
							</button>
						</div>
						<ul class="gnb-category-list__filtered-list">
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=UCIXvXBYSc9fQ7Ri5SM1r8xA">라이너의컬쳐쇼크</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=UCxlv4aOnrRTXMRSL8bVJqEw">B-MAN</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=UCiOWYRzOTiUYi9pJ-kscIKw">발 없는 새</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=UCJfthTE-ACoZJPVgwyw_hsw">필름에 빠지다</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=UCpCiIDf9UrfRqte55FHWlYQ">드림텔러</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=UCNR3K4HA6LyO9tz0oZoSJIA">백수골방</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=UC79hJz6y1EEiIkwfHOuWC4w">시선플레이</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=UCKvfTts0BCr0Zx6FWT_rtEw">김스카이의하늘담</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=UCu3BjLd03jxTVHXTPqZ77iQ">천재이승국</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=UC8OTtjmmFp-NAypjj64ocmg">뭅이</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=UCrBpV_pG2kyMMEHCMTNzjAQ">리뷰엉이</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=UCBHXCaw_W6sxfgAB7rC-BYw">소개해주는 남자</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=UCMguxwveCsLVpyKrLz-EFTg">달빛뮤즈</a></li>
						</ul>
					</div>
			</span>
			</li>

			<li><a class="gnb__nav-evaluate" href="javascript:;">취향 분석</a></li>
		</ul>
		<div class="gnb__right-navs">
			<div class="gnb__my-name">
				<%
					if (m == null) {
				%>
				<a href="/semi/views/member/login.jsp">로그인</a> <span
					class="glyphicon glyphicon-caret-down-f"></span>
				<%
					} else {
				%>

				<span><%=m.getUserId()%></span> <span
					class="glyphicon glyphicon-caret-down-f"></span> <span>
					<div class="gnb__account-menu-wrap">
						<ul class="account-menu">
							<li class="account-menu__item"><a class=""
								href="/semi/views/movie/movieVisit.jsp">본 리뷰</a></li>
							<li class="account-menu__item"><a class=""
								href="/semi/views/member/setting.jsp">설정</a></li>
							<li class="account-menu__item"><a class=""
								onclick="logout()">로그아웃</a></li>
						</ul>
					</div>
				</span>
				<%
					}
				%>

			</div>

			<!-- <div class="gnb__my-name">
                    <span>정한</span>
                    <span class="glyphicon glyphicon-caret-down-f"></span>
                    <span></span>
                </div> -->

				<div class="search">
				<button class="search__button">
					<span class="glyphicon glyphicon-search"></span> <span>&nbsp;&nbsp;검색</span>
				</button>
				<span>
					<div class="search-input">
						<a href="#" id="searchBtn" class="glyphicon glyphicon-search search-input__text-field"></a>
						<input class="search-input__text-field"
							id="search-input__text-field" type="search"
							placeholder="영화 제목으로 검색" >
					</div>
					
				</span>
			</div>
		</div>


	</nav>
</div>


<script>
	function logout(){
		location.href="/semi/logout.me";
	}
	
	function searchClick(){
		if($("#search-input__text-field").val() != ''){
			
			// 이동하는 코드
			location.href = "<%=request.getContextPath()%>/sMovie.sc?MovieTitle="+$('#search-input__text-field').val();
			} else {
				alert("검색어를 입력해주세요!");
			}
	}
	
	$('#searchBtn').click(function(){
		searchClick();
	});
	
	$('#search-input__text-field').keyup(function(key){
		if(key.keyCode == 13){
			searchClick();
		}
		
	});

</script>