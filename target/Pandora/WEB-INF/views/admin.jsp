<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

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

    <title>Pandora | Admin</title>

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
    <script src="${contextPath}/resources/js/signAction.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</head>
<body>
<%@include file="../jspf/header.jsp" %>
<div class="container-fluid">
    <div class="panel panel-default">
        <div class="panel-body">
            <label>Find user by username</label>
            <form class="form-search" method="get" action="${contextPath}/searchUser">
                <input type="text" class="form-control col-xs-3" name="username">
                <button type="submit" class="btn col-xs-1">Search</button>
            </form>
        </div>
        <c:if test="${userRequired != null}">
            <div class="panel-body">
                <table align="left" class="table">
                    <tbody>
                    <tr>
                        <td class="col-xs-2"><label><fmt:message key="label.user.username"/></label></td>
                        <td class="col-xs-10">${userRequired.username}</td>
                    </tr>
                    <tr>
                        <td class="col-xs-2"><label><fmt:message key="label.user.role"/></label></td>
                        <td class="col-xs-10">${userRequired.role}</td>
                    </tr>
                    <tr>
                        <td class="col-xs-2"><label><fmt:message key="label.user.enabled"/></label></td>
                        <td class="col-xs-10">${userRequired.enabled}</td>
                    </tr>
                    <tr>
                        <td class="col-xs-2"><label><fmt:message key="label.user.lastName"/></label></td>
                        <td class="col-xs-10">${userRequired.lastName}</td>
                    </tr>
                    <tr>
                        <td class="col-xs-2"><label><fmt:message key="label.user.firstName"/></label></td>
                        <td class="col-xs-10">${userRequired.firstName}</td>
                    </tr>
                    <tr>
                        <td class="col-xs-2"><label><fmt:message key="label.user.birthday"/></label></td>
                        <td class="col-xs-10">${userRequired.birthday}</td>
                    </tr>
                    <tr>
                        <td class="col-xs-2"><label><fmt:message key="label.user.lastLoginTime"/></label></td>
                        <td class="col-xs-10">${userRequired.lastLoginTime}</td>
                    </tr>
                    <tr>
                        <td class="col-xs-2"><label><fmt:message key="label.user.creatingTime"/></label></td>
                        <td class="col-xs-10">${userRequired.creatingTime}</td>
                    </tr>
                    <tr>
                        <td class="col-xs-2"><label><fmt:message key="label.user.locale"/></label></td>
                        <td class="col-xs-10">${userRequired.locale}</td>
                    </tr>
                    <tr>
                        <td class="col-xs-2"><label><fmt:message key="label.user.theme"/></label></td>
                        <td class="col-xs-10">${userRequired.theme}</td>
                    </tr>
                    <tr>
                        <td>
                            <c:if test="${userRequired.enabled}">
                                <button type="button" class="btn btn-hover btn-warning"
                                        onclick="location.href = '${contextPath}/banUser?userId=${userRequired.id}'">
                                    <fmt:message key="label.user.ban"/>
                                </button>
                            </c:if>
                            <c:if test="${!userRequired.enabled}">
                                <button type="button" class="btn btn-hover btn-warning"
                                        onclick="location.href = '${contextPath}/diluteUser?userId=${userRequired.id}'">
                                    <fmt:message key="label.user.dilute"/>
                                </button>
                            </c:if>
                        </td>
                        <td>
                            <button type="button" class="btn btn-hover btn-danger"
                                    onclick="location.href = '${contextPath}/deleteUser?userId=${userRequired.id}'">
                                <fmt:message key="label.user.delete"/>
                            </button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </c:if>
    </div>

</div><!-- /container -->
<%@include file="../../WEB-INF/jspf/footer.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
