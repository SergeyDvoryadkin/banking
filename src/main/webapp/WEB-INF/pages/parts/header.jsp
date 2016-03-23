<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<ul class="nav navbar-nav">
				<li><a class="navbar-brand" href="${sessionScope.homeUrl}">Home</a></li>
				<li><a class="navbar-brand" href="${sessionScope.clientsUrl}">Clients</a></li>
				<li><a class="navbar-brand" href="${sessionScope.accountsUrl}">Accounts</a></li>
				<li><a class="navbar-brand"
					href="${sessionScope.transactionsUrl}">Transactions</a></li>
			</ul>
		</div>
	</div>
</nav>