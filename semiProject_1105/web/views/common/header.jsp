<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="com.kh.semi.member.model.vo.Member"%>
<%
	Member m = (Member)session.getAttribute("member");
%>
   
<%-- <% ArrayList<Category> list = (ArrayList<Category>)request.getAttribute("list"); %> --%>

<!DOCTYPE html>
<script src="<%= request.getContextPath()%>/semi/resources/js/jquery-3.3.1.min.js"></script>
<div class="wrap">
   <nav class="gnb gnb--home gnb--scrolled">
      <a class="logo active" href="/semi/views/index.jsp"></a>
      <ul class="gnb__left-navs">
         <li><a class="gnb__nav-home active" href="/semi/views/index.jsp">홈</a></li>
         <li class="gnb__category-list"><a class="gnb__nav-category"
            href="<%request.getContextPath();%>/semi/views/category/movieCategory.jsp">영화 카테고리</a> <span>
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
                     <li class="gnb-category-list__filtered-list-item" id="all" ><a 
                        href="<%request.getContextPath();%>/semi/views/category/movieCategory.jsp">모든 장르</a></li>
                     <li class="gnb-category-list__filtered-list-item" id="sf" value="sf"><a 
                        href="<%request.getContextPath();%>/semi/sCategory.se?cCode=g1">SF</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="<%request.getContextPath();%>/semi/views/category/sCategory.se?cCode=g2">가족</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="<%request.getContextPath();%>/semi/views/category/sCategory.se?cCode=g3">공포/호러</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="<%request.getContextPath();%>/semi/views/category/sCategory.se?cCode=g4">다큐멘터리</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="<%request.getContextPath();%>/semi/views/category/sCategory.se?cCode=g5">드라마</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="<%request.getContextPath();%>/semi/views/category/sCategory.se?cCode=g6">멜로/로맨스</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="<%request.getContextPath();%>/semi/views/category/sCategory.se?cCode=g7">어드벤처</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="<%request.getContextPath();%>/semi/views/category/sCategory.se?cCode=g8">뮤지컬</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="<%request.getContextPath();%>/semi/views/category/sCategory.se?cCode=g9">범죄</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="<%request.getContextPath();%>/semi/views/category/sCategory.se?cCode=g10">액션</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="<%request.getContextPath();%>/semi/views/category/sCategory.se?cCode=g11">코미디</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="<%request.getContextPath();%>/semi/views/category/sCategory.se?cCode=g12">판타지</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="<%request.getContextPath();%>/semi/views/category/sCategory.se?cCode=g13">패러디</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="<%request.getContextPath();%>/semi/views/category/sCategory.se?cCode=g14">애니메이션</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="<%request.getContextPath();%>/semi/views/category/sCategory.se?cCode=g15">사극</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="<%request.getContextPath();%>/semi/views/category/sCategory.se?cCode=g16">미스터리</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="<%request.getContextPath();%>/semi/views/category/sCategory.se?cCode=g17">스릴러</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="<%request.getContextPath();%>/semi/views/category/sCategory.se?cCode=g18">전쟁</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="<%request.getContextPath();%>/semi/views/category/sCategory.se?cCode=g19">기타</a></li>
                  </ul>
                  <ul class="gnb-category-list__filtered-list" style="display: none">
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="../views/category/movieCategory.jsp">모든 국가</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="../views/category/movieCategory.jsp">미국</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="../views/category/movieCategory.jsp">프랑스</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="../views/category/movieCategory.jsp">이탈리아</a></li>   
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="../views/category/movieCategory.jsp">한국</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="../views/category/movieCategory.jsp">스페인</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="../views/category/movieCategory.jsp">대만</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="../views/category/movieCategory.jsp">인도</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="../views/category/movieCategory.jsp">일본</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="../views/category/movieCategory.jsp">영국</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="../views/category/movieCategory.jsp">독일</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="../views/category/movieCategory.jsp">중국</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="../views/category/movieCategory.jsp">캐나다</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="../views/category/movieCategory.jsp">홍콩</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="../views/category/movieCategory.jsp">기타</a></li>
                  </ul>
                  <ul class="gnb-category-list__filtered-list" style="display: none">
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="../views/category/movieCategory.jsp">모든 리뷰어</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="../views/category/movieCategory.jsp">라이너의컬쳐쇼크</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="../views/category/movieCategory.jsp">발 없는 새</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="../views/category/movieCategory.jsp">필름에 빠지다</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="../views/category/movieCategory.jsp">드림텔러</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="../views/category/movieCategory.jsp">백수골방</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="../views/category/movieCategory.jsp">시선플레이</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="../views/category/movieCategory.jsp">김스카이의하늘담</a></li>
                     <li class="gnb-category-list__filtered-list-item"><a
                        href="../views/category/movieCategory.jsp">천재이승국</a></li>
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

         </span></li>
         
         <script>
            <%-- $(function(){
               $("#sf").click(function(){
                  var selectedGenre = $(this).getAttribute("value");
                  location.href="<%=reqeust.getContextPath()%>/semi/views/category/movieCategory.jsp?genre=" + selectedGenre;
               })
            }); --%>
            
            <%-- function goCategory(){
               var cCode = $(this).val();
               
               location.href="<%request.getContextPath();%>/semi/views/category/sCategory.se?genre="+cCode;
               console.log(cCode);
            } --%>
         </script>
         <li><a class="gnb__nav-evaluate" href="javascript:;">취향 분석</a></li>
      </ul>
      <div class="gnb__right-navs">
         <div class="gnb__my-name">
         <%if ( m == null ) { %>
            <a href="/semi/views/member/login.jsp">로그인</a> 
            <span class="glyphicon glyphicon-caret-down-f"></span> 
            <% } else { %>
            <div class="gnb__my-name">
            <span><%= m.getUserId() %></span>
             <span class="glyphicon glyphicon-caret-down-f"></span>
            <span>
               <div class="gnb__account-menu-wrap">
                  <ul class="account-menu">
                     <li class="account-menu__item"><a class="" href="/semi/views/watches/watches.jsp">본
                           리뷰</a></li>
                     <li class="account-menu__item"><a class="" href="/semi/views/member/setting.jsp">설정</a>
                     </li>
                     <li class="account-menu__item"><a class="" onclick="logout()">로그아웃</a></li>
                  </ul>
               </div>
            </span>
            <% } %>
         </div>
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
         
      
   </nav>
</div>

<script>
	function logout(){
		location.href="/semi/logout.me";
	}
</script>