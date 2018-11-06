<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <script src="../../resources/js/jquery-3.3.1.min.js"></script>
  <!-- 슬라이더 -->
  <script src="../../resources/js/common.js"></script>
  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.15/jquery.bxslider.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.15/jquery.bxslider.css">
  
  <link rel="stylesheet" href="../../resources/css/reset.css">
  <link rel="stylesheet" href="../../resources/css/style.css">
  <link rel="stylesheet" href="../../resources/css/main.css">
  <link rel="stylesheet" href="../../resources/css/login.css">
  <title>로그인</title>
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
            <form action="#" method="post" enctype="multipart/form-data">
              <input type="email" name="email" id="email" class="inpt" required="required" placeholder="이메일(test@test.com)">
              <label for="email">이메일</label>
              <input type="password" name="password" id="password" class="inpt" required="required" placeholder="비밀번호(6자이상)">
              <label for="password">비밀번호</label>
              <div class="submit-wrap">
                <input type="submit" value="로그인" class="submit">
  
              </div>
            </form>
          </div>
          <div class="signup-cont cont">
            <form action="#" method="post" enctype="multipart/form-data">
              <input type="text" name="name" id="name" class="inpt" required="required" placeholder="이름">
              <label for="name">이름</label>
              <input type="email" name="email" id="email" class="inpt" required="required" placeholder="이메일(test@test.com)">
              <label for="email">이메일</label>
              <input type="password" name="password" id="password" class="inpt" required="required" placeholder="비밀번호(6자이상)">
              <label for="password">비밀번호</label>
              <div class="submit-wrap">
                <input type="submit" value="가입 완료" class="submit">
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

  </script>

</body>
</html>