<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
   String message = (String) request.getAttribute("message");
   if (message != null) {
      out.println("<p>" + message + "</p>");
   }
%>

<form method="post" action="TestiServlet" role="form">
Kayttajatunnus:<br>
<input type="text" name="username"><br>
Salasana:<br>
<input type="text" name="password"><br>
<input type="submit" name="Submit"><br>
</form>


</body>
</html>