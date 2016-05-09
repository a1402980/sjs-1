<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<%@ page import="pizzicato.model.Tayte"%>
<%@ page import="pizzicato.model.Pizza"%>
<%@ page import="pizzicato.model.Kayttaja"%>
<jsp:useBean id="kaikkitaytteet" type="java.util.ArrayList<Tayte>"
	scope="request" />
<jsp:useBean id="kayttaja" class="pizzicato.model.Kayttaja"
	scope="session" />
<html lang="fi">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
<title>Pizzeria Pizzicato</title>
<!--REQUIRED STYLE SHEETS-->
    <!-- JQUERY CODE SOURCE -->
    <script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<!-- BOOTSTRAP CORE STYLE CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLE CSS -->
<link href="assets/css/font-awesome.min.css" rel="stylesheet" />
<!-- CUSTOM STYLE CSS -->
<link href="assets/css/style.css" rel="stylesheet" />
<!-- GOOGLE FONT -->
<link href='https://fonts.googleapis.com/css?family=Raleway'
	rel='stylesheet' type='text/css'>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="assets/js/html5.image.preview.min.js"></script>
<!-- tämä on skripti kuvien esikatseluun  -->
</head>
<body>
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
<div class="container">

	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-ex1-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="ListaaPizzat">Pizzeria Pizzicato</a>
	</div>
	<!-- Collect the nav links for toggling -->
	<div class="collapse navbar-collapse navbar-ex1-collapse">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="Etusivu">Etusivu</a></li>
			<li><a href="Etusivu#pizzamenu">Pizzat</a></li>
			<li><a href="#contact">Yhteystiedot</a></li>
			<li id="ostoskorinappi2"><a href="ostoskori" class="btn btn-primary" role="button" id="ostoskorinappi"><span class="glyphicon glyphicon-shopping-cart"></span> <span class="badge">7</span></a></li>
			<li>
			<% 		
				if (kayttaja!= null &&  kayttaja.getUserRole()!= null){
					
					%> <li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">
						<%out.println("Tervetuloa "+"<b>"+ kayttaja.getUsername() +"</b>"+ "!"); %><b class="caret"></b></a>
						<ul class="dropdown-menu">	
           				<li>  <a href="KirjauduUlos" id="kirjaudu-ulos-nappi"><span class="glyphicon glyphicon-log-out"></span> Kirjaudu ulos</a></li>
						</ul>
					<%} 
			
					
				else {%> <li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>
						Kirjaudu <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<form method="post" role="form" class="navbar-form navbar-right">
							<div class="form-group">
								<input type="text" class="form-control" name="username"
									placeholder="Käyttäjätunnus" autocomplete="off">
							</div>
							<div class="form-group">
								<input type="password" class="form-control" name="password"
									placeholder="Salasana" autocomplete="off">
							</div class="form-group">
							<button type="submit" name="kirjautumisnappi" class="btn btn-primary">Kirjaudu</button>
						</form>
						<div id=huomio>
							<span id="ilmoitus">
								<%
									String message = (String) request.getAttribute("message");
									if (message != null) {
										out.println("<p>" + message + "</p>");
									}
								%>
							</span>
						</div>


					</ul>
					
				<li><a href="Rekisteroityminen">Rekisteröidy</a></li>
					</li>
		
		
				<%} %>
		
		
			
			
		</ul>
	</div>
	<!-- /.navbar-collapse -->
</div>
<!-- /.container --> </nav>
<!-- end of navigation -->


	<!-- Free Section -->

	<section id="pizzat">
	<div class="container">
		<div class="row text-center for-full-back color-light ">
			<div class="col-md-8 col-md-offset-2">
				<H1>Lisää Pizza</H1>


				<form method="post">

					<div class="imagePreview"></div>
					<input type="file" name="imagefile"
						onchange="previewImage(this,[256],4);" /><br>
					<!--  onchange="previewImage(this,[sizes],limit);" * limit is number of Mb  -->


					Nimi:<br> <input type="text" name="nimi" placeholder="Kirjoita pizzan nimi tähän" pattern="[a-zA-Z0-9]+[a-zA-Z0-9 ]+"  oninvalid="setCustomValidity('Nimessä pitää olla kirjaimia tai numeroita ja pituus vähintään 2 merkkiä.')" oninput="setCustomValidity('')"  required  ><br> <br>
					Hinta:<br> <input type="decimal" name="hinta" placeholder="X,XX Hinta ei yli 100€" pattern="[0-9,.]{4,5}"  oninvalid="setCustomValidity('Hinnan pitää olla numeroina ja ei yli 100€')" oninput="setCustomValidity('')"  required ><br> <br>



						Täytteet: <br>
						
						<%for(int i = 0; i < kaikkitaytteet.size(); i++) {%>
	
						<input type="checkbox" name="tayte" value="<%=kaikkitaytteet.get(i).getTayteId()%>"><%=kaikkitaytteet.get(i).gettNimi()%><br>
  												<%} %>		
  												
				 <br>Valikoimassa<br> <select name="valikoimassa">
						<option value="true">Kyllä</option>
						<option value="false">Ei</option></select>
						
				<div id="lisaapizzanapit">
					<button input type="submit" class="btn btn-success btn-lg">Tallenna</button>
					<a href="ListaaPizzat" class="btn btn-default btn-lg" role="button">Peruuta</a>
				</div>

				</form>
							
			</div>

		</div>
	</div>
	</section>
	<!--End Free Section -->

	<!-- Contact Section -->
	<section class="for-full-back color-white " id="contact">
	<div class="container">
		<div class="row text-center"></div>

		<div class="row">
			<div class="col-md-5 contact-cls">
				<h3>Yhteystiedot</h3>
				<div>
					<span><i class="fa fa-home"></i>&nbsp;Osoite</span> <br /> <span><i
						class="fa fa-phone"></i>&nbsp;Puhelin</span> <br /> <span><i
						class="fa fa-envelope-o"></i>&nbsp;e-mail</span> <br /> <span><i
						class="fa fa-phone"></i>&nbsp;Puhelin</span> <br />
				</div>

			</div>
		</div>
	</div>
	</section>

	<!--End Contact Section -->
	<!--footer Section -->
	<div class="for-full-back " id="footer">2016 | Silver Java
		Slayers</div>
	<!--End footer Section -->
	<!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
	<!-- BOOTSTRAP CORE SCRIPT   -->
	<script src="assets/plugins/bootstrap.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="assets/js/custom.js"></script>
	

</body>
</html>
