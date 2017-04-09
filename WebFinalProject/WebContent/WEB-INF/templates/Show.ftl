<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Final Project Demo</title>
<style>
table {
	   	 font-family: arial, sans-serif;
  	  		border-collapse: collapse;
   	 		width: 100%;
   	 		text-align: center;
}
td, th{
		    	border: 1px solid #dddddd;
		    	text-align: center;
		    	padding: 8px;
}
	
tr:nth-child(even) {
	    	background-color: #dddddd;
}
tr:nth-child(odd) {
	    	background-color: white;
}

</style>

</head>
<body>

<h1><u>Demo</u></h1>
<div>

<h2> Users</h2>
<table>

	<th>ID</th>
	<th>First Name</th>
	<th>Last Name</th>
	<th>UserName</th>
	<th>Password</th>
	<th>Email</th>
	<th>Expertise</th>
	<th>Days to Work Out</th>

	
		<#list users as user>
			<tr>				
				<td>${user.id}</td>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.userName}</td>
				<td>${user.password}</td>
				<td>${user.email}</td>
				<td>${user.expertise}</td>
				<td>${user.daysOfWorkout}</td>
			</tr>
		</#list>
			
</table>
</div>

<div>
<h2> Exercises</h2>
<table>


	<th>ID</th>
	<th>Exercise Name</th>
	<th>Video Link</th>
	<th>Tier</th>
	
	
		<#list exercises as exercise>
			<tr>				
				<td>${exercise.id}</td>
				<td>${exercise.exerciseName}</td>
				<td>${exercise.video}</td>
				<td>${exercise.tier}</td>
			</tr>
		</#list>
			
</table>
</div>

<div>
<h2> Tier1 </h2>
<table>


	<th>ID</th>
	<th>Exercise 1</th>
	<th>Exercise 2</th>

	
	
		<#list tier1 as one>
			<tr>				
				<td>${one.id}</td>
				<td>${one.exercise1}</td>
				<td>${one.exercise2}</td>
			</tr>
		</#list>
			
</table>
</div>

<div>
<h2> Tier 2</h2>
<table>

	<th>ID</th>
	<th>Exercise 1</th>
	<th>Exercise 2</th>
	<th>Exercise 3</th>
	
	
		<#list tier2 as two>
			<tr>				
				<td>${two.id}</td>
				<td>${two.exercise1}</td>
				<td>${two.exercise2}</td>
				<td>${two.exercise3}</td>
			</tr>
		</#list>
			
</table>
</div>

<div>

<h2> Tier3</h2>
<table>
	<th>ID</th>
	<th>Exercise 1</th>
	<th>Exercise 2</th>
	<th>Exercise 3</th>
	
	
		<#list tier3 as three>
			<tr>				
				<td>${three.id}</td>
				<td>${three.exercise1}</td>
				<td>${three.exercise2}</td>
				<td>${three.exercise3}</td>
			</tr>
		</#list>
			
</table>
</div>


<div>

<h2> Workouts</h2>
<table>
	<th>ID</th>
	<th>Tier 1 ID</th>
	<th>Tier 2 ID</th>
	<th>Tier 3 ID</th>
	
	
		<#list workouts as workout>
			<tr>				
				<td>${workout.id}</td>
				<td>${workout.tier1Id}</td>
				<td>${workout.tier2Id}</td>
				<td>${workout.tier3Id}</td>
			</tr>
		</#list>
			
</table>
</div>


<h2> Programs</h2>
<table>
	<th>ID</th>
	<th>Day 1</th>
	<th>Day 2</th>
	<th>Day 3</th>
	
	
		<#list programs as program>
			<tr>				
				<td>${program.id}</td>
				<td>${program.day1}</td>
				<td>${program.day2}</td>
				<td>${program.day3}</td>
			</tr>
		</#list>
			
</table>
</div>

<h2>Users with Programs</h2>
<table>
	<th>ID</th>
	<th>UserId</th>
	<th>ProgramId</th>
	
	
		<#list hasPrograms as hasProgram>
			<tr>				
				<td>${hasProgram.id}</td>
				<td>${hasProgram.userId}</td>
				<td>${hasProgram.programId}</td>
			</tr>
		</#list>
			
</table>
</div>


</body>
</html>