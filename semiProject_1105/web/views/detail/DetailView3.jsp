<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	import="java.sql.Date, com.kh.semi.user.detail.model.vo.MovieInfo"
%>
<%
	String getPage=(String)request.getAttribute("page");
	MovieInfo mov=(MovieInfo)request.getAttribute("mov");
	String mtitle=mov.getMtitle();
	String director=mov.getDirector();
	String actor=mov.getActor();
	int showtime=mov.getShowtime();
	String opendate=String.valueOf(mov.getOpendate());
	String gname1=mov.getGname1();
	String gname2=mov.getGname2();
	String nname=mov.getNname();
	int counts=mov.getCounts();
	String synopsis=mov.getSynopsis();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>포오스터어어어!!!</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link href="/web/resources/css/gridstack.css" rel="stylesheet">
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/underscore.js/1.7.0/underscore-min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
<script src="/web/resources/js/gridstack.js"></script>
<style>
	body{
		background:black;
		color: white;
	}
	#imgFrameF{
		left: 0px; 
		position: absolute;
		top: 102px;
		width: 203px;
		height: 307px;
	}
	#imgFrameS{
		width: 203px;
		height: 307px;
	}
	#imgFrameT{
		position: relative;
		width: 203px;
		height: 307px;
	}
	#PosterImg{
		width: 203px;
		height: 307px;
		object-fit: contain;
	}
</style>
<style type="text/css" data-styleid="c1">
	.c1bg {
		border:0px solid rgba(184, 184, 184, 1);
		background-color:rgba(0.0.0,1);
		border-radius:0;  
	}
 	.c1inlineContent,.c1bg {
 		position:absolute;
 		top:0;
 		right:0;
 		bottom:0;
 		left:0;
 	}
 </style>
<style type="text/css" data-styleid="txtNew">
	.txtNew {
		word-wrap:break-word;
		text-align:start;
	}
	.txtNew_override-left * {
		text-align:left !important;
	}
	.txtNew_override-right * {
		text-align:right !important;
	}
	.txtNew_override-center * {
		text-align:center !important;
	}
	.txtNew_override-justify * {
		text-align:justify !important;
	}
	.txtNew > * {
		pointer-events:auto;
	}
	.txtNew li {
		font-style:inherit;
		font-weight:inherit;
		line-height:inherit;
		letter-spacing:normal;
	}
	.txtNew ol,.txtNew ul {
		padding-left:1.3em;
		padding-right:0;
		margin-left:0.5em;
		margin-right:0;
		line-height:normal;
		letter-spacing:normal;
	}
	.txtNew ul {
		list-style-type:disc;
	}
	.txtNew ol {
		list-style-type:decimal;
	}
	.txtNew ul ul,.txtNew ol ul {
		list-style-type:circle;
	}
	.txtNew ul ul ul,.txtNew ol ul ul {
		list-style-type:square;
	}
	.txtNew ul ol ul,.txtNew ol ol ul {
		list-style-type:square;
	}
	.txtNew ul[dir="rtl"],.txtNew ol[dir="rtl"] {
		padding-left:0;
		padding-right:1.3em;
		margin-left:0;
		margin-right:0.5em;
	}
	.txtNew ul[dir="rtl"] ul,.txtNew ul[dir="rtl"] ol,.txtNew ol[dir="rtl"] ul,.txtNew ol[dir="rtl"] ol {
		padding-left:0;
		padding-right:1.3em;
		margin-left:0;
		margin-right:0.5em;
	}
	.txtNew p {
		margin:0;
		line-height:normal;
		letter-spacing:normal;
	}
	.txtNew h1 {
		margin:0;
		line-height:normal;
		letter-spacing:normal;
	}
	.txtNew h2 {
		margin:0;
		line-height:normal;
		letter-spacing:normal;
	}
	.txtNew h3 {
		margin:0;
		line-height:normal;
		letter-spacing:normal;
	}
	.txtNew h4 {
		margin:0;
		line-height:normal;
		letter-spacing:normal;
	}
	.txtNew h5 {
		margin:0;
		line-height:normal;
		letter-spacing:normal;
	}
	.txtNew h6 {
		margin:0;
		line-height:normal;
		letter-spacing:normal;
	}
	.txtNew a {
		color:inherit;
	}
