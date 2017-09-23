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

    <title>Pandora | newProject</title>

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
    <article class="jumbotron">
        <h2 class="pandora-profile-logo"><fmt:message key="label.project.new"/></h2>
        <div class="form-group">
            <%--<form class="form-horizontal" action="${contextPath}/project/newProject" method="post">
                <div class="form-group row">
                    <label class="col-xs-3 pandora-text-label">Название</label>
                    <div class="input-group col-xs-6">
                        <input type="text" class="form-control" required="required">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-xs-3 pandora-text-label">Основная цель</label>
                    <div class="input-group col-xs-6">
                        <input type="text" class="form-control" required="required">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-xs-3 pandora-text-label">Дата оканчания сбора средств</label>
                    <div class="input-group col-xs-6">
                        <input type="date" class="form-control" required="required">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-xs-3 pandora-text-label">Описание проекта</label>
                    <div class="input-group col-xs-6">
                        <textarea class="form-control col-xs-12" required="required" rows="10"></textarea>
                    </div>
                </div>
            </form>--%>


            <form:form method="POST" modelAttribute="newProjectForm" class="form-horizontal">
                <h2 class="pandora-profile-logo"><fmt:message key="label.project.new"/></h2>
                <div class="form-group row">
                    <label class="col-xs-3 pandora-text-label">Название</label>
                    <div class="input-group col-xs-6">
                        <form:input type="text" path="name" class="form-control"></form:input>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-xs-3 pandora-text-label">Описание</label>
                    <div class="input-group col-xs-6">
                        <form:input type="text" path="description" class="form-control"></form:input>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-xs-3 pandora-text-label">Дата оканчания сбора средств</label>
                    <div class="input-group col-xs-6">
                        <form:input type="date" path="finishDate" class="form-control"></form:input>
                    </div>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit">
                    <fmt:message key="label.submit"/>
                </button>
            </form:form>
        </div>
        <%@include file="../../WEB-INF/jspf/footer.jsp" %>
    </article>
</div>

<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
