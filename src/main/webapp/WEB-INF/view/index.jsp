<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head >
    <title>BOMB HOME</title>
    <style>
      .sold_out  {font-size:12px; color:#fff; margin-top:8px; background-color:#ff0000; text-align:center; padding:3px 5px; line-height:12px;}

    </style>
</head>
<body>
<div class="main_personalized">
    <div class="jumbotron">
        <h1 class="display-3">BOMB SAMPLE PAGE</h1>
        <p class="lead">개발자 박용범 스프링 샘플 페이지</p>
        <hr class="my-4">
        <p>자바 개발자 </p>
        <!--
        <p class="lead">
            <a class="btn btn-primary btn-lg" href="#" role="button">연락처</a>
        </p>
        -->
    </div>
</div>

<div class="modal" id="loginModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Modal body text goes here.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">Save changes</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<script>
    // 모달 버튼에 이벤트를 건다.
    $('.loginBtn').on('click', function(){
        $('#loginModal').modal('show');
    });

</script>

</body>
</html>
