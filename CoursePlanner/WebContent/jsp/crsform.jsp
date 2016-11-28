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
		font-size: 10px;
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
		SectionDAOImpl sdi = new SectionDAOImpl();
		List<Object[]> l = new ArrayList<>();
		try
		{
			if(request.getSession(false) != null)
			{
				UsersBean b = (UsersBean)session.getAttribute("user");
				CoursePlanDAOImpl cpd = new CoursePlanDAOImpl();
				CoursePlanBean cpb = new CoursePlanBean();
	
				l = sdi.customSelect();
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
				<div class="col-sm-10">
	<% 			if(b.getRole().equals("Student"))
				{
	%>
					<h1 style="text-align:center">Course table for <%=b.getFname() +" " +b.getLname() %></h1>
	<% 			}
				else
				{
	%>
					<h2 style="text-align:center;">Course table for the Current Academic year</h2>
	<% 			}
	%>
				<div class="table-responsive">
				<table class = "table table-hover">
				<tr>
					<th>Course ID</th>
					<th>Section ID</th>
					<th>Course Name</th>
					<th> Term</th>
					<th>Year</th>
					<th>Total Seats</th>
					<th>Seats Available</th>
					<th>Status</th>
					<th>Location</th>
					<th>Days</th>
					<th>Start Time</th>
					<th>End Time</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Instructor ID</th>
					<th>Select</th>
				</tr>
	<%			for(Object[] o : l)
				{
					SectionBean sec = (SectionBean) o[0];
					CourseBean c = (CourseBean)o[1];
					cpb.setC_id(sec.getCourse_no());
					cpb.setSec_id(sec.getSection_id());
					cpb.setTerm(sec.getTerm());
					cpb.setYear(sec.getYear());
					cpb.setNetid(b.getNetid());
					
	%>
					<tr>
						<td> <%= sec.getCourse_no()%></td>
						<td><%= sec.getSection_id()%></td>
						<td><%= c.getC_name()%></td>
						<td><%= sec.getTerm()%></td>
						<td><%= sec.getYear()%></td>
						<td><%= sec.getTotal_seats()%></td>
						<td><%= sec.getSeats_taken()%></td>
						<td><%= sec.getStatus()%></td>
						<td><%= sec.getLoc()%></td>
						<td><%= sec.getDays()%></td>
						<td><%= sec.getS_time()%></td>
						<td><%= sec.getE_time()%></td>
						<td><%= sec.getS_date()%></td>
						<td><%= sec.getE_date()%></td>
						<td><%= sec.getInst_id()%></td>
	<% 
					if(cpd.isPresent(cpb)){
	%>
						<td><a href="#" class="btn btn-success disabled" style="font-size:10px">Add</a></td>
	<%
					}else
					{
	%>
						<td><a  href = "enrollcrs.jsp?cid=<%= sec.getCourse_no()%>&secid=<%=sec.getSection_id() %>&secterm=<%=sec.getTerm() %>&secyear=<%=sec.getYear() %>" class="btn btn-success" style="font-size:10px">Add</a></td>
	<%	
					}
	%>
						
					</tr>	
	<% 			}				
	%>
				</table>
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
