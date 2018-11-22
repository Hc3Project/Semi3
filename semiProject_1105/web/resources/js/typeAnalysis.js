$(function(){
	var script = document.createElement("script");
	script.src = "http://apis.google.com/js/client.js?onload=init";
	document.getElementsByTagName("body")[0].appendChild(script);
	
	var scoreStr = $('#scoreCnt').val().replace(/\[|\]|\s/g,"").trim();
	if(scoreStr!=""){
		var scoreArr = scoreStr.split(",");
		var forChart = scoreStr.split(",");
		forChart.unshift("평가수");

		var chart = bb.generate({
			  data: {
				  columns: [
					  forChart
				  ],
				  type: "area-step",
				  colors : {
					  "평가수": "#ea4c88"
				  }
			  },
			  axis: {
			    x: {
			      type: "category",
			      categories: [
			    	"☆",
			        "★",
			        "★☆",
			        "★★",
			        "★★☆",
			        "★★★",
			        "★★★☆",
			        "★★★★",
			        "★★★★☆",
			        "★★★★★"
			      ]
			    }
			  },
			  bindto: "#scoreHist"
			});
		var sumScore = 0;
		var sumCnt = 0;
		var max = 0;
		for(var i=0; i<scoreArr.length; i++){
			if(scoreArr[i]>0) max = (i+1)/2;
			sumScore += parseInt(scoreArr[i])*(i+1)/2;
			sumCnt += parseInt(scoreArr[i]);
		}
		
		// 평점 평균
		$('#position').find('div[class="starWarp"]').eq(0).find('div').eq(1).text((sumScore/sumCnt).toFixed(2))
		// 평점 수
		$('#position').find('div[class="starWarp"]').eq(0).find('div').eq(4).text(sumCnt);
		// 최고 평점
		$('#position').find('div[class="starWarp"]').eq(0).find('div').eq(7).text(max)
	} else {
		// 평점 배열이 출력이 안됬을 때
	}
	
	// 영화 선호 장르
	$.ajax({
		url : "/semi/gStat.me",
		type : "post",
		data : {},
		success : function(data){
			var result = $.parseJSON(data);
			$g3Div = $('#gDiv');
			$gOutDiv = $('#gDivU');
			$g3Div.html('');
			$gOutDiv.html('');
			
			if(result.length!=0){
				for(var i=0; i<result.length; i++){
					if(i<3){
						$inDiv = $('<div>');
						$tDiv = $('<div>').attr({
							'style' : 'font-weight:bold;'
						}).text(result[i].name);
						$sDiv = $('<div>').attr({
							'style' : 'under_note'
						}).text(result[i].mean*10 + "점·" + result[i].cnt + "편");
						$inDiv.append($tDiv);
						$inDiv.append($sDiv);
						
						$g3Div.append($inDiv);
					} else if(i<6) {
						$iDiv = $('<div>').attr({
							'style' : 'height:13px;margin-top:9px;'
						})
						$tSpan = $('<span>').attr({
							'class' : 'under_note',
							'style' : 'float:left'
						}).text(result[i].name);
						$sSpan = $('<span>').attr({
							'class' : 'under_note',
							'style' : 'float:right'
						}).text(result[i].mean*20 + "점·" + result[i].cnt + "편");
						
						$iDiv.append($tSpan);
						$iDiv.append($sSpan);
						
						$gOutDiv.append($iDiv);
					} else {
						break;
					}
				}
			} else {
				$g3Div.text('현재 평가를 한 작품이 존재하지 않습니다.')
			}
		},
		error : function(data){
			console.log(data);
		}
	})
})

function init() {
	gapi.client.setApiKey(getKey()); // youtube api key value
	// gapi.client.ladt("nameOfApi", "Version", callback)
	gapi.client.load("youtube", "v3", function(){
	// yt api is ready
		var likesStr = $('#likesRiviewer').val().replace(/\[|\]|\s/g,"").trim();
		$('#rvrList').html('');
		// 좋아하는 리뷰어 띄워주기
		if(likesStr!=""){
			var likesArr = likesStr.split(",");
			$.each(likesArr, function(idx, item){
				var request = gapi.client.youtube.search.list({
					part : "snippet",
					channelId : item,
					type : "channel"
				})
				
				request.execute(function(data){
					var result = data.items[0];
					var channelTitle = result.snippet.channelTitle;
					var thumbnail = result.snippet.thumbnails.default.url;
					$rvrDiv = $('<div>').attr({
						'class' : 'height:50px'
					});
					$inImg = $('<img>').attr({
						'class' : 'circle',
						'style' : 'float:left;width:50px',
						'src' : thumbnail
					})
					$inDiv = $('<div>').attr({
						'style' : 'margin:6px 0 0 10px;display:inline-block;float:left;text-align:left;'
					})
					$inRvrName = $('<div>').attr({
						'class' :'font-weight:bold;font-size:17px;'
					}).text(channelTitle);
					$inDiv.append($inRvrName);
					
					$line = $('<div>').attr({
						'style' : 'clear:both;margin:10px 0;width:100%;height:1px;background-color:#dedede'
					})
					
					$rvrDiv.append($inImg);
					$rvrDiv.append($inDiv);
					
					$('#rvrList').append($rvrDiv);
					$('#rvrList').append($line);
				})
			})
		} else {
			$('#rvrList').text('회원님께선 현재 구독을 한 리뷰어가 없습니다.')
			$div = $('<div>').attr({
				'style' : 'margin:20px 0;width:100%;height:1px;background-color:#dedede'
			})
			$('#rvrList').append($div);
		}
		
	});
}

function getKey(){
	return "AIzaSyCQQm1VyQpzoPp4euLPT1RRNqraSmY12tc";
}