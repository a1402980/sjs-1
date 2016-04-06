<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- BOOTSTRAP CORE STYLE CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLE CSS -->
<link type="text/css" href="assets/css/font-awesome.min.css"
	rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-inverse" data-spy="affix" data-offset-top="500" id=navigaatio>
<div class="container">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="ListaaPizzat">Pizzeria Pizzicato</a>
		</div>
		<!-- Collect the nav links for toggling -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#home">Etusivu</a></li>
				<li><a href="#pizzamenu">Pizzat</a></li>
				<li><a href="#services">Tilaukset</a></li>
				<li><a href="#free-text">Yhteystiedot</a></li>
				<li><a><button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#myModal" style=text-align="center">Kirjaudu</button></a>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> 
</nav>
<!-- end of navigation --> 
	
<script type="text/javascript">

	$('nav').affix({
	    offset: {
	      top: $('nav#navigaatio').offset().top
	    }
	}); 

</script>
	
	
	
<!-- Free Section -->
<% 
   String message = (String) request.getAttribute("message");
   if (message != null) {
      out.println("<p>" + message + "</p>");
   }
%>
<section id="pizzat">
	<div class="container">
    	<div class="row text-center for-full-back color-light">
        	<div class="col-md-8 col-md-offset-2">
<form method="post" action="TestiServlet" role="form">
Kayttajatunnus:<br>
<input type="text" name="username"><br>
Salasana:<br>
<input type="text" name="password"><br>
<input type="submit" name="Submit"><br>
</form>

</div>
</div>
</div>
</section>

</body>
</html>