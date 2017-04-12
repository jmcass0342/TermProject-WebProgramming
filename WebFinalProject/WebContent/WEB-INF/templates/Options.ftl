<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Final Project Demo</title>

</head>
<body>

<form action="InsertTier" method="POST">
<#if tier == 1>
	<input type="hidden" name ="tier" value ="1">
	Choose 2:<br>
	<#list exercises as exercise>
		<input type="checkbox" name="options" value="${exercise.id}"> ${exercise.exerciseName}<br>
	</#list>
<#elseif tier == 2 >
	<input type="hidden" name ="tier" value ="2">
	Choose 3:<br>
	<#list exercises as exercise>
		<input type="checkbox" name="options" value="${exercise.id}"> ${exercise.exerciseName}<br>
	</#list>
	
<#elseif tier == 3 >
	<input type="hidden" name ="tier" value ="3">
	Choose 3:<br>
	<#list exercises as exercise>
		<input type="checkbox" name="options" value="${exercise.id}"> ${exercise.exerciseName}<br>
	</#list>
</#if>

<input type="submit">
</form>
</body>
</html>