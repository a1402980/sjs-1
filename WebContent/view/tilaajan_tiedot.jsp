<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<%@ page import="pizzicato.model.Asiakas"%>

<jsp:useBean id="tilaus" class="pizzicato.model.Tilaus"
	scope="session" />
<jsp:useBean id="kayttaja" class="pizzicato.model.Kayttaja"
	scope="session" />
	<jsp:useBean id="asiakas" class="pizzicato.model.Asiakas"
	scope="session" />
<jsp:useBean id="errors" type="java.util.Map" class="java.util.HashMap" scope= "request"/>
	
<html lang="fi">
<!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
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
    <link type="text/css" href="assets/css/font-awesome.min.css" rel="stylesheet" />
    <!-- CUSTOM STYLE CSS -->
    <link type="text/css" href="assets/css/style.css" rel="stylesheet" />
    <!-- GOOGLE FONT -->
    <link type="text/css" href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
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
				<H1>Asiakastiedot</H1>
				
				
				
			<% 
             if (errors.containsKey("url")) {
                out.println("<span class=\"error\">" + errors.get("url") + "</span>");%>
            
				<div class="alert alert-success">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> 
					
				</div>
				
			<%}%>
			
				<br><span style="color:red;">* Pakollinen kenttä</span>	<br><br>
				
				
			<!-- Jos asiakas on kirjautuneena, näytetään valmiiksi täytetty lomake-->
			
