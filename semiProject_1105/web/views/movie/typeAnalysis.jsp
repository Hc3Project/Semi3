<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script	src="<%=request.getContextPath()%>/resources/js/jquery-3.3.1.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
<script	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<%-- <script src="<%=request.getContextPath()%>/resources/js/reviewList.js"></script> --%>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">


<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/typeAnalysis.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
<title>취향 분석</title>
<%
	String likes = (String) session.getAttribute("likes");
	String scoreCnt = (String) ((session.getAttribute("scoreCnt")!="null")?session.getAttribute("scoreCnt"):"");
%>
</head>
<body>
	<header>
		<%@ include file="../common/header.jsp"%>
	</header>
	<!--header-->
	
	<%if(m!=null){%>
		<div style="text-align:center;width:1000px;margin:0 auto;" id="position">
	        <section>
	            <div>
	                <h5 style="float:left;">별점 분포</h4>
	                <input type="hidden" id="scoreCnt" value="<%=scoreCnt%>">
	            </div>
	            <!-- <h5 class="pink">취향이 뚜렷한 소나무형</h5> -->
	            <h5 class="pink"></h5>
	            <br>
	            <div class="stickChart">
	                <!-- 차트 넣는 곳-->
         			<!-- 차트 변경해야됨 -->
	                <div id="scoreHist"></div>
	            </div>
	            
	         
	            <br>
	            <div class="starWarp">
	                <div>
	                    <div style="font-weight:bold;">5</div>
	                    <div class="under_note">별점 평균</div>
	                </div>
	                <div>
	                    <div style="font-weight:bold;">100개</div>
	                    <div class="under_note">평가 횟수</div>
	                </div>
	                <div>
	                    <div style="font-weight:bold;">5</div>
	                    <div class="under_note">최고 별점</div>
	                </div>
	            </div>
	        </section>
	        <section>
	            <div>
	                <h5 style="float:left;">영화 선호 장르</h4>
	            </div>
	            <br><br>
	            <div class="starWarp" id="gDiv"></div>
	        </section>
	        <div style="margin:20px 0;width:100%;height:1px;background-color:#dedede"></div>
	        <section>
	            <div>
	                <h5 style="float:left;">좋아하는 리뷰어</h4>
	                <input type="hidden" id="likesRiviewer" value="<%=likes%>">
	            </div>
	            <br><br>
	           <div style="margin-top:12px;" id="rvrList">
	            </div>
	        </section>  
	        <!-- <div class="btn" onclick="more()">더 보기</div> -->
	        
	            <br><br>
	        
	        <br><br>
	    </div>
	<%} else{
		String path = "/views/common/errorPage.jsp";
		request.setAttribute("exception", new Exception("로그인을 해야 이용가능합니다."));
		request.getRequestDispatcher(path).forward(request, response);
	} %>
</body>
<script src="<%=request.getContextPath()%>/resources/js/typeAnalysis.js"></script>
<script src="https://d3js.org/d3.v5.min.js"></script>
<script src="/semi/resources/js/manager/billboard.min.js"></script>
<link rel="stylesheet" href="/semi/resources/css/manager/billboard.css">
</html>