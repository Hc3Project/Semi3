$(function(){
	var h = 50;
	
	$.ajax({
		// 장르별 차트 출력
		url : "/semi/gSelect.vi",
		type : "post",
		success : function(data){
			var result = $.parseJSON(data);
			var mainGenre = ['주장르'];
			var subGenre = ['부장르'];
			var idxGenre = ['x']
			for(var i=0; i<(result.length)/2; i++){
				mainGenre.push(result[i].cnt);
				subGenre.push(result[(result.length)/2+i].cnt);
				idxGenre.push(result[i].name);
			}
			var chart = bb.generate({
				data: {
					x: "x",
				columns: [
					idxGenre,
					mainGenre,
					subGenre
			    ],
			    type: "bar",
			    colors : {
			    }
			  },
			  axis: {
			    x: {
			      type: "category",
			      tick: {
			        /*rotate: 50,*/
			        multiline: false,
			        tooltip: true
			      },
			      height: h
			    }
			  },
			  bindto: "#genreCnt"
			});
		},
		error : function(data){
			console.log(data);
		}
	})
	
	$.ajax({
		// 국가별 차트 출력
		url : "/semi/nSelect.vi",
		type : "post",
		success : function(data){
			var result = $.parseJSON(data);
			var idxNation = ['x'];
			var cntNation = ['영화']
			for(var i=0; i<result.length; i++){
				idxNation.push(result[i].name);
				cntNation.push(result[i].cnt);
			}
			var chart = bb.generate({
				data: {
					x: "x",
				columns: [
					idxNation,
					cntNation
			    ],
			    type: "bar",
			  },
			  axis: {
			    x: {
			      type: "category",
			      tick: {
			        /*rotate: 50,*/
			        multiline: false,
			        tooltip: true
			      },
			      height: h
			    }
			  },
			  bindto: "#nationCnt"
			});
		},
		error : function(data){
			console.log(data);
		}
	})
	
	$('#numBtn').click(function(){
		var num = $('#num').val();
		if(num<10 || num>100){
			alert("10이상 100이하를 입력해주세요.");
			return false;
		}
		$.ajax({
			// 최근 개봉한 영화 장르 분포
			url : "/semi/gRecent.vi",
			type : "post",
			data : {"num" : num},
			success : function(data){
				var result = $.parseJSON(data);
				var colData = [];
				$.each(result, function(idx, item){
					colData.push([item.name, item.cnt]);
				})
		    	
				var chart = bb.generate({
					  data: {
					    columns: colData,
					    type: "pie",
					  },
					  bindto: "#pie1"
					});
			},
			error : function(data){
				console.log(data);
			}
		})
	})
	$('#numBtn').click();
	
	$.ajax({
		// 리뷰어 조아요오오오오오 랭크으으으으
		url : "/semi/rvrRank.rvr",
		type : "post",
		success : function(data){
			var result = $.parseJSON(data);
			console.log(result);
			// 차트 넣기
		},
		error : function(data){
			console.log(data);
		}
	})
	
	$.ajax({
		// 평점 분포오오오오오오오오오오
		url : "/semi/uAllRating.ur",
		type : "post",
		success : function(data){
			var result = $.parseJSON(data);
			console.log(result);
			// 차트 넣기이이이이이이ㅣ이이이ㅓㅁ나러;ㅣㅏ넝ㄹ;ㅏㅣ먼ㅇ;ㅣ러
		},
		error : function(data){
			console.log(data);
		}
	})
	
	var chart = bb.generate({
		  data: {
		    columns: [
			["data1", 30],
			["data2", 120]
		    ],
		    type: "pie",
		  },
		  bindto: "#pie2"
		});
})