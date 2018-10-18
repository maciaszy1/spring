<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<h3>Logowanie</h3>
<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
	<p>
		Login: <input type="text" name="username"/> 	
	</p>
	<p>
		Haslo: <input type="password" name="password"/>
	</p>
	<input type="submit" value="Zaloguj"/>
</form:form>
<a href="${pageContext.request.contextPath}/showRegistrationPage">Zarejestruj sie!!!</a>
</body>
</html>