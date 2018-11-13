var keyword;
var resultMax = 5;
var movieList;
var curPage;

$(function(){
	$('#moreList').prop('disabled', true);
	$('#selBtn').click(function(){
		if($('#search').val().trim()==""){
			alert("키워드를 입력해주세요~!")
			return false;
		}
		
		keyword = $('#search').val().trim();
		
		var strUrl = "/semi/mSelectPart.rv";
		$.ajax({
			url : strUrl,
			type : "get",
			data : {
				"keyword" : keyword
			},
			success : function(data){
				curPage = 0;
				$('#movieList tbody').html('');
				movieList = $.parseJSON(data);
				showList(movieList);
			},
			error : function(data){
				console.log(data);
			}
		})
	})
	$('#moreList').click(function(){
		showList(movieList)
	})
})

function showList(data){
	var tmpLen = data.length - resultMax*curPage;
	var num = (tmpLen<resultMax)?tmpLen:resultMax;
	var sIdx = resultMax*curPage++;
	$table = $('#movieList');
	for(var i=0; i<num; i++){
		$tr = $('<tr>');
		$tdCode = $('<td>').text(data[sIdx+i].mCode);
		$tdTitle = $('<td>').text(data[sIdx+i].mTitle);
		$tdDirector = $('<td>').text(data[sIdx+i].director);
		$tdActor = $('<td>').text(data[sIdx+i].actor);
		$tdNation = $('<td>').text(data[sIdx+i].nCode);
		$tdOpenDt = $('<td>').text(data[sIdx+i].openDate);
		$tdAddBtn = $('<td>').append($('<input>')
					.attr({
						type : 'button',
						value : '선택하기',
						onclick : 'addReview(this);'
					}))
		
		$tr.append($tdCode);
		$tr.append($tdTitle);
		$tr.append($tdDirector);
		$tr.append($tdActor);
		$tr.append($tdNation);
		$tr.append($tdOpenDt);
		$tr.append($tdAddBtn)
		
		$table.append($tr);
	}
	
	if(data.length-resultMax*curPage>0) $('#moreList').prop('disabled', false);
	else $('#moreList').prop('disabled', true);
}

function addReview(obj){
	var reviewInfo = getQueryStringData();
	reviewInfo['mCode'] = $(obj).parents('tr').find('td').eq(0).text();
	if(confirm($(obj).parents('tr').find('td').eq(1).text() + '\n해당 영화가 맞다면 확인 버튼을 눌러주세요.')){
		var strUrl = "/semi/rvInsert.rv";
		$.ajax({
			type : 'post',
			url : strUrl,
			data : reviewInfo,
			success : function(data){
				if(data>0) alert('리뷰가 성공적으로 추가 되었습니다.');
				else alert('리뷰 등록에 실패하였습니다.');
//				history.back();
				window.location.href = '/semi/rvrSelectAll.rv';
			},
			error : function(data){
				console.log(data);
			}
		})
	}
}

function getQueryStringData(){
	var arr = decodeURI(window.location.search.substr(1)).split('&');
	var data = new Object;
	for(var i=0; i<arr.length; i++){
		var tmp = arr[i].split("=");
		data[tmp[0]] = tmp[1];
	}
	return data;
}