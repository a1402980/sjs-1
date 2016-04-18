<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->

<%@ page import="pizzicato.model.Pizza"%>
<%@ page import="pizzicato.model.Tayte"%>
<jsp:useBean id="pizzat" type="java.util.ArrayList<Pizza>"
	scope="request" />


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
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="ListaaPizzat">Pizzeria Pizzicato</a>
		</div>
		<!-- Collect the nav links for toggling -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="Etusivu">Etusivu</a></li>
				<li><a href="#pizzamenu">Pizzat</a></li>
				<li><a href="#services">Tilaukset</a></li>
				<li><a href="#contact">Yhteystiedot</a></li>
				<li>Tervetuloa <span style="font-weight:bold">Admin</span>!</li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
        <!-- /.container -->
    </nav>
    <!--End Navigation -->


    <!-- Free Section -->

	<section id="pizzat">
	<div class="container">
		<div class="row text-center for-full-back color-light">
			<div class="col-md-8 col-md-offset-2">
				<h1>Pizzalista</h1>
				<h2>(Omistajan näkymä)</h2>
				<div class=container>
					<div class="row">
						<div class="col-sm-3" id="lisaapizzanappi">
							<a href="LisaaPizza" class="btn btn-success btn-xl" role="button">Lisää
								Pizza</a>
						</div>
						<div class="col-sm-3" id="taytteetnappi">
							<a href="ListaaTaytteet" class="btn btn-success btn-xl"
								role="button">Täytteet</a>
						</div>
					</div>
				</div>


				<div class="table-responsive">
					<table class="table table-hover" align="center" id="pizzataulukko">
						<tr>
							<th>Id</th>
							<th>Nimi</th>
							<th>Täytteet</th>
							<th>Hinta</th>
							<th>Valikoimassa</th>
							<th>Muokkaa</th>
							<th>Poista</th>



						</tr>
						<%for(int i = 0; i < pizzat.size(); i++) {%>
						<tr>
							<td><%=pizzat.get(i).getPizzaId()%></td>
							<td><%=pizzat.get(i).getpNimi()%></td>

							<td>
								<%for (int j=0; j<pizzat.get(i).getTaytteet().size(); j++){ %> <%=pizzat.get(i).getTayte(j).gettNimi() %>
								<% } %>
							</td>
							<td><%=pizzat.get(i).getpHinta()%></td>
							<td><%=pizzat.get(i).getpSaatavuus()%></td>
							<td><a
								href="MuokkaaPizza?pizza_id=<%=pizzat.get(i).getPizzaId()%>"
								role="button"><span class="glyphicon glyphicon-edit"></span></a></td>
							<td>
								<button onclick="poistapizza(<%=pizzat.get(i).getPizzaId()%>)">
									<span class="glyphicon glyphicon-trash"></span>
								</button>
							</td>
						</tr>
						<% } %>
					</table>
				</div>
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



						<script>function poistapizza(PizzaId){
								var p = confirm("Poistetaanko pizza?"); // poistonappi
								if(p==true){
									window.location="PoistaPizza?pizza_id="+PizzaId;
								}else{
									window.location="ListaaPizzat";
								}
						}</script>


</body>
</html>
