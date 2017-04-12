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

<form action="BuildWorkout" method="POST">

<div>
Choose one Tier1:<br>
<table>
<#list tier1 as tierone>
<tr>
	<td><input type="radio" name="getId1" value="${tierone.id}"></td> <td style="margin-top:5px">${string1[tierone_index]}</td>
</tr>
</#list>
</table>
</div>


<div>
Choose one Tier2:<br>
<table>
<#list tier2 as tiertwo>
<tr>
	<td><input type="radio" name="getId2" value="${tiertwo.id}"></td> <td>${string2[tiertwo_index]}</td>
</tr>
</#list>

</table>
</div>

<div>
Choose one Tier3:<br>
<table>
<#list tier3 as tierthree>
<tr>
	<td><input type="radio" name="getId3" value="${tierthree.id}"></td> <td>${string3[tierthree_index]}</td>
</tr>
</#list>

</table>
</div>
<input type="submit">
</form>
</body>
</html>