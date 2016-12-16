<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.girish.DAOLayers.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
		
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
</head>
<style>
	.nav-buttons
	{
		position: fixed;	
		padding-left: 0;
	}
	
	.table
	{
		font-size: 11px;
	}
	th td
	{
		text-align: center;
	}
	
	.menunav li
	{
		margin: 0px 3px;
		top : 8px;
	}
	.menunav li a{
		padding : 0.4em;
		color : white !important;
	}
	.menubarnav-container{
		top : -3px;
		margin : 0px;
		border : 0px;
	}
	
	.login-box-div{
	
	padding-top: 3em;
	padding-bottom: 3em;
	padding-left: 8em;
	padding-right: 8em;
}
.button-container{
	text-align: center;
}

</style>
<body>
	<br>
	<br>
	<%
		try
		{
			if(request.getSession(false) != null)
			{
				UsersBean b = (UsersBean)session.getAttribute("user");
	%>
				<script>
					$("title").html("<%= b.getFname() +" " +b.getLname()%>");
				</script>
				<div class="container-fluid">
				<div class="col-sm-2">
					<div class="nav-buttons col-sm-2">
					<br>
					<br>
					<br>
			
						<a class="btn btn-info col-sm-12" href="advHome.jsp">Profile</a><br><br><br>
						<a class="btn btn-success col-sm-12" href="crsform.jsp">Course Schedule</a><br><br><br>
						<a class="btn btn-success col-sm-12" href="enrollstud.jsp">Students Enrolled</a><br><br><br>
						<a class="btn btn-danger col-sm-12" href="logout.jsp">Logout</a><br><br><br>
					</div>
				</div>
				<div class="col-sm-10">
	
				
					<h2 style="text-align:center;">Course table for the Current Academic year</h2>
					<nav class="navbar navbar-default menubarnav-container">
  						<!-- 
  						<div class="navbar-header">
      						<p class="navbar-brand"></p>
    					</div>
    					-->
    
    					<ul class="nav navbar-nav menunav">
      						<li><a class="btn btn-info col-sm-12" href="viewall.jsp">View All Enrolled Students</a></li>
     						 <li><a class="btn btn-info col-sm-12" href="currstud.jsp">View Currently Enrolled Students</a></li>
     						 <li><a class="btn btn-info col-sm-12" href="studsrch.jsp">Search Student</a></li>
    					</ul>
					</nav>
				
					<div class="login-box-div">
					<form action = "srchstud.jsp" method = "post">
					<div class="form-group">
				  		<label for="usr">Student's netid:</label>
				  		<input type="text" class="form-control" placeholder="netid" name="netid">
					</div>
								
					<div class="button-container">
						<div class="col-sm-4"></div>
						<div class="col-sm-4">
							<button type="submit" class="btn btn-success">Search Student</button>
						</div>
						<div class="col-sm-4"></div>
					</div>
				</form>
				</div>
	
				</div>
				</div>
				
	<% 		} 	
		}
		catch(Exception e)
		{
	%>
			<jsp:forward page="Error.jsp"></jsp:forward>
	<%	}
	%>
		
		
	
</body>
</html>
