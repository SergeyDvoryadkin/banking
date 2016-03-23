<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>List of clients</title>
    <jsp:include page="parts/variables.jsp"/>
    <link href="${stylesUrl}/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="${stylesUrl}/style.css" rel="stylesheet">

</head>
<body>
<jsp:include page="parts/header.jsp"/>
<div class="container">
    <h2>Client list</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>name</th>
            <th>address</th>
            <th>age</th>
        </tr>

        </thead>
        <tbody>
        <c:if test="${not empty clients}">
            <c:forEach var="client" items="${clients}">

                <tr>
                    <td>${client.id}</td>
                    <td><a
                            href="<c:out value='${sessionScope.clientProfileUrl}'/>/${client.id}">${client.name}</a>
                    <td>${client.address}</td>
                    <td><c:choose>
                        <c:when test="${client.age > '0'}">
                            ${client.age}
                        </c:when>
                        <c:otherwise>
                            UNKNOWN
                        </c:otherwise>
                    </c:choose></td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>

    <hr/>


    <form:form action="${sessionScope.clientsUrl}" method="POST"
               modelAttribute="newClient">
        <h2>add client</h2>
        <div class="form-group" id="field-name">
            <label class="control-label">Name</label>
            <div class="row">
                <div class="col-lg-8"><form:input path="name" class="form-control"/></div>
                <div class="col-lg-4"><form:errors path="name" cssClass="control-label"/></div>
            </div>
        </div>
        <div class="form-group">
            <label for="address">Address</label>
            <div class="row">
                <div class="col-lg-8"><form:input path="address" class="form-control"/></div>
                <div class="col-lg-4"><form:errors path="address"/></div>
            </div>
        </div>
        <div class="form-group" id="field-age">
            <label for="age" class="control-label">Age</label>
            <div class="row">
                <div class="col-lg-8"><form:input path="age" cssClass="form-control"/></div>
                <div class="col-lg-4"><form:errors path="age" cssClass="control-label"/></div>
            </div>
        </div>
        <input type="submit" name="addClient" value="Add"
               class="btn btn-default"/>
    </form:form>
</div>
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="${scriptsUrl}/bootstrap/bootstrap.min.js"></script>
<script src="${scriptsUrl}/form-errors.js"></script>
</body>
</html>