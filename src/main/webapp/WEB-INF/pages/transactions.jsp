<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sprin" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <jsp:include page="parts/variables.jsp"/>
    <link href="${stylesUrl}/bootstrap/bootstrap-datepicker.min.css" rel="stylesheet">
    <link href="${stylesUrl}/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="${stylesUrl}/style.css" rel="stylesheet">

</head>
<body>
<jsp:include page="parts/header.jsp"/>
<div class="container">

    <div class="panel panel-default">
        <div class="panel-heading">
            <h2 class="panel-title">
                <a data-toggle="collapse" href="#transactionFilterForm">Transactions Filtering</a>
            </h2>
        </div>
        <form:form id="transactionFilterForm" modelAttribute="filter"
                   action="${transactionsUrl}/filter" method="get" cssClass="collapse in">
            <div class="row">
                <c:forEach items="${transactionTypes}" var="typeEntry" varStatus="loop">
                    <div class="col-lg-3">
                        <label><form:checkbox path="types[${loop.index}]"
                                              value="${typeEntry.key}"/>${typeEntry.value}</label>
                    </div>
                </c:forEach>
            </div>

            <div class="row">
                <fieldset class="form-group col-lg-6">
                    <label>Source Account</label>
                    <form:select path="sourceAccountId" items="${selectOptions}" cssClass="form-control"/>
                </fieldset>
                <fieldset class="form-group col-lg-6">
                    <label>Target Account</label>
                    <form:select path="targetAccountId" items="${selectOptions}" cssClass="form-control"/>
                </fieldset>
            </div>

            <div class="row">
                <div class="col-lg-6">
                    <label>Start Date</label>
                    <div class="input-group date" data-provide="datepicker">
                        <form:input type="text" path="minDate" cssClass="form-control"/>
                        <div class="input-group-addon">
                            <span class="glyphicon glyphicon-th"></span>
                        </div>
                    </div>
                </div>

                <div class="col-lg-6">
                    <label>End Date</label>
                    <div class="input-group date" data-provide="datepicker">
                        <form:input type="text" path="maxDate" cssClass="form-control"/>
                        <div class="input-group-addon">
                            <span class="glyphicon glyphicon-th"></span>
                        </div>
                    </div>
                </div>
            </div>

            <input type="submit" class="btn btn-default " value="Filter">
            <input type="reset" class="btn btn-default" value="Clear">

        </form:form>

    </div>
    <h2>Transactions</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>date</th>
            <th>source account</th>
            <th>target account</th>
            <th>money amount</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="transaction" items="${transactions}">
            <tr>
                <td>${transaction.id}</td>
                <td><fmt:formatDate value="${transaction.date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>
                    <c:choose>
                        <c:when test="${transaction.type=='DEPOSIT'}">
                            -
                        </c:when>
                        <c:otherwise>
                            ${transaction.sourceAccount.name}
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                    <c:when test="${transaction.type=='WITHDRAW'}">
                    -
                    </c:when>
                    <c:otherwise>
                        ${transaction.targetAccount.name}
                    </c:otherwise>
                    </c:choose>
                <td>${transaction.moneyAmount}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="${scriptsUrl}/bootstrap/bootstrap.min.js"></script>
<script src="${scriptsUrl}/bootstrap/bootstrap-datepicker.min.js"></script>
<script src="${scriptsUrl}/form-errors.js"></script>

</body>
</html>