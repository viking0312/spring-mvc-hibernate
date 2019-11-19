<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New customer form</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />

</head>
<body>
	
	<div id="wrapper">
		<div id="header">
		
			<h2>Fill out the details</h2>
			<hr>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<form:form modelAttribute="customer" method="POST" action="processForm">
			
				<form:hidden path="id" />
			
				<table>
					<tr>
						<td><label>First Name:</label></td>
						<td><form:input path="firstName"/>
					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="lastName"/>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email"/>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="save" class="save"/>
					</tr>
				</table>
				
				<div style="clear;both;"></div>
				
				<p>
					<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
				</p>
			
			</form:form>
		</div>
	</div>
	

</body>
</html>