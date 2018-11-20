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
	
	$.ajax({
		// 평점 분포오오오오오오오오오오
		url : "/semi/uAllRating.ur",
		type : "post",
		success : function(data){
			var result = $.parseJSON(data);
			var arr = new Array();
			for(var i=0; i<result.length; i++){
				var tmpStr = result[i].name;
				var tmpArr = result[i].ratingCnt;
				
				var tmpArr1 = tmpStr.concat("," + tmpArr).split(",");
				arr.push(tmpArr1)
			}
			var chart = bb.generate({
				  data: {
					columns: arr,
				    type: "bubble",
				    labels: true
				  },
				  axis: {
				    x: {
				    	type: "category",
					      categories: [
					    	"☆",
					        "★",
					        "★☆",
					        "★★",
					        "★★☆",
					        "★★★",
					        "★★★☆",
					        "★★★★",
					        "★★★★☆",
					        "★★★★★"
					      ]
				    }
				  },
				  bindto: "#ratingDistribution"
				});
			
		},
		error : function(data){
			console.log(data);
		}
	})
	
	$.ajax({
		// 리뷰어 조아요오오오오오 랭크으으으으
		url : "/semi/rvrRank.rvr",
		type : "post",
		success : function(data){
			var result = $.parseJSON(data);
			var cntArr = ['좋아요'];
			var cateArr = [];
			for(var i=0; i<result.length; i++){
				cntArr.push(result[i].cnt);
				cateArr.push(result[i].rName);
			}
			var chart = bb.generate({
				  data: {
				    columns: [
				    	cntArr
				    ],
				    type: "bar"
				  },
				  axis : {
					  x : {
						  type: "category",
						  categories: cateArr
					  }
				  },
				  bar: {
				    width: {
				      ratio: 0.5
				    }
				  },
				  bindto: "#rvrLikes"
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
	
	$('#dNum').change(function(){
		// 기간내 장르 평균
		var num = $('#dNum').val();
		if(num<1 || num>365){
			alert("1이상 365이하를 입력해주세요.");
			return false;
		}
		$.ajax({
			url : "/semi/gRecent.vi",
			type : "post",
			data : {
				"num" : num
			},
			success : function(data){
				var result = $.parseJSON(data);
				var colData = [];
				$.each(result, function(idx, item){
					colData.push([item.name, item.cnt]);
				})
				if(result.length!=0){
					console.log(colData);
					var chart = bb.generate({
						  data: {
						    columns: colData,
						    type: "pie",
						  },
						  bindto: "#dGenre"
						});
				} else {
					console.log("자료음슴")
					$('#dGenre').html('').text(num + "일 이내 개봉된 영화가 등록되어 있지 않습니다.")
				}
			},
			error : function(data){
				console.log(data);
			},
			async : false
		})
	})
	
	
	
})