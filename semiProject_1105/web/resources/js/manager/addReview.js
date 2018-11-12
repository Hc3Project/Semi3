var channelId;
var keyword;
var resultMax = 5;
var nToken;

$(function(){	
	var script = document.createElement("script");
	script.src = "http://apis.google.com/js/client.js?onload=init";//포함시킬 js 파일 (경로가 존재하면 경로까지 작성)
	document.getElementsByTagName("body")[0].appendChild(script);
	$('#moreList').prop('disabled', true)
	
	$('#rvBtn').click(function(){
		if($('#rvrList').val()==""){
			alert('리뷰어를 선택하세요.');
			return false;
		}
		channelId = $('#rvrList').val();
		keyword = $('#rvKeyword').val().trim();
		nToken = "";
		$('#videoList').html('');
		getVideo(channelId, keyword, nToken)
	})
	
	$('#moreList').click(function(){
		getVideo(channelId, keyword, nToken)
	})
})

function getVideo(channelId, keyword, nToken){
	
	var rRequest = gapi.client.youtube.search.list({
		part : "snippet",
		channelId : channelId,
		q : keyword,
		pageToken : nToken,
		maxResults : resultMax,
		order : "date",
		videoEmbeddable : 'true',
		type : "video"
	})
	
	rRequest.execute(function(data){
		console.log(data);
		showList(data);
	})
	
}

function showList(data){
	var result = data;
	nToken = data.nextPageToken;
	$.each(result.items, function(idx, item){
		var dataArr = {
				"title" : item.snippet.title,
				"videoId" : item.id.videoId,
				"pDate" : item.snippet.publishedAt
				
		}
		var urlStr = "/semi/views/manager/common/showVIdeo.jsp";
		
		$.ajax({
			type : "get",
			url : urlStr,
			success : function(code){
				$('#moreList').prop('disabled', false);
				$('#videoList').append(showVideo(code, dataArr));
				if(data.nextPageToken=="") $('#moreList').prop('disabled', true);
			},
			error : function(err){
				console.log(err);
			}
		})
	})
}

function showVideo(code, arr){
	var result = code;
	for(var i in arr){
		var reg = new RegExp('{{' + i + '}}','g'); 
		result = result.replace(reg, arr[i]);
	}
	return result;
}

function addReview(obj){
	
	var strUrl = '/semi/rvDup.rv';
	$.ajax({
		type : 'post',
		url : strUrl,
		data : {
			videoId : $(obj).siblings('input:hidden').eq(1).val()
		},
		success : function(data){
			if(data!=0) {
				alert('이미 등록된 리뷰입니다.');
				$(obj).prop('disabled', true);
			} else {
				var data = {
					rvrCode : channelId,
					title : $(obj).siblings('input:hidden').eq(0).val(),
					videoId : $(obj).siblings('input:hidden').eq(1).val(),
					pDate : $(obj).siblings('input:hidden').eq(2).val()
				}
				var quertString = "";
				$.each(data, function(idx, item){
					quertString += idx + '=' + encodeURI(item) + '&';
				})
				
				window.location.href='/semi/views/manager/choiceMovie.jsp?' + quertString.substr(0, quertString.length-1);
			}
		},
		error : function(data){
			console.log(data);
		},
		async : false
	})
}

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