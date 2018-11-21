$(function(){
	var logId = $('#logId').val();
	
	if(logId=="admin"){
		
		var host = "http://www.kobis.or.kr";
		var daily = '/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList';
		var movieInfo = "/kobisopenapi/webservice/rest/movie/searchMovieInfo";
		var key = "336a12b269060c6aa6f9c9f19ecd468a";
		var strUrl = host + daily + ".json?";
		var d = new Date();
		var mm = d.getMonth()+1;
		var dFormat = "" + d.getFullYear() + (mm<10?"0"+mm:mm) + (d.getDate()-1);
		var result = null;
		
		// 박스오피스 조회
		$.ajax({
			url : strUrl,
			type : "get",
			data : {
				"key" : key,
				"targetDt" : dFormat
			},
			success : function(data){
				result = data.boxOfficeResult.dailyBoxOfficeList;
				$.each(result, function(idx, item){

					var mCode = item.movieCd;
					// 중복확인
					$.ajax({
						url : "/semi/mDup.vi",
						type : "get",
						data : {
							mCode : mCode
						},
						success : function(dup){
							if(dup==0){
								// 중복되지 않았으면 디비디비에 넣어준다
								$.ajax({
									url : host + movieInfo + ".json?",
									type : "get",
									data : {
										key : key,
										movieCd : mCode
									},
									success : function(data){
										var mInfo = data.movieInfoResult.movieInfo;
										
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
										
										console.log(mInfo)
									},
									error : function(data){
										
									}
								})
							}
						},
						error : function(data){
							console.log(data);
						}
					})
				})
			},
			error : function(data){
				console.log(data);
			}
		})

	} else {
		console.log("nothing..")
	}
})