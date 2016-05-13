<%@ page import="pizzicato.model.Tilaus"%>
<%@ page import="pizzicato.model.PizzaTilaus"%>
<jsp:useBean id="tilaus" class="pizzicato.model.Tilaus" scope="session" />
<%@ page import="pizzicato.model.Pizza"%>
<%@ page import="pizzicato.model.Tayte"%>
<%@ page import="pizzicato.model.Kayttaja"%>
<jsp:useBean id="pizzat" type="java.util.ArrayList<Pizza>"
	scope="request" />
<jsp:useBean id="kayttaja" class="pizzicato.model.Kayttaja"
	scope="session" />
	<jsp:useBean id="pizza" class="pizzicato.model.Pizza"
	scope="request" />
	<jsp:useBean id="kaikkitaytteet" type="java.util.ArrayList<Tayte>"
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
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="Etusivu">Pizzeria Pizzicato</a>
	</div>
	<!-- Collect the nav links for toggling -->
	<div class="collapse navbar-collapse navbar-ex1-collapse">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="Etusivu">Etusivu</a></li>
			<li><a href="Etusivu#pizzamenu">Pizzat</a></li>
			<li><a href="Etusivu#contact">Yhteystiedot</a></li>
			<li id="ostoskorinappi2"><a href="ostoskori" class="btn btn-primary" role="button" id="ostoskorinappi"><span class="glyphicon glyphicon-shopping-cart"></span> <span class="badge"><%=tilaus.getPizzaTilLkm()%></span></a></li>
			<li>
			
			
			
			<% 		
				if (kayttaja!= null &&  kayttaja.getUserRole()!= null){
					
					%> <li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">
						<%out.println("Tervetuloa "+"<b>"+ kayttaja.getUsername() +"</b>"+ "!"); %><b class="caret"></b></a>
						<ul class="dropdown-menu">	
           				<li>  <a href="KirjauduUlos" id="kirjaudu-ulos-nappi"><span class="glyphicon glyphicon-log-out"></span> Kirjaudu ulos</a></li>
           				
           				  <% if (kayttaja != null && kayttaja.getUserRole().equals("kokki") && kayttaja.getUserRole().equals("kuljettaja")){%>
           				<li> <a href="roolinvalitseminen" id="kirjaudu-ulos-nappi"><i class="fa fa-user" aria-hidden="true"></i> Roolin valitseminen</a></li>
           				
           					<%} %>
           					
           				 <% if (kayttaja != null && kayttaja.getUserRole().equals("omistaja")){%>
     
           				<li> <a href="ListaaPizzat" id="kirjaudu-ulos-nappi"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Muokkaa pizzoja</a></li>
           				<li> <a href="roolinvalitseminen" id="kirjaudu-ulos-nappi"><i class="fa fa-user" aria-hidden="true"></i> Roolinäkymät</a></li>
           					<%} %>
           				
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
				<H1>Muokkaa Pizzaa</H1>


				<form method="post">

					<div class="imagePreview"></div>
					<input type="file" name="imagefile"
						onchange="previewImage(this,[256],4);" /><br>
					<!--  onchange="previewImage(this,[sizes],limit);" * limit is number of Mb  -->

					<input type="hidden" name="pizza_id" value="<%=pizza.getPizzaId()%>"/>
					Nimi:<br> <input type="text" name="nimi" value="<%=pizza.getpNimi()%>" pattern="[a-zA-Z0-9]+[a-zA-Z0-9 ]+" oninvalid="setCustomValidity('Nimessä pitää olla kirjaimia tai numeroita ja pituus vähintään 2 merkkiä.')" oninput="setCustomValidity('')" required ><br> <br>
					Hinta:<br> <input type="decimal" name="hinta" value="<%=pizza.getpHinta()%>" pattern="[0-9,.]{4,5}" oninvalid="setCustomValidity('Hinnan pitää olla numeroina ja muodossa x,xx')" oninput="setCustomValidity('')" required><br> <br>
						
						Täytteet: <br> 
						
							<%--<div class="taytteet">
						
					<%for (int i = 0; i <kaikkitaytteet.size(); i++) {%>
						
						<input type="checkbox" name="tayte"
						
						<%if (pizza.getTaytteet().contains(kaikkitaytteet.get(i).gettNimi()));
						{out.print("checked=\"checked\"");}%>
						
						value="<%=kaikkitaytteet.get(i).getTayteId() %>" /> <%=kaikkitaytteet.get(i).gettNimi() %> <br>
						<%}%>
					
					
						</div>
						<br>
						
						--%>
					<% for (int i = 0; i < kaikkitaytteet.size(); i++) {
							String checked="";
							 for (int j = 0; j < pizza.getTaytteet().size(); j++) {
								 if (pizza.getTaytteet().get(j).getTayteId() == kaikkitaytteet.get(i).getTayteId()) {
									 checked="checked";
								 }																
							}	
							%><input type="checkbox" name="tayte" <%=checked%> value="<%=kaikkitaytteet.get(i).getTayteId()%>">  <%=kaikkitaytteet.get(i).gettNimi()%><br>
					
						<%} %>
					
					
					<br>Valikoimassa<br> <select name="valikoimassa">
						<option value="true">Kyllä</option>
						<option value="false">Ei</option>
					</select>

				
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

	<div class="col-md-4 contact-cls"  id="osoitekartta">
		<h3><span><i class="fa fa-home"></i>&nbsp;Osoite:</span></h3>
		<div>
			<span>Kuusitie 6, Meilahti, Helsinki</span> <br />
			<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script><div style="overflow:hidden;height:200px;width:250px;"><div id="gmap_canvas" style="height:200px;width:290px;"><style>#gmap_canvas img{max-width:none!important;background:none!important}</style><a class="google-map-code" href="http://www.themecircle.net" id="get-map-data">Kartta</a></div></div><script type="text/javascript"> function init_map(){var myOptions = {zoom:16,center:new google.maps.LatLng(60.19484920000001,24.89962639999999),mapTypeId: google.maps.MapTypeId.ROADMAP};map = new google.maps.Map(document.getElementById("gmap_canvas"), myOptions);marker = new google.maps.Marker({map: map,position: new google.maps.LatLng(60.19484920000001, 24.89962639999999)});infowindow = new google.maps.InfoWindow({content:"<b>Pizzeria Pizzicato</b><br/>kuusitie 6<br/> Helsinki" });google.maps.event.addListener(marker, "click", function(){infowindow.open(map,marker);});infowindow.open(map,marker);}google.maps.event.addDomListener(window, 'load', init_map);</script>

		</div>

	</div>
	
	<div class="col-md-2 contact-cls">
		<h3><span><i class="fa fa-clock-o"></i>&nbsp;Aukioloajat:</span></h3>
		<div>
			<span>ma-to 11 - 21<br>pe-la  11 - 22<br>su		12 - 19  </span>
			

		</div>

	</div>
	
	<div class="col-md-5 contact-cls">
		<h3><span><i class="fa fa-phone"></i>&nbsp;Puhelin:</span></h3>
		<div>
			<span>(+358) 040-123456</span> <br /> 
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
