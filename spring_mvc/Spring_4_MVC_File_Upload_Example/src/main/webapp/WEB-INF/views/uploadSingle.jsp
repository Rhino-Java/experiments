<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring 4 MVC Upload Single File</title>
</head>
<body>
	<form method="POST" action="uploadSingleFile"
		enctype="multipart/form-data">
		<br /> Choose File to Upload: <input type="file" name="file">
		<br /> <br /> <br /> <input type="submit" value="Upload"
			style="margin-left: 140px;">
	</form>
</body>
</html>