<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World</title>
</head>
<body>
	<%-- For accessing model attributes in jsp file, use '${attribute_name}' --%>
	<h1>Hello : ${name}</h1>
	<br />
	<h2>Database details are following -</h2>
	<br />
	<table>
		<tbody>
			<tr>
				<td>Driver Class Name</td>
				<td>${driverClassName}</td>
			</tr>
			<tr>
				<td>Database URL</td>
				<td>${url}</td>
			</tr>
			<tr>
				<td>Database Username</td>
				<td>${username}</td>
			</tr>
			<tr>
				<td>Database Password</td>
				<td>${password}</td>
			</tr>
		</tbody>
	</table>
</body>
</html>