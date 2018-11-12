var resultMax = 5;
var curPage;
var keyword;
var opt;

$(function(){
//	$('#divList').css('display', 'none');
	$('#moreList').prop('disabled', true);
	
	$('#userBtn').click(function(){
		if($('#selOpt').val()==""){
			alert('검색범주를 선택해주세요.')
			return false;
		}
		curPage = 0;
		opt = $('#selOpt').val();
		keyword = $('#search').val().trim();
		getList(curPage++, curPage-1);
	})
})

function getList(stNum, edNum){
	var strUrl = "/semi/uSelectPart.ur";
	$.ajax({
		type : 'post',
		url : strUrl,
		data : {
			"opt" : opt,
			"keyword" : keyword,
			"stNum" : stNum,
			"edNum" : edNum
		},
		success : function(data){
			console.log(data);
		},
		error : function(data){
			console.log(data);
		}
	})
}

function showList(){
	
}