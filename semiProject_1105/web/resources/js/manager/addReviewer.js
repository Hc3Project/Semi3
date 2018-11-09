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