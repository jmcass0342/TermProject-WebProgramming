<!DOCTYPE html>
<html lang="en">

<head>
	<link rel="shortcut icon" type="image/png" href="http://i.imgur.com/pTkKI7J.png"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Build Program</title>

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
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="AddExercise.html">Add Exercise</a>
                    </li>
                    <li>
                        <a href="AddTiers">Add New Tiers</a>
                    </li>
                    <li>
                        <a href="BuildWorkout">Build A Workout</a>
                    </li>
                    <li>
                        <a href="CreateProgram">Create A Program</a>
                    </li>
                    <li>
                        <a href="DeleteUsers">Delete A User</a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Account Information<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                          	<li>
                        		<a href="UpdateAdminProfile">Update Your Profile</a>
                   			</li>
                    		<li>
                        		<a href="Login">Logout</a>
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
                <h1 class="page-header">Build A Program
                    <small></small><!--Subheading can go here -->
                </h1>
                <ol class="breadcrumb">
                    <li><a href="Home">Home</a>
                    </li>
                    <li class="active">Build A Program</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->

        <!-- Content Row -->
        <div class="row">
           <div class="col-lg-12">
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