<!-- Etunimi -->
			<%if(kayttaja.getUsername() != null) { %>
				<form autocomplete="off" action="TilaajanTiedot" method="post">
				<%String virhe = null;
				virhe = (String) errors.get("enimi");
					if (virhe != null) {%>
						<div class="alert alert-danger">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> 
						<%out.println("<strong>" + virhe + "</strong>");%></div> <%}
					session.setAttribute("virhe", null);%>		
				<span style="color:red;">*</span>Etunimi: <br><input type="text" name="etunimi"	 value="<%=asiakas.getEtuNimi() %>" pattern="[a-zåäöA-ZÅÄÖ0-9- ]{2,50}"  oninvalid="setCustomValidity('Nimen on oltava vähintään 2, enintään 30 merkkiä, ei erikoismerkkejä tai numeroita')" oninput="setCustomValidity('')" required ><br><br>

<!-- Sukunimi -->				
				<%virhe = (String) errors.get("snimi");
					if (virhe != null) {%>
						<div class="alert alert-danger">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> 
						<%out.println("<strong>" + virhe + "</strong>");%></div> <%}
					session.setAttribute("virhe", null);%>
					<span style="color:red;">*</span>Sukunimi: <br><input type="text" name="sukunimi" value="<%=asiakas.getSukuNimi() %>"  pattern="[a-zåäöA-ZÅÄÖ0-9- ]+[a-zåäöA-ZÅÄÖ0-9- ]{2,50}" oninvalid="setCustomValidity('Nimen on oltava vähintään 2, enintään 30 merkkiä, ei erikoismerkkejä tai numeroita')" oninput="setCustomValidity('')" required ><br><br>

<!-- Puhelin -->				
					<%virhe = (String) errors.get("puh");
					if (virhe != null) {%>
						<div class="alert alert-danger">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> 
						<%out.println("<strong>" + virhe + "</strong>");%></div> <%}
					session.setAttribute("virhe", null);%>
					<span style="color:red;">*</span>Puhelin: <br><input type="text" name="puh" 	value="<%=asiakas.getPuh() %>" pattern="[0-9]{7,16}" title="Numeron on oltava vähintään 7, enintään 16 merkkiä, ei erikoismerkkejä tai kirjaimia" oninput="setCustomValidity('')" required ><br><br>
	
<!-- Katuosoite -->			
					<%virhe = (String) errors.get("osoite");
					if (virhe != null) {%>
						<div class="alert alert-danger">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> 
						<%out.println("<strong>" + virhe + "</strong>");%></div> <%}
					session.setAttribute("virhe", null);%>	
					<span style="color:red;">*</span>Katuosoite: <br><input type="text" name="osoite" 	value="<%=asiakas.getOsoite() %>" pattern="[a-zåäöA-ZÅÄÖ0-9- ]{2,30}" oninvalid="setCustomValidity('Osoitteen on oltava vähintään 2, enintään 30 merkkiä, ei erikoismerkkejä tai numeroita')" oninput="setCustomValidity('')" required ><br><br>
<!-- Postinro -->						
					<%virhe = (String) errors.get("postinro");
					if (virhe != null) {%>
						<div class="alert alert-danger">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> 
						<%out.println("<strong>" + virhe + "</strong>");%></div> <%}
					session.setAttribute("virhe", null);%>
					<span style="color:red;">*</span>Postinumero: <br><input type="text" name="postinro" value="<%=asiakas.getPostiNro() %>" pattern="[0-9]{5}" oninvalid="setCustomValidity('Postinumerossa on oltava viisi numeroa!')" oninput="setCustomValidity('')" required ><br><br>

<!-- Postitoimip -->						
					<%virhe = (String) errors.get("postitmp");
					if (virhe != null) {%>
						<div class="alert alert-danger">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> 
						<%out.println("<strong>" + virhe + "</strong>");%></div> <%}
					session.setAttribute("virhe", null);%>
					<span style="color:red;">*</span>Postitoimipaikka: <br><input type="text" name="postitmp" value="<%=asiakas.getPostiTmp() %>" pattern="[a-zåäöA-ZÅÄÖ- ]{2,15}" oninvalid="setCustomValidity('Postitoimipaikan on oltava vähintään 2, enintään 15 merkkiä, ei erikoismerkkejä tai numeroita')" oninput="setCustomValidity('')" required ><br><br>					
<!-- sposti -->					
					<%virhe = (String) errors.get("sposti");
					if (virhe != null) {%>
						<div class="alert alert-danger">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> 
						<%out.println("<strong>" + virhe + "</strong>");%></div> <%}
					session.setAttribute("virhe", null);%>
					<span style="color:red;">*</span>Sähköposti: <br><input type="text" 	name="sposti" 	value="<%=asiakas.getsPosti() %>" pattern="[a-zA-Z0-9@.]{6,50}" oninvalid="setCustomValidity('Sähköpostin on oltava vähintään 6, enintään 50 merkkiä, ei muita erikoismerkkejä kuin @')" oninput="setCustomValidity('')" ><br><br>
										
					<button type="submit" name="kirjautumisnappi" class="btn btn-success btn-lg">Jatka</button>
					<a class="btn btn-default" href="ostoskori" role="button">Takaisin</a><br><br>
				</form>
				
			<%} else {%>
						
			<!--  Jos asiakas ei ole kirjautunut, näytetään tyhjä lomake -->
			
				<form method="post" autocomplete="off">
				
				<%String virhe = null;
				virhe = (String) errors.get("enimi");
					if (virhe != null) {%>
						<div class="alert alert-danger">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> 
						<%out.println("<strong>" + virhe + "</strong>");%></div> <%}
					session.setAttribute("virhe", null);%>
					<span style="color:red;">*</span>Etunimi: <br><input type="text" name="etunimi" placeholder="Etunimi" pattern="[a-zåäöA-ZÅÄÖ0-9- ]{2,30}" oninvalid="setCustomValidity('Nimen on oltava vähintään 2, enintään 30 merkkiä, ei erikoismerkkejä tai numeroita')" oninput="setCustomValidity('')" required ><br><br>
					
					<%virhe = (String) errors.get("snimi");
					if (virhe != null) {%>
						<div class="alert alert-danger">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> 
						<%out.println("<strong>" + virhe + "</strong>");%></div> <%}
					session.setAttribute("virhe", null);%>
					<span style="color:red;">*</span>Sukunimi: <br><input type="text"  name="sukunimi" placeholder="Sukunimi" pattern="[a-zåäöA-ZÅÄÖ0-9- ]+[a-zåäöA-ZÅÄÖ0-9- ]{2,30}" oninvalid="setCustomValidity('Nimen on oltava vähintään 2, enintään 30 merkkiä, ei erikoismerkkejä tai numeroita')" oninput="setCustomValidity('')" required ><br><br>
					
					<%virhe = (String) errors.get("puh");
					if (virhe != null) {%>
						<div class="alert alert-danger">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> 
						<%out.println("<strong>" + virhe + "</strong>");%></div> <%}
					session.setAttribute("virhe", null);%>
					<span style="color:red;">*</span>Puhelin: <br><input type="text" name="puh" placeholder="Puhelinnumero" pattern="[0-9]{7,16}" title="Numeron on oltava vähintään 7, enintään 16 merkkiä, ei erikoismerkkejä tai kirjaimia" oninput="setCustomValidity('')" required ><br><br>
					
					<%virhe = (String) errors.get("osoite");
					if (virhe != null) {%>
						<div class="alert alert-danger">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> 
						<%out.println("<strong>" + virhe + "</strong>");%></div> <%}
					session.setAttribute("virhe", null);%>
					<span style="color:red;">*</span>Katuosoite: <br><input type="text" name="osoite" placeholder="Katuosoite" pattern="[a-zåäöA-ZÅÄÖ0-9- ]{2,30}" oninvalid="setCustomValidity('Osoitteen on oltava vähintään 2, enintään 30 merkkiä, ei erikoismerkkejä tai numeroita')" oninput="setCustomValidity('')" required ><br><br>
					
					<%virhe = (String) errors.get("postinro");
					if (virhe != null) {%>
						<div class="alert alert-danger">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> 
						<%out.println("<strong>" + virhe + "</strong>");%></div> <%}
					session.setAttribute("virhe", null);%>
					<span style="color:red;">*</span>Postinumero: <br><input type="text" name="postinro" placeholder="Postinumero" pattern="[0-9]{5}" oninvalid="setCustomValidity('Postinumerossa on oltava viisi numeroa!')" oninput="setCustomValidity('')" required ><br><br>
					
					<%virhe = (String) errors.get("postitmp");
					if (virhe != null) {%>
						<div class="alert alert-danger">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> 
						<%out.println("<strong>" + virhe + "</strong>");%></div> <%}
					session.setAttribute("virhe", null);%>
					<span style="color:red;">*</span>Postitoimipaikka: <br><input type="text" name="postitmp" placeholder="Postitoimipaikka" pattern="[a-zåäöA-ZÅÄÖ- ]{2,15}" oninvalid="setCustomValidity('Postitoimipaikan on oltava vähintään 2, enintään 15 merkkiä, ei erikoismerkkejä tai numeroita')" oninput="setCustomValidity('')" required ><br><br>
					
					<%virhe = (String) errors.get("sposti");
					if (virhe != null) {%>
						<div class="alert alert-danger">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> 
						<%out.println("<strong>" + virhe + "</strong>");%></div> <%}
					session.setAttribute("virhe", null);%>
					<span style="color:red;">*</span>Sähköposti: <br><input type="text" name="sposti" placeholder="Sähköposti" pattern="[a-zA-Z0-9@.]{6,50}" oninvalid="setCustomValidity('Sähköpostin on oltava vähintään 6, enintään 50 merkkiä, ei muita erikoismerkkejä kuin @')" oninput="setCustomValidity('')" ><br><br>
					
					<a class="btn btn-default" href="ostoskori" role="button"><i class="fa fa-arrow-circle-o-left" aria-hidden="true"></i> Takaisin</a>
					<button type="submit" onClick="window.location='TilausYhteenveto';" name="kirjautumisnappi" class="btn btn-success btn-lg">Jatka</button><br><br>
					
				</form>
			<%}%>
			
			
					
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
    <div class="for-full-back " id="footer">
        2016 | Silver Java Slayers
         
    </div>
    <!--End footer Section -->
    <!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
    <!-- BOOTSTRAP CORE SCRIPT   -->
    <script src="assets/plugins/bootstrap.js"></script>
    <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>

</body>
</html>
