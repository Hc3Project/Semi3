<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.kh.semi.manager.video.model.vo.*"%>
<%@ page import="org.json.*"%>


<%

	ArrayList<MovieInfo> mList = (ArrayList<MovieInfo>) request.getAttribute("mList");
	
	String cCode = request.getParameter("cCode");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="<%=request.getContextPath()%>/resources/js/jquery-3.3.1.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/main.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/category.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css">

<title>모든 장르</title>
</head>
<body>
	<header>
		<%@ include file="../common/header.jsp"%>
	</header>
	

	<!-- 셀렉트박스 옵션 가져오는 ajax -->

	<script>
	
	// 장르 옵션
	$(function addOptionGenre(){
		
		
		console.log("<%=cCode%>");
		var $addOption = $(".genre")
		$
			.ajax({
					url : "/semi/cList.ca",
					data : {
						csql : "selectCategoryGenreList"
					},
					success : function(data){
						
						for(var i in data){
							$genreOption = $("<option>").attr("value",data[i].code).text(data[i].name)
							
							$addOption.append($genreOption);
							

							if($genreOption.val() == "<%=cCode%>"){
								$genreOption.attr("selected","selected");
							}
							
						}
						
				},
				error : function(data){
					console.log(data);
					console.log("실패실패")
				}
			});
	});
	
	// 나라 옵션
	$(function addOptionNation(){
		
		var $addOption = $(".nation")
		$
			.ajax({
					url : "/semi/cList.ca",
					data : {
						csql : "selectCategoryNationList"
					},
					success : function(data){
						
						for(var i in data){
							$nationOption = $("<option>").attr("value",data[i].code).text(data[i].name)
							
							$addOption.append($nationOption);
							
							if($nationOption.val() == "<%=cCode%>"){
								$nationOption.attr("selected","selected");
							}
							
							
						}
				},
				error : function(data){
					console.log(data);
					console.log("실패실패")
				}
			});
	});
	
	// 리뷰어 옵션
	$(function addOptionReviewer(){
		
		var $addOption = $(".reviewer")
		$
			.ajax({
					url : "/semi/cList.ca",
					data : {
						csql : "selectCategoryReviewerList"
					},
					success : function(data){
						
						for(var i in data){
							$reviewerOption = $("<option>").attr("value",data[i].code).text(data[i].name)
							
							
							$addOption.append($reviewerOption);
							
							if($reviewerOption.val() == "<%=cCode%>") {
							$reviewerOption.attr("selected", "selected");
						}
					}
				},
				error : function(data) {
					console.log(data);
					console.log("실패실패")
				}
			});
		});
	</script>


	<!-- 검색결과 -->
	<!-- 셀렉트 박스와 연동 -->
	<section class="movieSection">
	<div class="select-menu">
		<div class="select-genre">
			<select class="genre select" id="genre">
				<option value="all" id="all">모든 장르</option>
			</select>
		</div>


		<div class="select-nation">
			<select class="nation select" id="nation">
				<option value="all" id="all" selected="selected">모든 국가</option>
			</select>
		</div>

		<div class="select-reviewer">
			<select class="reviewer select" id="reviewer">
				<option value="all" id="all" selected="selected">모든 리뷰어</option>
			</select>
		</div>


		<div class="select-order">
			<select class="order">
				<option value="avgScore">평균별점 순</option>
				<option value="update">최신작품 순</option>
				<option value="showtime">러닝타임 짧은 순</option>
			</select>
		</div>

		<div class="searchBtn">
			<button type="button" class="button" value="search">검색
			</button>
		</div>
	</div>
	
		<div class="category-page" >
			<div class="home-page__rec-list">
				<div class="rec-row poster" id="catecoryMovie">
					
				</div>
			</div>
		</div>
		
	</section>


	<%-- 	<!-- 검색결과 -->
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
	</div> --%>
<script src="<%=request.getContextPath()%>/resources/js/category.js"></script>
</body>
</html>