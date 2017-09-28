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

    <title>Pandora</title>

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

    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>

    <%--
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>--%>

</head>
<body>
<%@include file="../../WEB-INF/jspf/header.jsp" %>
<div class="container-fluid">
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
                <img src="${contextPath}/main/loadMainPicture" alt="Pandora" style="width:100%;">
            </div>
            <div class="item">
                <img src="${contextPath}/main/loadBeautifulPicture" alt="New york" style="width:100%;">
            </div>
            <div class="item">
                <img src="${contextPath}/main/loadNyPicture" alt="Field" style="width:100%;">
            </div>
        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <br>
    <div class="panel panel-default">
        <div class="panel-body">
            <h1 align="center" class="pandora-font"><fmt:message key="label.projects.popular"/></h1>
        </div>
    </div>

    <table class="table no-border">
        <tbody class="colorfulTable">
        <c:forEach items="${projectListPopular}" var="project">
            <tr>
                <td align="left" class="col-xs-2">
                    <h4 class="text-center">
                        <img height="auto" width="300"
                             src="${contextPath}/project/loadPicture/${project.id}"
                             alt="projectPicture">
                    </h4>
                </td>
                <td align="left" class="col-xs-8">
                    <table class="table mainTable" bgcolor="white">
                        <tr class="table-rounded"></tr>
                        <tr>
                            <td>
                                <div class="col-xs-2 row">
                                    <img height="auto" width="150"
                                         src="${contextPath}/user/loadAvatarById/${project.creatorId}"
                                         alt="projectPicture">
                                    <h4 class="pandora-font">${project.creator.firstName} ${project.creator.lastName}</h4>
                                </div>
                                <div class="col-xs-10 left">
                                    <a href="${contextPath}/project?projectId=${project.id}">
                                        <h2 class="pandora-font">${project.name}</h2>
                                    </a>
                                    <div class="panel panel-default">
                                        <div class="panel-body">
                                            <h4><label><fmt:message key="label.rating"/>:</label>
                                                    ${project.rating}</h4>
                                            <h4><label><fmt:message key="label.finish"/>:</label>
                                                <fmt:formatDate value="${project.finishDate}" pattern="yyyy-MM-dd"/>
                                            </h4>
                                            <h4><label><fmt:message key="label.balance"/>:</label>
                                                    ${project.balance} / ${project.price} $
                                            </h4>
                                            <table align="left">
                                                <tbody>
                                                <c:forEach items="${project.getObjectives()}" var="obj">
                                                    <tr>
                                                        <td class="col-xs-3">${obj.balance} / ${obj.price} $</td>
                                                        <td class="col-xs-9">${obj.name}</td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr bgcolor="#dcdcdc">
                            <td>
                                    ${project.description}
                            </td>
                        </tr>
                        <tr class="table-rounded"></tr>
                    </table>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="panel panel-default">
        <div class="panel-body">
            <h1 align="center" class="pandora-font"><fmt:message key="label.projects.latest"/></h1>
        </div>
    </div> <%--projectListLatest--%>

    <table class="table no-border">
        <tbody class="colorfulTable">
        <c:forEach items="${projectListLatest}" var="project">
            <tr>
                <td align="left" class="col-xs-2">
                    <h4 class="text-center">
                        <img height="auto" width="300"
                             src="${contextPath}/project/loadPicture/${project.id}"
                             alt="projectPicture">
                    </h4>
                </td>
                <td align="left" class="col-xs-8">
                    <table class="table mainTable" bgcolor="white">
                        <tr class="table-rounded"></tr>
                        <tr>
                            <td>
                                <div class="col-xs-2 row">
                                    <img height="auto" width="150"
                                         src="${contextPath}/user/loadAvatarById/${project.creatorId}"
                                         alt="projectPicture">
                                    <h4 class="pandora-font">${project.creator.firstName} ${project.creator.lastName}</h4>
                                </div>
                                <div class="col-xs-10 left">
                                    <a href="${contextPath}/project?projectId=${project.id}">
                                        <h2 class="pandora-font">${project.name}</h2>
                                    </a>
                                    <div class="panel panel-default">
                                        <div class="panel-body">
                                            <h4><label><fmt:message key="label.rating"/>:</label>
                                                    ${project.rating}</h4>
                                            <h4><label><fmt:message key="label.finish"/>:</label>
                                                <fmt:formatDate value="${project.finishDate}" pattern="yyyy-MM-dd"/>
                                            </h4>
                                            <h4><label><fmt:message key="label.balance"/>:</label>
                                                    ${project.balance} / ${project.price} $
                                            </h4>
                                            <table align="left">
                                                <tbody>
                                                <c:forEach items="${project.getObjectives()}" var="obj">
                                                    <tr>
                                                        <td class="col-xs-3">${obj.balance} / ${obj.price} $</td>
                                                        <td class="col-xs-9">${obj.name}</td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr bgcolor="#dcdcdc">
                            <td>
                                    ${project.description}
                            </td>
                        </tr>
                        <tr class="table-rounded"></tr>
                    </table>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="panel panel-default">
        <div class="panel-body">
            <h1 align="center" class="pandora-font"><fmt:message key="label.projects.expiring"/></h1>
        </div>
    </div><%--projectListExpiring--%>

    <table class="table no-border">
        <tbody class="colorfulTable">
        <c:forEach items="${projectListExpiring}" var="project">
            <tr>
                <td align="left" class="col-xs-2">
                    <h4 class="text-center">
                        <img height="auto" width="300"
                             src="${contextPath}/project/loadPicture/${project.id}"
                             alt="projectPicture">
                    </h4>
                </td>
                <td align="left" class="col-xs-8">
                    <table class="table mainTable" bgcolor="white">
                        <tr class="table-rounded"></tr>
                        <tr>
                            <td>
                                <div class="col-xs-2 row">
                                    <img height="auto" width="150"
                                         src="${contextPath}/user/loadAvatarById/${project.creatorId}"
                                         alt="projectPicture">
                                    <h4 class="pandora-font">${project.creator.firstName} ${project.creator.lastName}</h4>
                                </div>
                                <div class="col-xs-10 left">
                                    <a href="${contextPath}/project?projectId=${project.id}">
                                        <h2 class="pandora-font">${project.name}</h2>
                                    </a>
                                    <div class="panel panel-default">
                                        <div class="panel-body">
                                            <h4><label><fmt:message key="label.rating"/>:</label>
                                                    ${project.rating}</h4>
                                            <h4><label><fmt:message key="label.finish"/>:</label>
                                                <fmt:formatDate value="${project.finishDate}" pattern="yyyy-MM-dd"/>
                                            </h4>
                                            <h4><label><fmt:message key="label.balance"/>:</label>
                                                    ${project.balance} / ${project.price} $
                                            </h4>
                                            <table align="left">
                                                <tbody>
                                                <c:forEach items="${project.getObjectives()}" var="obj">
                                                    <tr>
                                                        <td class="col-xs-3">${obj.balance} / ${obj.price} $</td>
                                                        <td class="col-xs-9">${obj.name}</td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr bgcolor="#dcdcdc">
                            <td>
                                    ${project.description}
                            </td>
                        </tr>
                        <tr class="table-rounded"></tr>
                    </table>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div><!-- /container -->
<%@include file="../../WEB-INF/jspf/footer.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
