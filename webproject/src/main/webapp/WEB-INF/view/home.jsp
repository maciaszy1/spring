<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Forum</title>
</head>
<body>
 
<h4>Strona Forum</h4>
	
	<security:authorize access="hasRole('ADMIN')">
	<p>
		<a href="/webproject/admin">Administration panel</a>
	</p>
	</security:authorize>
	<br>
	<hr>
	<table>
	<tr>
		<th>Deska</th>
		<th>Opis</th>
	</tr>
	<c:forEach var="tempCategory" items="${forumCategory}">
	<c:url var="boardLink" value="/board">
		<c:param name="categoryId" value="${tempCategory.id}"/>
	</c:url>
	<c:url var="deleteBoard" value="/deleteBoard">
		<c:param name="categoryId" value="${tempCategory.id}"/>
	</c:url>
	<tr>
		<td>${tempCategory.title}</td>
		<td>${tempCategory.description}</td>
		<td>
		<a href="${boardLink}">Wejscie</a>
		</td>
		<td>
		<a href="${deleteBoard}">Usun</a>
		</td>
	</tr>
	</c:forEach>
	</table>
	<hr>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Wyloguj"/>
	</form:form>
</body>
</html>