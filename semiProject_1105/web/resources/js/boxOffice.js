var dt = new Date();

	var m = dt.getMonth() + 1;
	if (m < 10) {
		var month = "0" + m;
	} else {
		var month = m + "";
	}

	var d = dt.getDate() - 1;
	if (d < 10) {
		var day = "0" + d;
	} else {
		var day = d + "";
	}

	var y = dt.getFullYear();
	var year = y + "";

	var result = year + month + day;
	
	$(function(){
		$.ajax({
			//"키입력" 부분에 발급받은 키를 입력
			//&itemPerPage: 1-10위 까지의 데이터가 출력되도록 설정
					url : "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=fc1ca30ccd58e0a604bba197baaa2a6a&targetDt="
							+ result + "&itemPerPage=10",
					dataType : "xml",
					success : function(data){
						
						var $data = $(data)
								.find("boxOfficeResult>dailyBoxOfficeList>dailyBoxOffice");
						//데이터를 테이블 구조에 저장. html의 table태그, class는 table로 하여 부트스트랩 적용
						if ($data.length > 0) {
							var table = $("<table/>").attr("class", "table");
							//<table>안에 테이블의 컬럼 타이틀 부분인 thead 태그
							var thead = $("<thead/>")
									.append(
											//추출하고자 하는 컬럼들의 타이틀 정의
											$("<th/>").html("&nbsp;순위"),
											$("<th/>").html("&nbsp;&nbsp;영화 제목"),				
											$("<th/>").html("&nbsp;&nbsp;오늘의 관객수"));
							var tbody = $("<tbody/>");
							$.each($data, function(i, o) {

								//오픈 API에 정의된 변수와 내가 정의한 변수 데이터 파싱
								var $rank = $(o).find("rank").text(); // 순위
								var $movieNm = $(o).find("movieNm").text(); //영화명
								var $audiAcc = $(o).find("audiCnt").text(); //누적 관객수
								var $movieCd = $(o).find("movieCd").text();
								$audiAcc= $audiAcc+"명";
								//<tbody><tr><td>태그안에 파싱하여 추출된 데이터 넣기
								var row = $("<tr/>").append(
										
										$("<td/>").text($rank),
										$("<td/>").text($movieNm),
										$("<td/>").text($audiAcc)).attr("class","movieTr").attr("value",$movieCd);

								tbody.append(row);

							});// end of each 

							table.append(thead);
							table.append(tbody);
							$(".boxRank").append(table);
						}
						$(".movieTr").click(function() {
							console.log($(this).attr("value"));
							location.href = "/semi/dView.do?mCode="+$(this).attr("value");
							
						})
					},
					//에러 발생시 "실시간 박스오피스 로딩중"메시지가 뜨도록 한다.
					error : function() {
						alert("실시간 박스오피스 로딩중...");
					}
					
					
				});
	});