var mPage=0;
var ePage =0;
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
				data:{page:mPage++},
				type : "post",
					success : function(data) {
	                    var $top = $("#visitMovie")
	                    console.log(data);
							for ( var i in data) {
								console.log(data[i].mCode);
								$list= $("<div>").attr("class", "col-md-2").attr("style","background-image: url("+data[i].mPage+")").attr("value",data[i].mCode)
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
	                    $(".rec-list> div").click(function() {
							console.log($(this).attr("value"));
							location.href = "/semi/dView.do?mCode="+$(this).attr("value");
							
						})
					}
			
				
                });
		});

$(window).scroll(function() {
    if ($(window).scrollTop() == $(document).height() - $(window).height()) {
    	$.ajax({
			url : "/semi/mVisit.do",
			data:{page:mPage++},
			type : "post",
				success : function(data) {
                    var $top = $("#visitMovie")
						for ( var i in data) {
							console.log(data[i].mCode);
							$list= $("<div>").attr("class", "col-md-2").attr("style","background-image: url("+data[i].mPage+")").attr("value",data[i].mCode)
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
                    $(".rec-list> div").click(function() {
						console.log($(this).attr("value"));
						location.href = "/semi/dView.do?mCode="+$(this).attr("value");
						
					})
				}
		
			
            });
      
    }
});
$(function() {
	$.ajax({
		url : "/semi/mEval.do",
		data:{page:ePage++},
		type : "post",
			success : function(data) {
                var $top = $("#evalMovie")
					for ( var i in data) {
						console.log(data[i].mCode);
						$list= $("<div>").attr("class", "col-md-2").attr("style","background-image: url("+data[i].mPage+")").attr("value",data[i].mCode)
                        .append(
                            $("<h3>").text(data[i].mTitle)
                        ).append(
                            $("<i>").attr("class","hover-box hover-box--play")
                        );

	                        if(i%8==0){
	                            $top.append($("<div>").attr("class","item rec-list clearfix").append($list));
	                        }else{
	                            $("#evalMovie div[class='item rec-list clearfix']:last-child").append($list);
	                        }
				        }
                $(".col-md-2").css("background-size","contain");
                $(".rec-list> div").click(function() {
					console.log($(this).attr("value"));
					location.href = "/semi/dView.do?mCode="+$(this).attr("value");
					
				})
			}
	
		
        });
});

$(window).scroll(function() {
if ($(window).scrollTop() == $(document).height() - $(window).height()) {
$.ajax({
	url : "/semi/mEval.do",
	data:{page:ePage++},
	type : "post",
		success : function(data) {
            var $top = $("#evalMovie")
				for ( var i in data) {
					console.log(data[i].mCode);
					$list= $("<div>").attr("class", "col-md-2").attr("style","background-image: url("+data[i].mPage+")").attr("value",data[i].mCode)
                    .append(
                        $("<h3>").text(data[i].mTitle)
                    ).append(
                        $("<i>").attr("class","hover-box hover-box--play")
                    );

                        if(i%8==0){
                            $top.append($("<div>").attr("class","item rec-list clearfix").append($list));
                        }else{
                            $("#evalMovie div[class='item rec-list clearfix']:last-child").append($list);
                        }
			        }
            $(".col-md-2").css("background-size","contain");
            $(".rec-list> div").click(function() {
				console.log($(this).attr("value"));
				location.href = "/semi/dView.do?mCode="+$(this).attr("value");
				
			})
		}

	
    });

}
});