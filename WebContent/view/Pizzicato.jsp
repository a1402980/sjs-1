<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->

<%@ page import="pizzicato.model.Pizza"%>
<jsp:useBean id="pizzat" type="java.util.ArrayList<Pizza>"
	scope="request" />

<!--<![endif]-->
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pizzeria Pizzicato -laadukas ja edullinen pizzeria</title>
<!--REQUIRED STYLE SHEETS-->
<!-- JQUERY CODE SOURCE -->
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">


<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>




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

</head>
</body>
<header class="masthead">


<section id="cover">
        <div class="col-lg-12" id="cover-caption">

                <div>
                	<h1>Pizzeria Pizzicato</h1>
                    <h1>Tervetuloa!</h1>

					<span><i class="fa fa-home"></i>&nbsp; <a href="https://goo.gl/maps/W61P9QmPrDC2">Pizzakatu 12</a> </span> <br /> <span><i
						class="fa fa-phone"></i>&nbsp;(+030)123123</span> <br />


                    <br>
                    
                    <a href="#pizzat" class="glyphicon glyphicon-chevron-down"></a>
                </div>
		</div>

    </section>

</header>

<!-- navigation --> 
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
                    <button type="submit" class="btn btn-default">Sign In</button>
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
<!-- end of navigation --> 
	
<script type="text/javascript">

	$('nav').affix({
	    offset: {
	      top: $('nav#navigaatio').offset().top
	    }
	}); 

</script>
	
	
	
<!-- Free Section -->

<section id="pizzat">
	<div class="container">
    	<div class="row text-center for-full-back color-light">
        	<div class="col-md-8 col-md-offset-2">
            	<h1>Pizzalista</h1>
					<div class="table-responsive">
                    	<table class="table table-hover" align="center" id="pizzataulukko">
							<tr>
								<th>Nimi</th>
								<th>T‰ytteet</th>
								<th>Hinta</th>
							</tr>
							<%for(int i = 0; i < pizzat.size(); i++) {%>
							<tr>
								<td><%=pizzat.get(i).getpNimi()%></td>
								<td>Tomaattikastike,Salami,Paprika</td>
								<td><%=pizzat.get(i).getpHinta()%></td>
								<td>
							<button onclick="poistapizza()">
							<span class="glyphicon glyphicon-shopping-cart" style="color:green"></span></button></td>				
							</tr>
							<% } %>
						</table>
					</div>
              </div>
          </div>
      </div>
      
</section>    

			
		
		<div class="container">

			<div class="col-md-8 col-md-offset-2">
			
			
			
			</div>

			</div>
		
		
		
		
		
	<!-- Contact Section -->
	<section class="for-full-back color-white " id="contact">
	<div class="container">

			<div class="col-md-5 contact-cls">
				<h3>Sijaintimme</h3>
				<div>
					<span><i class="fa fa-home"></i>&nbsp;Osoite</span> <br /> <span><i
						class="fa fa-phone"></i>&nbsp;Puhelin</span> <br /> <span><i
						class="fa fa-envelope-o"></i>&nbsp;e-mail</span> <br /> <span><i
						class="fa fa-phone"></i>&nbsp;Puhelin</span> <br />
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
	<!-- <script src="assets/plugins/bootstrap.js"></script> t‰m‰ ei toiminut niin javascriptkirjasto haetaan netist‰ headerissa -->
	<!-- CUSTOM SCRIPTS -->
	<script src="assets/js/custom.js"></script>
	


<script type="text/javascript">
$("#myModal").modal("show");
$("#myModal").css("z-index", "1500");
</script>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Kirjaudu Sis‰‰n</h4>
			</div> <!-- /.modal-header -->

			<div class="modal-body">
				<form method="post" action="Etusivu" role="form">
					<div class="form-group">
						<div class="input-group">
							<i class="fa fa-user"></i><input type="text" class="form-control" id="uLogin" placeholder="K‰ytt‰j‰tunnus">
							

						</div>
					</div> <!-- /.form-group -->

					<div class="form-group">
						<div class="input-group">
							<i class="fa fa-unlock-alt"></i><input type="password" class="form-control" id="uPassword" placeholder="Salasana">
							

						</div> <!-- /.input-group -->
					</div> <!-- /.form-group -->
				</form>
			</div> <!-- /.modal-body -->
			<div class="modal-footer">
				<button class="form-control btn btn-primary">Ok</button>

			</div> <!-- /.modal-footer -->

		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->




	
</body>	

	</html>
