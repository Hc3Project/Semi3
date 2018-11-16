$(function () {
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
			$.ajax({
				url : "/semi/mVisit.do",
				type : "post",
					success : function(data) {
	                    var $top = $("#visitMovie")
							for ( var i in data) {
								console.log(data[i].mPage);
								$list= $("<div>").attr("class", "col-md-2").attr("style","background-image: url("+data[i].mPage+")")
		                        .append(
		                            $("<h3>").text(data[i].mTitle)
		                        ).append(
		                            $("<i>").attr("class","hover-box hover-box--play")
		                        );
		
			                        if(i%8==0){
			                            $top.append($("<div>").attr("class","item rec-list clearfix").append($list));
			                        }else{
			                            $("#visitMovie div[class='item rec-list clearfix']:last-child").append($list);
			                        }
						        }
	                    $(".col-md-2").css("background-size","contain");
					}
				
                });
		});