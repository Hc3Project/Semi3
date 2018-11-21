$(function(){
	$('#auto').click(function(){
		if(confirm("사이트에 등록되지 않은 순위권 영화를 자동으로 등록합니다.")){
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
						// 상세 정보 수정
						$.ajax
						({
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
								
								// 영화 등록하기
								$.ajax({
									url : "/semi/mInsert.vi",
									data : infoData,
									error : function(data){
										console.log(data);
									}
								})
								
							},
							error : function(data){
								console.log(data);
							},
							async : false
						})
					})
					alert("자동 추가가 완료되었습니다.")
				},
				error : function(data){
					console.log(data);
				}
			})
			
		} else {
			alert("취소하셨습니다.");
		}
	})
})