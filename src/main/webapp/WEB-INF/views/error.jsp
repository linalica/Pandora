<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="roles" uri="http://itransition.by/pandora" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<fmt:setLocale value="${visitor.locale}"/>
<fmt:setBundle basename="properties.content"/>

<html>
<head>
    <meta charset="utf-8">

    <title><fmt:message key="label.error"/></title>

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

<main class="container">
    <div class="jumbotron">
        <h3 class="text-center"><fmt:message key="label.error"/></h3>

        <p>Request from ${pageContext.errorData.requestURI} is failed</p>
        <p>Servlet name or type: ${pageContext.errorData.servletName}</p>
        <p>Status code: ${pageContext.errorData.statusCode}</p>
        <p>Exception: ${pageContext.errorData.throwable}</p>

        <div class="text-center"><a href="${contextPath}/main"><h2><fmt:message key="label.to.main"/></h2></a></div>
    </div>
</main>

<%@include file="../../WEB-INF/jspf/footer.jsp" %>
</body>
</html>
