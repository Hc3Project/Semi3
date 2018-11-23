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
<script src="<%=request.getContextPath()%>/resources/js/category.js"></script>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/main.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/category.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css">

<title>movie traveler</title>
</head>
<body>
	<header>
		<%@ include file="../common/header.jsp"%>
	</header>
	

	<!-- 셀렉트박스 옵션 가져오는 ajax -->

	<script>
	
	$(function() {
		var $addOption = $(".genre");
		var cSql= "selectCategoryGenreList";
		var cCode = "<%=cCode%>";
		addOptionList($addOption,cSql,cCode);
		
		$addOption = $(".nation");
		cSql= "selectCategoryNationList";
		addOptionList($addOption,cSql,cCode);
		
		$addOption = $(".reviewer");
		cSql= "selectCategoryReviewerList";
		addOptionList($addOption,cSql,cCode);
		if(cCode=="all")mlist($(".genre").val(),$(".nation").val(),$(".reviewer").val(),orderSql($(".order").val()));
		
		
	});
	
	function addOptionList($addOption,cSql,cCode){
		$.ajax({
				url : "/semi/cList.ca",
				data : {
					csql : cSql
				},
				success : function(data){
					
					for(var i in data){
						$option = $("<option>").attr("value",data[i].code).text(data[i].name)
						
						$addOption.append($option);
						
						if($option.val() == cCode){
							$option.attr("selected","selected");
							var a = $(".nation").val()
							console.log("asdasdsa1213213asd31asd   "+a);
							mlist($(".genre").val(),$(".nation").val(),$(".reviewer").val(),orderSql($(".order").val()));
						}	
					}	
			},
			error : function(data){
				console.log("실패실패")
			}
		});
		
	};
	
	// 장르 옵션
	$(function addOptionGenre(){
		var $addOption = $(".genre")
		
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
			<select class="order" id = "order">
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



</body>
</html>