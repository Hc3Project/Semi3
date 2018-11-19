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
	String estMovie = (String) ((session.getAttribute("estMovie")!="null")?session.getAttribute("estMovie"):"");
	String estTitle = (String) ((session.getAttribute("estTitle")!="null")?session.getAttribute("estTitle"):"");
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
	                <h5 style="float:left;">좋아하는 리뷰어</h4>
	                <input type="hidden" id="likesRiviewer" value="<%=likes%>">
	            </div>
	            <br><br>
	            <div style="margin-top:12px;" id="rvrList">
	                <div style="height:50px">
	                    <img class="circle" src="" style="float:left;width:50px">
	                    <div style="margin:6px 0 0 10px;display:inline-block;float:left;text-align:left;">
	                        <div style="font-weight:bold;font-size:17px;">라이너의 컬쳐쇼크</div>
	                    </div>
	                    
	                </div>
	                <div style="clear:both;margin:10px 0;width:100%;height:1px;background-color:#dedede"></div>
	                <div style="height:50px">
	                    <img class="circle" src="" style="float:left;width:50px">
	                    <div style="margin:6px 0 0 10px;display:inline-block;float:left;text-align:left;">
	                        <div style="font-weight:bold;font-size:17px;">달빛 뮤즈</div>
	                    </div>
	                </div>
	                <div style="clear:both;margin:10px 0;width:100%;height:1px;background-color:#dedede"></div>
	                <div style="height:50px">
	                    <img class="circle" src="" style="float:left;width:50px">
	                    <div style="margin:6px 0 0 10px;display:inline-block;float:left;text-align:left;">
	                        <div style="font-weight:bold;font-size:17px;">필빠</div>
	                    </div>
	                </div>
	                <div style="clear:both;margin:10px 0;width:100%;height:1px;background-color:#dedede"></div>
	                <div style="height:50px">
	                    <img class="circle" src="" style="float:left;width:50px">
	                    <div style="margin:6px 0 0 10px;display:inline-block;float:left;text-align:left;">
	                        <div style="font-weight:bold;font-size:17px;">시선 플레이</div>
	                    </div>
	                </div>
	            </div>
	        </section>  
	        
	        <section>
	            <div>
	                <h5 style="float:left;">영화 선호 장르</h4>
	            </div>
	            <br><br>
	            <div class="starWarp">
	                <div>
	                    <div style="font-weight:bold;">가족</div>
	                    <div class="under_note">96점·9편</div>
	                </div>
	                <div>
	                    <div style="font-weight:bold;">드라마</div>
	                    <div class="under_note">90점15편</div>
	                </div>
	                <div>
	                    <div style="font-weight:bold;">코미디</div>
	                    <div class="under_note">90점·12편</div>
	                </div>
	            </div>
	            <div class="moreMovie" style="width:700px;margin:0 auto;min-height:20px;">
	                <div style="height:13px;margin-top:9px;">
	                    <span class="under_note" style="float:left">로맨스</span>
	                    <span class="under_note" style="float:right">89점·11편</span>
	                </div>
	                <div style="height:13px;margin-top:9px;">
	                    <span class="under_note" style="float:left">판타지</span>
	                    <span class="under_note" style="float:right">89점·9편</span>
	                </div>
	                <div style="height:13px;margin-top:9px;">
	                    <span class="under_note" style="float:left">애니메이션</span>
	                    <span class="under_note" style="float:right">84점·8편</span>
	                </div>
	                <div style="height:13px;margin-top:9px;" class="more1">
	                    <span class="under_note" style="float:left">모험</span>
	                    <span class="under_note" style="float:right">96점·7편</span>
	                </div>
	                <div style="height:13px;margin-top:9px;clear:both;" class="more2">
	                    <span class="under_note" style="float:left">액션</span>
	                    <span class="under_note" style="float:right">56점·3편</span>
	                </div>
	                <div style="height:13px;margin-top:9px;clear:both;" class="more3">
	                    <span class="under_note" style="float:left">SF</span>
	                    <span class="under_note" style="float:right">88점·5편</span>
	                </div>
	                <div style="height:13px;margin-top:9px;clear:both;" class="more4">
	                    <span class="under_note" style="float:left">음악</span>
	                    <span class="under_note" style="float:right">79점·4편</span>
	                </div>
	            </div>
	        </section>
	        <div class="btn" onclick="more()">더 보기</div>
	            <br><br>
	        <section>
	            <div>
	                <h5 style="float:left;"><font style="color:darkred"><%=m.getUserId()%></font>님! 이러한 영화는 어떠세요?</h5>
	                <input type="hidden" id="estMovie" value="<%=estMovie%>">
	                <input type="hidden" id="estTitle" value="<%=estTitle%>">
	            </div>
	            <br><br><br>
	            <div class="carousel slide" data-ride="carousel" id="st2Carousel" data-interval="30000">
							<div class="carousel-inner ">
								<a class="carousel-control-prev" href="#st2Carousel"
									role="button" data-slide="prev"> <span
									class="carousel-control-prev-icon" aria-hidden="true"></span> <span
									class="sr-only">Previous</span>
								</a> <a class="carousel-control-next" href="#st2Carousel"
									role="button" data-slide="next"> <span
									class="carousel-control-next-icon" aria-hidden="true"></span> <span
									class="sr-only">Next</span>
								</a>
							</div>
						</div>
	        </section>
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