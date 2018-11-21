<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.kh.semi.user.member.model.vo.Member, java.util.*"
%>
<%
	Member member=(Member)session.getAttribute("member");
	String list=(String)request.getAttribute("list");
	String[] rvr=list.split(", ");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script	src="<%=request.getContextPath()%>/resources/js/jquery-3.3.1.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
<script	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>


<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/reviewer.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">



<title>리뷰어 페이지</title>
<style>
	
</style>
</head>
<body>
<header>
		<%@ include file="../common/header.jsp"%>
	</header>
	<!--header-->
	
<div class="row" id="place">
<div class="col-sm-3">
<a href="/semi/views/movie/movieReviewerDetailView.jsp">
    <div class="card">
            <div class="box">
            <a href="<%=request.getContextPath()%>/profile.rvr?rvrCode=UCIXvXBYSc9fQ7Ri5SM1r8xA&prfImg=AN66SAwVm7WA528o_GTVJTBQw7VyY9yvZzoB7COb7g=s176-c-k-c0x00ffffff-no-rj-mo">
                <div class="img">
                    <img src="https://yt3.ggpht.com/a-/AN66SAwVm7WA528o_GTVJTBQw7VyY9yvZzoB7COb7g=s176-c-k-c0x00ffffff-no-rj-mo">
                </div>
                </a>
                <h2>라이너의 컬쳐쇼크<br><br><span><img class=heartBtn id="UCIXvXBYSc9fQ7Ri5SM1r8xA" src="/semi/resources/image/grheart.png" alt="grey"></span></h2>
                <p> #촌철살인 #전문가 포스 #스포일러 多 #최신 영화 위주 </p>
              
            </div>
        </div>
        
   </div>
   <div class="col-sm-3">
    <div class="card">
            <div class="box">
            <a href="<%=request.getContextPath()%>/profile.rvr?rvrCode=UCMguxwveCsLVpyKrLz-EFTg&prfImg=AN66SAzBujm1ekWQQuRSVCQNW_Vu426WBlvr5X4rcg=s176-c-k-c0x00ffffff-no-rj-mo">
                <div class="img">
                    <img src="https://yt3.ggpht.com/a-/AN66SAzBujm1ekWQQuRSVCQNW_Vu426WBlvr5X4rcg=s176-c-k-c0x00ffffff-no-rj-mo">
                </div>
                </a>
                <h2>달빛 뮤즈<br><br><span><img class="heartBtn" id="UCMguxwveCsLVpyKrLz-EFTg" src="/semi/resources/image/grheart.png" alt="grey"></span></h2>
                <p> #여성 리뷰어 #꾀꼬리 같은 목소리 #숨겨진 영화 발굴러</p>
              
            </div>
        </div>
   </div>
   <div class="col-sm-3">
    <div class="card">
            <div class="box">
            <a href="<%=request.getContextPath()%>/profile.rvr?rvrCode=UCJfthTE-ACoZJPVgwyw_hsw&prfImg=AN66SAzLcisUWXl_LhZz44Xi70FSfiVr9Muxj7xUhQ=s176-c-k-c0x00ffffff-no-rj-mo">
                <div class="img">
                    <img src="https://yt3.ggpht.com/a-/AN66SAzLcisUWXl_LhZz44Xi70FSfiVr9Muxj7xUhQ=s176-c-k-c0x00ffffff-no-rj-mo">
                </div>
                </a>
                <h2>필름에 빠지다<br><br><span><img class="heartBtn" id="UCJfthTE-ACoZJPVgwyw_hsw" src="/semi/resources/image/grheart.png" alt="grey"></span></h2>
                <p> ####</p>
              
            </div>
        </div>
   </div>
   <div class="col-sm-3">
    <div class="card">
            <div class="box">
            <a href="<%=request.getContextPath()%>/profile.rvr?rvrCode=UC79hJz6y1EEiIkwfHOuWC4w&prfImg=AN66SAxwMf-CFDUpC66-uduG7jk8kNGKtBsxAG1I5g=s288-mo-c-c0xffffffff-rj-k-no">
                <div class="img">
                    <img src="https://yt3.ggpht.com/a-/AN66SAxwMf-CFDUpC66-uduG7jk8kNGKtBsxAG1I5g=s288-mo-c-c0xffffffff-rj-k-no">
                </div>
                </a>
                <h2>시선 플레이<br><br><span><img class="heartBtn" id="UC79hJz6y1EEiIkwfHOuWC4w" src="/semi/resources/image/grheart.png" alt="grey"></span></h2>
                <p> #특이한 콘텐츠 #웹, 잡지 문화컨텐츠 운영 ##</p>
              
            </div>
        </div>
   </div>
    
</div>

