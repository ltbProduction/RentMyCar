<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <link rel="icon" type="image/vnd.microsoft.icon" href="img\car_logo.jpg">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>RentMyCar</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/the-big-picture.css" rel="stylesheet">

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="index.html">Rent My Car</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="index.html">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="viewcar">Unsere Autos</a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="Upload.jsp">Stellen Sie ihr Auto online</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="legal_notice.html">Impressum</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

	<!-- Page Content -->

	<div class="container">
		<div class="row">
			<div class="col-lg-6">
				<h1 class="mt-5">Kontakt</h1>
				<p>Geben Sie Ihre Kontaktdaten und Ihre Fahrzeugdaten ein:</p>

				<form method="post" action="uploadServlet"
					enctype="multipart/form-data" >

					<div class="form-group">
						<label for="firstName">Vorname</label> <input type="text"
							name="firstName" size="50" class="form-control" id="firstName"
							placeholder="Vorname" value="" required="required">
					</div>
					<div class="form-group">
						<label for="lastName">Nachname</label> <input type="text"
							name="lastName" size="50" class="form-control" id="lastName"
							placeholder="Vorname" value="" required="required">
					</div>
					<div class="form-group">
						<label for="Ort">Ort</label> <input type="text" name="location"
							class="form-control" id="location" placeholder="Musterstadt"
							value="" required="required">
					</div>
					<div class="form-group">
						<label for="InputEmail">E-Mail</label> <input type="email"
							class="form-control" name="email" id="email" placeholder="E-Mail"
							value="" required="required">
					</div>
					<div class="form-group">
						<label for="PhoneNumber">Telefonnummer</label> <input type="tel"
							class="form-control" name="phone" id="phone"
							placeholder="Telefonnummer" value="" required="required">
					</div>
					<div class="form-group">
						<label for="CarBrand">Automarke</label> <input type="text"
							class="form-control" name="brand" id="brand"
							placeholder="Automarke" value="" required="required">
					</div>
					<div class="form-group">
						<label for="CarType">Modell</label> <input type="text"
							class="form-control" name="type" id="type" placeholder="Modell"
							value="" required="required">
					</div>
					<div class="form-group">
						<label for="FuelType">Kraftstoff</label> <select
							class="custom-select" name="fuel" id="fuel">
							<option>Diesel</option>
							<option>Benzin</option>
							<option>Erdgas</option>
							<option>Hybrid Elektro-Diesel</option>
							<option>Hybrid Elektro-Benzin</option>
							<option>Elektro</option>
							<option>Wasserstoff</option>
						</select>
					</div>


					<div class="form-group">
						<label for="Price">Preis pro Tag in EUR</label> <input
							type="number" class="form-control" name="price" id="price" step=1
							min=0 max=500 placeholder="Preis pro Tag in EUR" value=""
							required="required">
					</div>
					<div class="form-group">
						<label for="Image">Bild</label> <input type="file"
							class="form-control-file" name="photo" size="50" id="image"
							placeholder="Bild" value="" required="required" />
					</div>
					<div class="form-group">
						<label for="Description">Beschreibung</label>
						<textarea class="form-control" name="description" id="description"
							placeholder="Weitere Infos zu Ihrem Auto ..." rows="5"
							required="required"></textarea>
					</div>





					<button type="submit" class="btn btn-primary" value="Save">Einstellen</button>
				</form>

			</div>
		</div>
	</div>


</body>
</html>