</style>
<style type="text/css" data-styleid="txtNew">
	.txtNew {
		word-wrap:break-word;
		text-align:start;
	}
	.txtNew_override-left * {
		text-align:left !important;
	}
	.txtNew_override-right * {
		text-align:right !important;
	}
	.txtNew_override-center * {
		text-align:center !important;
	}
	.txtNew_override-justify * {
		text-align:justify !important;
	}
	.txtNew > * {
		pointer-events:auto;
	}
	.txtNew li {
		font-style:inherit;
		font-weight:inherit;
		line-height:inherit;
		letter-spacing:normal;
	}
	.txtNew ol,.txtNew ul {
		padding-left:1.3em;
		padding-right:0;
		margin-left:0.5em;
		margin-right:0;
		line-height:normal;
		letter-spacing:normal;
	}
	.txtNew ul {
		list-style-type:disc;
	}
	.txtNew ol {
		list-style-type:decimal;
	}
	.txtNew ul ul,.txtNew ol ul {
		list-style-type:circle;
	}
	.txtNew ul ul ul,.txtNew ol ul ul {
		list-style-type:square;
	}
	.txtNew ul ol ul,.txtNew ol ol ul {
		list-style-type:square;
	}
	.txtNew ul[dir="rtl"],.txtNew ol[dir="rtl"] {
		padding-left:0;
		padding-right:1.3em;
		margin-left:0;
		margin-right:0.5em;
	}
	.txtNew ul[dir="rtl"] ul,.txtNew ul[dir="rtl"] ol,.txtNew ol[dir="rtl"] ul,.txtNew ol[dir="rtl"] ol {
		padding-left:0;
		padding-right:1.3em;
		margin-left:0;
		margin-right:0.5em;
	}
	.txtNew p {
		margin:0;
		line-height:normal;
		letter-spacing:normal;
	}
	.txtNew h1 {
		margin:0;
		line-height:normal;
		letter-spacing:normal;
	}
	.txtNew h2 {
		margin:0;
		line-height:normal;
		letter-spacing:normal;
	}
	.txtNew h3 {
		margin:0;
		line-height:normal;
		letter-spacing:normal;
	}
	.txtNew h4 {
		margin:0;
		line-height:normal;
		letter-spacing:normal;
	}
	.txtNew h5 {
		margin:0;
		line-height:normal;
		letter-spacing:normal;
	}
	.txtNew h6 {
		margin:0;
		line-height:normal;
		letter-spacing:normal;
	}
	.txtNew a {
		color:inherit;
	}
</style>
<style>
	#cff{
		left: 200px; 
		width: 779px; 
		position: absolute; 
		top: 102px; 
		height: 301px;
	}
	#cfs{
		left: 20px; 
		width: 360px; 
		position: absolute; 
		top: 15px; 
		height: 25px;
	}
	#cft{
		left: 30px; 
		width: 1000px; 
		position: absolute; 
		pointer-events: none; 
		top: 15px;
	}
	#pf{
		line-height:1.4em;
	}
	#ps{
		line-height:1.4em;
	}
	#pt{
		line-height:1.4em;
	}
	#pfo{
		line-height:1.4em;
	}
	#pfi{
		line-height:1.4em;
	}
	#spf{
		line-height:1.4em;
	}
	#sps{
		line-height:1.4em;
	}
	#spt{
		line-height:1.4em;
	}
	#spfo{
		line-height:1.4em;
	}
	#spfi{
		line-height:1.4em;
	}
</style>
</head>
<body>
	
	<div data-exact-height="306.02294792586054" data-content-padding-horizontal="0" data-content-padding-vertical="0" id="imgFrameF">
		<div id="imgFrameS">
			<div data-style="" id="imgFrameT">
				<img id="PosterImg" alt="" data-type="image" src="<%=getPage %>">
			</div>
		</div>
	</div>
	
	<div class="c2" id="cff">
		<div id="Cntnr1cbg" class="c2bg"></div>
		<div id="Cntnr1cinlineContent" class="c2inlineContent">
			<div class="c1" id="cfs">
				<div id="Cntnr1dbg" class="c1bg"></div>
				<div id="Cntnr1dinlineContent" class="c1inlineContent"></div>
			</div>
			<div data-packed="true" class="txtNew" id="cft">
				<h2 style="line-height:1.4em;" class="font_6"><span style="line-height:1.4em;"><b><%=mtitle %></b></span></h2>
			</div>
			<div data-packed="true" class="txtNew" id="WRchTxt2j" style="left: 30px; width: 680px; position: absolute; pointer-events: none; top: 55px;">
				<p class="font_8" id="pf"><span id="spf"><span class="color_17"><strong>감독: &nbsp;</strong></span><span class="color_8"><%=director %></span></span></p>
				<p class="font_8" id="ps"><span id="sps"><span class="color_17"><strong>배우: &nbsp;</strong></span><span class="color_8"><%=actor %></span></span></p>
				<p class="font_8" id="pt"><span id="spt"><span class="color_17"><strong>장르: &nbsp;</strong></span><span class="color_8"><%=gname1 %>, <%=gname2 %></span></span></p>
				<p class="font_8" id="pfo"><span id="spfo"><span class="color_17"><strong>개봉일: &nbsp;</strong></span><span class="color_8"><%=opendate %>, <%=nname %></span></span></p>
				<p class="font_8" id="pfi"><span id="spfi"><span class="color_17"><strong>상영시간: &nbsp;</strong></span><span class="color_8"><%=showtime %>분</span></span></p>

				<p class="font_8">&nbsp;</p>

				<p class="font_8"><span class="color_21"><%=synopsis %></span></p>

			</div>
		</div>
	</div>
</body>
</html>