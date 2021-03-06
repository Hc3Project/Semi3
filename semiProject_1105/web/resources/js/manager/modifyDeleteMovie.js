var jsonData;
var curPage = 0;
var resultMax = 5;

$(function(){
	$('.search input[type="text"]').keypress(function(e){
		if(e.which==13){
			$('.search input[type="button"]').click();
		}
	})
	// 검색 버튼 눌렀을때
	$('#mBtn').click(function(){
		if($('#selList').val() == "" || $('#search').val().trim() == "") {
			alert("검색범주와 키워드 모두 입력해주세요.");
			return false;
		}
		var sel = $('#selList').val();
		var keyword = $('#search').val().trim();
		curPage = 0;
		getList(sel, keyword);
		if(jsonData.length!=0){
			$('#movieList tbody').html('');
			$('#search').val('');
			$('#modifyInfo').css('display', 'none');
			$('#getList').css('display', 'block');
			showList(curPage, resultMax);
		} else {
			alert('검색결과가 존재하지 않습니다.')
		}
		
	})
	
	// 항목 더보기를 눌렀을 때
	$('#moreList').click(function(){
		showList(curPage, resultMax);
	})
	
	// 테이블 내 뒤로가기 눌렀을 시
	$('#backBtn').click(function(){
		$('#selList').val('');
		$(this).parents('div').css('display', 'none');
		$('#getList').css('display', 'block');
	})
	
	// 테이블 내 삭제하기 버튼을 눌렀을 시
	$('#delBtn').click(function(){
		var strUrl = "/semi/mDelete.vi";
		var mCode = $(this).parents('table').find('th').eq(1).text();
		
		$.ajax({
			type : 'post',
			url : strUrl,
			data : {
				"mCode" : mCode
			},
			success : function(data){
				if(data>0){
					alert('성공적으로 삭제되었습니다.');
				} else {
					alert('삭제 실패 \n 개발자에게 문의하세요.')
				}
			},
			complete : function(data){
				$('#movieList tbody').html('');
				$('#modifyInfo').css('display', 'none');
				$('#getList').css('display', 'block');
				$('#getList').css('display', 'none');
			}
		})
	})
	
	// 테이블 내 수정하기 버튼 눌렀을 시
	$('#modifyBtn').click(function(){
		var strUrl = "/semi/mUpdate.vi";
		var jArr = new Object;
		jArr.mCode = $(this).parents('table').find('th').eq(1).text().trim();
		jArr.mTitle = $(this).parents('table').find('input:text').eq(0).val().trim();
		jArr.director = $(this).parents('table').find('input:text').eq(1).val().trim();
		jArr.actor = $(this).parents('table').find('input:text').eq(2).val().trim();
		jArr.syno = $(this).parents('table').find('textarea').val().trim();
		
		$.ajax({
			url : strUrl,
			type : 'post',
			data : jArr,
			success : function(data){
				if(data>0) alert("성공적으로 수정되었습니다.");
				else alert("삭제 실패\n 개발자에게 문의하세요.");
			},
			error : function(data){
				console.log(data);
			},
			complete : function(data){
				$('#movieList tbody').html('');
				$('#modifyInfo').css('display', 'none');
				$('#getList').css('display', 'none');
			}
		})
	})
})

function getList(sel, keyword){
	var strUrl = "/semi/mSelectPart.vi";
	
	$.ajax({
		url : strUrl,
		type : "get",
		data : {
			"sel" : sel,
			"keyword" : keyword
		},
		success : function(data){
			jsonData = $.parseJSON(data);
		},
		error : function(data){
			
		},
		async : false
	})
}

function showList(sIdx, num){
	$table = $('#movieList tbody');
	var tmpLen = jsonData.length - resultMax*curPage++;
	num = (tmpLen<5)?tmpLen:num;
	
	for(var i=0; i<num; i++){
		$tr = $('<tr>');
		$tdCode = $('<td>').text(jsonData[sIdx+i].mCode);
		$tdTitle = $('<td>').text(jsonData[sIdx+i].mTitle);
		$tdDirector = $('<td>').text(jsonData[sIdx+i].director);
		$tdActor = $('<td>').text(jsonData[sIdx+i].actor);
		$hidden = $('<input>').attr({
			type : 'hidden',
			value : sIdx+i});
		
		$tr.append($tdCode);
		$tr.append($tdTitle);
		$tr.append($tdDirector);
		$tr.append($tdActor);
		$tr.append($hidden);
		
		$table.append($tr);
	}
	
	
	// 테이블 행 선택했을 때
	$('#movieList tbody tr').click(function(){
		var idx = $(this).find('input:hidden').eq(0).val();
		
		$(this).parents('#getList').css('display', 'none');
		var table = $('#modifyInfo');
		table.css('display', 'block');
		
		table.find('th').eq(1).text(jsonData[idx].mCode);
		table.find('input:text').eq(0).val(jsonData[idx].mTitle);
		table.find('input:text').eq(1).val(jsonData[idx].director);
		table.find('input:text').eq(2).val(jsonData[idx].actor);
		table.find('textarea').val(jsonData[idx].syno);
	})
	
	if(resultMax*curPage >= jsonData.length) $('#moreList').prop('disabled', true);
	else $('#moreList').prop('disabled', false);
}
