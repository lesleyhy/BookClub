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
<title>Book Share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<h1>Add a book to your shelf!</h1>
	<a href="/books">Back to shelves</a>
	<form:form action="/book/create" method="post" modelAttribute="book" class="form">
		
		<div class="form-group">
			<form:label path="title">Title:</form:label>
			<form:input path="title" />
			<form:errors path="title" />
		</div>
		<div class="form-group">
			<form:label path="author">Author:</form:label>
			<form:input path="author" />
			<form:errors path="author" />
		</div>
		<div class="form-group">
			<form:label path="thought">My thoughts:</form:label>
			<form:textarea path="thought"/>
			<form:errors path="thought" />
		</div>
	
		<button class="btn btn-outline-success">Add a book</button>
	</form:form>
	

</body>
</html>