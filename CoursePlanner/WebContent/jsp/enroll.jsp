<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.girish.DAOLayers.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>In enroll</h1>
	<%
		if(request.getSession(false) != null)
		{
			UsersBean b = (UsersBean)session.getAttribute("user");
	%>
				<%= b.getNetid()%><br>
				<%= request.getParameter("secid")%><br>
				<%= request.getParameter("secterm")%><br>
				<%= request.getParameter("secyear")%><br>
	<% 	}
	%>

</body>
</html>