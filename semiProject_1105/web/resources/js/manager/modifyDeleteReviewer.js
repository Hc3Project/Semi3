var rvrList;
var curPage;
var resultMax = 5;
$(function(){
	// 검색 버튼
	$('#rvrBtn').click(function(){
		var keyword = $('#rvrSearch').val().trim();
		if(keyword == ""){
			alert("키워드를 입력하세요.");
			return false;
		}
		curPage = 0;
		$('#divList').css('display', 'block');
		$('#divUpdate').css('display', 'none');
		getList(keyword);
	})
	
	// 더보기 버튼
	$('#moreList').click(function(){
		showList(curPage*resultMax, resultMax);
	})
	
	// 뒤로가기 버튼
	$('#backBtn').click(function(){
		$('#divList').css('display', 'block');
		$('#divUpdate').css('display', 'none');
	})
	
	// 수정 버튼
	$('#modifyBtn').click(function(){
		var channelId = $(this).parents('table').find('th').eq(1).text();
		var rvrName = $(this).parents('table').find('input:text').eq(0).val();
		var profile = $(this).parents('table').find('textarea').eq(0).val();
		var strUrl = "/semi/rUpdate.rvr";
		$.ajax({
			type : 'post',
			url : strUrl,
			data : {
				"channelId" : channelId,
				"rvrName" : rvrName,
				"profile" : profile
			},
			success : function(data){
				if(data>0) alert('수정 성공적')
				else alert('수정 실패')
			},
			error : function(data){
				console.log(data);
			},
			complete : function(data){
				$('#divList').css('display', 'block');
				$('#divUpdate').css('display', 'none');
			}
		})
	})
})

function getList(keyword){
	var strUrl = "/semi/rSelectPart.rvr";
	$.ajax({
		type : "post",
		url : strUrl,
		data : {
			"keyword" : keyword
		},
		success : function(data){
			rvrList = $.parseJSON(data)
			if(rvrList.length==0) alert('검색결과가 존재하지 않습니다.');
			$('#rvrList tbody').html('');
			showList(0, resultMax);
		},
		error : function(data){
			console.log(data);
		},
		complete : function(data){
			$('#rvrSearch').val('');
		}
	})
}

function showList(sIdx, num){
	$table = $('#rvrList tbody');
	var tmpLen = rvrList.length - resultMax*curPage++;
	num = (tmpLen<5)?tmpLen:num;
	
	for(var i=0; i<num; i++){
		$tr = $('<tr>');
		$tdCode = $('<td>').text(rvrList[sIdx+i].rvrCode);
		$tdName = $('<td>').text(rvrList[sIdx+i].rName);
		$tdCnt = $('<td>').text(rvrList[sIdx+i].reviewCnt);
		$hidden = $('<input>').attr({
			type : 'hidden',
			value : sIdx+i});
		
		$tr.append($tdCode);
		$tr.append($tdName);
		$tr.append($tdCnt);
		$tr.append($hidden);
		
		$table.append($tr);
	}
	
	// 테이블 행 선택했을 때
	$('#rvrList tbody tr').click(function(){
		var idx = $(this).find('input:hidden').eq(0).val();
		
		$(this).parents('div').css('display', 'none');
		var table = $('#divUpdate');
		table.css('display', 'block');
		
		table.find('th').eq(1).text(rvrList[idx].rvrCode);
		table.find('input:text').eq(0).val(rvrList[idx].rName);
		table.find('textarea').val((rvrList[idx].profile==null)?"":rvrList[idx].profile);
	})
	
	if(resultMax*curPage >= rvrList.length) $('#moreList').prop('disabled', true);
	else $('#moreList').prop('disabled', false);
}