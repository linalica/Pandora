<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="roles" uri="http://itransition.by/pandora" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<fmt:setLocale value="${visitor.locale}"/>
<fmt:setBundle basename="properties.content"/>

<html>
<head>
    <meta charset="utf-8">

    <title>Pandora | login</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/${visitor.theme}.css" rel="stylesheet">

<%--    <script src="${contextPath}/resources/js/jquery-3.1.1.min.js"></script>--%>
    <script src="${contextPath}/resources/js/jquery.form.min.js"></script>

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <script src="${contextPath}/resources/js/signAction.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</head>
<body>
<%@include file="../../WEB-INF/jspf/header.jsp" %>
<div class="container">




    <roles:guest principal="${pageContext.request.userPrincipal}">
        GUEST
    </roles:guest>
    <roles:user principal="${pageContext.request.userPrincipal}">
        USER
    </roles:user>
    <roles:admin principal="${pageContext.request.userPrincipal}">
        ADMIN
    </roles:admin>
    <roles:notguest principal="${pageContext.request.userPrincipal}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
        </h2>
    </roles:notguest>

    <%--<roles:guest principal="${pageContext.request.userPrincipal}">
        <form method="POST" action="${contextPath}/login" class="form-signin">
            <h2 class="form-heading"><fmt:message key="label.sign.in"/></h2>
            <div class="form-group ${error != null ? 'has-error' : ''}">
                &lt;%&ndash;<span>${message}</span>&ndash;%&gt;
                <input name="username" type="text" class="form-control" placeholder="Username"
                       autofocus="true"/>
                <input name="password" type="password" class="form-control" placeholder="Password"/>
                <span>${error}</span>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>

                <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
            </div>
        </form>
    </roles:guest>--%>
</div>
<%@include file="../../WEB-INF/jspf/footer.jsp" %>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
