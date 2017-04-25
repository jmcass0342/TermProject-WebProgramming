<!DOCTYPE html>
<html lang="en">

<head>
	<link rel="shortcut icon" type="image/png" href="http://i.imgur.com/pTkKI7J.png"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Home</title>

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
<style>
table
 {
    border: 1px solid black;
    table-layout: fixed
    background-color: lightGrey;
}
th, td
{
	display: inline-block;
	width: 150px;
	text-align: center;
	color: #ffffff;
}
</style>


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

    <!-- Header Carousel -->
    <header id="myCarousel" class="carousel slide">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
                <div class="fill" style="background-image:url('images/gymOne.jpg');"></div>
                <div class="carousel-caption">
                    <h2></h2> <!-- Caption Can Go Here -->
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url('images/gymTwo.jpg');"></div>
                <div class="carousel-caption">
                    <h2></h2> <!-- Caption Can Go Here -->
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url('images/gymThree.jpg');"></div>
                <div class="carousel-caption">
                    <h2></h2> <!-- Caption Can Go Here -->
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>
    </header>

    <!-- Page Content -->
    <div class="container">

        <!-- Marketing Icons Section -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">
                    Welcome ${username}!
                </h1>
            </div>
        </div>
        <!-- /.row -->

      

        <!-- Features Section -->
        <div class="row">
            <div class="col-lg-12">
                <h2>Your Exercise Plan</h2>
            </div>
      
            <div class="col-md-6">

	<center>
          <#if program1??>
          <h1>Day 1</h1>
          <table>
          	<tr>
          		<th>Exercise Name</th>
				<th>Sets</th>
				<th>Reps</th>
			</tr>
		  <#list program1 as day1>
		  	<tr>
				<td>${day1.exerciseName}</td>
				
					<#if day1_index == 0 || day1_index == 1>
					<td>4</td>
					<#elseif day1_index gt 1>
					<td>3</td>
					</#if>
					
					<#if user.expertise == 1>
					<td>6-8</td>
					<#elseif user.expertise == 2>
					<td>8-10</td>
					<#elseif user.expertise == 3>
					<td>10-12</td>
					</#if>
			</tr>
		  </#list>
		  </table>
		  <#else>
		  <div style="color: white;"> Click "Get Workout for Week" at the top of the page to generate a workout! </div>
		  
          </#if>
          <br /><br />
          
           <#if program2??>
           <h1>Day 2</h1>
           <table>
          	<tr>
          		<th>Exercise Name</th>
				<th>Sets</th>
				<th>Reps</th>
			</tr>
		  <#list program2 as day2>
		  	<tr>
				<td>${day2.exerciseName}</td>
					<#if day2_index == 0 || day2_index == 1>
					<td>4</td>
					<#elseif day2_index gt 1>
					<td>3</td>
					</#if>
					
					<#if user.expertise == 1>
					<td>6-8</td>
					<#elseif user.expertise == 2>
					<td>8-10</td>
					<#elseif user.expertise == 3>
					<td>10-12</td>
					</#if>
			</tr>
		  </#list>
		  </table>
		  <br /><br />
          </#if>
          
          <#if program3??>
          <h1>Day 3</h1>
          <table>
          	<tr>
          		<th>Exercise Name</th>
				<th>Sets</th>
				<th>Reps</th>
			</tr>
		  <#list program3 as day3>
		  
		  	<tr>
				<td>${day3.exerciseName}</td>
					<#if day3_index == 0 || day3_index == 1>
					<td>4</td>
					<#elseif day3_index gt 1>
					<td>3</td>
					</#if>
					
					<#if user.expertise == 1>
					<td>6-8</td>
					<#elseif user.expertise == 2>
					<td>8-10</td>
					<#elseif user.expertise == 3>
					<td>10-12</td>
					</#if>
			</tr>
		  </#list>
		  </table>
		  <br /><br />
          </#if>
            </center>
            </div>
            
            <div class="col-md-6">
                <a class="twitter-timeline"  href="https://twitter.com/hashtag/FitnessGoals" data-widget-id="855569731490807810">#FitnessGoals Tweets</a>
<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+"://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>
            </div>
            
            
        </div>
        <!-- /.row -->

        <hr>

		
        <!-- Call to Action Section -->
        <div class="well">
            <div class="row">
                <div class="col-lg-12">
                <h3 style="text-align:center">Random Fitness Tip</h3>
                <#list randomTips as randomTip>
                    <p style="text-align:center">${randomTip.tip}</p>
                </#list>
                </div>
             <#--   <div class="col-md-4">
                    <a class="btn btn-lg btn-default btn-block" href="#">Get New Fitness Tip!</a> 
                </div> -->
            </div>
        </div>

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

    <!-- Script to Activate the Carousel -->
    <script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>

</body>
</html>
