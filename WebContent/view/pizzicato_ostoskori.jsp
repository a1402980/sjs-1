<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->

<%@ page import="pizzicato.model.Pizza"%>
<%@ page import="pizzicato.model.Tilaus"%>
<%@ page import="pizzicato.model.PizzaTilaus"%>
<%@ page import="pizzicato.model.Kayttaja"%>
<%@ page import="java.text.DecimalFormat"%>
<jsp:useBean id="tilaus" class="pizzicato.model.Tilaus" scope="session" />
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
<link type="text/css" href="assets/css/font-awesome.min.css"
	rel="stylesheet" />
<!-- CUSTOM STYLE CSS -->
<link type="text/css" href="assets/css/style.css" rel="stylesheet" />
<!-- GOOGLE FONT -->
<link type="text/css"
	href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet'
	type='text/css'>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    
     <script>
  $(document).ready(function() {
    
	$('.juoma').click(function() {
		var total = 0;
		
		$('.juoma:checked').each(function(){
		
			total += parseFloat($(this).val());
		
		});
		$('#juomasumma').html(total);
		
	});
	
  });
 </script>

    
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
				<H1>Ostoskori</H1>

				<div class="table-responsive">
					<table class="table table-hover" align="center"
						id="ostoskori_asiakkaalle">
						<tr>
							<th>Nimi</th>
							<th>Täytteet</th>
							<th>Hinta</th>
							<th style="display:none;">Lkm</th>
							<th>Lisätäytteet</th>
							<th></th>
							<th style="display:none;">Rivi</th>
						</tr>
						<%
							PizzaTilaus pizzatilaus;
									Pizza pizza;
						%>
						<%
							for (int i = 0; i < tilaus.getPizzaTilLkm(); i++) {
						%>
						<tr>
							<td>
								<%
									pizzatilaus = tilaus.getPizzaTilaus(i); 
												pizza = pizzatilaus.getPizza();
								%> <%=pizza.getpNimi()%>
							</td>
							<td>
								<%
									for (int j=0; j<pizza.getTaytteet().size(); j++){
								%> <%=pizza.getTayte(j).gettNimi()%>
								<%
									}
								%>
							</td>
							<td><%=pizza.getpHinta()%></td>
							<td style="display:none;"><%=tilaus.getPizzaTilLkm()%></td>
							<td><input type="checkbox" name="oregano"> Oregano <br>
								<input type="checkbox" name="valkosipuli"> Valkosipuli
							<td>
								<button onclick="poistapizza(<%=i%>)"> <!-- i= väliaikainen rivinumero ostoskorissa -->
									<span class="glyphicon glyphicon-trash"></span>
								</button>
							</td>
							<td style="display:none;"><%=i%> </td>
						</tr>
						<%
							}
						%>
					</table>

<form method="get" action="TilaajanTiedot">
				

				<div id="ostoskorinvalinnat">
					<h3>Maksutapa</h3>
					
						<input type="radio" name="maksutapa"> Pankkikortilla <i
							class="fa fa-credit-card" aria-hidden="true"></i><br> <input
							type="radio" name="maksutapa"> Käteisellä <i
							class="fa fa-money" aria-hidden="true"></i><br>
						<h3>Juomat (1,5L)</h3>
						<div class="row" id=juomat>

							<input type="checkbox" class="juoma" name="cola" value="4"><img
								src="assets/images/cola.png" alt="Coca Cola"
								style="height: 35px;"><br> <input type="checkbox" class="juoma"
								name="sprite" value="4"><img src="assets/images/sprite.png"
								alt="Sprite" style="height: 100%;"><br> <input
								type="checkbox" class="juoma" name="fanta" value="4"><img
								src="assets/images/fanta.png" alt="Fanta" style="height: 100%;"><br>
						</div>
				
				</div>
			</div>


			<hr>


			<!--loppusumman näyttäm. -->
			<div>
			<br>
			<span style="font-size: 200%; font-weight: bold;">Juomien hinta: </span>
			<span style="font-size: 200%; font-weight: bold;" id="juomasumma" class="juomiensumma">0</span>
			<i class="fa fa-eur" aria-hidden="true" style="font-size:150% "></i><br>
			
			<span style="font-size: 200%; font-weight: bold;">Pizzojen yhteishinta: </span>
			<span style="font-size: 200%; font-weight: bold;" id="total" class="pizzasumma">
				
				<%
				double yhteishinta = 0;
					 PizzaTilaus pizzatilaus2;
					 for (int i=0;i<tilaus.getPizzaTilLkm();i++){  
						pizzatilaus2= tilaus.getPizzaTilaus(i);
						 yhteishinta += pizzatilaus2.getPizza().getpHinta()*1;	
					}
					 DecimalFormat des = new DecimalFormat("0.00");
						des.format(yhteishinta);
			%>



				<%=des.format(yhteishinta)%>
				<%session.setAttribute("yhteishinta", yhteishinta); %>
				
			
			</span>
			<i class="fa fa-eur" aria-hidden="true" style="font-size:150% "></i><br>
			
			<span style="font-size: 300%; font-weight: bold;">Lopullinen summa: </span>
			<span style="font-size: 300%; font-weight: bold;" id="summat" name="summa"></span>
			<i class="fa fa-eur" aria-hidden="true" style="font-size:200% "></i><br>
			
			 <script>
 
 $(document).ready(function() {
 
	 $(":checkbox").on("click", function(){
		 var pizzat = parseFloat($('.pizzasumma').text().replace(',', '.'));
		 var juomat = parseFloat($('.juomiensumma').text());

		 
		 //var juomat1 = juomat.toFixed(4);
		 //var pizzat1 = pizzat.toFixed(4);
		
		 total = juomat + pizzat;
		 $('#summat').text(total.toFixed(2));
		} );
	 
 });
 
 </script>
 
 			 <script>
 
 $(document).ready(function() {
 
	 
		 var pizzat = parseFloat($('.pizzasumma').text().replace(',', '.'));

		 $('#summat').text(pizzat.toFixed(2));
		
	 
 });
 
 
 </script>

		 		
			</div>



			<div>
				<a class="btn btn-default" href="Etusivu" role="button">Peruuta</a>
				<button input type="submit"
					class="btn btn-success btn-lg">Tilaa </button>
				
			</div>

			<p>Ongelmia? Lähetä sähköpostia osoitteeseen
				apua@silverjavaslayers.fi</p>
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
	<!-- BOOTSTRAP CORE SCRIPT   -->
	<script src="assets/plugins/bootstrap.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="assets/js/custom.js"></script>


	<script>function poistapizza(rivinro){
								var p = confirm("Poistetaanko pizza?"); // poistonappi
								if(p==true){
									window.location="PoistaOstoskorista?rivinro="+rivinro;
								}else{
									window.location="ostoskori";
								}
						} 
	</script>


</body>
</html>
