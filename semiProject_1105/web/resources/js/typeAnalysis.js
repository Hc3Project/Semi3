$(function(){
	var script = document.createElement("script");
	script.src = "http://apis.google.com/js/client.js?onload=init";
	document.getElementsByTagName("body")[0].appendChild(script);
	
	var scoreStr = $('#scoreCnt').val().replace(/\[|\]|\s/g,"").trim();
	if(scoreStr!=""){
		var scoreArr = scoreStr.split(",");
		var forChart = scoreStr.split(",");
		forChart.unshift("0");
		forChart.unshift("평가수");
		forChart.push("0");
		
		var chart = bb.generate({
			  data: {
			    columns: [
			    	forChart
			    ],
			    types: {
			      '평가수' : "area-step"
			    }
			  },
			  bindto: "#scoreHist"
			});
		var sumScore = 0;
		var sumCnt = 0;
		var max = 0;
		for(var i=0; i<scoreArr.length; i++){
			if(scoreArr[i]>0) max = i+1;
			sumScore += parseInt(scoreArr[i])*(i+1);
			sumCnt += parseInt(scoreArr[i]);
		}
		// 평점 평균
		$('#position').find('div[class="starWarp"]').eq(0).find('div').eq(1).text(sumScore/scoreArr.length)
		// 평점 수
		$('#position').find('div[class="starWarp"]').eq(0).find('div').eq(4).text(sumCnt);
		// 최고 평점
		$('#position').find('div[class="starWarp"]').eq(0).find('div').eq(7).text(max)
	} else {
		// 평점 배열이 출력이 안됬을 때
	}
	
	var likesStr = $('#likesRiviewer').val().replace(/\[|\]|\s/g,"").trim();
	$('#rvrList').html('');
	// 좋아하는 리뷰어 띄워주기
	if(likesStr!=""){
		var likesArr = likesStr.split(",");
		setTimeout(function(){
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
		}, 1500);
		
	} else {
		$('#rvrList').text('회원님께선 현재 구독을 한 리뷰어가 없습니다.')
		$div = $('<div>').attr({
			'style' : 'margin:20px 0;width:100%;height:1px;background-color:#dedede'
		})
		$('#rvrList').append($div);
	}
	
	// 영화 선호 장르
	
	// 영화 추천
	var movieStr = $('#estMovie').val().replace(/\[|\]|\s/g,"");
	var titleStr = $('#estTitle').val().replace(/\[|\]|\s/g,"");
	$(st2Carousel).html('');
	if(movieStr!=""){
		var estArr = movieStr.split(",");
		var titleArr = titleStr.split(",");
		var resultNum = 5;
		for(var i=0; i<estArr.length/resultNum; i++){
			// 페이지마다
			$inDiv = $('<div>').attr({
				'class' : 'item rec-list clearfix'
			})
			for(var j=0; j<((estArr.length-i*resultNum>=5)?5:estArr.length-i*resultNum); j++){
				$miniDiv = $('<div>').attr({
					'class' : 'col-md-2',
					'value' : estArr[i*resultNum + j]
				})
				// 영화명
				$h = $('<h1>').attr({
					'style' : 'opacity: 1;'
				}).text(titleArr[j]);
				// 이미지 주소
				$img = $('<img>').attr({
					'src' : '서음네이이일주우우우소오오오오오'
				})
				$img.click(function(){
					location.href = "/semi/dView.do?mCode="+$(this).parent('div').attr('value');
				})
				$miniDiv.append($h);
				$miniDiv.append($img);
				
				$inDiv.append($miniDiv);
			}
			$(st2Carousel).append($inDiv);
		}
	} else {
		$('#st2Carousel').text('평점 항목이 적거나 사용자와 비슷한 성향의 다른 사용자가 없습니다.')
	}
})

function init() {
	gapi.client.setApiKey(getKey()); // youtube api key value
	// gapi.client.ladt("nameOfApi", "Version", callback)
	gapi.client.load("youtube", "v3", function(){
	// yt api is ready
	});
}

function getKey(){
	return "AIzaSyCQQm1VyQpzoPp4euLPT1RRNqraSmY12tc";
}