<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
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
                    <li><a href="ListaaPizzat">Pizzat</a>
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


					Nimi:<br> <input type="text" name="nimi" placeholder="Kirjoita pizzan nimi tähän" pattern="[a-zA-Z0-9]+[a-zA-Z0-9 ]+" required ><br> <br>
					Hinta:<br> <input type="decimal" name="hinta" placeholder="X,XX Hinta ei yli 100€" pattern="[0-9,.]{4,5}" required ><br> <br>
					
						
						Täytteet: <br>
						<input type="checkbox" name="Tomaattikastike" value="tomaattikastike"> Tomaattikastike<br>
  						<input type="checkbox" name="Juusto" value="juusto" checked="checked"> Juusto<br>
  						<input type="checkbox" name="Herkkusieni" value="herkkusieni"> Herkkusieni<br>
  						<input type="checkbox" name="Sipuli" value="sipuli"> Sipuli<br>
  						<input type="checkbox" name="Oliivi" value="oliivi"> Oliivi<br>
  						<input type="checkbox" name="Pinaatti" value="pinaatti"> Pinaatti<br>
  						<input type="checkbox" name="Tonnikala" value="tonnikala"> Tonnikala<br>
  						<input type="checkbox" name="Katkarapu" value="katkarapu"> Katkarapu<br>
  						<input type="checkbox" name="Simpukka" value="simpukka"> Simpukka<br>
  						<input type="checkbox" name="Kinkku" value="kinkku"> Kinkku<br>
  						<input type="checkbox" name="Salami" value="salami"> Salami<br>
  						<input type="checkbox" name="Pepperoni" value="pepperoni"> Pepperoni<br>
  						<input type="checkbox" name="Jalopeno" value="Jalopeno"> Jalopeno<br>
  						
  						
  						
  						
  						
  						
						Täytteet: <br> <select name="tayte1">
						<option value="eitaytetta">Täyte1</option>
						<option value="tomaattikastike">Tomaattikastike</option>
						<option value="juusto">Juusto</option>
						<option value="herkkusieni">Herkkusieni</option>
						<option value="sipuli">Sipuli</option>
						<option value="oliivi">Oliivi</option>
						<option value="pinaatti">Pinaatti</option>
						<option value="tonnikala">Tonnikala</option>
						<option value="katkarapu">Katkarapu</option>
						<option value="simpukka">Simpukka</option>
						<option value="kinkku">Kinkku</option>
						<option value="salami">Salami</option>
						<option value="pepperoni">Pepperoni</option>
						<option value="jalopeno">Jalopeno</option>
					</select> <select name="tayte2">
						<option value="eitaytetta">Täyte2</option>
						<option value="tomaattikastike">Tomaattikastike</option>
						<option value="juusto">Juusto</option>
						<option value="herkkusieni">Herkkusieni</option>
						<option value="sipuli">Sipuli</option>
						<option value="oliivi">Oliivi</option>
						<option value="pinaatti">Pinaatti</option>
						<option value="tonnikala">Tonnikala</option>
						<option value="katkarapu">Katkarapu</option>
						<option value="simpukka">Simpukka</option>
						<option value="kinkku">Kinkku</option>
						<option value="salami">Salami</option>
						<option value="pepperoni">Pepperoni</option>
						<option value="jalopeno">Jalopeno</option>
					</select> <select name="tayte3">
						<option value="eitaytetta">Täyte3</option>
						<option value="tomaattikastike">Tomaattikastike</option>
						<option value="juusto">Juusto</option>
						<option value="herkkusieni">Herkkusieni</option>
						<option value="sipuli">Sipuli</option>
						<option value="oliivi">Oliivi</option>
						<option value="pinaatti">Pinaatti</option>
						<option value="tonnikala">Tonnikala</option>
						<option value="katkarapu">Katkarapu</option>
						<option value="simpukka">Simpukka</option>
						<option value="kinkku">Kinkku</option>
						<option value="salami">Salami</option>
						<option value="pepperoni">Pepperoni</option>
						<option value="jalopeno">Jalopeno</option>
					</select> <select name="tayte4">
						<option value="eitaytetta">Täyte4</option>
						<option value="tomaattikastike">Tomaattikastike</option>
						<option value="juusto">Juusto</option>
						<option value="herkkusieni">Herkkusieni</option>
						<option value="sipuli">Sipuli</option>
						<option value="oliivi">Oliivi</option>
						<option value="pinaatti">Pinaatti</option>
						<option value="tonnikala">Tonnikala</option>
						<option value="katkarapu">Katkarapu</option>
						<option value="simpukka">Simpukka</option>
						<option value="kinkku">Kinkku</option>
						<option value="salami">Salami</option>
						<option value="pepperoni">Pepperoni</option>
						<option value="jalopeno">Jalopeno</option>
					</select> <select name="tayte5">
						<option value="eitaytetta">Täyte5</option>
						<option value="tomaattikastike">Tomaattikastike</option>
						<option value="juusto">Juusto</option>
						<option value="herkkusieni">Herkkusieni</option>
						<option value="sipuli">Sipuli</option>
						<option value="oliivi">Oliivi</option>
						<option value="pinaatti">Pinaatti</option>
						<option value="tonnikala">Tonnikala</option>
						<option value="katkarapu">Katkarapu</option>
						<option value="simpukka">Simpukka</option>
						<option value="kinkku">Kinkku</option>
						<option value="salami">Salami</option>
						<option value="pepperoni">Pepperoni</option>
						<option value="jalopeno">Jalopeno</option>
					</select> <select name="tayte6">
						<option value="eitaytetta">Täyte6</option>
						<option value="tomaattikastike">Tomaattikastike</option>
						<option value="juusto">Juusto</option>
						<option value="herkkusieni">Herkkusieni</option>
						<option value="sipuli">Sipuli</option>
						<option value="oliivi">Oliivi</option>
						<option value="pinaatti">Pinaatti</option>
						<option value="tonnikala">Tonnikala</option>
						<option value="katkarapu">Katkarapu</option>
						<option value="simpukka">Simpukka</option>
						<option value="kinkku">Kinkku</option>
						<option value="salami">Salami</option>
						<option value="pepperoni">Pepperoni</option>
						<option value="jalopeno">Jalopeno</option>
					</select> <br>Valikoimassa<br> <select name="valikoimassa">
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
