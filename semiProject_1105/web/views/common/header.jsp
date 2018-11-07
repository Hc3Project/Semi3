<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="wrap">
	<nav class="gnb gnb--home gnb--scrolled">
		<a class="logo active" href="/semi/views/index.jsp"></a>
		<ul class="gnb__left-navs">
			<li><a class="gnb__nav-home active" href="/semi/views/index.jsp">홈</a></li>
			<li class="gnb__category-list"><a class="gnb__nav-category"
				href="javascript:;">영화 카테고리</a> <span>
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
								class="gnb-category-list__filtered-list-item gnb-category-list__filtered-list-item--new"><a
								href="/arrivals/latest">새로 올라온 작품</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=525036">TV 드라마</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=10011199117">TV 다큐멘터리</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=97110105109101">TV 애니메이션</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/staffmades/419">영어자막 지원 작품</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380918">코미디</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=403704">예능</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380922">스릴러</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380916">다큐멘터리</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380915">드라마</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=38092">애니메이션</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=510433">단편</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380919">액션</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380925">로맨스·멜로</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=385958">스포츠</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380924">범죄·느와르</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380921">공포</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380928">판타지</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=386140">틴에이저</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380927">SF</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=397781">키즈</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380929">전쟁</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=384755">음악</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=386906">재난</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380937">시대극</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380933">가족·아동</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380934">시트콤</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=380923">로맨틱코미디</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="/category?genre=510435">시사·교양</a></li>
						</ul>
						<ul class="gnb-category-list__filtered-list" style="display: none">
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">미국</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">프랑스</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">한국</a></li>
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
						</ul>
						<ul class="gnb-category-list__filtered-list" style="display: none">
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">추리</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">심리</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">그림</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">영화</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">2010년대</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">사회</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">관계</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">문화</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">작가</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">90년이전</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">기독교</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">여행</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">인물</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">사진</a></li>
							<li class="gnb-category-list__filtered-list-item"><a
								href="javascript:;">정치</a></li>
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
