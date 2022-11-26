<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page isErrorPage="true" %>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) --> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Functions --> 
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read Share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="d-flex justify-content-around p-3">
	<div class="col-6 border border-white p-3">
		<form:form action="/register" method="post" modelAttribute="newUser"
			class="form">
			<h2>Register:</h2>
			<div class="form-group">
				<form:label path="name">Name:</form:label>
				<form:input path="name" />
				<form:errors path="name" />
			</div>
			<div class="form-group">
				<form:label path="email">Email:</form:label>
				<form:input path="email" />
				<form:errors path="email" />
			</div>
			<div class="form-group">
				<form:label path="password">Password:</form:label>
				<form:input type="password" path="password"/>
				<form:errors path="password" />
			</div>
			<div class="form-group">
				<form:label path="confirm">Confirm Password:</form:label>
				<form:input type="password" path="confirm"/>
				<form:errors path="confirm" />
			</div>

			<button class="btn btn-outline-success">Register</button>
		</form:form>
	</div>
	<div class="col-6 border border-white p-3">
		<form:form action="/login" method="post" modelAttribute="newLogin"
			class="form">
			<h2>Login:</h2>
			<div class="form-group">
				<form:label path="email">Email:</form:label>
				<form:input path="email" />
				<form:errors path="email" />
			</div>
			<div class="form-group">
				<form:label path="password">Password:</form:label>
				<form:input type="password" path="password"/>
				<form:errors path="password" />
			</div>

			<button class="btn btn-outline-success">Login</button>
		</form:form>
	</div>
</div>

</body>
</body>
</html>