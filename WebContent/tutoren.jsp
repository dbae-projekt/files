<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="WEB-INF/taglib/customtags.tld" prefix="my"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<my:icon/>
<meta charset="ISO-8859-1">
<title>Die Tutoren der Uni</title>
</head>
<body>

<my:header_tag/>
<my:tab_admin/>
<div class="jumbotron">
		<h2 class="header">Anlegen eines neuen Tutors</h2>
		<div class="form">
			<form action="TutorenServlet" method="post">
			<div class="form-group">
				<label>Titel</label>
				<input name="titel" class="form-control" id='titel' required>
			</div>
			<div class="form-group">
				<label>Name</label>
				<input type="text" class="form-control" name="name" id='name' required>
			</div><div class="form-group">
				<label>E-Mail</label>
				<input type="email" class="form-control" name="email" id ='email' required>
			</div><div class="form-group">
				<label>Telefon</label>
				<input type="text" class="form-control" name="telefon" id='telefon' required>
			</div>
		<button type="submit" formaction="TutorenServlet" class="btn btn-primary" value="Submit">Hinzufügen/Ändern</button>
		</form>
	</div>
</div>
<my:table_tutoren/>
<my:excel_export_tag/>
<button class="btn btn-primary" onclick="exportTableToExcel('tabelle_tutoren','tutoren_test');">Tabelle als Excel-Datei exportieren</button>
</body>
</html>