<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Final Project Demo</title>
<style>

a{
	padding: 20px;
	display: inline-block;
}


</style>

</head>
<body>
<h1>Please fill out the following form</h1>

<form action="UpdateAdminProfile" method="POST">
<table>
	<tr>
		<td>First Name </td>
		<td> <input type ="text" name="firstName" size="35" placeholder="${user.firstName}" ></td>
	</tr>
	<tr>
		<td>Last Name </td>
		<td> <input type ="text" name="lastName" size="35" placeholder="${user.lastName}" ></td>
	</tr>
	<tr>
		<td>UserName </td>
		<td> <input type ="text" name="userName" size="35" placeholder="${user.userName}" ></td>
	</tr>
	<tr>
		<td>Password</td>
		<td> <input type ="password" name="password" size="35" placeholder="********"></td>
	</tr>
	<tr>
		<td>Email</td>
		<td> <input type ="text" name="email" size="35" placeholder="${user.email}"></td>
	</tr>
</table>


 <input type="submit">
</form>

</body>
</html>