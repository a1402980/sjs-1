<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<section id="pizzat">
	<div class="container">
		<div class="row text-center for-full-back color-light ">
			<div class="col-md-8 col-md-offset-2">
				<H1>Lisää Täyte</H1>


				<form method="post" novalidate>

					<div class="imagePreview"></div>
					<input type="file" name="imagefile"
						onchange="previewImage(this,[256],4);" /><br>
					<!--  onchange="previewImage(this,[sizes],limit);" * limit is number of Mb  -->


					Nimi:<br> <input type="text" name="nimi" placeholder="Kirjoita pizzan nimi tähän"  ><br> <br>
					Hinta:<br> <input type="decimal" name="hinta" placeholder="X,XX Hinta ei yli 100€" ><br> <br>
					
					<!-- pattern="[a-zA-Z0-9]+[a-zA-Z0-9 ]+" required -->
					<!-- pattern="[0-9,.]{4,5}" required -->
		

				
				<div id="lisaapizzanapit">
					<button input type="submit" class="btn btn-success btn-lg">Tallenna</button>
					<a href="ListaaPizzat" class="btn btn-default btn-lg" role="button">Peruuta</a>
				</div>
				</form>
			</div>

		</div>
	</div>
	</section>
</body>
</html>