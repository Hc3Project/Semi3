<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="wrap">
	<nav class="gnb gnb--home gnb--scrolled">
		<a class="logo active" href="/semi/views/index.jsp"></a>
		<ul class="gnb__left-navs">
			<li><a class="gnb__nav-home active" href="/semi/views/index.jsp">홈</a></li>
			<li class="gnb__category-list"><a class="gnb__nav-category"
				href="../views/category/movieCategory.jsp">영화 카테고리</a> <span>
					<div class="gnb-category-list">
						<div class="gnb-category-list__filters">
							<button class="category-filter-item category-filter-item--active">
								<span class="category-filter-item__text">장르</span>
							</button>
							<button class="category-filter-item">
								<span class="category-filter-item__text">국가</span>
							</button>
							<button class="category-filter-item">
								<span class="category-filter-item__text">특징</span>
							</button>
						</div>
						<ul class="gnb-category-list__filtered-list">
							<li
								class="gnb-category-list__filtered-list-item-all"><a
								href="../views/category/all.jsp">모든 장르</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=525036">SF</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=10011199117">가족</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=97110105109101">공포/호러</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/staffmades/419">다큐멘터리</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380918">드라마</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=403704">멜로/로맨스</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380922">어드벤처</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380916">뮤지컬</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380915">범죄</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=38092">액션</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=510433">코미디</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380919">판타지</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380925">패러디</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=385958">애니메이션</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380924">사극</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380921">미스터리</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380928">스릴러</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=386140">전쟁</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380927">기타</a></li>
						</ul>
						<ul class="gnb-category-list__filtered-list" style="display: none">
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">모든 국가</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">미국</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">프랑스</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">이탈리아</a></li>	
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">한국</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">스페인</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">대만</a></li>
								<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">인도</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">일본</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">영국</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">독일</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">중국</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">캐나다</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">홍콩</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">기타</a></li>
						</ul>
						<ul class="gnb-category-list__filtered-list" style="display: none">
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">모든 리뷰어</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">라이너의컬쳐쇼크</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">발 없는 새</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">필름에 빠지다</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">드림텔러</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">백수골방</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">시선플레이</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">김스카이의하늘담</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">천재이승국</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">뭅이</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">리뷰엉이</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">소개해주는 남자</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">달빛뮤즈</a></li>
						</ul>
					</div>

			</span></li>
			<li><a class="gnb__nav-evaluate" href="javascript:;">취향 분석</a></li>
		</ul>
		<div class="gnb__right-navs">
			<div class="gnb__my-name">
				<a href="/semi/views/member/login.jsp">로그인</a> <span
					class="glyphicon glyphicon-caret-down-f"></span> <span>
					<div class="gnb__account-menu-wrap">
						<ul class="account-menu">
							<li class="account-menu__item"><a class="" href="/watches">본
									리뷰</a></li>
							<li class="account-menu__item"><a class="" href="/semi/views/member/setting.jsp">설정</a>
							</li>
							<li class="account-menu__item"><a href="#">로그아웃</a></li>
						</ul>
					</div>
				</span>
			</div>
			<!-- <div class="gnb__my-name">
                    <span>정한</span>
                    <span class="glyphicon glyphicon-caret-down-f"></span>
                    <span></span>
                </div> -->
			<a class="gnb__wishes" href="/wishes">리뷰어</a>
			<div class="search">
				<button class="search__button">
					<span class="glyphicon glyphicon-search"></span> <span>&nbsp;&nbsp;검색</span>
				</button>
				<span>
					<div class="search-input">
						<a href="javascript:;"
							class="glyphicon glyphicon-search search-input__text-field"></a>
						<input class="search-input__text-field"
							id="search-input__text-field" type="search"
							placeholder="제목, 감독, 배우로 검색" value="">
					</div>
					
				</span>
			</div>
		</div>
	</nav>
</div>
