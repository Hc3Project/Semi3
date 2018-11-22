
$(function(){
	
	var gCode = $('.genre').val();
	var nCode = $('.nation').val();
	var rvrCode = $('.reviewer').val();
	var order = orderSql( $(".order").val());
	console.log("gCode1:"+gCode);
	console.log("nCode1:"+nCode);
	console.log("rvrCode1:"+rvrCode);
	
	mPage=0;
	mflag = true;
	error = true;
		$('.button').click(function(){
			mPage=0;
			$(".item").remove();
			 gCode = $('.genre').val();
			 nCode = $('.nation').val();
			 rvrCode = $('.reviewer').val();
			 order = orderSql( $(".order").val());
			 
			console.log("gCode2:"+gCode);
			console.log("nCode2:"+nCode);
			console.log("rvrCode2:"+rvrCode);
			
		
			mlist(gCode,nCode,rvrCode,order);
		});
	
		
		//mlist(gCode,nCode,rvrCode,order);
		
		$(window).scroll(function() {
		    if ($(window).scrollTop() == $(document).height() - $(window).height()&&mflag==true) {
		    	if(error==true)
		    		mlist(gCode,nCode,rvrCode,order);
		    }
		 });
});
function orderSql(order) {
	var sql 
	switch (order) {
	case "avgScore":
		sql="selectMovieBySelectBox_avgScore";
		break;
	case "update":
		sql="selectMovieBySelectBox_update";
		break;
	case "showtime":
		sql="selectMovieBySelectBox_showtime";
		break;

	}
	console.log(sql);
	return sql
}


function mlist(gCode,nCode,rvrCode,order) {
	$.ajax({
		url : "/semi/csBox.ca",
		
		data : {
			msql : order,
			gCode : gCode,
			nCode : nCode,
			rvrCode : rvrCode,
			page:mPage++
		},
		success : function(data) {
			console.log("success");
            var $top = $("#catecoryMovie")
            console.log(data);
				for ( var i in data) {
					console.log(data[i].mCode);
					$list= $("<div>").attr("class", "col-md-2").attr("value",data[i].mCode)
                    .append(
                        $("<h3>").text(data[i].mTitle)
                    ).append(
                            $("<img>").attr("src",data[i].poster)
                    ).append(
                        $("<i>").attr("class","hover-box hover-box--play")
                    );

                        if(i%8==0){
                            $top.append($("<div>").attr("class","item rec-list clearfix").append($list));

                        }else{
                            $("#catecoryMovie div[class='item rec-list clearfix']:last-child").append($list);

                        }
			        }
            $(".col-md-2").css("background-size","contain");
            $(".rec-list> div").click(function() {
				console.log($(this).attr("value"));
				location.href = "/semi/dView.do?mCode="+$(this).attr("value");
				
			});
		}
	, beforeSend: function () {
		console.log("start");
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
		 * $("#div_ajax_load_image img").css({ "margin-top": top+"px",
		 * "margin-left": left+"px" });
		 */
        console.log("ajax 로딩");
        if(error==true){
        $("#catecoryMovie").append($("<div>")
            .attr("class", "div_ajax_load_image")
            .css({"width": "100%", "height": "300px", "background": "#191919"})
            .append($("<img>").attr("src", "resources/image/233F6D505786DA870A.gif").css({
            "margin-top": top + "px",
            "margin-left": left + "px",
            "width": "50px",
            "height": "50px"
        })));}
        $('.button').attr('disabled', true);
    },error:function(){
    	console.log("false");
    	error=false;
    } 
    , complete: function (data) {
    	$(".div_ajax_load_image").remove();
    	if(data===null)mflag=false;
    	else mflag=true;
    	
    	$('.button').attr('disabled',false);
    }
	});
	
}
