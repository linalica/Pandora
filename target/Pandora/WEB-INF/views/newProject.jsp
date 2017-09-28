<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="roles" uri="http://itransition.by/pandora" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<fmt:setLocale value="${visitor.locale}"/>
<fmt:setBundle basename="properties.content"/>

<jsp:useBean id="dateToday" class="java.util.Date"/>
<fmt:formatDate var="now" value="${dateToday}" pattern="yyyy-MM-dd"/>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Pandora | Create project</title>

    <link href="https://fonts.googleapis.com/css?family=Noto+Serif" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=PT+Serif" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Patua+One" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Baloo+Bhaina" rel="stylesheet">
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/${visitor.theme}.css" rel="stylesheet">
    <link rel="shortcut icon" href="../../resources/css/pandora-letter-logo-icon.png" type="image/png">

    <%--    <script src="${contextPath}/resources/js/jquery-3.1.1.min.js"></script>--%>
    <script src="${contextPath}/resources/js/jquery.form.min.js"></script>

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</head>
<body>
<%@include file="../jspf/header.jsp" %>
<div class="container-fluid">
    <article class="jumbotron">
        <div class="form-group">
            <form:form method="POST" modelAttribute="newProjectForm" class="form-horizontal"
                        acceptCharset="UTF-8">
                <h2 class="pandora-profile-logo"><fmt:message key="label.project.new"/></h2>
                <div class="form-group row">
                    <label class="col-xs-3 pandora-text-label"><fmt:message key="label.project.name"/></label>
                    <div class="input-group col-xs-6">
                        <form:input type="text" path="name" required="required" class="form-control"/>
                        <form:errors path="name"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-xs-3 pandora-text-label"><fmt:message key="label.project.finish.date"/></label>
                    <div class="input-group col-xs-6">
                        <form:input type="date" path="finishDate" required="required" class="form-control"
                                    min="${now}" value="${now}" max="2018-12-30"/>
                    </div>
                </div>
                <div class="form-group row ${error != null ? 'has-error' : ''}">
                    <label class="col-xs-3 pandora-text-label"><fmt:message key="label.objective.main"/></label>
                    <div class="input-group col-xs-6">
                        <input type="text" class="form-control" required="required" name="projectMainObjectiveName"
                        value="${value}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-xs-3 pandora-text-label"><fmt:message key="label.objective.main.price"/></label>
                    <div class="input-group col-xs-6">
                        <input type="number" class="form-control" required="required" name="projectMainObjectivePrice"
                               min="10" max="1000000" value="1000">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-xs-3 pandora-text-label"><fmt:message key="label.project.description"/></label>
                    <div class="input-group col-xs-6">
                        <form:textarea type="text" path="description" required="required" class="form-control" rows="5"/>
                        <form:errors path="description"/>
                    </div>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit">
                    <fmt:message key="label.submit"/>
                </button>
            </form:form>
        </div>
    </article>
</div>
<%@include file="../jspf/footer.jsp" %>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
