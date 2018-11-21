var resultMax = 5;
var curPage;
var keyword;
var opt;

$(function(){
	$('#divList').css('display', 'none');
	$('#moreList').prop('disabled', true);
	
	$('.search input[type="text"]').keypress(function(e){
		if(e.which==13){
			$('.search input[type="button"]').click();
		}
	})
	
	$('#userBtn').click(function(){
		if($('#selOpt').val()==""){
			alert('검색범주를 선택해주세요.')
			return false;
		}
		$('#divList').css('display', 'none');
		curPage = 0;
		opt = $('#selOpt').val();
		keyword = $('#search').val().trim();
		$('#userList tbody').html('');
		var num = getList(curPage+1, ++curPage*resultMax);
		if(num==0){
			alert('검색결과가 없습니다.');
			return false;
		}
		$('#divList').css('display', 'block');
	})
	
	$('#moreList').click(function(){
		getList(curPage*resultMax+1, ++curPage*resultMax);
	})
	
})

function getList(stNum, edNum){
	var strUrl = "/semi/uSelectPart.ur";
	var len = 0;
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
			var result = $.parseJSON(data);
			len = result.length;
			showList(result);
		},
		error : function(data){
			console.log(data);
		},
		async : false
	})
	return len;
}

function showList(result){
	$table = $('#userList tbody');
	$.each(result, function(idx, item){
		$tr = $('<tr>');
		$tdId = $('<td>').text(item.userId);
		$tdEmail = $('<td>').text(item.email);
		$btn = $('<input>').attr({
			type : 'button',
			value : '탈퇴하기',
			onclick : 'removeUser(this);'
		})
		$tdBtn = $('<td>').append($btn);
		
		$tr.append($tdId);
		$tr.append($tdEmail);
		$tr.append($tdBtn);
		
		$table.append($tr);
	})
	if(result.length<5) $('#moreList').prop('disabled', true);
	else $('#moreList').prop('disabled', false);
}

function removeUser(obt){
	if(confirm("정말 탈퇴시키겠습니까?")){
		var userId = $(obt).parents('tr').find('td').eq(0).text();
		var strUrl = "/semi/uDelete.ur";
		$.ajax({
			url : strUrl,
			type : "post",
			data : {
				"userId" : userId
			},
			success : function(data){
				if(data>0) alert("사용자가 성공적으로 삭제 되었습니다.");
				else alert("사용자 삭제를 실패하였습니다.");
			},
			error : function(data){
				console.log(data);
			},
			complete : function(data){
				history.go(0);
			}
		})
	}
}