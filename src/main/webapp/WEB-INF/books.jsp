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
		<div>
			<h1>
				Welcome, <c:out value="${loggedInUser.name}" />
			</h1>
			<p>Books from everyone's shelves:</p>
		</div>
		<div>
			<a href="/logout">Log out</a><br>
			<a href="/books/new">+Add a to my shelf</a>			
		</div>
	</div>
	<div class="d-flex justify-content-around p-3">
		<div class="col-6 border border-dark p-3">
			<table class="table table-striped">
				<thead class="table-dark">
					<tr scope="row">
						<th>ID</th>
						<th>Title</th>
						<th>Author Name</th>
						<th>Posted By</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="b" items="${allBook}">
						<tr scope="row">
							<td><c:out value="${b.id}"/></td>
							<td><a href="/books/${b.id}"><c:out value="${b.title}"/></a></td>
							<td><c:out value="${b.author}"/></td>
							<td><c:out value="${b.user.name}"/></td>							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		 </div>
	</div>

</body>
</html>