<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.girish.DAOLayers.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	try
	{
		if(request.getSession(false) != null)
		{
			UsersBean b = (UsersBean)session.getAttribute("user");
			CoursePlanBean cpb = new CoursePlanBean();
			CoursePlanDAOImpl cpd = new CoursePlanDAOImpl();
			
			cpb.setNetid(b.getNetid());
			cpb.setC_id(request.getParameter("cid"));
			cpb.setSec_id(request.getParameter("secid"));
			cpb.setTerm(request.getParameter("secterm"));
			int year = Integer.parseInt(request.getParameter("secyear"));
			cpb.setYear(year);
			cpb.setGrade("NA");
			
			cpd.write(cpb);	
%>	
			<jsp:forward page="enroll.jsp"></jsp:forward>	
<% 		}
	}
	catch(Exception e)
	{
%>
		<jsp:forward page="Error.jsp"></jsp:forward>

<% 	}
%>
</body>
</html>