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
		getList(curPage+1, ++curPage*resultMax);
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
			console.log($.parseJSON(data));
			showList($.parseJSON(data));
		},
		error : function(data){
			console.log(data);
		}
	})
}

function showList(result){
	$table = $('#userList tbody');
	$.each(result, function(idx, item){
		$tr = $('<tr>');
		$tdId = $('<td>').text(item.userId);
		$tdEmail = $('<td>').text(item.email);
		$btn = $('input').attr({
			type : 'button',
			value : '삭제하기',
			onclick : 'removeUser(this);'
		})
		$tdBtn = $('<td>').append($btn);
		
		$tr.append($tdId);
		$tr.append($tdEmail);
		$tr.append($tdBtn);
		
		$table.append($tr);
	})
}