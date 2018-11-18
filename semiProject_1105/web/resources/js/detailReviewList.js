$(function() {
	// rlCarousel 대상 div 지정
	var $todayDivRl = $("#rlCarousel .carousel-inner");
	$.ajax({
				url : "/semi/rList.rv",
				data : {
					rsql : "movieReview",
					title : $("#mtitle").text()
				},
				success : function(data) {
					var count = 0;
					for ( var i in data) {
						$review = $("<div/>")
								.attr("class", "col-md-2 youtube")
								.attr("rel", data[i].Videoid)
								.append($("<h1/>").text(data[i].Movie))
								.append(
										$("<img/>").attr(
												"src",
												"https://img.youtube.com/vi/"
														+ data[i].Videoid + "/"
														+ "mqdefault.jpg")

								)
								.append(
										$("<i/>").attr("class",
												"hover-box hover-box--play"))
								.append(
										$("<div/>")
												.attr("class", "hover-box")
												.append(
														$("<h2/>")
																.text(
																		data[i].Reviewer)))
								.attr("value", data[i].Videoid);

						if (i > -1 && i < 6) {
							if (i == 0) {
								$todayDivRl.append($("<div>").attr("class",
										"item active rec-list clearfix")
										.append($review));
							}
							$(
									"#rlCarousel div[class='item active rec-list clearfix']")
									.append($review);
						} else {
							if (i % 6 == 0) {
								$todayDivRl.append($("<div>").attr("class",
										"item rec-list clearfix").append(
										$review));
							}
							$(
									"#rlCarousel div[class='item rec-list clearfix']:last-child")
									.append($review);
						}
						count = i;

					}
					// 영상이 6개 이하면 페이지 넘기는 버튼 hidden
					if (count < 5) {

						$("#rlCarousel .carousel-inner>a").attr("hidden",
								"hidden");
					}

					/*
					 * $("div.youtube").click(function() {
					 * console.log("실asdasd패");
					 *  })
					 */

				},
				error : function() {
					console.log("실패");
				}
			});


	// rnCarousel 대상 div 지정
	var $topDivRn = $("#rnCarousel .carousel-inner");
	$.ajax({
				url : "/semi/rList.rv",
				data : {
					rsql : "topList"
				},
				success : function(data) {
					count = 0;
					for ( var i in data) {
						$review = $("<div/>")
						.attr("class", "col-md-2 youtube")
						.attr("rel", data[i].Videoid)
						.append($("<h1/>").text(data[i].Movie))
						.append(
								$("<img/>").attr(
										"src",
										"https://img.youtube.com/vi/"
												+ data[i].Videoid + "/"
												+ "mqdefault.jpg")

						)
						.append(
								$("<i/>").attr("class",
										"hover-box hover-box--play"))
						.append(
								$("<div/>")
										.attr("class", "hover-box")
										.append(
												$("<h2/>")
														.text(
																data[i].Reviewer)))
						.attr("value", data[i].Videoid);

						if (i > -1 && i < 6) {
							if (i == 0) {
								$topDivRn.append($("<div>").attr("class",
										"item active rec-list clearfix")
										.append($review));
							}
							$(
									"#rnCarousel div[class='item active rec-list clearfix']")
									.append($review);
						} else {
							if (i % 6 == 0) {
								$topDivRn.append($("<div>").attr("class",
										"item rec-list clearfix").append(
										$review));
							}
							$(
									"#rnCarousel div[class='item rec-list clearfix']:last-child")
									.append($review);
						}
						count = i;

					}
					// 영상이 6개 이하면 페이지 넘기는 버튼 hidden
					if (count < 5) {

						$("#rnlCarousel .carousel-inner>a").attr("hidden",
								"hidden");
					}

				},
				error : function() {
					console.log("실패");
				}
			});


	// rrcCarousel 대상 div 지정
	var $topDivRr = $("#rrcCarousel .carousel-inner");
	$.ajax({
				url : "/semi/rList.rv",
				data : {
					rsql : "todayList"
				},
				success : function(data) {
					 count = 0;
					for ( var i in data) {
						$review = $("<div/>")
						.attr("class", "col-md-2 youtube")
						.attr("rel", data[i].Videoid)
						.append($("<h1/>").text(data[i].Movie))
						.append(
								$("<img/>").attr(
										"src",
										"https://img.youtube.com/vi/"
												+ data[i].Videoid + "/"
												+ "mqdefault.jpg")

						)
						.append(
								$("<i/>").attr("class",
										"hover-box hover-box--play"))
						.append(
								$("<div/>")
										.attr("class", "hover-box")
										.append(
												$("<h2/>")
														.text(
																data[i].Reviewer)))
						.attr("value", data[i].Videoid);

						if (i > -1 && i < 6) {
							if (i == 0) {
								$topDivRr.append($("<div>").attr("class",
										"item active rec-list clearfix")
										.append($review));
							}
							$(
									"#rrcCarousel div[class='item active rec-list clearfix']")
									.append($review);
						} else {
							if (i % 6 == 0) {
								$topDivRr.append($("<div>").attr("class",
										"item rec-list clearfix").append(
										$review));
							}
							$(
									"#rrcCarousel div[class='item rec-list clearfix']:last-child")
									.append($review);
						}
						count = i;
					}
					// 영상이 6개 이하면 페이지 넘기는 버튼 hidden
					if (count < 5) {

						$("#rrCarousel .carousel-inner>a").attr("hidden",
								"hidden");

					}
					$("div.youtube").click(function() {
						$.ajax({
							url:"rCount.rv",
							data:{
								videoId : $(this).attr("value")
							},success: function (data) {
								console.log($(this).attr("value"));
							}
						});
						
					});
				
					youtubePopup();
					// 썸네일 마우스 오버
					hoverThmbnail();
					
				},
				error : function() {
					console.log("실패");
				},complete: function(){
					
					
					$("div[class= 'ui-dialog-content ui-widget-content']").css("overflow","hidden");
				}
			});
	
	
	function hoverThmbnail() {
		$(".rec-list>div").hover(function() {

			$(this).children(".hover-box").stop().fadeIn();
			$(this).children("h1").stop().hide();
		}, function() {
			$(this).children(".hover-box").stop().fadeOut();
			$(this).children("h1").stop().fadeIn();
		});
	}
	
	function youtubePopup() {
		$("div.youtube").YouTubePopup({

			'youtubeId' : '',

			'title' : '',

			'idAttribute' : 'rel',

			'draggable' : false,

			'modal' : true,

			'width' : 1280,

			'height' : 720,

			'hideTitleBar' : true,

			'clickOutsideClose' : true,

			'overlayOpacity' : 0.7,

			'autohide' : 1,

			'autoplay' : 1,

			'color' : 'red ',

			'controls' : 1,

			'fullscreen' : 0,

			'loop' : 0,

			'hd' : 1,

			'showinfo' : 1,
			'showBorder' : false

		});
		
	};

});