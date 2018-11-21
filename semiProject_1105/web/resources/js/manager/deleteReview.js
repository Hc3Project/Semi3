var reviewList;
var resultMax = 5;
var curPage;

$(function(){
	$('#moreList').prop('disabled', true);
	
	$('.search input[type="text"]').keypress(function(e){
		if(e.which==13){
			$('.search input[type="button"]').click();
		}
	})
	
	$('#rvBtn').click(function(){
		if($('#search').val().trim()==""){
			alert('키워드를 입력해주세요.');
			return false;
		}
		$('#videoList').html('');
		curPage = 0;
		getList($('#rvrList').val(), $('#search').val().trim());
		$('#search').val('');
	})
	
	$('#moreList').click(function(){
		console.log(curPage)
		showList(reviewList)
	})
})

function getList(rvrCode, keyword){
	var strUrl = "/semi/rvSelectPart.rv";
	$.ajax({
		type : 'post',
		url : strUrl,
		data : {
			"rvrCode" : rvrCode,
			"keyword" : keyword
		},
		success : function(data){
			reviewList = $.parseJSON(data);
			showList(reviewList);
		},
		error : function(data){
			console.log(data);
		}
	})
}

function showList(data){
	if(data.length==0){
		alert("검색 결과가 존재하지 않습니다.");
		return false;
	}
	var strUrl = "/semi/views/manager/common/delShowVideo.jsp";
	var tmpLen = data.length - resultMax*curPage;
	var num = (tmpLen<resultMax)?tmpLen:resultMax;
	var sIdx = resultMax*curPage++;
	$.ajax({
		type : 'post',
		url : strUrl,
		success : function(code){
			for(var i=0; i<num; i++){
				$('#videoList').append(showVideo(code, data[sIdx+i]));
			}
		},
		error : function(data){
			console.log(data);
		},
		async : false
	})
	if(data.length<=resultMax*curPage) $('#moreList').prop('disabled', true);
	else $('#moreList').prop('disabled', false);
}

function showVideo(code, arr){
	var result = code;
	for(var i in arr){
		var reg = new RegExp('{{' + i + '}}','g'); 
		result = result.replace(reg, arr[i]);
	}
	return result;
}

function delReview(obj){
	if(confirm("정말 삭제하시겠습니까?")){
		var videoId = $(obj).siblings('input:hidden').eq(0).val();
		var urlStr = "/semi/rvDelete.rv";
		$.ajax({
			type : 'post',
			url : urlStr,
			data : {
				"videoId" : videoId
			},
			success : function(data){
				if(data>0) alert('리뷰가 성공적으로 삭제되었습니다.');
				else alert('리뷰 삭제를 실패하였습니다.');
				location.reload();
			},
			error : function(data){
				console.log(data)
			}
		})
	}
}