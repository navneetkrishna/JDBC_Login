<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Documents</title>
</head>
<body>


	<%
		response.setHeader("Cache-Control", "no-cache , no-store , must-revalidate");	//HTTP1.1
		response.setHeader("pargma", "no-cache");		//for older version of HTTP (1.0)
		response.setHeader("Expires", "0");				//proxies
		
		String username = (String)session.getAttribute("username");
		if ( username == null )
		{
			response.sendRedirect("Login.jsp");  
		} 
	%>	
		
	<jsp:include page="Link.jsp"></jsp:include>	
	
	<h3>here are some cool stuffs...</h3>
	<ul>
	Types of Beverages
	<li>tea</li>
	<li>Coffee</li>
	<li>Soft Drinks</li>
	</ul>		



</body>
</html>