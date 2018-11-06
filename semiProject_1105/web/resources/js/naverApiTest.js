$(function(){
	$("#naverForm").on("submit", function(e){
		e.preventDefault;
		console.log(movieSearch());
	})
});

function movieSearch(){
	var url = "https://openapi.naver.com/v1/search/movie.json";
//	var search = $("#search").val();
	var search = "";
	var div = $("#results");
	div.html("");
	
//	url += "query=" + search;
	var result = null;
	
	$.ajax({
		type : "get",
		host : "http://openapi.naver.com",
		url : "/v1/search/movie",
		data : {
			query : search,
			display : 20
		},
		dataType : "json",
		headers : {
			'X-Naver-Client-Id':getClientId(),
			'X-Naver-Client-Secret':getClientSecret()
		},
		success : function(data){
			result = data;
		},
		error : function(a,b,c){
			console.log(a)
			console.log(b)
			console.log(c)
		}
	})
	
	return result;
}

function getClientId(){
	return "f1lI5BaAwEDWvf6UPMiK";
}
function getClientSecret(){
	return "flUGLrhsdJ";
}