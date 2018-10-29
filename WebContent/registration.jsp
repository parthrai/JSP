<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>COMP3095 Assignment</title>

    <!-- Bootstrap -->
	<script src="js/pace.js"></script>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/theme.css" rel="stylesheet">
    <link href="css/font-awesome.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Roboto+Slab:700,400|Open+Sans+Condensed:300' rel='stylesheet' type='text/css'>
	<link href="css/theme-loading-bar.css" rel="stylesheet" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
	<div class="container" id="container" style="display:none;">
		<header>
			<!-- Main comapny header -->
			<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			  <div class="container">
				<div class="navbar-header">
				  				  <a class="navbar-brand top-navbar-brand" href="#"><span class="text-primary">COMP</span> 3095 <span style="font-size:0.50em">Assignment<span></a>
				</div>
				<ul class="nav navbar-nav navbar-right bigger-130 hidden-xs">
					<li><a href="#"><i class="fa fa-google"></i></a></li>
					<li><a href="#"><i class="fa fa-facebook"></i></a></li>
					<li><a href="#"><i class="fa fa-twitter"></i></a></li>
				</ul>
			  </div>
			</nav>
		</header>
		<section id="form">
			<div class="container">    
				<div id="registertext" class="mainbox col-xs-12 col-sm-6">  
					<div class="jumbotron black-alpha-90 animated fadeInLeft">
						<h2>Be a  <span class="text-primary">member</span></h2>
						<p>And continue your education</p>
						
					</div>
				</div>
				<div id="loginbox" class="mainbox col-xs-12 col-sm-6 animated zoomInDown">                    
					<div class="panel white-alpha-90" >
						<div class="panel-heading">
							<div class="panel-title text-center"><h2>Register<span class="text-primary"></span></h2></div>
						</div>     
						<div class="panel-body" >
							<div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
								<form id="loginform" class="form-horizontal" role="form" action="Registration" method="post">
								
								<div class="input-group col-xs-6">
									<span class="input-group-addon"></span>
									<input id="login-username" type="text" class="form-control" name="firstname" pattern="[a-zA-Z]+" value="" placeholder="First Name" required title="Please enter a valid first name">
								</div>
								<div class="input-group col-xs-6">
									<span class="input-group-addon"><i class="fa fa-lock"></i></span>
									<input id="login-password" type="text" class="form-control" name="lastname" pattern="[a-zA-Z]+" placeholder="Last Name" required title="Please enter a valid last name">
								</div>
								<div class="input-group">
									<span class="input-group-addon"></span>
									<input id="login-username" type="text" class="form-control" name="phone" value="" placeholder="1234567890" pattern="[0-9][0-9]{9}" title="Please enter a valid phone number" required>
								</div>
								
								<div class="input-group col-xs-6">
									<span class="input-group-addon"></span>
									<input id="login-username" type="email" class="form-control" name="email" value="" placeholder="Email" required >
									<div class="form-group has-error">
									
											<span class="help-block"><strong>${email_error}</strong></span>
						
										</div>
								</div>
								
								<div class="input-group col-xs-6">
									<span class="input-group-addon"></span>
									<input id="login-username" type="email" class="form-control" name="confirm_email" value="" placeholder="Confirm Email" required >
									<div class="form-group has-error">
									
											<span class="help-block"><strong>${email_error}</strong></span>
						
										</div>
								</div>
								
								
								<div class="input-group col-xs-6">
									<span class="input-group-addon"><i class="fa fa-lock"></i></span>
									<select class="form-control" name="major">
  										<option value="programing">Programming</option>
  										<option value="gaming">gaming</option>
  										<option value="database">Database</option>
  										<option value="cisco">CISCO</option>
  										<option value="voip">VOIP</option>
  										<option value="security">Security</option>
  										
									</select>
								</div>
								
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock"></i></span>
									
									
									<select class="form-control" name="year">
  										<option value="2010">2010</option>
  										<option value="2011">2011</option>
  										<option value="2012">2012</option>
  										<option value="2013">2013</option>
  										<option value="2014">2014</option>
  										<option value="2015">2015</option>
  										<option value="2016">2016</option>
  										<option value="2017">2017</option>
									</select>
								</div>
								
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock"></i></span>
									<input id="login-username" type="text" class="form-control" name="username" value="" placeholder="Username" title="Please enter a valid username" pattern="[a-zA-Z]+" required>
								</div>
								<div class="input-group col-xs-6">
									<span class="input-group-addon"><i class="fa fa-lock"></i></span>
									<input id="login-password" type="password" class="form-control" name="password" placeholder="password" required>
					
										<div class="form-group has-error">
									
											<span class="help-block"><strong>${password_error}</strong></span>
						
										</div>
								</div>
								<div class="input-group col-xs-6">
									<span class="input-group-addon"><i class="fa fa-lock"></i></span>
									<input id="login-password" type="password" class="form-control" name="confirm_password" placeholder="confirm password" required>
									
									<div class="form-group has-error">
									
											<span class="help-block"><strong>${password_error}</strong></span>
						
										</div>
								</div>
								<div class="input-group col-xs-12 text-center login-action">
								  <div class="checkbox">
									<label>
									  <input id="login-remember" type="checkbox" name="remember" value="1" style="margin-top: 10px;" required> I agree to terms and conditions &nbsp;
									  <br><br><span id="btn-login"><input type="submit" class="btn btn-success form-control" value="Register"></span>
									</label>
								  </div>
								</div>
								<div style="margin-top:10px" class="form-group">
									<div class="col-sm-12 controls">
									  
									</div>
								</div>
							</form>     
						</div>                     
					</div>  
				</div>
			</div>
		</section>
		<footer>
			<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
			  <div class="container text-center">
				<div class="footer-content">
				  Already registered? <a href="login.jsp" class="btn btn-primary"> Sign In </a>
				</div>
			  </div><!-- /.container-fluid -->
			</nav>
		</footer>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.backstretch.min.js"></script>
	<script>
		Pace.on('hide', function(){
		  $("#container").fadeIn('1000');
		  $.backstretch([
				"images/login_bg_2.jpg",
				"images/login_bg_1.jpg"
			], {duration: 5000, fade: 1000});
		});		
	</script>
  </body>
</html>