<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
  <link href="css/style.css" rel="stylesheet">

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
          <li class="nav-item active">
            <a class="nav-link" href="viewcar">Unsere Autos</a>
          </li>
          <li class="nav-item">
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
          <h1 class="mt-5">Unsere Autos</h1>
          <p>Diese Autos sind derzeit zur Miete abrufbar.</p>


	<c:forEach items="${cars}" var="car">
		<%-- <tr>      
        	<h2><c:out value="${car.firstName}" /></h2>
    <h3><c:out value="${car.lastName}" /></h3>
    <img src="data:image/jpg;base64,${car.base64image}" width="240" height="300"/>

    </tr> --%>

		<div class="card" style="width: flex;">
			<img src="data:image/jpg;base64,${car.base64image}" width="100%" height=auto/>
			<div class="card-body">
				<h5 class="card-title">
					<c:out value="${car.brand} ${car.type}" />
				</h5>
				<p class="card-text">
					<strong>Vorname:</strong>
					<c:out value="${car.firstName}" />
					<br> <strong>Nachname:</strong>
					<c:out value="${car.lastName}" />
					<br> <strong>Ort:</strong>
					<c:out value="${car.location}" />
          <br> <strong>Telefonnummer:</strong>
          <c:out value="${car.phonenumber}" />
					<br> <strong>E-Mail:</strong>
					<c:out value="${car.mail}" />
					<br> <strong>Automarke:</strong>
					<c:out value="${car.brand}" />
					<br> <strong>Autotyp:</strong>
					<c:out value="${car.type}" />
					<br> <strong>Kraftstoff:</strong>
					<c:out value="${car.fuel}" />
					<br> <strong>Preis pro Tag in EUR:</strong>
					<c:out value="${car.price}" />
					<br> <strong>Beschreibung:</strong>
					<c:out value="${car.description}" />
          <br>
          <br>
          Diese Anzeige ist noch<strong>
					<c:out value="${car.restDays}" />
					Tage </strong>online 

				</p>

				<a
					href="mailto:${car.mail}?subject=RentMyCar%20Autovermietung&amp;body=Hallo%20${car.firstName} ${car.lastName},%0D%0A%0D%0Aich%20wollte%20Ihnen%20mitteilen,%20dass%20ich%20Interesse%20an%20Ihrem%20Auto%20${car.brand}%20${car.type}%20habe.%20Bitte%20geben%20Sie%20mir%20eine%20Rueckmeldung,%20ob%20das%20Auto%20aktuell%20zur%20Verfuegung%20steht.%0D%0A%0D%0AViele%20Gruesse"
					class="btn btn-primary">Mieten</a>


			</div>
		</div>
		<br>


	</c:forEach>
	
	  </div>
      </div>
    </div>


  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>