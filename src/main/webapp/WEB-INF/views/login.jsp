<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<title>Login Page</title>
	</head>
	<body>
		<h1>
			Login page
		</h1>		
		<form:form action = "http://localhost:8080/usermanagement/login" commandName = "user" method = "POST">
			<table>
				<tr>
					<td>User Name:</td>
					<td><form:input path = "userName"/></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path= "password"/></td>
				</tr>
				<tr>
					<td colspan = "2"><input type = "submit" value = "Ok"></td>
				</tr>
			</table>
		</form:form>
			
	</body>
</html>
