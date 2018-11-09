var keyword;
var resultMax = 5;
var curPage;

$(function(){
	$('#moreList').prop('disabled', true);
	$('#selBtn').click(function(){
		if($('#search').val().trim()==""){
			alert("키워드를 입력해주세요~!")
			return false;
		}
		
		keyword = $('#search').val().trim();
		
		var strUrl = "/semi/mSelectAll.rv";
		$.ajax({
			url : strUrl,
			type : "get",
			data : {
				"keyword" : keyword
			},
			success : function(data){
				curPage = 1;
				showList($.parseJSON(data));
			},
			error : function(data){
				console.log(data);
			}
		})
	})
})

function showList(data, sIdx){
	var tmpLen = data.length - resultMax*curPage++;
	var num = (tmpLen<5)?tmpLen:num;
	console.log(data);
	$table = $('#movieList');
	for(var i=0; i<num; i++){
		$tr = $('<tr>');
		$tdCode = $('<td>').text(data[i].mCode);
		$tdTitle = $('<td>').text(data[i].mTitle);
		$tdDirector = $('<td>').text(data[i].director);
		$tdActor = $('<td>').text(data[i].actor);
		$tdNation = $('<td>').text(data[i].nation);
		$tdOpenDt = $('<td>').text(data[i].openDate);
		
		$tr.append($tdCode);
		$tr.append($tdTitle);
		$tr.append($tdDirector);
		$tr.append($tdActor);
		$tr.append($tdNation);
		$tr.append($tdOpenDt);
		
		$table.append($tr);
	}
	
}

function getQueryStringData(){
	var arr = window.location.search.substr(1).split('&');
}