<div class="row">
<div class="col-sm-3">
    <div class="card">
            <div class="box">
            <a href="<%=request.getContextPath()%>/profile.rvr?rvrCode=UC8OTtjmmFp-NAypjj64ocmg&prfImg=AN66SAyYrjuMUrtDOIee-fl2yRVR68xJYQOuDsAf3A=s176-c-k-c0x00ffffff-no-rj-mo">
                <div class="img">
                    <img src="https://yt3.ggpht.com/a-/AN66SAyYrjuMUrtDOIee-fl2yRVR68xJYQOuDsAf3A=s176-c-k-c0x00ffffff-no-rj-mo">
                </div>
                </a>
                <h2>뭅이<br><br><span><img class="heartBtn" id="UC8OTtjmmFp-NAypjj64ocmg" src="/semi/resources/image/grheart.png" alt="grey"></span></h2>
                <p>  ####</p>
              
            </div>
        </div>
   </div>
   <div class="col-sm-3">
    <div class="card">
            <div class="box">
            <a href="<%=request.getContextPath()%>/profile.rvr?rvrCode=UCxlv4aOnrRTXMRSL8bVJqEw&prfImg=AN66SAzfM5tqDLOjZk_tWQemsDuLYaRg1izgE4DwsA=s176-c-k-c0x00ffffff-no-rj-mo">
                <div class="img">
                    <img src="https://yt3.ggpht.com/a-/AN66SAzfM5tqDLOjZk_tWQemsDuLYaRg1izgE4DwsA=s176-c-k-c0x00ffffff-no-rj-mo">
                </div>
                </a>
                <h2>B-MAN<br><br><span><img class="heartBtn" id="UCxlv4aOnrRTXMRSL8bVJqEw" src="/semi/resources/image/grheart.png" alt="grey"></span></h2>
                <p>  #마블, DC 히어로물 전문 ###</p>
            
            </div>
        </div>
   </div>
   <div class="col-sm-3">
    <div class="card">
            <div class="box">
            <a href="<%=request.getContextPath()%>/profile.rvr?rvrCode=UCpCiIDf9UrfRqte55FHWlYQ&prfImg=AN66SAwC3Qq-_sIFlKVlgw7tNEAhgxrD7IYDeeQvVQ=s176-c-k-c0x00ffffff-no-rj-mo">
                <div class="img">
                    <img src="https://yt3.ggpht.com/a-/AN66SAwC3Qq-_sIFlKVlgw7tNEAhgxrD7IYDeeQvVQ=s176-c-k-c0x00ffffff-no-rj-mo">
                </div>
                </a>
                <h2>드림 텔러<br><br><span><img class="heartBtn" id="UCpCiIDf9UrfRqte55FHWlYQ" src="/semi/resources/image/grheart.png" alt="grey"></span></h2>
                <p>  ####</p>
              
            </div>
        </div>
   </div>
   <div class="col-sm-3">
    <div class="card">
            <div class="box">
            <a href="<%=request.getContextPath()%>/profile.rvr?rvrCode=UCKvfTts0BCr0Zx6FWT_rtEw&prfImg=AN66SAwAHX86u0AddaV5rdxMLcLzhZNQbS-QLh5e0Q=s176-c-k-c0x00ffffff-no-rj-mo">
                <div class="img">
                    <img src="https://yt3.ggpht.com/a-/AN66SAwAHX86u0AddaV5rdxMLcLzhZNQbS-QLh5e0Q=s176-c-k-c0x00ffffff-no-rj-mo">
                </div>
                </a>
                <h2>김스카이의 하늘담<br><br><span><img class="heartBtn" id="UCKvfTts0BCr0Zx6FWT_rtEw" src="/semi/resources/image/grheart.png" alt="grey"></span></h2>
                <p>  #수려한 말솜씨 #재밌는 영상 # #</p>
              
            </div>
        </div>
   </div>
    
</div>

