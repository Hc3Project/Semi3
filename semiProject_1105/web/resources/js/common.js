$(document).ready(function(){
  

    //로그인(닉네임) 마우스 오버
    $(".gnb .gnb__right-navs .gnb__my-name").hover(function () { 
        $(this).find(".gnb__account-menu-wrap").stop().fadeIn(); 
    }, function () { 
        $(this).find(".gnb__account-menu-wrap").stop().fadeOut(); 
    });

    $(".gnb .gnb__left-navs .gnb__category-list").hover(function(){
        $(this).find(".gnb-category-list").stop().fadeIn(); 
    }, function () { 
        $(this).find(".gnb-category-list").stop().fadeOut(); 
    });

    // 영화 카테고리의 장르 국가 특징 클릭시
    $(".category-filter-item").click(function(){
        $(this).addClass("category-filter-item--active");

        $(this).siblings("button").removeClass("category-filter-item--active");

        var cfiIndex=$(this).index();
        var $cfiList=$(".gnb-category-list__filtered-list");

        $cfiList.hide();

        $cfiList.eq(cfiIndex).show();
    })

    //메뉴 검색 클릭
    $(".search__button").click(function () {
        $(".search-input").stop().fadeIn();
        return false; 
    });
    //외에 영역 클릭
    $('html,body').click(function (e) { 
        if (!$(e.target).hasClass("search-input__text-field")) { 
            $(".search-input").stop().fadeOut();

            console.log("1");
        }
    });




})