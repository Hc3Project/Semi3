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
					<div class="gnb-category-list" id="gnb-category-list">
						<div class="gnb-category-list__filters">
							<button class="category-filter-item category-filter-item--active" id="genreBtn" onChange="displayList();">
								<span class="category-filter-item__text">장르</span>
							</button>
							<button class="category-filter-item" id="nationBtn" onChange="displayList();">
								<span class="category-filter-item__text">국가</span>
							</button>
							<button class="category-filter-item" id="reviewerBtn" onChange="displayList();">
								<span class="category-filter-item__text">리뷰어</span>
							</button>
						</div>
						
						
						<!-- 장르 목록 -->
						<ul class="gnb-category-list__filtered-list" onChange=addCategory();>
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=all">모든 장르</a></li>
						</ul>
						
						
						<!-- 국가 목록 -->
						<ul class="gnb-category-list__filtered-list2" onChange="addNation();" style="display:none">
							<li class="gnb-category-list__filtered-list-item2"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=all">모든 국가</a></li>
						</ul>
						
						<!-- 리뷰어 목록 -->
						<ul class="gnb-category-list__filtered-list3" onChange="addReviewer();" style="display: none">
							<li class="gnb-category-list__filtered-list-item"><a
								href="<%request.getContextPath();%>/semi/sCategory.se?cCode=all">모든 리뷰어</a></li>
						</ul>
					</div>
			</span>
			</li>
			
			
			<!-- 리뷰어 소개 페이지 -->
			<li class="gnb__category-list"><a class="gnb__nav-category"
				href="/semi/reviewer.do">리뷰어</a> 
			<span>
				
			</span>
			</li>

			<li><a class="gnb__nav-evaluate" href="<%request.getContextPath();%>/semi/mRecommend.me">취향 분석</a></li>
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
								href="/semi/views/movie/myMovie.jsp">MyMovie</a></li>
							<li class="account-menu__item"><a class=""
								href="/semi/views/member/setting.jsp">설정</a></li>
							<%if(m.getUserId().equals("admin")){
							%>
							<li class="account-menu__item"><a class="" href="/semi/views/manager/mIndex.jsp">관리자 페이지</a></li>
							<li class="account-menu__item" id="auto"><a >자동 추가</a></li>
							<%	
							}%>
							<li class="account-menu__item"><a class=""
								onclick="logout()">로그아웃</a></li>
						</ul>
					</div>
				</span>
				<%
					}
				%>

			</div>

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


<!-- 장르코드, 장르명 // 국가코드, 국가명 // 리뷰어코드, 리뷰어명 가져오는 부분 ajax -->
<script>

$(function addCategory(){
	// 장르 추가할 ul 부분 지정, 추가할때는 li로 추가 
	var $setGenre = $(".gnb-category-list__filtered-list")
	$
			.ajax({
					url : "/semi/cList.ca",
					data : {
						csql : "selectCategoryGenreList"
					},
					success : function(data){
						
						for(var i in data){
							$category = $("<li>").attr("class", "gnb-category-list__filtered-list-item")
							.append($("<a>").text(data[i].name).attr(
									"href","<%request.getContextPath();%>/semi/sCategory.se?cCode="
											+ data[i].code))
											
							if(i>-1){
								
								$setGenre.append($category);
								
							}
						}
					},
					error : function(data) {
						console.log(data);
						console.log("불러오기실패");
					}
	});
});


$(function addNation(){
	// 국가 추가할 ul 부분 지정, 추가할때는 li로 추가 
	var $setNation = $(".gnb-category-list__filtered-list2")
	$
			.ajax({
					url : "/semi/cList.ca",
					data : {
						csql : "selectCategoryNationList"
					},
					success : function(data){
						
						for(var i in data){
							$category = $("<li>").attr("class", "gnb-category-list__filtered-list-item2")
							.append($("<a>").text(data[i].name).attr(
									"href","<%request.getContextPath();%>/semi/sCategory.se?cCode="
											+ data[i].code))
											
							if(i>-1){
								
								$setNation.append($category);
								
							}
						}
					},
					error : function(data) {
						console.log(data);
						console.log("불러오기실패");
					}
		
	});
});


$(function addReviewer(){
	// 리뷰어 추가할 ul 부분 지정, 추가할때는 li로 추가 
	var $setReviewer = $(".gnb-category-list__filtered-list3")
	$
			.ajax({
					url : "/semi/cList.ca",
					data : {
						csql : "selectCategoryReviewerList"
					},
					success : function(data){
						
						for(var i in data){
							$category = $("<li>").attr("class", "gnb-category-list__filtered-list-item3")
							.append($("<a>").text(data[i].name).attr(
									"href","<%request.getContextPath();%>/semi/sCategory.se?cCode="
											+ data[i].code))
											
							if(i>-1){
								
								$setReviewer.append($category);
								
							}
						}
					},
					error : function(data) {
						console.log(data);
						console.log("불러오기실패");
					}
		
	});
});
</script>


<!-- 장르, 국가, 리뷰어 탭 표시 -->
<script>
$(function displayList(){

		$("#genreBtn").click(function(){
			$(".gnb-category-list__filtered-list2").css("display","none");
			$(".gnb-category-list__filtered-list3").css("display","none")
		})

		$("#nationBtn").click(function(){
			$(".gnb-category-list__filtered-list2").css("display","");
			$(".gnb-category-list__filtered-list3").css("display","none");	
		})
	
		
		$("#reviewerBtn").click(function(){
			$(".gnb-category-list__filtered-list2").css("display","none");
			$(".gnb-category-list__filtered-list3").css("display","");			
		})

});
</script>
<!-- 자동추가기능 -->
<script src="resources/js/adminLogin.js"></script>