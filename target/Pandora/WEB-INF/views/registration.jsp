<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<<<<<<< HEAD
=======
<%@ taglib prefix="roles" uri="http://itransition.by/pandora" %>
>>>>>>> new-start

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<fmt:setLocale value="${visitor.locale}"/>
<fmt:setBundle basename="properties.content"/>

<html>
<head>
    <meta charset="utf-8">

    <title>Pandora | registration</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<<<<<<< HEAD

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
=======
    <link href="${contextPath}/resources/css/${visitor.theme}.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <%--<script>$('#signInButton').click();</script>--%>
>>>>>>> new-start
</head>
<body>
<%@include file="../../WEB-INF/jspf/header.jsp" %>
<div class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading"><fmt:message key="label.sign.up"/></h2>
        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <fmt:message key="label.email" var="fmtusername"/>
                <form:input type="text"
                            path="username"
                            class="form-control"
                            required="required"
                            placeholder="${fmtusername}"></form:input>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <fmt:message key="label.password" var="fmtpassword"/>
                <form:input type="password"
                            path="password"
                            class="form-control"
                            required="required"
                            placeholder="${fmtpassword}"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="confirmPassword">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <fmt:message key="label.confirm.password" var="fmtconfpassword"/>
                <form:input type="password" path="confirmPassword"
                            class="form-control"
                            required="required"
                            placeholder="${fmtconfpassword}"></form:input>
                <form:errors path="confirmPassword"></form:errors>
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
