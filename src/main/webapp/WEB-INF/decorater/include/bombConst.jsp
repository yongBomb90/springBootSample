<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="<%= request.getContextPath()%>"></c:set>
<script>
    var BOMB = BOMB? BOMB : {};
    BOMB.contextPath = '${contextPath}';
    <sec:authorize access="!isAuthenticated()">
    BOMB.loginYn = 'N';
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
    BOMB.loginYn = 'Y';
    </sec:authorize>
    BOMB.CONST = {
        //로그인 관련
        loginPageUrl : '<spring:eval expression="@properties.getProperty(\'juvis.mall.prop.auth.login-page-url\')"></spring:eval>',
        loginProcessUrl : '<spring:eval expression="@properties.getProperty(\'juvis.mall.prop.auth.login-process-url\')"></spring:eval>',
        logOutUrl : '<spring:eval expression="@properties.getProperty(\'juvis.mall.prop.auth.logout-url\')"></spring:eval>',
        userNameParam : '<spring:eval expression="@properties.getProperty(\'juvis.mall.prop.auth.user-name-param\')"></spring:eval>',
        pwParam : '<spring:eval expression="@properties.getProperty(\'juvis.mall.prop.auth.password-param\')"></spring:eval>',
        rememParam : '<spring:eval expression="@properties.getProperty(\'juvis.mall.prop.auth.remember-me-param\')"></spring:eval>'
    }

</script>