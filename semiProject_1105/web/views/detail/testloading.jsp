<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajax 로딩바 구현하기</title>
 
<script src="http://code.jquery.com/jquery-latest.min.js"></script><!-- 항상 최신버전의 JQuery를 사용가능하다. -->
 
</head>

<body>
 	<div id = "a0"></div>

 	<script type="text/javascript" language="javascript">
 $(function(){
	 $.ajax({
		 	url: "/semi/mVisit.do",
		 	async: false
		    , error: function (res) {
		    
		        console.log("ajax error - " + res);
		    }
		    , success: function (res) {
		           console.log("ajax success - " + res);
		    }
		    , beforeSend: function () {
		    	 
		           var width = 0;
		           var height = 0;
		           var left = 0;
		           var top = 0;

		           width = 50;
		           height = 50;


		           top = ( 300 - height ) / 2 
		           left = ( $(window).width() ) / 2 - width 

		         /*   $("#div_ajax_load_image img").css({
                       "margin-top": top+"px",
                       "margin-left": left+"px"
                }); */

		           console.log("ajax 로딩");
                
		           $("#a0").append($("<div>").attr("class","div_ajax_load_image").css({
		        	   
                       "width": "100%",
		        	   "height": "300px",
		        	   "background":"#191919"
		           }).append($("<img>").attr("src","233F6D505786DA870A.gif").css({
		        	   "margin-top": top+"px",
                       "margin-left": left+"px",
		        	   "width": "50px",
		        	   "height": "50px"
		           })
		        ))
		

		    }
		    , complete: function () {
		    	setTimeout(function(){  $("#a0").remove();}, 3000);
		    	
			  
		    }
		});
	 
 });
 
function loadTest(){
	
	
	
}
</script>
</body>
</html>