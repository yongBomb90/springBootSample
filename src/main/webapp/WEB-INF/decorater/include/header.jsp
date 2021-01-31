<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<ul class="skip_navi">
    <li><a href="#container">본문 바로가기</a></li>
    <li><a href="#gnb">주메뉴 바로가기</a></li>
</ul>
<!-- header -->

<div id="header" class="header">
    <header>
        <h1 class="logo"><a href="/"><img src="<c:url value='/assets/images/common/logo_2019.jpg'/>" alt="JOINBY"></a></h1>
        <!-- header_util -->
        <div class="header_util">
            <!-- 로그아웃 상태 -->
            <sec:authorize access="!isAuthenticated()">
                <a href="/">HOME</a>
                <a href='<spring:eval expression="@properties.getProperty(\'juvis.mall.prop.auth.login-page-url\')"></spring:eval>'>로그인</a>
                <a href="javascript: void(0);" id="btn_join_set"  class="btn_join_set" onclick="JUVISMALL.joinPath();">회원가입</a>
                <a href="javascript: void(0);">장바구니</a>
                <a href="javascript: void(0);">공지사항</a>
            </sec:authorize>

            <!-- 로그인 상태 -->
            <sec:authorize access="isAuthenticated()">
                <span class="login_msg">쥬비스 통합 멤버스로 로그인 중입니다.</span>
                <a href='<spring:eval expression="@properties.getProperty(\'juvis.mall.prop.auth.logout-url\')"></spring:eval>'>로그아웃</a>
                <a href="javascript: void(0);">마이페이지</a>
                <a href="javascript: void(0);">장바구니</a>
                <a href="javascript: void(0);">공지사항</a>
            </sec:authorize>


        </div>
        <!--// header_util -->
        <!-- gnb -->
        <nav>
            <div id="gnb" class="gnb">
                <ul>
                    <li><a href="#">1</a></li>
                </ul>
            </div>
        </nav>
        <!--// gnb -->
    </header>
</div>
