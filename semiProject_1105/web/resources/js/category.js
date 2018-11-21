$(function(){

	var gCode = $('.genre').val();
	var nCode = $('.nation').val();
	var rvrCode = $('.reviewer').val();
	var order = $(".order").val();
	
	switch (order) {
	case "avgScore":
		order="selectMovieBySelectBox_avgScore";
		break;
	case "update":
		order="selectMovieBySelectBox_update";
		break;
	case "showtime":
		order="selectMovieBySelectBox_showtime";
		break;

	}
	
	mPage=0;
	mflag = true;
	
		$('.select-menu').change(function(){
			$(".item").remove();
			console.log("gCode:"+gCode);
			console.log("nCode:"+nCode);
			console.log("rvrCode:"+rvrCode);
			mlist(gCode,nCode,rvrCode,order);
		});
		
		mlist(gCode,nCode,rvrCode,order);
		
		$(window).scroll(function() {
		    if ($(window).scrollTop() == $(document).height() - $(window).height()&&mflag==true) {
		    	mlist(gCode,nCode,rvrCode,order);
		    }});
	});

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
            var $top = $("#catecoryMovie")
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
                            $("#catecoryMovie div[class='item rec-list clearfix']:last-child").append($list);
                        }
			        }
            $(".col-md-2").css("background-size","contain");
            $(".rec-list> div").click(function() {
				console.log($(this).attr("value"));
				location.href = "/semi/dView.do?mCode="+$(this).attr("value");
				
			})
		}
	, beforeSend: function () {
		 mflag=false;
           var width = 0;
           var height = 0;
           var left = 0;
           var top = 0;

           width = 50;
           height = 50;


           top = ( 300 - height ) / 2 
           left = ( $(window).width() ) / 2 - width 

         /*   $("#div_ajax_load_image img").css({
             "margin-top": top+"px",
             "margin-left": left+"px"
      }); */

           console.log("ajax 로딩");
      
           $("#catecoryMovie").append($("<div>").attr("class","div_ajax_load_image").css({
        	   
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
    	if(data==null)mflag=false;
    	else mflag=true;
    }
			})
	
}