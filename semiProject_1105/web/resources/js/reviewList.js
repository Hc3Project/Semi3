$(function() {
	// st2Carousel 대상 div 지정
	var $todayDiv = $("#st2Carousel .carousel-inner");
	var todayItemA = "#st2Carousel div[class='item active rec-list clearfix']";
	var todayItem = "#st2Carousel div[class='item rec-list clearfix']:last-child";
	var todaySql = "todayList";
	
	var $top20Div = $("#st3Carousel .carousel-inner");
	var top20ItemA = "#st3Carousel div[class='item active rec-list clearfix']";
	var top20Item = "#st3Carousel div[class='item rec-list clearfix']:last-child";
	var top20Sql="topList";

	reviewList($todayDiv,todaySql,todayItemA,todayItem);
	reviewList($top20Div,top20Sql,top20ItemA,top20Item);
	

});

function reviewList($topDiv,sql,itemDivA,itemDiv) {
	
	$.ajax({
		url : "/semi/rList.rv",
		data : {
			rsql:sql
		},
		success : function(data) {

			for ( var i in data) {
				$review = $("<div/>").attr("class", "col-md-2").append(
						$("<h1/>").text(data[i].Movie)).append(
						$("<img/>").attr(
								"src",
								"https://img.youtube.com/vi/"
										+ data[i].Videoid + "/"
										+ "mqdefault.jpg")

				).append(
						$("<i/>").attr("class",
								"hover-box hover-box--play")).append(
						$("<div/>").attr("class", "hover-box").append(
								$("<h2/>").text(data[i].Reviewer))).attr("value",data[i].Videoid);

				
				if (i > -1 && i < 6) {
					if (i == 0) {
						$topDiv.append($("<div>").attr("class",
								"item active rec-list clearfix")
								.append($review));
					}
					$(itemDivA).append($review);
				} else {
					if (i % 6 == 0) {
						$topDiv.append($("<div>").attr("class",
								"item rec-list clearfix").append(
								$review));
					}
					$(itemDiv).append($review);
				}
			}
			// 썸네일 마우스 오버
			$(".rec-list>div").hover(function() {

				$(this).children(".hover-box").stop().fadeIn();
				$(this).children("h1").stop().hide();
			}, function() {
				$(this).children(".hover-box").stop().fadeOut();
				$(this).children("h1").stop().fadeIn();
			});
			$(".rec-list> div").click(function() {
				console.log($(this).attr("value"));
				location.href = "/semi/dView.do?videoId="+$(this).attr("value");
				
			})
		},
		error : function(data) {
			console.log(data);
			console.log("실패");
		}
	});
}



//
$(function() {
	// st4Carousel 대상 div 지정
	if($('#logChk').val()!="true"){
		// 로그인 했을 때
		var $topDiv = $("#st4Carousel .carousel-inner");
		$.ajax({
			url : "/semi/recMovie.do",
			success : function(data) {
				console.log(data);
				for ( var i in data) {
				
					$list= $("<div>").attr("class", "col-md-2").attr("value",data[i].mCode)
                    .append(
                        $("<h3>").text(data[i].mTitle)
                    ).append(
                            $("<img>").attr("src",data[i].poster)
                    ).append(
                        $("<i>").attr("class","hover-box hover-box--play")
                    );
      
						if (i > -1 && i < 8) {
							if (i == 0) {
								$topDiv.append($("<div>").attr("class",
										"item active rec-list clearfix")
										.append($list));
							}
							$(
									"#st4Carousel div[class='item active rec-list clearfix']")
									.append($list);
						} else {
							if (i % 8 == 0) {
								$topDiv.append($("<div>").attr("class",
										"item rec-list clearfix").append(
												$list));
							}
							$(
									"#st4Carousel div[class='item rec-list clearfix']:last-child")
									.append($list);
						}
			        }
            $("#st4Carousel .col-md-2").css("background-size","contain");
            $("#st4Carousel .rec-list> div").click(function() {
				console.log($(this).attr("value"));
				location.href = "/semi/dView.do?mCode="+$(this).attr("value");
				
			})
			},
			error : function() {
				console.log("실패");
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
           
		           $topDiv.append($("<div>").attr("class","div_ajax_load_image").css({
		        	   
                  "width": "100%",
		        	   "height": "300px",
		        	   "background":"#191919"
		           }).append($("<img>").attr("src","resources/image/233F6D505786DA870A.gif").css({
		        	   "margin-top": top+"px",
                  "margin-left": left+"px",
		        	   "width": "50px",
		        	   "height": "50px"
		           })
		        ))

		    }
		    , complete: function (data) {
		    	$(".div_ajax_load_image").remove();	    			    	
		    }
		});
	} else {
		// 로그인 안했을때
	}
});