<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="<%=request.getContextPath()%>/resources/js/jquery-3.3.1.min.js"></script>
  <!-- 슬라이더 -->
  <script src="../../resources/js/common.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.15/jquery.bxslider.js"></script>
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.15/jquery.bxslider.css">
	<link rel="stylesheet" href="../../resources/css/reset.css">
    <link rel="stylesheet" href="../../resources/css/style.css">
  	<link rel="stylesheet" href="../../resources/css/main.css">
    <link rel="stylesheet" href="../../resources/css/setting.css">
    <title>설정</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>
            <!--header-->
<section class="container">
        <h1>회원 정보 수정</h1>
        <div class="content">
            <div class="setting-page">
              
                <div class="profile-form">
                    <form action="/semi/mUpdate.me" method="post" id="update">
                        <div class="profile-form__group clearfix">
                            <div class="profile-form__label-area">
                                <div class="form-column">
                                    <label class="form-label">이메일</label>
                                </div>
                            </div>
                            <div class="profile-form__input-area">
                                <div class="profile-email-field">
                                    <div class="form-column">
                                        <span class="profile-email-field__current-email">
                                        <div class="form-input form-input--valid">
                                        <input type="email" name = "email" required="required" value="<%=m.getEmail() %>">
                                            </div>
                                        </span>
                                        <span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--profile-form__group-->
                        <div class="profile-form__group clearfix">
                            <div class="profile-form__label-area">
                                <div class="form-column">
                                    <label class="form-label">아이디</label>
                                </div>
                            </div>
                            <div class="profile-form__input-area">
                                <div class="form-column">
                                    <div class="form-input form-input--valid">
                                        <input type="text" required="required" placeholder="<%=m.getUserId() %>" readonly>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--profile-form__group-->
                        <div class="profile-form__group clearfix">
                            <div class="profile-form__label-area">
                                <div class="form-column">
                                    <label class="form-label">비밀번호</label>
                                </div>
                            </div>
                            <div class="profile-form__input-area">
                                
                                <div class="form-column">
                                    <div class="form-input">
                                        <input type="password" id="new1" name="newPassword"  required="required" placeholder="새 비밀번호">
                                    </div>
                                </div>
                                <div class="form-column">
                                    <div class="form-input">
                                        <input type="password" id="new2" required="required" placeholder="새 비밀번호 확인">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--profile-form__group-->
                    </form>
                    <div class="profile-form__button-area">
                        <button class="profile-form__submit-button1" onclick="changeInfo();">프로필 저장</button>
                        <button class="profile-form__submit-button2" onclick="deleteMember();">회원 탈퇴</button>   
                    </div>
                    
                </div>
                <!--profile-form-->
            </div>
            <!--setting-page-->
        </div>
        <!--content-->
        
    </section>
    <!--container-->

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script type="text/javascript">
        
        
        //이메일 변경 클릭시
        /* var profileEmailField ='<div class="profile-email-field"><div><div class="form-column"><div class="form-input"><input type="email" name="email" required="required" placeholder="새 이메일"></div></div></div></div>';

        $(".profile-email-field__change-button").click(function(){
            var edit =  $(this);

                edit.hide();
                edit.closest(".form-column").hide();
                edit.closest(".profile-email-field").append(profileEmailField);
                isChangeEmail = true;

           edit.unbind("click");
           
        }) */
        
        // 프로필 수정(저장)
       	function changeInfo(){
        	$("#update").submit();
        } 
        
       
        $("#update").submit(function(event){
			
			if($('#new1').val() != $('#new2').val()) alert("비밀번호 확인 값과 다릅니다.");
			else return;
			event.preventDefault();
		});
        // 회원탈퇴
        function deleteMember() {
					location.href = "/semi/mDelete.me?mid=<%= m.getUserId() %>";
				}
        
    </script>

</body>
</html>