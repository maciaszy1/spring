<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Panel Administracyjny</title>
</head>
<body>
	<h4>Panel Administracyjny</h4><br>
	<hr><hr>
	<h4>BANOWANIE UZYTKOWNIKOW</h4><br>
	<form:form action="banUser"  method="POST">
		<label>Uzytkownik do zbanowania</label><input type="text" name="userName" id="userName"/>
		<br>
		<input type="submit" value="BANUJ"/>
	</form:form>
	<hr>
	<h4>DODAJ KATEGORIE</h4><br>
	
	<form:form action="saveForumCategory" modelAttribute="forumCategory" method="POST">
		<form:hidden path="id" />
		<label>Nazwa kategori: </label>
		<form:input path="title"/>
		<br>
		<label>Opis: </label>
		<form:input path="description"/>
		<br>
		<input type="submit" value="Zapisz" class="save"/>
	</form:form>
	<hr>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Wyloguj"/>
	</form:form> 
</body>
</html>