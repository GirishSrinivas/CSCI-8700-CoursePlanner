<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.girish.DAOLayers.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student</title>
		
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
				StudentBean sb = (StudentBean)session.getAttribute("stud");
	%>
			<script>
					$("title").html("<%= b.getFname() %>");
			</script>
			
			<div class="container-fluid">
				<div class="col-sm-2">
					<div class="nav-buttons col-sm-2">
					<br>
					<br>
					<br>
			<% 			if(b.getRole().equals("Student"))
						{
			%>
							<a class="btn btn-info col-sm-12" href="studHome.jsp">Profile</a><br><br><br>
							<a class="btn btn-success col-sm-12" href="crsform.jsp">Course Schedule</a><br><br><br>
							<a class="btn btn-success col-sm-12" href="enroll.jsp">Course Plan</a><br><br><br>
							<a class="btn btn-warning col-sm-12" href="#">Drop Course</a><br><br><br>
							<a class="btn btn-success col-sm-12" href="#">Graduate Exit Requirement</a><br><br><br>
							<a class="btn btn-success col-sm-12" href="#">Degree Works</a><br><br><br>
							<a class="btn btn-success col-sm-12" href="#">Transcripts</a><br><br><br>
			<% 			}
						else
						{
			%>
							<a class="btn btn-info col-sm-12" href="advHome.jsp">Profile</a><br><br><br>
			<% 			}
			%>
						<a class="btn btn-danger col-sm-12" href="logout.jsp">Logout</a><br><br><br>
					</div>
				</div>
				<div class = "col-sm-10">
				<h1 style = "text-align: center">Welcome <%= b.getFname() +" " +b.getLname()%></h1>
				<div class="table-responsive">
				<table class = "table table-hover">
					<tr>
						<td>First Name : </td>
						<td><%= b.getFname() %></td>
					</tr>
					<tr>
						<td>Last Name : </td>
						<td><%= b.getLname() %></td>
					</tr>
					<tr>
						<td>Major : </td>
						<td><%=sb.getMajor() %></td>
					</tr>
					<tr>
						<td>Level : </td>
						<td><%= sb.getLevel() %></td>
					</tr>
					<tr>
						<td>Concentration : </td>
						<td><%= sb.getConcentration() %></td>
					</tr>
					<tr>
						<td>Email : </td>
						<td><%= b.getEmail() %></td>
					</tr>
					<tr>
						<td>NETID : </td>
						<td><%= b.getNetid() %></td>
					</tr>
				</table>
				</div>
			
	<% 		} 
		}
		catch(Exception e)
		{
	%>
				<jsp:forward page="Error.jsp"></jsp:forward>
	<%	
		} 
	%>
	</div>
	</div>
</body>
</html>