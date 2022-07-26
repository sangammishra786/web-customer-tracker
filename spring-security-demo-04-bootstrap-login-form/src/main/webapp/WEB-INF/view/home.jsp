<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>

<title>Luv2code Company Hoe Page</title>
</head>

<body>
	<h2>Luv2code Company Home Page</h2>
	<hr>
	<p>Welcome to the luv2code company home page!</p>

	<hr>
	<!-- display username and roles -->
	<p>
		User:
		<security:authentication property="principal.username" />

		<br> <br> Roles:
		<security:authentication property="principal.authorities" />
	</p>
	<hr>

	<!-- Add a new page for Employee -->

	<p>
		<a href="${pageContext.request.contextPath}/employeePage">Employee
			Meeting</a> (Any Employee can access)
	</p>

	<!-- Add a link to point to /leaders ... this is for the managers -->
	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${pageContext.request.contextPath}/leaders">LeaderShip
				Meeting</a> (Only for Manager peeps)
		</p>
	</security:authorize>

	<!-- Add a link to point to /systems ... this is only for admin -->

	<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT Systems
				Meeting</a> (Only for Admin peeps)
		</p>
	</security:authorize>
	<hr>

	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />
	</form:form>

</body>
</html>