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
<title>Edit</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<h1>Edit <c:out value="${ book.title }" /></h1>
	<form:form action="/${book.id}/update" method="post" modelAttribute="book" class="form">
	<input type="hidden" name="_method" value="put">
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
	
		<button class="btn btn-outline-success">Edit</button>
	</form:form>
	<a href="/books">Back to shelves</a>

</body>
</html>