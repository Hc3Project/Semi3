$(function(){
	var script = document.createElement("script");
	script.src = "http://apis.google.com/js/client.js?onload=init";//포함시킬 js 파일 (경로가 존재하면 경로까지 작성)
	document.getElementsByTagName("body")[0].appendChild(script);
	
	$('#rvrBtn').click(function(){
		var keyword = $('#rvrSearch').val().trim();
		
		if(keyword == ""){
			alert("키워드를 입력하세요.");
			return false;
		}
		
		var rvrRequest = gapi.client.youtube.channels.list({
			part : "snippet",
			forUsername : keyword.replace(/%20/g, '+'),
			maxResults : 5
		}) 
		
		rvrRequest.execute(function(rvrResponse){
			
			var result = rvrResponse;
			
			console.log(result);
			
		})
		
	})
	
	// 추가하기 버튼
	// 대충만든거라 손좀 봐야됨
	$('#addRvrBtn').click(function(){
		var rvrName = $(this).parents('table').find('th')[1].innerText;
		var rCode = $(this).parents('table').find('th')[3].innerText;
		var profile = $(this).parents('table').find('textarea').val();
		
		var strUrl = "";
		$.ajax({
			type : 'post',
			url : strUrl,
			data : {
				"rvrName" : rvrName,
				"rCode" : rCode,
				"profile" : profile
			},
			success : function(data){
				if(data>0) alert('성공적으로 추가하였습니다.');
				else alert('리뷰어 추가를 실패하였습니다.')
			},
			error : function(data){
				console.log(data);
			}
		})
	})	
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