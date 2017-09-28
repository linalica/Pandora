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

    <title>Pandora | Error</title>

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

</head>
<body>
<main class="container-fluid">
    <div class="jumbotron">
        <h3 class="text-center"><fmt:message key="label.error"/></h3>

        <p>Request from ${pageContext.errorData.requestURI} is failed</p>
        <p>Servlet name or type: ${pageContext.errorData.servletName}</p>
        <p>Status code: ${pageContext.errorData.statusCode}</p>
        <p>Exception:</p>
            <textarea class="col-xs-10 form-control" rows="5"> ${pageContext.errorData.throwable} </textarea>

        <div class="text-center"><a href="${contextPath}/main"><h2><fmt:message key="label.to.main"/></h2></a></div>
    </div>
</main>
<%@include file="../../WEB-INF/jspf/footer.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