<div class="row">
<div class="col-sm-3">
    <div class="card">
            <div class="box">
            <a href="<%=request.getContextPath()%>/profile.rvr?rvrCode=UCrBpV_pG2kyMMEHCMTNzjAQ&prfImg=AN66SAwQvfhgQXh2A1_sdbc86MGkMi-I7OaC3iqLuw=s176-c-k-c0x00ffffff-no-rj-mo">
                <div class="img">
                    <img src="https://yt3.ggpht.com/a-/AN66SAwQvfhgQXh2A1_sdbc86MGkMi-I7OaC3iqLuw=s176-c-k-c0x00ffffff-no-rj-mo">
                </div>
                </a>
                <h2>리뷰엉이<br><br><span><img class="heartBtn" id="UCrBpV_pG2kyMMEHCMTNzjAQ" src="/semi/resources/image/grheart.png" alt="grey"></span></h2>
                <p>  ####</p>
              
            </div>
        </div>
   </div>
   <div class="col-sm-3">
    <div class="card">
            <div class="box">
            <a href="<%=request.getContextPath()%>/profile.rvr?rvrCode=UCiOWYRzOTiUYi9pJ-kscIKw&prfImg=AN66SAzHi74WkMpaq1rqdV7XL73pSe2rGXYZ7uGgFA=s176-c-k-c0x00ffffff-no-rj-mo">
                <div class="img">
                    <img src="https://yt3.ggpht.com/a-/AN66SAzHi74WkMpaq1rqdV7XL73pSe2rGXYZ7uGgFA=s176-c-k-c0x00ffffff-no-rj-mo">
                </div>
                </a>
                <h2>발 없는 새<br><br><span><img class="heartBtn" id="UCiOWYRzOTiUYi9pJ-kscIKw" src="/semi/resources/image/grheart.png" alt="grey"></span></h2>
                <p>  #영화 전문 파워 블로거 출신 #리뷰에 직접 출연 #스포일러 多#</p>
              
            </div>
        </div>
   </div>
   <div class="col-sm-3">
    <div class="card">
            <div class="box">
            <a href="<%=request.getContextPath()%>/profile.rvr?rvrCode=UCNR3K4HA6LyO9tz0oZoSJIA&prfImg=AN66SAyxILC15q6D7V77L8Qv6N0fG5uXV4WS4Zs8_w=s176-c-k-c0x00ffffff-no-rj-mo">
                <div class="img">
                    <img src="https://yt3.ggpht.com/a-/AN66SAyxILC15q6D7V77L8Qv6N0fG5uXV4WS4Zs8_w=s176-c-k-c0x00ffffff-no-rj-mo">
                </div>
                </a>
                <h2>백수 골방<br><br><span><img class="heartBtn" id="UCNR3K4HA6LyO9tz0oZoSJIA" src="/semi/resources/image/grheart.png" alt="grey"></span></h2>
                <p> #ASMR로 들으면 좋은 # 자극적이지 않은 제목 # 애니메이션 위주</p>
              
            </div>
        </div>
   </div>
   <div class="col-sm-3">
    <div class="card">
            <div class="box">
            <a href="<%=request.getContextPath()%>/profile.rvr?rvrCode=UCu3BjLd03jxTVHXTPqZ77iQ&prfImg=AN66SAzgi9pUTOTN-eAqe9wUfosbEzquvrSfkdlvvg=s176-c-k-c0x00ffffff-no-rj-mo">
                <div class="img">
                    <img src="https://yt3.ggpht.com/a-/AN66SAzgi9pUTOTN-eAqe9wUfosbEzquvrSfkdlvvg=s176-c-k-c0x00ffffff-no-rj-mo">
                </div>
                </a>
                <h2>천재 이승국<br><br><span><img class="heartBtn" id="UCu3BjLd03jxTVHXTPqZ77iQ" src="/semi/resources/image/grheart.png" alt="grey"></span></h2>
                <p>  #리얼 천재 #아나운서 수준의 발음 #다양한 이벤트성 영상 #</p>
              
            </div>
        </div>
   </div>
    
</div>
<div class="row">
<div class="col-sm-3">
    <div class="card">
            <div class="box">
            <a href="<%=request.getContextPath()%>/profile.rvr?rvrCode=UCBHXCaw_W6sxfgAB7rC-BYw&prfImg=AN66SAySsICVpJqGA1EBC7RpZawR5ykR7GVjQrYD9g=s176-c-k-c0x00ffffff-no-rj-mo">
                <div class="img">
                    <img src="https://yt3.ggpht.com/a-/AN66SAySsICVpJqGA1EBC7RpZawR5ykR7GVjQrYD9g=s176-c-k-c0x00ffffff-no-rj-mo">
                </div>
                </a>
                <h2>소개해주는 남자<br><br><span><img class="heartBtn" id="UCBHXCaw_W6sxfgAB7rC-BYw" src="/semi/resources/image/grheart.png" alt="grey"></span></h2>
                <p> ####</p>
              
            </div>
        </div>
   </div>
   
    
</div>


<script>
	// 로그인시에만 동작
	<%if(member!=null){%>
		
		<%if(list.length()>0){%>
			<%for(int i=0;i<rvr.length;i++){%>
				$('#<%=rvr[i]%>').attr({
					src:'/semi/resources/image/rdheart.png',
					alt:'red'
				});
			<%}%>
		<%}%>
		
		$('.heartBtn').click(function(){
			var color=$(this).attr('alt');
			if(color=='grey'){
				$.ajax({
					url:"/semi/insert.rvr",
					data:{
						userId:"<%=member.getUserId()%>",
						rvrCode:$(this).attr('id')
					},
					success:function(data){
						console.log(data+" 좋아요");
					}
				});
				$(this).attr({
					src:'/semi/resources/image/rdheart.png',
					alt:'red'
				});
				
			}else{
				$.ajax({
					url:"/semi/delete.rvr",
					data:{
						userId:"<%=member.getUserId()%>",
						rvrCode:$(this).attr('id')
					},
					success:function(data){
						console.log(data+" 싫어요");
					}
				});
				$(this).attr({
					src:'/semi/resources/image/grheart.png',
					alt:'grey'
				});
			}
		});
	<%}else{%>
		$('.heartBtn').click(function(){
			alert("로그인을 하시면 리뷰어 좋아요 기능이 활성화됩니다.");
		});
	<%}%>
	
</script>
</body>
</html>