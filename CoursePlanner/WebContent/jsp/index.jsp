<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Course Planner</title>
		
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
	</head>
	
	<body>
		<div class="container login-box">
	<div class="col-sm-2"></div>
		<div class="col-sm-8 login-box-div">
		<form action = "jsp/login.jsp" method = "post">
				<div class="form-group">
				  <label for="usr">Email:</label>
				  <input type="text" class="form-control" placeholder="NUID" name="nuid">
				</div>
				<div class="form-group">
				  <label for="pwd">Password:</label>
				  <input type="password" class="form-control" placeholder="Password" name="pwd">
				</div>			
				<br><br>
				<div class="button-container">
					<div class="col-sm-4"></div>
					<div class="col-sm-4">
						<button type="submit" class="btn btn-success">Login</button>
					</div>
					<div class="col-sm-4"></div>
					
				</div>
			</form>
		</div>
	<div class="col-sm-2"></div>
	</div>
	
	</body>
	
	<style>
.login-box{
	padding-top : 100px;
}
.login-box-div{
	border: 3px solid black;
	padding-top: 3em;
	padding-bottom: 3em;
	padding-left: 8em;
	padding-right: 8em;
}
.button-container{
	text-align: center;
}
</style>
</html>