<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<c:if
        test="${empty sessionScope.homeUrl or empty sessionScope.clientsUrl or empty sessionScope.clientProfileUrl or empty sessionScope.accountsUrl or empty transactionsUrl}">

    <spring:url value="/" var="homeUrl" scope="session"/>
    <spring:url value="/clients" var="clientsUrl" scope="session"/>
    <spring:url value="/clients/profile" var="clientProfileUrl" scope="session"/>
    <spring:url value="/accounts" var="accountsUrl" scope="session"/>
    <spring:url value="/transactions" var="transactionsUrl" scope="session"/>
    <spring:url value="/css" var="stylesUrl" scope="session"/>
    <spring:url value="/js" var="scriptsUrl" scope="session"/>

</c:if>