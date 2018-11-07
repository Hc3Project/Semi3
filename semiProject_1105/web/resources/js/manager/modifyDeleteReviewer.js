var rvrList;
var curPage;
$(function(){
	$('#rvrBtn').click(function(){
		var keyword = $('#rvrSearch').val().trim();
		if(keyword == ""){
			alert("키워드를 입력하세요.");
			return false;
		}
		
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
				showList(rvrList);
			},
			error : function(data){
				console.log(data);
			},
			complete : function(data){
				$('#rvrSearch').val('');
			}
		})
	})
})

function showList(jsonData){
	
}