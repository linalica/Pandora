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

    <title>Pandora | project</title>

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

    <table class="table no-border rounded">
        <tbody class="colorfulTable rounded">
        <tr>
            <td align="left" class="col-xs-2">
                <h4 class="text-center">
                    <img height="auto" width="300px"
                         src="${contextPath}/user/loadAvatarById/${project.creatorId}"
                         alt="projectPicture">
                </h4>
                <div class="panel panel-default">
                    <div class="panel-body">
                        <label>${project.creator.firstName} ${project.creator.lastName}</h4></label>
                    </div>
                </div>
            </td>
            <td align="left" class="col-xs-8">
                <table class="table mainTable rounded" bgcolor="white">
                    <tr>
                        <td>
                            <div class="row">
                                <div class="col-xs-4">
                                    <img height="auto" width="400px"
                                         src="${contextPath}/project/loadPicture/${project.id}"
                                         alt="projectPicture">
                                </div>
                                <div class="col-xs-8">
                                    <h4><label><fmt:message key="label.creator"/>: </label>
                                        ${project.creator.firstName} ${project.creator.lastName}</h4>
                                    <h4><label><fmt:message key="label.rating"/>:</label>
                                        ${project.rating}</h4>
                                    <h4><label><fmt:message key="label.status"/>:</label>
                                        ${project.status.name().toLowerCase()}</h4>
                                    <h4><label><fmt:message key="label.finish"/>:</label>
                                        <fmt:formatDate value="${project.finishDate}" pattern="yyyy-MM-dd"/>
                                    </h4>
                                    <h4><label><fmt:message key="label.balance"/>:</label>
                                        ${project.balance} / ${project.price} $
                                    </h4>
                                    <h4><label><fmt:message key="label.projects.subscriptions"/>:</label>
                                        ${project.subscriptions.size()}
                                    </h4>

                                    <roles:notguest principal="${pageContext.request.userPrincipal}">
                                        <div class="btn-toolbar" style="margin: 0;">
                                            <div class="btn-group ${project.marks.contains(pageContext.request.userPrincipal.getPrincipal().getUserId()) ? 'hidden' : ''}">
                                                <button type="button" class="btn btn-hover btn-default"
                                                        onclick="location.href = '${contextPath}/setMark?projectId=${project.id}&value=1'">
                                                    1
                                                </button>
                                                <button type="button" class="btn btn-hover btn-default"
                                                        onclick="location.href = '${contextPath}/setMark?projectId=${project.id}&value=2'">
                                                    2
                                                </button>
                                                <button type="button" class="btn btn-hover btn-default"
                                                        onclick="location.href = '${contextPath}/setMark?projectId=${project.id}&value=3'">
                                                    3
                                                </button>
                                                <button type="button" class="btn btn-hover btn-default"
                                                        onclick="location.href = '${contextPath}/setMark?projectId=${project.id}&value=4'">
                                                    4
                                                </button>
                                                <button type="button" class="btn btn-hover btn-default"
                                                        onclick="location.href = '${contextPath}/setMark?projectId=${project.id}&value=5'">
                                                    5
                                                </button>
                                            </div>
                                            <div class="btn-group">
                                                <c:set var="subMsg" scope="session" value="label.project.subscribe"/>
                                                <c:if test="${project.subscriptions.contains(pageContext.request.userPrincipal.getPrincipal().getUserId()) }">
                                                    <c:set var="subMsg" scope="session"
                                                           value="label.project.unsubscribe"/>
                                                </c:if>
                                                <form method="post"
                                                      action="${contextPath}/subscribe?projectId=${project.id}">
                                                    <button type="submit" class="btn btn-default">
                                                        <fmt:message key="${subMsg}"/>
                                                    </button>
                                                </form>
                                            </div>
                                        </div>
                                    </roles:notguest>


                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr bgcolor="#F2CCCC">
                        <td>
                            <h3><label>${project.name}</label></h3>
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <label><fmt:message key="label.project.objectives"/></label>
                                    <table align="left" class="table table-hover">
                                        <tbody>
                                        <c:forEach items="${project.getObjectives()}" var="obj">
                                            <tr>
                                                <td>
                                                    <a data-toggle="collapse" data-parent="#collapse-group"
                                                       href="#el${obj.id}">
                                                        <table class="table-hover col-xs-12">
                                                            <tbody>
                                                            <tr>
                                                                <td class="col-xs-3">${obj.balance} / ${obj.price} $</td>
                                                                <td class="col-xs-9">${obj.name}</td>
                                                            </tr>
                                                            </tbody>
                                                        </table>
                                                    </a>
                                                    <div id="el${obj.id}" class="panel-collapse collapse">
                                                        <div class="panel-body text-center">
                                                            <br>
                                                            <button type="button" class="btn btn-hover btn-info"
                                                                    onclick="location.href = '${contextPath}/doPayment?objectiveId=${obj.id}'">
                                                                <fmt:message key="label.support.goal"/>
                                                            </button>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr bgcolor="#dcdcdc">
                        <td>
                            <label><fmt:message key="label.project.description"/></label>
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    ${project.description}
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr bgcolor="#C2CEDC">
                        <td>
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <label><fmt:message key="label.project.comments"/></label>
                                    <table align="left" class="table table-hover">
                                        <tbody>
                                        <c:forEach items="${project.getComments()}" var="comm">
                                            <tr>
                                                <td class="col-xs-2">${comm.text}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        </tbody>
    </table>
</div><!-- /container -->
<%@include file="../jspf/footer.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
