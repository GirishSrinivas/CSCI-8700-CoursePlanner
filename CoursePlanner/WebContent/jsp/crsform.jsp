<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.girish.DAOLayers.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		SectionDAOImpl sdi = new SectionDAOImpl();
		List<Object[]> l = new ArrayList<>();
		try
		{
			if(request.getSession(false) != null)
			{
				UsersBean b = (UsersBean)session.getAttribute("user");
				if(b.getRole().equals("Student"))
				{
	%>
					<h2>Course table for <%=b.getFname() +" " +b.getLname() %></h2>
	<% 			}
				else
				{
	%>
					<h2>Course table for the Current Academic year</h2>
	<% 			}
				l = sdi.customSelect();
	%>
				
				<table border = 2>
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
				</tr>
	<%			for(Object[] o : l)
				{
					SectionBean sec = (SectionBean) o[0];
					CourseBean c = (CourseBean)o[1];
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
					</tr>	
	<% 			}				
	%>
				</table>
				
	<% 			if(b.getRole().equals("Student"))
				{
	%>
					<h3>
						<a href="studHome.jsp">Home</a>
					</h3>
	<% 			}
				else
				{
	%>
					<h3>
						<a href="advHome.jsp">Home</a>
					</h3>
	<% 			}
	%>
				
				
				<h3>
					<a href="logout.jsp">Logout</a>
				</h3>
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