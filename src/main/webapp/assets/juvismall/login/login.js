/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
| 참조 URL    : login/view
| 설명        : 로그인 처리
-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

// 로그인 버튼 클릭시
$(document).on('click','.loginBtn',function(e){
    var memId = $('#j_username').val().trim();
    var memPw = $('#j_password').val().trim();
    var rememberMe = $('#remember-me').val();
    if ( !memId || memId == '' ) {
        alert('아이디를 입력해주세요.');
        return;
    }
    if ( !memPw || memPw == '' ) {
        alert('비밀번호를 입력해주세요.');
        return;
    }
    var data = {};

    data[JUVISMALL.CONST.userNameParam] = memId;
    data[JUVISMALL.CONST.pwParam] = memPw;
    data[JUVISMALL.CONST.rememParam] = rememberMe;

    JUVISMALL.ajax(
        {
            'url'      : JUVISMALL.CONST.loginProcessUrl,
            'method'   : 'POST', // GET, POST, PUT, DELETE
            'data'     :  data,
            'success'  : function (data) {
                location.href='/';
            },
            'error' : function (xhr, status, error)  {
                console.dir(xhr);
                console.dir(status);
                console.dir(error);
                console.log(xhr.responseJSON);
                var data = xhr.responseJSON;
                if ( data.code == '9100') {
                    alert(data.msg);
                }
            }
        }

    );
});