<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.girish.DAOLayers.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<jsp:useBean id="bean" class="com.girish.DAOLayers.LoginBean" scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="bean"/>
	<%
		LoginDAOImpl log = new LoginDAOImpl();
	
		try
		{
			UsersBean b = log.login(bean);
			session.setAttribute("user", b);
			if(b.getRole().equals("Student"))
			{
	%>
				<jsp:forward page="studHome.jsp"></jsp:forward>
	<%		}
			else
			{
	%>
				<jsp:forward page="advHome.jsp"></jsp:forward>
	<%		} 		
		}
		catch(Exception e)
		{
	%>
			<jsp:forward page="Error.jsp"></jsp:forward>
	<%	}
	%>	
</body>
</html>