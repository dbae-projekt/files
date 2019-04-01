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
<title>Die Praktika</title>
</head>
<body>

<my:header_tag/>
<my:tab_admin/>
<div class="jumbotron">
	<h1>Erstellen oder Bearbeiten der Praktika: </h1>
	<div class="form">
		<form  method="post">
			<div class="form-group">
				<label>Matrikelnummer</label>
				<!--<input name='matrikelnummer' class="form-control" id='matrikelnummer' required>
				 Klappt noch nicht, vielleicht skippen:D -->
				<my:dropdown auswahl="matrikelnummern"/>
			</div>
			<div class="form-group">
				<label>Name</label>
				<input name='name' class="form-control" id='name' required>
			</div>
			<div class="form-group">
				<label>Unternehmen</label>
				<input name='unternehmen' class="form-control" id='unternehmen' required>
			</div>
			<div class="form-group">
				<label>Angelegt am</label>
				<input name='angelegt_am' class="form-control" id='angelegt_am' required>
			</div>
			<div class="form-group">
				<label>Tutor</label>
				<my:dropdown auswahl="tutoren"/>
			</div>
			<div class="form-group">
				<label>Kolloquium</label>
				<input name='kolloquium' class="form-control" id='kolloquium' required>
			</div>
			<div class="form-group">
				<label>Vorschlag Mentor</label>
				<input name='vorschlag_mentor' class="form-control" id='vorschlag_mentor' required>
			</div>
			<div class="form-group">
				<label>Bemerkung</label>
				<input name='bemerkung' class="form-control" id='bemerkung' required>
			</div>
			<div class="form-group form-check">
				<label class="form-check-label">
				<input type="checkbox" checked="checked" class="form-check-input" value='true' name='aktiv' id='aktiv'>aktiv
				</label>
			</div>
			<button type="submit" formaction="PraktikaServlet" class="btn btn-primary" value="Speichern"> Hinzufuegen/Aendern</button>
			<button type="submit" formaction="ProfilServlet" class="btn btn-primary">Zu dem Profil</button>
		</form>
	</div>
</div>
<my:table_praktika/>
<my:excel_export_tag/>
<button class="btn btn-primary" onclick="exportTableToExcel('tabelle_praktika','praktika_liste');">Tabelle als Excel-Datei exportieren</button>

</body>
</html>


