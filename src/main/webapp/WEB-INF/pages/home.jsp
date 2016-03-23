<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Home</title>
    <jsp:include page="parts/variables.jsp"/>
    <link href="${stylesUrl}/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="${stylesUrl}/style.css" rel="stylesheet">

</head>
<body>
<jsp:include page="parts/header.jsp"/>
<div class="container">
    <h1>Banking project</h1>
</div>

<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="${scriptsUrl}/bootstrap/bootstrap.min.js"></script>
<script src="${scriptsUrl}/form-errors.js"></script>
</body>
</html>