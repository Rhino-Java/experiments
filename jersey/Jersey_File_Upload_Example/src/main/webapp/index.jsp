<html>
<head>
<title>Jersey File Upload Example</title>
</head>
<body>
	<h1>Jersey File Upload Example</h1>

	<form action="rest/upload/file" method="post"
		enctype="multipart/form-data">

		<p>
			Select a file : <input type="file" name="file" size="45" />
		</p>
		<input type="submit" value="Upload" />

	</form>

</body>
</html>