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

    <title>Pandora | Do purchase</title>

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
    <div class="panel panel-default">
        <div class="panel-body">
            <div clas="col-xs-3">
                <p><fmt:message key="text.payment.minimum"/></p>
                <p><fmt:message key="text.payment.maximum"/></p>
                <p><fmt:message key="text.payment.fractions"/></p>
                <p><fmt:message key="text.payment.account.number"/></p>
            </div>
            <div clas="col-xs-3">
                <h3><label><fmt:message key="label.purchase"/>:</label><br></h3>
                <h4><label><fmt:message key="label.projects"/>:</label><br>${project.name}</h4>
                <h4><label><fmt:message key="label.objective"/>:</label><br>${objective.name}</h4>
            </div>
            <br>
            <br>
            <div class="text-center">
                <form class="form-horizontal" action="${contextPath}/pay?objectiveId=${objective.id}" method="post">
                    <div class="form-group has-feedback">
                        <label class="col-xs-3"><fmt:message key="label.payment.account.number"/></label>
                        <div class="input-group col-xs-4">
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-pencil"></span>
                        </span>
                            <input type="number" class="form-control inputAddMoney" required="required"
                                   name="accountNumber" id="accountNumber"
                                   min="1000000000000000"
                                   max="9999999999999999"
                                   placeholder="<fmt:message key="label.payment.account.number"/>">
                            <span class="glyphicon form-control-feedback"></span>
                        </div>
                    </div>
                    <div class="form-group has-feedback">
                        <label class="col-xs-3"><fmt:message key="label.payment.amount"/></label>
                        <div class="input-group col-xs-4">
                         <span class="input-group-addon">
                            <span class="glyphicon glyphicon-usd"></span>
                        </span>
                            <input type="number" class="form-control inputAddMoney" required="required"
                                   name="paymentAmount" id="paymentAmount"
                                   min="10"
                                   max="10000"
                                   placeholder="<fmt:message key="label.payment.amount"/>">
                            <span class="glyphicon form-control-feedback"></span>
                        </div>
                    </div>
                    <div class="modal-footer has-feedback" style="width: 70%">
                        <button type="submit" name="command" id="addMoneyAction" value="addMoney"
                                class="btn btn-primary">
                            <fmt:message key="label.submit"/></button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div><!-- /container -->
<%@include file="../../WEB-INF/jspf/footer.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
