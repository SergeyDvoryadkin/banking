<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <jsp:include page="parts/variables.jsp"/>
    <link href="${stylesUrl}/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="${stylesUrl}/style.css" rel="stylesheet">

    <title>Client Details</title>

</head>
<body>

<jsp:include page="parts/header.jsp"/>

<div class="container">
    <div class="panel panel-default panel-short">
        <div class="panel-heading">
            <h2 class="panel-title">details</h2>
        </div>
        <div class="panel-body">
            <table class="table">
                <tr>
                    <th>Name</th>
                    <td>${client.name}</td>
                </tr>
                <tr>
                    <th>Address</th>
                    <td>${client.address}</td>
                </tr>
                <tr>
                    <th>Age</th>
                    <td><c:choose>
                        <c:when test="${client.age > '0'}">
                            ${client.age}
                        </c:when>
                        <c:otherwise>
                            UNKNOWN
                        </c:otherwise>
                    </c:choose></td>
                </tr>
            </table>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h2 class="panel-title">accounts</h2>
        </div>
        <div class="panel-body">
            <table class="table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Account Name</th>
                    <th>Amount of Money</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="account" items="${client.accounts}">
                    <tr>
                        <td>${account.id}</td>
                        <td>${account.name}</td>
                        <td>${account.moneyAmount}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td><strong>Total</strong></td>
                    <td></td>
                    <td><strong>${total}</strong></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

    <form:form action="${sessionScope.clientProfileUrl}/${client.id}"
               modelAttribute="newAccount" method="post">
        <h2>create account</h2>

        <div class="form-group" id="field-moneyAmount">
            <label for="moneyAmount" class="control-label">Money Ammount</label>
            <div class="row">
                <div class="col-lg-8"><form:input path="moneyAmount" cssClass="form-control"/></div>
                <div class="col-lg-4"><form:errors path="moneyAmount" cssClass="control-label"/></div>
            </div>
        </div>

        <div class="form-group" id="field-name">
            <label for="name" class="control-label">Account name</label>
            <div class="row">
                <div class="col-lg-8"><form:input path="name" class="form-control"/></div>
                <div class="col-lg-4"><form:errors path="name" cssClass="control-label"/></div>
            </div>
        </div>

        <input class="btn btn-default" type="submit" value="Add"
               name="addAccount"/>
    </form:form>
</div>

<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="${scriptsUrl}/bootstrap/bootstrap.min.js"></script>
<script src="${scriptsUrl}/form-errors.js"></script>
</body>
</html>