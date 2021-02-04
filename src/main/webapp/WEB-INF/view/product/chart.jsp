<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
<h4> chart.js </h4>
<br>
<h4> 그냥</h4>

<form method="post" action="/product/chart">
    <input type="text" name="memId"> <br>
    <input type="text" name="memPw"> <br>
    <button>로그인</button>
</form>

<h4>멀티파트</h4>
<form method="post" action="/product/chart"  enctype="multipart/form-data">
    <input type="text" name="prdName"> <br>
    <input type="text" name="memPw"> <br>
    <input type="file" name="file"><br />

    <button>로그인</button>
</form>




</body>
</html>
