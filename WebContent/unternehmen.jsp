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
<title>Die Unternehmen</title>
</head>
<body>

<my:tab_admin/>
<div class="jumbotron">
	<h1>Erstellen oder Bearbeiten eines Unternehmens: </h1>
	<div class="form">
		<form action="UnternehmenServlet" method="post">
			<div class="form-group">
				<label>Name</label>
				<input name='name' class="form-control" id='name' required>
			</div>
			<div class="form-group">
				<label>URL</label>
				<input name='url' class="form-control" id='url' required>
			</div>
			<div class="form-group">
				<label>Nickname</label>
				<input name='nickname' class="form-control" id='nickname' required>
			</div>
		    <div class="form-group">
				<label>Beschreibung</label>
				<input name='beschreibung' class="form-control" id='beschreibung'>
			</div>
			<div class="form-group form-check">
				<label class="form-check-label">
				<input type="checkbox" checked="checked" class="form-check-input" value='true' name='aktiv' id='aktiv'> aktiv
				</label>
			</div>
			<button type="submit" formaction="UnternehmenServlet" class="btn btn-primary" value="Speichern"> Hinzufügen/Ändern</button>
		</form>
	</div>
</div>
<my:table_unternehmen/>
<my:excel_export_tag/>
<button class="btn btn-primary" onclick="exportTableToExcel('tabelle','unternehmen_test');">Tabelle als Excel-Datei exportieren</button>
</body>
</html>