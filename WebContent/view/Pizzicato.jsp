<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->



<!--<![endif]-->
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
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
<body id="home">
	 <div class="intro-header">
	 	<div class="col-xs-12 text-center abcen1">
	 	<h1>Tervetuloa herkuttelemaan Pizzeria Pizzicatoon! </h1>
	 	<h2>Tutustu monipuoliseen pizzalistaamme t�st�.</h2>
	 	</div>
	 </div>
	 <div class="col-xs-12 text-center abcen wow fadeIn">
	 	<div class="button_down">
	 		<a class="button_down_img" href="#pizzamenu"><img class="button_img" src="assets/images/arrow.png"></a>
	 	</div>	
	 </div>
	 </div>
	
	
	
			
			<!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>     
                <a class="navbar-brand" href="ListaaPizzat">Pizzeria Pizzicato</a>
            </div>
            <!-- Collect the nav links for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#home">Etusivu</a>
                    </li>
                    <li><a href="#pizzamenu">Pizzat</a>
                    </li>
                    <li><a href="#services">Tilaukset</a>
                    </li>
                    <li><a href="#free-text">Yhteystiedot</a>
                    </li>
                     <li><a><button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#myModal" style=text-align="center">Kirjaudu</button></a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    <!--End Navigation -->
	
	<div id="pizzamenu">
	
	
	</div> 
	
   <!-- Contact Section -->
    <section class="for-full-back color-white " id="contact">
        <div class="container">
            <div class="row text-center">


            </div>

            <div class="row">
                <div class="col-md-5 contact-cls">
                    <h3>Sijaintimme</h3>
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
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">�</button>
				<h4 class="modal-title" id="myModalLabel">Kirjaudu sis��n</h4>
			</div> <!-- /.modal-header -->

			<div class="modal-body">
				<form role="form">
					<div class="form-group">
						<div class="input-group">
							<input type="text" class="form-control" id="uLogin" placeholder="K�ytt�j�tunnus">
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