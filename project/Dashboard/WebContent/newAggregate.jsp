<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="appstyle.css">




<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New</title>
</head>
<body>

<div id="title" onclick="location.href='dashboard.jsp'">
		Dashboard
	</div>
	
	
	<div id="ContainerTails">
	<div class="tail">
 		<form action="dashboard.jsp">
  		Insert name of the new aggregate
  		<input type="text" name="name" value="">
  		<% if(request.getParameterMap().containsKey("aggregateType")) out.println("<input type=\"text\" name=\"aggregateType\" value=\""+request.getParameter("aggregateType")+"\" style=\"visibility:hidden; width:0px; height:0px;\">"); 
  		if(request.getParameterMap().containsKey("id")) out.println("<input type=\"text\" name=\"aggregateType\" value=\""+request.getParameter("id")+"\" style=\"visibility:hidden; width:0px; height:0px;\">"); %>
  		<input type="submit" value="Create"></form></div></div>

</body>
</html>