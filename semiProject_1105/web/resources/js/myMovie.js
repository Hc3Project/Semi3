mPage = 0;
ePage = 0;
mflag = true;
efalg = true;

$(function() {
	$('.tabs .tab').click(function() {
		if ($(this).hasClass('signin')) {
			$('.tabs .tab').removeClass('active');
			$(this).addClass('active');
			$('.cont').hide();
			$('.signin-cont').show();
		}
		if ($(this).hasClass('signup')) {
			$('.tabs .tab').removeClass('active');
			$(this).addClass('active');
			$('.cont').hide();
			$('.signup-cont').show();
		}
	});

})

$(function() {

	visitMovie();
	evalMovie();
	$(window).scroll(
			function() {
				if ($(window).scrollTop() == $(document).height()
						- $(window).height()
						&& mflag == true) {
					visitMovie();
				}
				if ($(window).scrollTop() == $(document).height()
						- $(window).height()
						&& eflag == true) {
					evalMovie();
				}

			});
});

function visitMovie() {
	$
			.ajax({
				url : "/semi/mVisit.do",
				data : {
					page : mPage++
				},
				type : "post",
				success : function(data) {
					var $top = $("#visitMovie")
					for ( var i in data) {
						
						console.log(data[i].mCode);
						$list = $("<div>").attr("class", "col-md-2").attr(
								"value", data[i].mCode).append(
								$("<h3>").text(data[i].mTitle)).append(
								$("<img>").attr("src", data[i].poster)).append(
								$("<i>").attr("class",
										"hover-box hover-box--play"));

						if (i % 8 == 0) {
							$top.append($("<div>").attr("class",
									"item rec-list clearfix").append($list));
						} else {
							$(
									"#visitMovie div[class='item rec-list clearfix']:last-child")
									.append($list);
						}
					}
					$(".col-md-2").css("background-size", "contain");
					$(".rec-list> div").click(
							function() {
								console.log($(this).attr("value"));
								location.href = "/semi/dView.do?mCode="
										+ $(this).attr("value");

							})

				},
				beforeSend : function() {
					mflag = false;
					var width = 0;
					var height = 0;
					var left = 0;
					var top = 0;

					width = 50;
					height = 50;

					top = (300 - height) / 2
					left = ($(window).width()) / 2 - width

					/*
					 * $("#div_ajax_load_image img").css({ "margin-top":
					 * top+"px", "margin-left": left+"px" });
					 */

					console.log("ajax 로딩");

					$("#visitMovie")
							.append(
									$("<div>")
											.attr("class",
													"div_ajax_load_image")
											.css({

												"width" : "100%",
												"height" : "300px",
												"background" : "#191919"
											})
											.append(
													$("<img>")
															.attr("src",
																	"233F6D505786DA870A.gif")
															.css(
																	{
																		"margin-top" : top
																				+ "px",
																		"margin-left" : left
																				+ "px",
																		"width" : "50px",
																		"height" : "50px"
																	})))

				},
				complete : function(data) {
					$("#visitMovie .div_ajax_load_image").remove();
					if (data === null)
						mflag = false;
					else
						mflag = true;

				}

			});

}

function evalMovie() {
	$
			.ajax({
				url : "/semi/mEval.do",
				data : {
					page : ePage++
				},
				type : "post",
				success : function(data) {
					var $top = $("#evalMovie")
					for ( var i in data) {
						console.log(data[i].mCode);
						$list = $("<div>").attr("class", "col-md-2").attr(
								"value", data[i].mCode).append(
								$("<h3>").text(data[i].mTitle)).append(
								$("<img>").attr("src", data[i].poster)).append(
								$("<i>").attr("class",
										"hover-box hover-box--play"));

						if (i % 8 == 0) {
							$top.append($("<div>").attr("class",
									"item rec-list clearfix").append($list));
						} else {
							$(
									"#evalMovie div[class='item rec-list clearfix']:last-child")
									.append($list);
						}
					}
					$(".col-md-2").css("background-size", "contain");
					$("#evalMovie .rec-list> div").click(
							function() {
								console.log($(this).attr("value"));
								location.href = "/semi/dView.do?mCode="
										+ $(this).attr("value");

							})
				},
				beforeSend : function() {
					eflag = false;
					var width = 0;
					var height = 0;
					var left = 0;
					var top = 0;

					width = 50;
					height = 50;

					top = (300 - height) / 2
					left = ($(window).width()) / 2 - width

					/*
					 * $("#div_ajax_load_image img").css({ "margin-top":
					 * top+"px", "margin-left": left+"px" });
					 */

					console.log("ajax 로딩");

					$("#evalMovie")
							.append(
									$("<div>")
											.attr("class",
													"div_ajax_load_image")
											.css({

												"width" : "100%",
												"height" : "300px",
												"background" : "#191919"
											})
											.append(
													$("<img>")
															.attr("src",
																	"233F6D505786DA870A.gif")
															.css(
																	{
																		"margin-top" : top
																				+ "px",
																		"margin-left" : left
																				+ "px",
																		"width" : "50px",
																		"height" : "50px"
																	})))

				},
				complete : function(data) {
					$("#evalMovie .div_ajax_load_image").remove();
					if (data === null)
						eflag = false;
					else
						eflag = true;

				}

			});
}
