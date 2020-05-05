<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>

	<%
		response.setHeader("Cache-Control", "no-cache , no-store , must-revalidate");	//for HTTP !.1
		response.setHeader("pargma", "no-cache");		//for older version of HTTP (1.0)
		response.setHeader("Expires", "0");		//proxies
		
		String username = (String)session.getAttribute("username");
		if ( username == null )
		{
			 response.sendRedirect("Login.jsp");
		} 
	%>
		<jsp:include page="Link.jsp"></jsp:include><br><hr>	
		<h1>Welcome ${ username } </h1>		<br><hr>
	
	<h3>Click <a href=Documents.jsp>here</a> to explore ...</h3>
	
	
	

</body>
</html>