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
