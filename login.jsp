<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="WEB-INF/taglib/customtags.tld" prefix="my"%>
<!DOCTYPE html>
<html>
<head>
<!-- <link rel="stylesheet" type="text/css" href="css/w3.css">  -->
<link rel="stylesheet" type="text/css" href="css/style_login.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<my:icon/>
<meta charset="ISO-8859-1">
<title>Praktikumsdaten für die Studiengänge WInf/IMIT</title>
</head>
<body>

	<img class="float-left" alt="Logo" src="pics/uni_logo.jpg">
	
	<div class="jumbotron text-center">
		<h1>Login-/Registrierungsbereich der Praktikumsdatenbank</h1>
	</div>
	
	<div class="jumbotron">
		<h2 class="header">Einloggen</h2>
		<div class="form">
				<form action="LoginServlet" method="post">
				<label>Matrikelnummer</label>
				<input name="matrikelnummer" required>
				<label>Passwort</label>
				<input type="password" name="passwort" required>
				<input type="submit" formaction="LoginServlet" name="submit" value="Submit">
				</form>
		</div>
	</div>
	
	<div class="jumbotron">
		<h2 class="header">Registrieren</h2>
		<div class="form">
			<form action="RegistrationServlet" method="post">
				<label>Name</label>
				<input name='name' required>
				<label>Matrikelnummer</label>
				<input name='matrikelnummer' required>
				<label>E-Mail</label>
				<input type="email" name='email' required>
				<label>Passwort</label>
				<input type="password" name='passwort' required>
				<input type="submit" name='submit' value='Submit'>
			</form>
		</div>
	</div>
	
</body>
</html>








