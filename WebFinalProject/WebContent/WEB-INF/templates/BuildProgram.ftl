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

<form action="CreateProgram" method="POST">



<div>

<select name ="day1">
<option value="null" > </option>
<#list workouts as workout>
	<option value="${workout.id}">Workout - ${workout.id}</option>
</#list>
</select>
</div>


<div>
<select name="day2">
<option value="null" > </option>
<#list workouts as workout>
	<option value="${workout.id}">Workout - ${workout.id}</option>
</#list>
</select>
</div>

<div>
<select name="day3">
<option value="null" > </option>
<#list workouts as workout>
	<option value="${workout.id}">Workout - ${workout.id}</option>
</#list>
</select>
</div>
<input type="submit">
</form>
</body>
</html>