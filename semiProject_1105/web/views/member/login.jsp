<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <script src="../../resources/js/jquery-3.3.1.min.js"></script>
  <!-- 슬라이더 -->
  <script src="../../resources/js/common.js"></script>
  <script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="../../resources/css/bootstrap.min.css">

  
  <link rel="stylesheet" href="../../resources/css/reset.css">
  <link rel="stylesheet" href="../../resources/css/style.css">
  <link rel="stylesheet" href="../../resources/css/main.css">
  <link rel="stylesheet" href="../../resources/css/login.css">
  <title>movie traveler</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>
            <!--header-->
  <div class="main">
    <section class="container">
  
      <article class="half">
       <h1>MOVIE TRAVELER</h1>
        <div class="tabs">
          <span class="tab signin active">
            <a href="#signin">로그인</a>
          </span>
          <span class="tab signup">
            <a href="#signup">회원가입</a>
          </span>
        </div>
        <div class="content">
          <div class="signin-cont cont">
            <form action="<%=request.getContextPath()%>/login.me" method="post">
              <input type="text" name="name" id="name" class="inpt"  required="required" placeholder="아이디">
              <label for="name">아이디</label>
              <input type="password" name="password" id="password" class="inpt" required="required" placeholder="비밀번호">
              <label for="password">비밀번호</label>
              <div class="submit-wrap">
                <input type="submit" value="로그인" class="submit">
  
              </div>
            </form>
          </div>
                    <div class="signup-cont cont">
            <form id="joinForm" action="<%=request.getContextPath()%>/mInsert.me" method="post" >
              <input type="text" name="name" id="jname" class="inpt" required="required" placeholder="아이디">
              <input type="button" id="idCheck" value="중복 체크" >
             
              <br><br>
              <input type="email" name="email" id="email" class="inpt" required="required" placeholder="이메일(test@test.com)">
              
              <input type="password" name="password" id="password" class="inpt" required="required" placeholder="비밀번호">
              
              <div class="submit-wrap">
                <input type="button" value="가입 완료" class="submit" onclick="gosubmit();">
              </div>
            </form>
          </div>
        </div>
      </article>
  
    </section>
  </div>



  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script type="text/javascript">
    $('.tabs .tab').click(function () {
      if ($(this).hasClass('signin')) {
        $('.tabs .tab').removeClass('active');
        $(this).addClass('active');
        $('.cont').hide();
        $('.signin-cont').show();
      }
      if ($(this).hasClass('signup')) {
        $('.tabs .tab').removeClass('active');
        $(this).addClass('active');
        $('.cont').hide();
        $('.signup-cont').show();
      }
    });
    
    var chk = 0;
    $('#idCheck').click(function(event){
       if($('#jname').val() == "") alert("아이디를 입력해 주세요!")
       else
      $.ajax({
         url : "/semi/idDup.me",
         type : "post",
         data : { userId : $('#jname').val()},
         success : function(data) {
            
            if( data == 'no' ) {
               alert("이미 사용중인 아이디입니다.");
               $('#name').select();
               chk = 0;
            } else {
               alert("사용 가능한 아이디입니다.");
               chk= 2;
            }
            
         }, error : function(request, status, error){
            alert(request+"\n"
               + status+"\n"
               + error);
            console.log("에러 발생!!");
         }
      });
      event.preventDefault();
   });
    
    
    
    
    function gosubmit(){
       
       if(chk == 0){
          
       alert("아이디 중복 체크를 해주세요!");
       
       } else if (chk == 1){
          alert("이미 사용 중인 아이디 입니다!");
          chk=0;
          
       } else {
          
          $('#joinForm').submit();
       }
       };
       </script>

</body>
</html>