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
				CoursePlanDAOImpl cpd = new CoursePlanDAOImpl();
				EnrollsBean eb = new EnrollsBean();
				EnrollsDAOImpl edi = new EnrollsDAOImpl();
				List<Object[]> l = new ArrayList<>();
				l = cpd.read(b.getNetid());
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
					<h2 style = "text-align: center">Course Plan for <%= b.getFname() +" " +b.getLname()%></h2>
				<div class="table-responsive">
				<table class = "table table-hover">
					<tr>
						<th>Course ID</th>
						<th>Section ID</th>
						<th>Course Name</th>
						<th> Term</th>
						<th>Year</th>
						<th>Grade</th>
						<th colspan="2" style="text-align: center">Select</th>
					</tr>
	<%
				for(Object[] o : l)
				{
					CoursePlanBean cpb = (CoursePlanBean)o[0];
					CourseBean cb = (CourseBean)o[1];
					
					eb.setNetid(b.getNetid());
					eb.setC_id(cpb.getC_id());
					eb.setSec_id(cpb.getSec_id());
					eb.setTerm(cpb.getTerm());
					eb.setYear(cpb.getYear());
	%>
					<tr>
						<td><%= cpb.getC_id()%></td>
						<td><%= cpb.getSec_id()%></td>
						<td><%= cb.getC_name()%></td>
						<td><%= cpb.getTerm()%></td>
						<td><%= cpb.getYear()%></td>
						<td><%= cpb.getGrade()%></td>

	<%				if(edi.isPresent(eb))
					{
	%>
						<td><a href = "#" class="btn btn-success disabled" style="font-size:11px">Enroll</a></td>
						<td><a href = "#" class="btn btn-warning disabled" style="font-size:11px">Remove</a></td>
	<%				}
					else
					{
	%>
						<td><a href = "crsenroll.jsp?cid=<%= cpb.getC_id()%>&sid=<%= cpb.getSec_id()%>&term=<%= cpb.getTerm()%>&yr=<%= cpb.getYear()%>" class="btn btn-success" style="font-size:11px">Enroll</a></td>
						<td><a href = "rmvcrspln.jsp?cid=<%= cpb.getC_id()%>&term=<%= cpb.getTerm()%>&yr=<%= cpb.getYear()%>" class="btn btn-warning" style="font-size:11px">Remove</a></td>
	<% 				}
	%>
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