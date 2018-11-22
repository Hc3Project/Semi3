var globaMovieName = "";
var curPage = 1;
var resultMax = 5;

$(function(){
	var script = document.createElement("script");
	script.src = "../../resources/js/manager/KobisOpenAPIRestService.js";//포함시킬 js 파일 (경로가 존재하면 경로까지 작성)
	document.getElementsByTagName("body")[0].appendChild(script);
	$('.search input[type="text"]').keypress(function(e){
		if(e.which==13){
			$('.search input[type="button"]').click();
		}
	})
	$('#movieBtn').click(function(){
		var title = $('#movieName').val().trim();
		
		if(title == "") {
			alert("영화명을 입력해주세요!");
			$('#movieName').text("");
			$('#movieName').focus();
			return false;
		}
		
		var strUrl = "";
		globaMovieName = title;
		curPage = 1;
		
		var mApi = new KobisOpenAPIRestService(getKey());
		var mList = mApi.getMovieList(true, title, resultMax, curPage);
		
		if(mList.movieListResult.totCnt!=0){
			$('#searchMovie').css("display", "block");
			$('#insertMovie').css("display", "none");
			$('#movieList tbody').html("");
			$('#more').prop('disabled', false);
			addTable(mList);
		} else {
			alert('검색결과가 존재하지 않습니다.');
		}
		
	})
	
	$('#more').click(function(){
		var mApi = new KobisOpenAPIRestService(getKey());
		var mList = mApi.getMovieList(true, globaMovieName, resultMax, curPage);
		addTable(mList);
	})
})

function addTable(data){
	
	var totCnt = data.movieListResult.totCnt;
	$table = $('#movieList tbody');
	
	$.each(data.movieListResult.movieList, function(idx, item){
		$tr = $('<tr>');
		$tdCode = $('<td>').text(item.movieCd);
		$tdName = $('<td>').text(item.movieNm);
		$tdDiretor = $('<td>').text((item.directors.length==0)?"":item.directors[0].peopleNm);
		$tdNation = $('<td>').text(item.nationAlt);
		$tdOpenDt = $('<td>').text(item.openDt);
		$tdGenre = $('<td>').text(item.genreAlt);
		$tdDetail = $('<td>').text("");
		if(item.openDt!="") $tdDetail = $('<td>').html("<input type='button' value='추가하기' onclick='detailBtn(this);'>");
		else $tdDetail = $('<td>').html("<input type='button' value='추가하기' onclick='detailBtn(this);' disabled>");
		
		$tr.append($tdCode);
		$tr.append($tdName);
		$tr.append($tdDiretor);
		$tr.append($tdNation);
		$tr.append($tdOpenDt);
		$tr.append($tdGenre);
		$tr.append($tdDetail);
		$table.append($tr)
	})
	
	if(totCnt/resultMax <= curPage++) $('#more').prop('disabled', true);
}

function detailBtn(obj){
	var mCode = $(obj).parent().parent().children().eq(0).text();
	var mTitle = $(obj).parent().parent().children().eq(1).text();
	
	var strUrl = "/semi/mDup.vi";
	$.ajax({
		type : "get",
		url : strUrl,
		data : {
			"mCode" : mCode
		},
		success : function(data){
			if(data>0){
				alert("이미 등록된 영화입니다.");
				$(obj).prop("disabled", true);
			} else {
				$('#searchMovie').css("display", "none");
				$('#insertMovie').css("display", "block");
				
				$('#addDetail thead').find('th').eq(1).text(mCode);
				$('#addDetail thead').find('th').eq(3).text(mTitle);
				$('#addDetail textarea').val("");
			}
		},
		error : function(data){
			
		}
	})
}

function addDetail(obj){
	var mCode = $(obj).parents('table').find('th').eq(1).text();
	var syno = $(obj).parents('tbody').find('textarea').val();
	
	var mApi = new KobisOpenAPIRestService(getKey());
	var mInfo = mApi.getMovieInfo(true, mCode).movieInfoResult.movieInfo;
	
	var infoData = new Object;
	infoData.mCode = mCode;
	infoData.mTitle = mInfo.movieNm;
	infoData.director = (mInfo.directors.length==0)?"없음":mInfo.directors[0].peopleNm;
	infoData.actor = (mInfo.actors.length==0)?"없음":mInfo.actors[0].peopleNm;
	infoData.showTime = mInfo.showTm;
	infoData.openDate = mInfo.openDt;
	infoData.genre1 = mInfo.genres[0].genreNm;
	infoData.genre2 = (mInfo.genres.length<2)?"없음":mInfo.genres[1].genreNm;
	infoData.nation = (mInfo.nations.length!=0)?mInfo.nations[0].nationNm:"없음";
	infoData.syno = syno.trim();

	if(syno==""){
		alert("상세정보를 입력바랍니다.");
		return false;
	}
	var strUrl = "/semi/mInsert.vi";

	$.ajax({
		type : "get",
		url : strUrl,
		data : infoData,
		success : function(data){
			if(data>0) alert("영화 정보를 입력을 성공하였습니다.");
			else alert("영화 정보 등록 실패하였습니다..");
		},	
		error : function(data){
			console.log(data);
		},
		complete : function(data){
			backList();
		}
	})
}

function backList(){
	$('#searchMovie').css("display", "block");
	$('#insertMovie').css("display", "none");
	$('#movieName').val('');
}

function getKey(){
	return "336a12b269060c6aa6f9c9f19ecd468a";
}