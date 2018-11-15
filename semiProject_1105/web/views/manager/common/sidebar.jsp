<%@
	page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%>
<%
	String path = "\\semi\\views\\manager\\";
%>
<aside>
	<div class="sidebar">
		<div class="menu">
			관리자 메뉴
		</div>
		<div class="accordion vertical">
		    <ul>
		    	<li>
		    		<label for=""><a href="<%=path %>mIndex.jsp">관리자 메인</a></label>
		    	</li>
		    	<li>
		    		<label for=""><a href="<%=path %>userList.jsp">회원 목록</a></label>
		    	</li>
		        <li>
		            <input type="checkbox" id="checkbox-1" name="checkbox-accordion" />
		            <label for="checkbox-1">영화 관리</label>
		            <div class="content">
		                <a href="<%=path%>addMovie.jsp">영화 추가하기</a>
		            </div>
		            <div class="content">
		                <a href="<%=path%>modifyDeleteMovie.jsp">영화 수정 및 삭제</a>
		            </div>
		        </li>
		        <li>
		            <input type="checkbox" id="checkbox-2" name="checkbox-accordion" />
		            <label for="checkbox-2">리뷰어 관리</label>
		            <div class="content">
		                <a href="<%=path%>addReviewer.jsp">리뷰어 추가하기</a>
		            </div>
		            <div class="content">
		                <a href="<%=path%>modifyDeleteReviewer.jsp">리뷰어 수정 및 삭제</a>
		            </div>
		        </li>
		        <li>
		            <input type="checkbox" id="checkbox-3" name="checkbox-accordion" />
		            <label for="checkbox-3">리뷰 관리</label>
		            <div class="content">
		                <a href="/semi/rvrSelectAll.rv?opt=add">리뷰 추가하기</a>
		            </div>
		            <div class="content">
		                <a href="/semi/rvrSelectAll.rv?opt=del">리뷰 수정 및 삭제</a>
		            </div>
		        </li>
		    </ul>
		</div>
	</div>
</aside>
<!-- <link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css"> -->
<link rel="stylesheet" href="/semi/resources/css/manager/sidebar.css">
<link rel="stylesheet" href="/semi/resources/css/style.css">