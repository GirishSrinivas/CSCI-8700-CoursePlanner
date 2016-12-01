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
	th td
	{
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
				EnrollsDAOImpl edi = new EnrollsDAOImpl();
				List<Object[]> l = new ArrayList<>();
				l = edi.read(b.getNetid());
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
			<% 			if(b.getRole().equals("Student"))
						{
			%>
							<a class="btn btn-info col-sm-12" href="studHome.jsp">Profile</a><br><br><br>
							<a class="btn btn-success col-sm-12" href="crsform.jsp">Course Schedule</a><br><br><br>
							<a class="btn btn-success col-sm-12" href="enroll.jsp">Course Plan</a><br><br><br>
							<a class="btn btn-warning col-sm-12" href="dropcrs.jsp">Drop Course</a><br><br><br>
							<a class="btn btn-success col-sm-12" href="#">Graduate Exit Requirement</a><br><br><br>
							<a class="btn btn-success col-sm-12" href="#">Degree Works</a><br><br><br>
							<a class="btn btn-success col-sm-12" href="transcript.jsp">Transcripts</a><br><br><br>
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
					<h2 style = "text-align: center">Enrollment details of <%= b.getFname() +" " +b.getLname()%></h2>
				<div class="table-responsive">
				<table class = "table table-hover">
					<tr>
						<th>Course ID</th>
						<th>Section ID</th>
						<th>Course Name</th>
						<th>Term</th>
						<th>Year</th>
						<th>GPA</th>
						<th>Grade</th>
						<th>Status</th>
						<th>Select</th>
					</tr>
	<%
				for(Object[] o : l)
				{
					EnrollsBean eb = (EnrollsBean)o[0];
					CourseBean cb = (CourseBean)o[1];
	%>
					<tr>
						<td><%= eb.getC_id()%></td>
						<td><%= eb.getSec_id()%></td>
						<td><%= cb.getC_name()%></td>
						<td><%= eb.getTerm()%></td>
						<td><%= eb.getYear()%></td>
						<td><%= eb.getGpa()%></td>
						<td><%= eb.getGrade()%></td>
						<td><%= eb.getStatus()%></td>
						<td><a href = "drop.jsp?cid=<%= eb.getC_id()%>&sid=<%= eb.getSec_id()%>&term=<%= eb.getTerm()%>&yr=<%= eb.getYear()%>" class="btn btn-danger" style="font-size:11px">Drop Course</a></td>
					</tr>
	<%
				}
	%>
				</table>
				</div>
				</div>
	<%  	}
		}
		catch(Exception e)
		{
	%>
			<jsp:forward page="Error.jsp"></jsp:forward>

	<% 	}
	%>
	</div>
</body>
</html>