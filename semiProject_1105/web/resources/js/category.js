$(function() {
	// st2Carousel 대상 div 지정
	var $topDiv = $("#st2Carousel .carousel-inner");
	$
			.ajax({
				url : "/semi/rToday.rv",
				success : function(data) {

					for ( var i in data) {
						$review = $("<div/>").attr("class", "col-md-2").append(
								$("<h1/>").text(data[i].Videoid)).append(
								$("<img/>").attr(
										"src",
										"https://img.youtube.com/vi/"
												+ data[i].Videoid + "/"
												+ "mqdefault.jpg")

						).append(
								$("<i/>").attr("class",
										"hover-box hover-box--play")).append(
								$("<div/>").attr("class", "hover-box").append(
										$("<h2/>").text("호버시 제목")).append(
										$("<p/>").text("호버시 텍스트"))).attr("value",data[i].Videoid);

						if (i > -1 && i < 6) {
							if (i == 0) {
								$topDiv.append($("<div>").attr("class",
										"item active rec-list clearfix")
										.append($review));
							}
							$(
									"#st2Carousel div[class='item active rec-list clearfix']")
									.append($review);
						} else {
							if (i % 6 == 0) {
								$topDiv.append($("<div>").attr("class",
										"item rec-list clearfix").append(
										$review));
							}
							$(
									"#st2Carousel div[class='item rec-list clearfix']:last-child")
									.append($review);
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
				error : function() {
					console.log("실패");
				}
			});

});