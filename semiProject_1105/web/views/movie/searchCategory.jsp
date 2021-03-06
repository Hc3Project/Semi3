<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.*,java.util.*, com.kh.semi.manager.video.model.vo.*"%>
<%@ page import="org.json.*"%>


<%
	ArrayList<MovieInfo> mList = (ArrayList<MovieInfo>) request.getAttribute("sList");
	System.out.println(mList.toString());
	String search = (String)request.getAttribute("search");
	System.out.println(search);
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

<title>movie traveler</title>
</head>
<body>
	<header style="height: 80px;">
		<%@ include file="../common/header.jsp"%>
	</header>
	<div style="width: 100%; margin: 50px 0px;">
	<h6 align="center">"<%=search %>"에 대한 검색 결과 입니다</h6>
	</div>
	

	<!-- 셀렉트 박스와 연동 -->
	<section class="movieSection">
		<div class="category-page" style="position: relative;">
			<div class="home-page__rec-list">
				<div class="rec-row poster" id="catecoryMovie">

					<!-- 내가 검색한 조건일 경우 -->

					<%
					
						for (int i = 0; i < Math.ceil((double)(mList.size()) / 8.0); i++) {
					%>

					<div class="item rec-list clearfix">
						<%
							for (int j = 0; j < mList.size(); j++) {
						%>
						<div class="col-md-2"value="<%=mList.get(j + (i * 8)).getmCode()%>">
							<h3><%=mList.get(j + (i * 8)).getmTitle()%></h3>
							<img src = "<%=mList.get(j + (i * 8)).getPoster()%>"/>
							<i class="hover-box hover-box--play"></i>
						</div>
						<%
							}
						%>
					</div>



					<%
						}
				
					%>
<script type="text/javascript">
$(function() {
	$(".rec-list> div").click(function() {
		console.log($(this).attr("value"));
		location.href = "/semi/dView.do?mCode="+$(this).attr("value");
		
	});
})
</script>
					
				</div>
			</div>
		</div>
		
	</section>


</body>
</html>