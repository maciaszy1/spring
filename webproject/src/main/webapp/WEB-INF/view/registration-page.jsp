<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<htmnl>
<head>
	<title>Rejestracja konta</title>
</head>
<body>
<h4>Rejestracja Konta</h4>
<hr>
	<form:form action="processRegistration" modelAttribute="wpUser" method="POST">
		<label>Nazwa konta: </label>
		<form:input path="userName"/>
		<br>
		<label>Haslo: </label>
		<form:input path="password" type="password"/>
		<br>
		<label>Imie: </label>
		<form:input path="firstName"/>
		<br>
		<label>Nazwisko </label>
		<form:input path="lastName" />
		<br>
		<label>Email: </label>
		<form:input path="email" />
		<br>
		<input type="submit" value="Zarejestruj" class="save"/>
	</form:form >
</body>
</htmnl>