var BOMB = BOMB? BOMB : {};
BOMB['ajaxHistory' ] = [];

/**
 * 배열로부터 지정된 아이템을 삭제
 *
 * @param item 삭제할 아이템
 * @returns 삭제된 아이템
 */
Array.prototype.removeItem = function( item ) {
    var idx = this.indexOf( item );
    if( idx < 0 ) {
        return null;
    }
    this.splice( idx, 1 );
};


(function($) {

    var ajaxCount = 0; //현재 ajax 요청 횟수
    var ajaxRetryCount = 0; //현재 ajax 재요청 횟수

    BOMB.joinPath = function() {
        var mobileKeyWords = new Array('Android', 'Mobile', 'iPhone', 'iPod', 'iPad', 'IEMobile', 'Kindle', 'NetFront', 'Silk-Acceleratedhpw', 'Silk-Acceleratedweb', 'Fennec', 'Minimo', 'Opera Mobi', 'Opera Mini', 'Dolfin', 'Dolphin', 'Skyfire', 'BlackBerry', 'Windows CE', 'LG', 'MOT', 'SAMSUNG', 'SonyEricsson');
        var pcurl = BOMB.CONST.joinPcUrl;
        var mburl = BOMB.CONST.joinMbUrl;
        var url = pcurl;
        for (var word in mobileKeyWords){
            if (navigator.userAgent.match(mobileKeyWords[word]) != null){
                url = mburl;
                break;
            }
        }
        var win = window.open(url, '_blank');
        win.focus();
    };










    BOMB.loadingstart = function(){
        //TODO : 로딩바시작

    };
    BOMB.loadingEnd = function(){
        //TODO : 로딩바제거
    };
    BOMB.SUCCESS_COMMON_CODE_LIST = [
        '1',
        '9200'
    ];
    BOMB.CONST_URL = [
        BOMB.CONST.loginPageUrl,
        BOMB.CONST.loginProcessUrl,
        BOMB.CONST.logOutUrl
    ];

    BOMB.ajax = function(options, showLoader){

        if (!(BOMB.SUCCESS_COMMON_CODE_LIST.indexOf(options.url) > -1) && BOMB.contextPath != '/' ) {
            options.url = BOMB.contextPath+options.url;
        }
        //기존 요청 재요청 불가
        if (BOMB.ajaxHistory.indexOf(options.url) > -1) {
            return false;
        }

        BOMB.ajaxHistory.push(options.url);

        if( showLoader == null || showLoader instanceof undefined) {
            showLoader = true;
        }

        var _options = {
            'url'      : '',
            'method'   : 'GET', // GET, POST, PUT, DELETE
            'dataType' : 'json', // xml, html, script, json, jsonp, text
            'data'     : {}
        };

        $.extend(_options, options);
        $.extend(_options, {
            'beforeSend' : function(xhr, settings) {
                if (showLoader && ajaxCount++ == 0) {
                    //로딩바 시작
                    BOMB.loadingstart();
                }
                if(typeof options.beforeSend == 'function') {
                    options.beforeSend(xhr, settings);
                }
            },
            'success' : function(result, status, xhr) {
                if (xhr.status == 200 && BOMB.SUCCESS_COMMON_CODE_LIST.indexOf(result.code) > -1) {
                    if (typeof options.success == 'function') {
                        options.success(result, status, xhr);
                    }
                }
                else if (typeof result != 'undefined' && result.hasOwnProperty('application')) {
                    if (application.result
                        && application.result == 'success'
                        && typeof options.success == 'function') {
                        options.success(result, status, xhr);
                    }
                    else if(typeof options.error == 'function') {
                        options.error(xhr, status, result);
                    }
                }
                else {
                    options.error(xhr, status, result);
                }
            },
            'error' : function(xhr, status, error) {
                var statusCode = xhr.status;
                var errorMessage = xhr.responseJSON && xhr.responseJSON.msg ? xhr.responseJSON.msg  : '일시적인 오류가 발생하였습니다. 잠시 후에 다시 이용해주시기 바랍니다.';
                var errorCode = xhr.responseJSON && xhr.responseJSON.code ? xhr.responseJSON.code : '' ;

                if (statusCode == 401  ){ // 비로그인상태
                    if ( options.url != BOMB.CONST.loginProcessUrl) {
                        alert('로그인후 가능하십니다.');
                        location.href = BOMB.CONST.loginPageUrl;
                        return;
                    }
                } else if ( statusCode == 400 ){  //bad request
                    alert(errorMessage)
                } else if ( statusCode == 204 ){  //데이터 없음.
                    //options.error(xhr, status, error);
                } else {
                    alert('일시적인 오류가 발생하였습니다. 잠시 후에 다시 이용해주시기 바랍니다.');
                }

                if(typeof options.error == 'function') {
                    options.error(xhr, status, error);
                }

            },
            'complete' : function(xhr, status) {
                if(typeof options.complete == 'function') {
                    options.complete(xhr, status);
                }
                if(showLoader && --ajaxCount == 0) {
                    BOMB.loadingEnd();
                }
                BOMB.ajaxHistory.removeItem(options.url);
            }


        });

        $.ajax(_options);

    }

})(jQuery);





