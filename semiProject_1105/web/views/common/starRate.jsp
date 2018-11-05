<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>별점 매기기</title>
        <style>
                .starR1{
            background: url('http://www.escgo.com/wp-content/plugins/universal-star-rating/images/189/08.png') no-repeat -30px 0;
            background-size: auto 100%;
            width: 15px;
            height: 30px;
            float:left;
            text-indent: -9999px;
            cursor: pointer;
        }
        .starR2{
            background: url('http://www.escgo.com/wp-content/plugins/universal-star-rating/images/189/08.png') no-repeat right 0;
            background-size: auto 100%;
            width: 15px;
            height: 30px;
            float:left;
            text-indent: -9999px;
            cursor: pointer;
        }
        .starR1.on{background-position:0px 0;}
        .starR2.on{background-position:-15px 0;}
        
            </style>
    </head>
    <body>
            <div class="starRev">
                    <span class="starR1 on">별1_왼쪽</span>
                    <span class="starR2">별1_오른쪽</span>
                    <span class="starR1">별2_왼쪽</span>
                    <span class="starR2">별2_오른쪽</span>
                    <span class="starR1">별3_왼쪽</span>
                    <span class="starR2">별3_오른쪽</span>
                    <span class="starR1">별4_왼쪽</span>
                    <span class="starR2">별4_오른쪽</span>
                    <span class="starR1">별5_왼쪽</span>
                    <span class="starR2">별5_오른쪽</span>
                  </div>

                  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
                  <script type="text/javascript">
                  
                  $('.starRev span').hover(function(){
                  $(this).parent().children('span').removeClass('on');
                  $(this).addClass('on').prevAll('span').addClass('on');
                    return false;
                    });

                  </script>
    </body>


</html>