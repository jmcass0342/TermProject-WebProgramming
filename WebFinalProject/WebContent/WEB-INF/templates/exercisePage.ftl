<!DOCTYPE html>
<html lang="en">

<head>
	<link rel="shortcut icon" type="image/png" href="http://i.imgur.com/pTkKI7J.png"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
<#list exercises as exercise>
    <title>${exercise.exerciseName}</title>

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
                <h1 class="page-header">${exercise.exerciseName}
                    <small>Tier ${exercise.tier}</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="Home">Home</a>
                    </li>
                    <li class="active">${exercise.exerciseName}</li>
                </ol>
            </div>
        </div>
        <!-- /.row -->

        <!-- Portfolio Item Row -->
        <div class="row">

            <div class="col-md-8">
                <iframe width="720" height="400" src="https://www.youtube.com/embed/${exercise.video}" frameborder="0" allowfullscreen></iframe>
            </div>

            <div class="col-md-4">
                <h3>Exercise Description</h3>
            <table>
  				<tr>
   					<td class="label">Name: </td>
    				<td class="label">${exercise.exerciseName}</td> 
  				</tr>
  				<tr>
    				<td class="label">ID: </td>
    				<td class="label">${exercise.id}</td> 
  				</tr>
  				<tr>
    				<td class="label">Tier: </td>
    				<td class="label">${exercise.tier}</td> 
  				</tr>
			</table>
            </div>

        </div>
        <!-- /.row -->

        <!-- Related Projects Row -->
        <div class="row">

            <div class="col-lg-12">
                <h3 class="page-header">Other Exercises</h3>
            </div>
		<#list randomExercises as random>
            <div class="col-sm-3 col-xs-6">
                <a href="CreateExercisePage?id=${random.id}">
                    <img class="img-responsive img-hover img-related" src="http://i3.ytimg.com/vi/${random.video}/hqdefault.jpg" height="500" width="300" alt="${random.exerciseName}">
                </a>
            </div>
		</#list>

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
</#list>
</body>
</html>