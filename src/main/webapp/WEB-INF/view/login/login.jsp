<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<div class="login m_auto">
    <h4 class="txt_tit eng_lang">로그인</h4>
    <p class="txt_txt">쥬비스 통합 멤버스 아이디로 다양한 서비스를 이용하세요.</p>
    <div class="directions mb150">
        <div class="login_area">
            <nav class="menu_tab">
                <a href="javascript:void(0);" class="active">회원 로그인</a>
                <a href="javascript:void(0);" class="">비회원 (주문조회)</a>
            </nav>
            <div class="wrap_tab_content">
                <!-- 회원 로그인 -->
                <div class="tab_content userLogin active"> <!-- 활성탭 active 클래스 -->

                    <div class="tab_content_area">
                        <h5>쥬비스 몰에 오신것을 환영합니다. 회원 계정이 있으시면 로그인을 해주세요.<br>쥬비스 통합 멤버스 아이디로 로그인됩니다.</h5>
                        <div class="tab_area">
                            <input type="text" name = "j_username" id="j_username" placeholder="아이디">
                            <input type="password" name = "j_password" id="j_password" placeholder="비밀번호">
                            <label><input name="remember-me" id="remember-me"type="checkbox"> 로그인 상태 유지</label>
                            <button  class="btn03 loginBtn">로그인</button>
                        </div>
                    </div>
                    <div class="login_info">
                        <div class="login_search">
                            <div class="ft_l">
                                <h6>로그인 정보를 잊으셨나요?</h6>
                                <p>가입시 등록된 계정정보를<br>간단한 인증으로 찾으실 수 있습니다.</p>
                            </div>
                            <a><button type="button" class="btn05 ft_r">아이디·비밀번호 찾기</button></a>
                        </div>
                        <div class="login_join">
                            <div class="ft_l">
                                <h6>아직 회원이 아니신가요?</h6>
                                <p>쥬비스 통합 멤버스에 가입하시면<br>쥬비스 몰, 쥬비스 다이어트, 쥬비스 프리미엄 간편푸드,<br>온라인 강의의 다양한 서비스를<br>만나실 수 있습니다.</p>
                            </div>
                            <a href="javascript: void(0);" class="btn_join_set" onclick="JUVISMALL.joinPath();">신규 회원가입</a>
                        </div>
                    </div>
                </div>
                <!-- //회원 로그인 -->
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="<c:url value='/assets/juvismall/login/login.js'/>"></script>


</body>
</html>
