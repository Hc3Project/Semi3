$(function() {
	// st4Carousel 대상 div 지정
	if($('#logChk').val()=="true"){
		// 로그인 했을 때
		var $topDiv = $("#st4Carousel .carousel-inner");
		$.ajax({
			url : "/semi/recMovie.do",
			success : function(data) {
				console.log(data);
				for (var i in data) {

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
				$h = $('<h6>').attr({
					align : 'center',
					style : 'margin-top:3%;'
				}).text('평점 항목이 적거나 사용자와 비슷한 성향의 다른 사용자가 없습니다.')
				$topDiv.html('').append($h);
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