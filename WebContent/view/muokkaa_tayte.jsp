<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<%@ page import="pizzicato.model.Tayte"%>
<jsp:useBean id="tayte" class="pizzicato.model.Tayte"
	scope="request" />
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
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="ListaaPizzat">Pizzeria
				Pizzicato</a>
		</div>
		<!-- Collect the nav links for toggling -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#home">Etusivu</a></li>
				<li><a href="ListaaPizzat">Pizzat</a></li>
				<li><a href="#services">Tilaukset</a></li>
				<li><a href="#free-text">Linkki</a></li>
				<li><a href="#contact">Linkki</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>
	<!--End Navigation -->


	<!-- Free Section -->

	<section id="pizzat">
	<div class="container">
		<div class="row text-center for-full-back color-light ">
			<div class="col-md-8 col-md-offset-2">
				<H1>Muokkaa Täytettä</H1>


				<form method="post" novalidate>

					

					<input type="hidden" name="tayte_id" value="<%=tayte.getTayteId()%>"/>
					Nimi:<br> <input type="text" name="nimi" value="<%=tayte.gettNimi()%>" pattern="[a-zA-Z0-9]+[a-zA-Z0-9 ]+" required ><br> <br>
					Hinta:<br> <input type="decimal" name="hinta" value="<%=tayte.gettHinta()%>"pattern="[0-9,.]{4,5}" required><br> <br>
						
						
				
				<div id="lisaapizzanapit">
					<button input type="submit" class="btn btn-success btn-lg">Tallenna</button>
					<a href="ListaaTaytteet" class="btn btn-default btn-lg" role="button">Peruuta</a>
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
				<h3>Sijaintimme</h3>
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
	<!-- CORE JQUERY  -->
	<script src="assets/plugins/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP CORE SCRIPT   -->
	<script src="assets/plugins/bootstrap.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="assets/js/custom.js"></script>

</body>
</html>
