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
	<h1><c:out value="${ book.title }" /></h1>
	
	<p><c:out value="${ book.user.name }" /> read <c:out value="${ book.title }" /> by <c:out value="${ book.author }" /></p>
	<h2>Here are <c:out value="${ book.user.name }" />'s thoughts:</h2>
	<p><c:out value="${ book.thought }" /></p>

	<a href="/books">Back to shelves</a><br>
	
	<c:if test="${ book.user.id == loggedInUser.id}">
	<a href="/books/edit/${book.id}">Edit</a>
	<form action="/${book.id}/delete" method="post">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="Delete this Book" class="btn btn-danger">
	</form>
	</c:if>
	
</body>
</html>