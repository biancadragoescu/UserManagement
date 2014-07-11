<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<title>Login Page</title>
		<link rel="stylesheet" type="text/css" href="resources/login.css">
	</head>
	<body>
		<c:url value = "/login" var = "myUrl"/>	
		<%-- <form:form action = "http://localhost:8080/usermanagement/login" commandName = "user" method = "POST"> --%> 
		<div id = "wrapper">
			<form:form id = "form" action = "${myUrl}" commandName = "user" method = "POST">
				<form:input  class = "field" path = "userName" placeholder = "Username"/>
				<form:password class = "field" path = "password" placeholder = "Password"/>
				<button id = "button" type = "submit">Login</button>
			</form:form>	
		</div>		
	</body>	
</html>
