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



<script>
    // 모달 버튼에 이벤트를 건다.
    $('.loginBtn').on('click', function(){
        $('#loginModal').modal('show');
    });

</script>

</body>
</html>
