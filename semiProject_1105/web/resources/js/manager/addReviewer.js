var keyword;
var nToken;

$(function(){
	var script = document.createElement("script");
	script.src = "http://apis.google.com/js/client.js?onload=init";//포함시킬 js 파일 (경로가 존재하면 경로까지 작성)
	document.getElementsByTagName("body")[0].appendChild(script);
	$('#moreList').prop('disabled', true);
	// 검색하기 눌렀을 시
	$('#rvrBtn').click(function(){
		if($('#rvrSearch').val().trim() == ""){
			$('#rvrSearch').val('').focus();
			alert("키워드를 입력하세요.");
			return false;
		}
		$('#inputRvr').css('display', 'none');
		$('#getRvrList').css('display', 'block');
		keyword = $('#rvrSearch').val().trim();
		$('#rvrSearch').val('');
		$('#rvrList tbody').html('');
		nToken = '';
		getRivewer(keyword);
		
	})
	
	// 결과 더 보기 눌렀을 시
	$('#moreList').click(function(){
		getRivewer(keyword);
	})
	
	// 뒤로가기 눌렀을 시
	$('#backBtn').click(function(){
		$('#inputRvr').css('display', 'none');
		$('#getRvrList').css('display', 'block');
	})
	
	// 추가하기 버튼
	// 대충만든거라 손좀 봐야됨
	$('#addRvrBtn').click(function(){
		if($(this).parents('table').find('textarea').eq(0).val().length>1300){
			alert('1300자를 초과하였습니다.')
			return false;
		}
//		var rvrName = ;
//		var rCode = $(this).parents('table').find('th').eq(3).text();
//		var profile = $(this).parents('table').find('textarea').val();
//		console.log(rvrName);
		var strUrl = "/semi/rvrInsert.rvr";
//		var strUrl = "";
		$.ajax({
			type : 'post',
			url : strUrl,
			data : {
				"rvrName" : $(this).parents('table').find('th').eq(1).text(),
				"rvrCode" : $(this).parents('table').find('th').eq(3).text(),
				"profile" : $(this).parents('table').find('textarea').val()
			},
			success : function(data){
				if(data>0) alert('성공적으로 추가하였습니다.');
				else alert('리뷰어 추가를 실패하였습니다.')
			},
			error : function(data){
				console.log(data);
			},
			complete : function(data){
				$('#moreList').prop('disabled', false);
				$('#inputRvr').css('display', 'none');
				$('#getRvrList').css('display', 'none');
				$('#getRvrList').find('table tbody').html('');
				$('#rvrSearch').val('').focus();
			}
		})
	})	
})

function getRivewer(keyword){
	var rvrRequest = gapi.client.youtube.search.list({
		part : 'snippet',
		type : 'channel',
		q : keyword,
		maxResults : 5,
		pageToken : nToken,
		regionCode : 'KR'
	})
	
	rvrRequest.execute(function(rvrResponse){
		showReviewer(rvrResponse);
	})
}

function showReviewer(result){
	if(result.items.length!=0) $('#moreList').prop('disabled', false);
	else {
		$('#moreList').prop('disabled', true);
		return false
	}
	nToken = result.nextPageToken;
	$table = $('#rvrList');
	$.each(result.items, function(idx, item){
		
		$tr = $('<tr>');
		$Img = $('<img>').attr({
			src : item.snippet.thumbnails.default.url
		})
		$tdImg = $('<td>').append($Img);
		$tdTitle = $('<td>').text(item.snippet.channelTitle);
		$tdId = $('<td>').text(item.snippet.channelId);
		$btn = $('<input>').attr({
			type : 'button',
			value : '추가하기',
			onclick : 'showDetail(this);'
		})
		$tdBtn = $('<td>').append($btn);
		
		$tr.append($tdImg);
		$tr.append($tdTitle);
		$tr.append($tdId);
		$tr.append($tdBtn);
		
		$table.append($tr);
	})
}

function showDetail(obj){
	var channelId = $(obj).parents('tr').find('td').eq(2).text();
	var channelTitle = $(obj).parents('tr').find('td').eq(1).text();
	
	var strUrl = "/semi/rvrDup.rvr";
	$.ajax({
		type : 'post',
		url : strUrl,
		data : {
			"channelId" : channelId
		},
		success : function(data){
			if(data>0){
				alert('이미 추가된 리뷰어입니다.');
				$(obj).prop('disabled', true);
			} else {
				$('#getRvrList').css('display', 'none');
				$('#inputRvr').css('display', 'block');
				
				$table = $('#inputRvr').find('table');
				$table.find('th').eq(1).text(channelTitle);
				$table.find('th').eq(3).text(channelId);
				$table.find('textarea').eq(0).val('');
			}
		},
		error : function(data){
			console.log(data);
		}
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