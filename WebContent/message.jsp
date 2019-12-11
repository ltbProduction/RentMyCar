<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>

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
    <center>
        <h1><%=request.getAttribute("Message")%></h1>
        <br>
        <br>
        <INPUT type="submit" class="btn btn-primary" value="Zur Ansicht aller Autos" onClick="parent.location='viewcar'"></FORM>
    </center>
</body>
</html>