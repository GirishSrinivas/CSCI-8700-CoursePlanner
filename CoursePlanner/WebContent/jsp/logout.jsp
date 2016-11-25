<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.girish.DAOLayers.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logout</title>
</head>
<body>
	<%
		session = request.getSession(false);
		if(session != null)
		{
				session.removeAttribute("user");
				session.invalidate();
				//System.out.println(session.getAttribute("stu"));
	%>
			<jsp:forward page="logoutsuccess.jsp"></jsp:forward>
	<% 
		}
		else
		{
	%>
			<jsp:forward page="Error.jsp"></jsp:forward>
	<% 	}
	%>	
</body>
</html>