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

    <title>Pandora | My projects</title>

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

    <div class="panel panel-default">
        <div class="panel-body">
            <h2 align="center" class="pandora-font"><fmt:message key="label.projects.mine"/></h2>
        </div>
    </div>

    <table class="table no-border rounded">
        <tbody class="colorfulTable rounded">
        <c:forEach items="${projectList}" var="project">
            <tr>
                <td align="left" class="col-xs-2">
                    <h4 class="text-center">
                        <img height="300" width="300"
                             src="${contextPath}/project/loadPicture/${project.id}"
                             alt="projectPicture">
                    </h4>
                </td>
                <td align="left" class="col-xs-8">
                    <table class="table mainTable rounded" bgcolor="white">
                        <tr>
                            <td>
                                <h3><label class="pandora-font">${project.name}</label></h3>
                                <h4><label><fmt:message key="label.balance"/>:</label>
                                        ${project.balance} / ${project.price} $
                                </h4>
                                <div class="panel panel-default">
                                    <div class="panel-body">
                                        <label><fmt:message key="label.project.objectives"/></label>
                                        <table align="left" class="table table-hover">
                                            <tbody>
                                            <c:forEach items="${project.getObjectives()}" var="obj">
                                                <tr>
                                                    <td class="col-xs-2">${obj.price}</td>
                                                    <td class="col-xs-10">${obj.name}</td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="panel panel-default">
                                    <div class="panel-body">
                                        <form:form method="POST" modelAttribute="addObjectForm"
                                                   action="${contextPath}/addObject?projectId=${project.id}">
                                            <label><fmt:message key="label.objective.add"/></label>
                                            <div class="form-group row">
                                                <p class="col-xs-3"><fmt:message
                                                        key="label.objective.name"/></p>
                                                <div class="input-group col-xs-6">
                                                    <form:input type="text" path="name" class="form-control"
                                                                required="required"
                                                                placeholder="${fmtname}"/>
                                                    <form:errors path="name"></form:errors>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <p class="col-xs-3"><fmt:message
                                                        key="label.objective.price"/></p>
                                                <div class="input-group col-xs-6">
                                                    <form:input type="number" path="price" class="form-control"
                                                                required="required" placeholder="${fmtname}"
                                                                min="10" max="1000000" value="1000"></form:input>
                                                    <form:errors path="price"></form:errors>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <p class="col-xs-3"><fmt:message
                                                        key="label.objective.is.min"/></p>
                                                <div class="input-group col-xs-6">
                                                    <form:checkbox path="min"></form:checkbox>
                                                    <form:errors path="min"></form:errors>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <p class="col-xs-3"></p>
                                                <div class="input-group col-xs-6">
                                                    <button class="btn btn-default pull-left" type="submit">
                                                        <fmt:message key="label.objective.add"/>
                                                    </button>
                                                </div>
                                            </div>
                                        </form:form>
                                    </div>

                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="panel panel-default">
                                    <div class="panel-body">
                                        <label><fmt:message key="label.project.change.picture"/></label>
                                        <form id="changePictureForm" enctype="multipart/form-data" method="post"
                                              action="${contextPath}/project/changePicture/${project.id}">
                                            <div class="form-group-lg">
                                                <input id="changePicture" type="file" name="picture"
                                                       class="form-control">
                                            </div>
                                            <button type="submit"
                                                    class="btn btn-primary pull-right"><fmt:message
                                                    key="label.submit"/></button>
                                        </form>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr bgcolor="#dcdcdc">
                            <td>
                                    ${project.description}
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div><!-- /container -->
<%@include file="../jspf/footer.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
