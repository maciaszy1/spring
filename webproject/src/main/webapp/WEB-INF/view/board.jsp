<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<hr><hr>

	<form:form action="saveForumPost" modelAttribute="forumPost" method="POST">
		<form:hidden path="id"/>	
		<label>Tytul</label>
		<form:input path="title"/>
		<br>
		<form:input path="content"/>
		<br>
		<input type="submit" value="Postuj" class="save"/>
	</form:form>
	
</body>
</html>