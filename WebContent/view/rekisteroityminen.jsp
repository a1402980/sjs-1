<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->

<%@ page import="pizzicato.model.Kayttaja"%>

<jsp:useBean id="kayttaja" class="pizzicato.model.Kayttaja"
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
		<a class="navbar-brand" href="ListaaPizzat">Pizzeria Pizzicato</a>
	</div>
	<!-- Collect the nav links for toggling -->
	<div class="collapse navbar-collapse navbar-ex1-collapse">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="Etusivu">Etusivu</a></li>
			<li><a href="#pizzamenu">Pizzat</a></li>
			<li><a href="#contact">Yhteystiedot</a></li>
			<li><a href="ostoskori" class="btn btn-primary" role="button" id="ostoskorinappi"><span class="glyphicon glyphicon-shopping-cart"></span> <span class="badge">7</span></a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>
					Kirjaudu <b class="caret"></b></a>
				<ul class="dropdown-menu">
				
				<li role="separator" class="divider" id="kirjaudu-ulos-nappi"></li>
           		<li><a href="KirjauduUlos">Kirjaudu ulos</a></li>
            	<li role="separator" class="divider"></li>
            	
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
				<H1>Rekisteröityminen</H1>

				<%
				
				if(null!=request.getAttribute("errors"))
				{
					for(int i = 0; i < errors.size(); i++) {
						out.println(request.getAttribute("<span class=\"errors\">" + errors.get(i) + "</span>"));
					}
				}%>
				
				<br><br><span style="color:red;">* Pakollinen kenttä</span>	<br><br>
				<form method="post">

					<span style="color:red;">*</span>Käyttäjätunnus:<br><input type="text" name="kayttajatunnus" placeholder="Kirjoita haluamasi käyttäjätunnus" pattern="[a-zA-Z0-9]+[a-zA-Z0-9 ]{2,15}" oninvalid="setCustomValidity('Nimessä ei voi olla erikoismerkkejä ja pituus vähintään 2 merkkiä!')" oninput="setCustomValidity('')" required ><br><br>
					<span style="color:red;">*</span>Salasana:<br><input type="password" name="salasana" placeholder="Vähintään 8 merkkiä" pattern="[a-zA-Z0-9]+[a-zA-Z0-9 ]{8,10}" oninvalid="setCustomValidity('Salasanassa ei voi olla erikoismerkkejä ja pituus vähintään 8 merkkiä!')" oninput="setCustomValidity('')" required ><br><br>
					<span style="color:red;">*</span>Etunimi: <br><input type="text" placeholder="Etunimi" pattern="[a-zåäöA-ZÅÄÖ0-9- ]{2,30}" name="etunimi" oninvalid="setCustomValidity('Nimen on oltava vähintään 2, enintään 30 merkkiä, ei erikoismerkkejä tai numeroita')" oninput="setCustomValidity('')" required ><br><br>
					<span style="color:red;">*</span>Sukunimi: <br><input type="text" placeholder="Sukunimi" name="sukunimi" pattern="[a-zåäöA-ZÅÄÖ0-9- ]+[a-zåäöA-ZÅÄÖ0-9- ]{2,30}" oninvalid="setCustomValidity('Nimen on oltava vähintään 2, enintään 30 merkkiä, ei erikoismerkkejä tai numeroita')" oninput="setCustomValidity('')" required ><br><br>
					<span style="color:red;">*</span>Puhelin: <br><input type="text" name="puh" placeholder="Puhelinnumero" pattern="[0-9]{7,16}" title="Numeron on oltava vähintään 7, enintään 16 merkkiä, ei erikoismerkkejä tai kirjaimia" oninput="setCustomValidity('')" required ><br><br>
					<span style="color:red;">*</span>Katuosoite: <br><input type="text" name="osoite" placeholder="Katuosoite" pattern="[a-z åäöA-ZÅÄÖ0-9-]{2,30}" oninvalid="setCustomValidity('Osoitteen on oltava vähintään 2, enintään 30 merkkiä, ei erikoismerkkejä tai numeroita')" oninput="setCustomValidity('')" required ><br><br>
					<span style="color:red;">*</span>Postinumero: <br><input type="text" name="postinro" placeholder="Postinumero" pattern="[0-9]{5}" oninvalid="setCustomValidity('Postinumerossa on oltava viisi numeroa!')" oninput="setCustomValidity('')" required ><br><br>
					<span style="color:red;">*</span>Postitoimipaikka: <br><input type="text" name="postitmp" placeholder="Postitoimipaikka" pattern="[a-z åäöA-ZÅÄÖ-]{2,15}" oninvalid="setCustomValidity('Postitoimipaikan on oltava vähintään 2, enintään 15 merkkiä, ei erikoismerkkejä tai numeroita')" oninput="setCustomValidity('')" required ><br><br>
					<span style="color:red;">*</span>Sähköposti: <br><input type="text" name="sposti" placeholder="Sähköposti" pattern="[a-zA-Z0-9@.]{6,50}" oninvalid="setCustomValidity('Sähköpostin on oltava vähintään 6, enintään 50 merkkiä, ei muita erikoismerkkejä kuin @')" oninput="setCustomValidity('')" required><br><br>
					
					<div id="lisaakayttajanapit">
					<button input type="submit" class="btn btn-success btn-lg">Rekisteröidy</button>
					<a class="btn btn-default" href="Etusivu#pizzamenu" role="button">Peruuta</a>
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
            <div class="row text-center">


            </div>

            <div class="row">
                <div class="col-md-5 contact-cls">
                    <h3>Yhteystiedot</h3>
                    <div>
                        <span><i class="fa fa-home"></i>&nbsp;Osoite</span>
                        <br />
                        <span><i class="fa fa-phone"></i>&nbsp;Puhelin</span>
                        <br />
                        <span><i class="fa fa-envelope-o"></i>&nbsp;e-mail</span>
                        <br />
                        <span><i class="fa fa-phone"></i>&nbsp;Puhelin</span>
                        <br />
                    </div>
                  
                </div>
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
