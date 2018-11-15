$(function() {
	// rlCarousel 대상 div 지정
	var $todayDiv = $("#rlCarousel .carousel-inner");
	$
			.ajax({
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
								$todayDiv.append($("<div>").attr("class",
										"item active rec-list clearfix")
										.append($review));
							}
							$(
									"#rlCarousel div[class='item active rec-list clearfix']")
									.append($review);
						} else {
							if (i % 6 == 0) {
								$todayDiv.append($("<div>").attr("class",
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

});
$(function() {
	// rnCarousel 대상 div 지정
	var $topDiv = $("#rnCarousel .carousel-inner");
	$
			.ajax({
				url : "/semi/rList.rv",
				data : {
					rsql : "topList"
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
								$topDiv.append($("<div>").attr("class",
										"item active rec-list clearfix")
										.append($review));
							}
							$(
									"#rnCarousel div[class='item active rec-list clearfix']")
									.append($review);
						} else {
							if (i % 6 == 0) {
								$topDiv.append($("<div>").attr("class",
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

						$("#rlCarousel .carousel-inner>a").attr("hidden",
								"hidden");
					}

				},
				error : function() {
					console.log("실패");
				}
			});

});

//
$(function() {
	// rrcCarousel 대상 div 지정
	var $topDiv = $("#rrcCarousel .carousel-inner");
	$
			.ajax({
				url : "/semi/rList.rv",
				data : {
					rsql : "todayList"
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
								$topDiv.append($("<div>").attr("class",
										"item active rec-list clearfix")
										.append($review));
							}
							$(
									"#rrcCarousel div[class='item active rec-list clearfix']")
									.append($review);
						} else {
							if (i % 6 == 0) {
								$topDiv.append($("<div>").attr("class",
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

						$("#rlCarousel .carousel-inner>a").attr("hidden",
								"hidden");

					}

					// 썸네일 마우스 오버
					$(".rec-list>div").hover(function() {

						$(this).children(".hover-box").stop().fadeIn();
						$(this).children("h1").stop().hide();
					}, function() {
						$(this).children(".hover-box").stop().fadeOut();
						$(this).children("h1").stop().fadeIn();
					});
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
				},
				error : function() {
					console.log("실패");
				}
			});

});