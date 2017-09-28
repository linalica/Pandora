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

    <title>Pandora | registration</title>

    <link href="https://fonts.googleapis.com/css?family=Noto+Serif" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=PT+Serif" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Patua+One" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Baloo+Bhaina" rel="stylesheet">
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/${visitor.theme}.css" rel="stylesheet">
    <link rel="shortcut icon" href="../../resources/css/pandora-letter-logo-icon.png" type="image/png">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <%--<script>$('#signInButton').click();</script>--%>
</head>
<body>
<%@include file="../../WEB-INF/jspf/header.jsp" %>
<div class="container-fluid">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <fmt:message key="label.email" var="fmtusername"/>
                <form:input type="email"
                            path="username"
                            class="form-control"
                            required="required"
                            placeholder="${fmtusername}"/>
                <form:errors path="username"/>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <fmt:message key="label.password" var="fmtpassword"/>
                <form:input type="password"
                            path="password"
                            class="form-control"
                            required="required"
                            placeholder="${fmtpassword}"/>
                <form:errors path="password"/>
            </div>
        </spring:bind>

        <spring:bind path="confirmPassword">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <fmt:message key="label.confirm.password" var="fmtconfpassword"/>
                <form:input type="password" path="confirmPassword"
                            class="form-control"
                            required="required"
                            placeholder="${fmtconfpassword}"/>
                <form:errors path="confirmPassword"/>
            </div>
        </spring:bind>
        <button class="btn btn-lg btn-primary btn-block" type="submit">
            <fmt:message key="label.submit"/>
        </button>
    </form:form>

</div>
<!-- /container -->
<%@include file="../../WEB-INF/jspf/footer.jsp" %>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
