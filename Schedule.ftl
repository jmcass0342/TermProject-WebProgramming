<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Final Project Demo</title>
	<style>
		table,td,tr{
			border: 1px solid;
		}
		div{
			padding: 5px;
		}
	</style>

</head>
<body>



<#if program1??>
<div>
		<table>
		<#list program1 as day1> 
			<tr>
				<td>${day1.id}</td>
				<td>${day1.exerciseName}</td>
				<td>${day1.video}</td>
				<td>${day1.tier}</td>
				<#if day1_index == 0 || day1_index == 1>
					<td> 4 </td>
				<#elseif day1_index gt 1>
					<td> 3 </td>
				</#if>
				<#if user.expertise == 1>
					<td> 6-8 </td>
				<#elseif user.expertise == 2>
					<td> 8-10 </td>
					<#elseif user.expertise == 3>
					<td> 10-12 </td>
				</#if>
			</tr>
		</#list>
		</table>
</div>
</#if>

<#if program2??>
<div>	
		<table>
		<#list program2 as day2> 
			<tr>
				<td>${day2.id}</td>
				<td>${day2.exerciseName}</td>
				<td>${day2.video}</td>
				<td>${day2.tier}</td>
			</tr>
			</#list>
		</table>
		</div>
</#if>

<#if program3??>	
<div>
		<table>
		<#list program3 as day3> 
			<tr>
				<td>${day3.id}</td>
				<td>${day3.exerciseName}</td>
				<td>${day3.video}</td>
				<td>${day3.tier}</td>
			</tr>
			</#list>
		</table>
		</div>
</#if>



</body>
</html>