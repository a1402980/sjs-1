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
				<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> Kirjaudu <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<form method="post" role="form" class="navbar-form navbar-right">
                    <div class="form-group">
                        <input type="text" class="form-control" name="username" placeholder="Username">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="password" placeholder="Password">
                    </div>
                    <button type="submit" class="btn btn-default">Kirjaudu</button>
                	</form>
                	<p><% 
   String message = (String) request.getAttribute("message");
   if (message != null) {
      out.println("<p>" + message + "</p>");
   }
%></p>
                </ul>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
        <!-- /.container -->
    </nav>
    <!--End Navigation -->


    <!-- Free Section -->

    <section id="pizzat" >
        <div class="container">
            <div class="row text-center for-full-back color-light">
                <div class="col-md-8 col-md-offset-2">
                    <h1>Pizzalista</h1>
					<h2>(Omistajan näkymä)</h2>
					
					<div class="col-xs-4" id="lisaapizzanappi">
					<a href="LisaaPizza" class="btn btn-success btn-xl" role="button">Lisää Pizza</a>
					</div>
					<div class="col-xs-4" id="taytteetnappi">
					<a href="ListaaTaytteet" class="btn btn-success btn-xl" role="button">Täytteet</a>
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
				<td><%=pizzat.get(i).getTaytteet() %>
				<td><%=pizzat.get(i).getpHinta()%></td>
				<td><%=pizzat.get(i).getpSaatavuus()%></td>
				<td><a href="MuokkaaPizza?pizza_id=<%=pizzat.get(i).getPizzaId()%>" role="button"><span class="glyphicon glyphicon-edit"></span></a></td>
				<td>
					<button onclick="poistapizza()">
						<span class="glyphicon glyphicon-trash"></span></button></td>
						<script>function poistapizza(){
								var p = confirm("Poistetaanko pizza?"); // poistonappi
								if(p==true){
									window.location="PoistaPizza?pizza_id=<%=pizzat.get(i).getPizzaId()%>";
								}else{
									window.location="ListaaPizzat";
								}
						}</script>
								
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

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">Kirjaudu sisään</h4>
			</div> <!-- /.modal-header -->

			<div class="modal-body">
				<form role="form">
					<div class="form-group">
						<div class="input-group">
							<input type="text" class="form-control" id="uLogin" placeholder="Käyttäjätunnus">
							<label for="uLogin" class="input-group-addon glyphicon glyphicon-user"></label>
						</div>
					</div> <!-- /.form-group -->

					<div class="form-group">
						<div class="input-group">
							<input type="password" class="form-control" id="uPassword" placeholder="Salasana">
							<label for="uPassword" class="input-group-addon glyphicon glyphicon-lock"></label>
						</div> <!-- /.input-group -->
					</div> <!-- /.form-group -->

					<div class="checkbox">
						<label>
							<input type="checkbox"> Muista minut
						</label>
					</div> <!-- /.checkbox -->
				</form>

			</div> <!-- /.modal-body -->

			<div class="modal-footer">
				<button class="form-control btn btn-primary">Kirjaudu</button>

				<div class="progress">
					<div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="1" aria-valuemin="1" aria-valuemax="100" style="width: 0%;">
						<span class="sr-only">progress</span>
					</div>
				</div>
			</div> <!-- /.modal-footer -->

		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->


</body>
</html>
