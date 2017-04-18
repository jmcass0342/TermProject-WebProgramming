<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Final Project Demo</title>
<style>
	div{
		padding: 20px;
	}
</style>
</head>
<body>

<form action="DeleteUsers" method="POST">
<div>
<select name ="user">
<#list users as user>
	<option value="${user.id}">${user.userName}</option>
</#list>
</select>
</div>

<input type="submit">
</form>
</body>
</html>