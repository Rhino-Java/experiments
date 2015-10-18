<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display Employees</title>
<style type="text/css">
li {
	margin: 20px 0;
}
</style>
</head>
<body>

	<c:choose>
		<c:when test="${empList.isEmpty()}">
			<h2>No Employee data found in the database</h2>
		</c:when>
		<c:otherwise>
			<br />
			<h2>Employees read from the database -</h2>
			
				<ol>
					<c:forEach items="${empList}" var="emp">
						<li><c:out value="${emp}" /></li>
						
					</c:forEach>
				</ol>
			
		</c:otherwise>
	</c:choose>

	<a href="./">Go Back</a>

</body>
</html>