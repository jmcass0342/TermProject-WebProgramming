<!DOCTYPE html>
<html lang="en">

<head>
	<link rel="shortcut icon" type="image/png" href="http://i.imgur.com/pTkKI7J.png"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Schedule</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/modern-business.css" rel="stylesheet">
    
    <!-- Our Custom CSS -->
    <link href="css/myStyle.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <!-- Google Font I Added -->
    <link href="https://fonts.googleapis.com/css?family=Knewave" rel="stylesheet"> 

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <!-- Navigation -->
     <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="Home">GymBuddy</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="GetWorkout">Get A Workout For Week</a>
                    </li>
                    <li>
                        <a href="ShowWorkout">See Your Workout For The Week </a>
                    </li>
                    <li>
                        <a href="Ask">Ask An Expert</a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Account Information<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                          	<li>
                        		<a href="UpdateProfile">Update Your Profile</a>
                   			</li>
                    		<li>
                        		<a href="Login">Logout</a>
                    		</li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Exercises<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="CreateExerciseList?tier=1">Tier One</a>
                            </li>
                            <li>
                                <a href="CreateExerciseList?tier=2">Tier Two</a>
                            </li>
                            <li>
                                <a href="CreateExerciseList?tier=3">Tier Three</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">

        <!-- Page Heading/Breadcrumbs -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Update Account
                    <small></small><!--Subheading can go here -->
                </h1>
                <ol class="breadcrumb">
                    <li><a href="Home">Home</a>
                    </li>
                    <li class="active">Schedule</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->

        <!-- Content Row -->
        <div class="row">
            <div class="col-lg-12">
            
            
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
 
            </div>
        </div>
        <!-- /.row -->

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p class="pageFooter"> Made By CSCI4300 Group 12</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>
</html>