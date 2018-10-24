<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<h3>${forumCategory.title}</h3>
<hr><hr>
<c:forEach var="tempPost" items="${forumCategory.forumPosts}">
<c:url var="deletePost" value="/deletePost">
	<c:param name="postId" value="${tempPost.id}"/>
</c:url>
<td><tr>||Wpis dokonany przez: ${tempPost.user.username} ||</tr><tr>||tytyl: ${tempPost.title} ||</tr> <tr><a href="${deletePost}">Usun</a></tr> </td>
<hr>
<p>${tempPost.content}</p>
<hr><hr>
</c:forEach>
	<form:form action="saveForumPost${forumCategory.id}" modelAttribute="forumPost" method="POST">
		<form:hidden path="id"/>
		<label>Tytul</label>
		<form:input path="title"/>
		<br>
		<form:textarea path="content" rows="5" cols="30"/>
		<br>
		<input type="submit" value="Postuj" class="save"/>
	</form:form>
	<hr>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Wyloguj"/>
	</form:form>
</body>
</html>