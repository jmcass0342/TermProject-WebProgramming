<!DOCTYPE html>
<html lang="en">

<head>
	<link rel="shortcut icon" type="image/png" href="http://i.imgur.com/pTkKI7J.png"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Tier ${tier} Exercises</title>

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
                <h1 class="page-header">Exercises
                    <small></small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="Home">Home</a>
                    </li>
                    <li class="active">Tier ${tier} Exercises</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->

	<#list exercises as exercise>
        <!-- Project One -->
        <div class="row">
            <div class="col-md-7">
                <a href="CreateExercisePage?id=${exercise.id}">
                    <img class="img-responsive img-hover" src="http://i3.ytimg.com/vi/${exercise.video}/hqdefault.jpg" alt="${exercise.exerciseName}">
                </a>
            </div>
            <div class="col-md-5">
                <h3>${exercise.exerciseName}</h3>
            </div>
        </div>
        <!-- /.row -->
        <hr>
	</#list>

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