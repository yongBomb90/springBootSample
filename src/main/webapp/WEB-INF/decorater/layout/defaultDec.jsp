<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="ko" xml:lang="ko">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="Content-Script-Type" content="text/javascript">
    <meta http-equiv="Content-Style-Type" content="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
    <meta name="description" content="쥬비스몰은 건강하고 행복한 삶을 도와드리는 다이어트 식품과 헬스케어 제품을 판매하는 프리미엄 쇼핑몰입니다.">
    <meta name="viewport" content="width=1200">
    <meta name="format-detection" content="telephone=no">

    <title><sitemesh:write property='title'/> | JUVIS MALL</title>


    <%--19.07.02 favicon 추가 START--%>
    <link rel="apple-touch-icon" sizes="57x57" href="<c:url value='/assets/images/favicon/apple-icon-57x57.png'/>">
    <link rel="apple-touch-icon" sizes="60x60" href="<c:url value='/assets/images/favicon/apple-icon-60x60.png'/>">
    <link rel="apple-touch-icon" sizes="72x72" href="<c:url value='/assets/images/favicon/apple-icon-72x72.png'/>">
    <link rel="apple-touch-icon" sizes="76x76" href="<c:url value='/assets/images/favicon/apple-icon-76x76.png'/>">
    <link rel="apple-touch-icon" sizes="114x114" href="<c:url value='/assets/images/favicon/apple-icon-114x114.png'/>">
    <link rel="apple-touch-icon" sizes="120x120" href="<c:url value='/assets/images/favicon/apple-icon-120x120.png'/>">
    <link rel="apple-touch-icon" sizes="144x144" href="<c:url value='/assets/images/favicon/apple-icon-144x144.png'/>">
    <link rel="apple-touch-icon" sizes="152x152" href="<c:url value='/assets/images/favicon/apple-icon-152x152.png'/>">
    <link rel="apple-touch-icon" sizes="180x180" href="<c:url value='/assets/images/favicon/apple-icon-180x180.png'/>">
    <link rel="icon" type="image/png" sizes="192x192"  href="<c:url value='/assets/images/favicon/android-icon-192x192.png'/>">
    <link rel="icon" type="image/png" sizes="32x32" href="<c:url value='/assets/images/favicon/favicon-32x32.png'/>">
    <link rel="icon" type="image/png" sizes="96x96" href="<c:url value='/assets/images/favicon/favicon-96x96.png'/>">
    <link rel="icon" type="image/png" sizes="16x16" href="<c:url value='/assets/images/favicon/favicon-16x16.png'/>">
    <%--19.07.02 favicon 추가 END--%>
    <%@ include file="/WEB-INF/decorater/include/styles.jsp" %>
    <%@ include file="/WEB-INF/decorater/include/bombConst.jsp" %>
    <%@ include file="/WEB-INF/decorater/include/script.jsp" %>

    <sitemesh:write property='head'/>



</head>
<body class="js">
    <div id="wrap" class="<sitemesh:write property='meta.bodyClass'/>">
        <%@ include file="/WEB-INF/decorater/include/header.jsp" %>
        <!--Content-->
        <div id="container" class="container">
            <sitemesh:write property='body'/>
            <%@ include file="/WEB-INF/decorater/include/kakaoFooter.jsp" %>
        </div>
        <!--//Content-->

        <%@ include file="/WEB-INF/decorater/include/footer.jsp" %>
    </div>
</body>

