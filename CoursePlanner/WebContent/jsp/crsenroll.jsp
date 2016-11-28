<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.girish.DAOLayers.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>in course enroll table</h1>
	<%
	try
	{
		if(request.getSession(false) != null)
		{
			UsersBean b = (UsersBean)session.getAttribute("user");
			EnrollsBean eb = new EnrollsBean();
			EnrollsDAOImpl edi = new EnrollsDAOImpl();
			
			eb.setNetid(b.getNetid());
			eb.setC_id(request.getParameter("cid"));
			eb.setSec_id(request.getParameter("sid"));
			eb.setTerm(request.getParameter("term"));
			int year = Integer.parseInt(request.getParameter("yr"));
			eb.setYear(year);
			eb.setGpa(0);
			eb.setGrade("NA");
			eb.setStatus("Enrolled");
			
			edi.write(eb);
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