<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.girish.DAOLayers.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student</title>
</head>
<body>
	<h1>In Student Home Page</h1>
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
				<h1>Welcome <%= b.getFname() +" " +b.getLname()%></h1>
				<h2>Email: <%= b.getEmail() %></h2>
				<h2>NETID: <%= b.getNetid() %></h2>
				<h2>Level: <%= sb.getLevel() %></h2>
				<h2>Major: <%=sb.getMajor() %></h2>
				<h2>Concentration: <%= sb.getConcentration() %></h2>
				<h3>Role: <%= b.getRole() %></h3>
				<h3>
					<a href="logout.jsp">Logout</a>
				</h3>
			
	<% 		} 
		}
		catch(Exception e)
		{
	%>
				<jsp:forward page="Error.jsp"></jsp:forward>
	<%	
		} 
	%>
	<h3>
		<a href = "crsform.jsp">Course Select</a>
	</h3>
	<h3></h3>
	<h3></h3>
	
</body>
</html>