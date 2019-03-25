<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="WEB-INF/taglib/customtags.tld" prefix="my"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
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
				<input name='matrikelnummer' class="form-control" id='matrikelnummer' required>
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
				<input name='tutor' class="form-control" id='tutor' required>
			</div>
			<div class="form-group">
				<label>Kolloquium</label>
				<input name='kolloquium' class="form-control" id='kolloquium' required>
			</div>
			<div class="form-group">
				<label>Bemerkung</label>
				<input name='bemerkung' class="form-control" id='bemerkung' required>
			</div>
			
			<button type="submit" formaction="PraktikaServlet" class="btn btn-primary" value="Speichern"> Hinzufügen/Ändern</button>
			<button type="submit" formaction="student_profilseite.jsp" class="btn btn-primary">Zu dem Profil</button>
		</form>
	</div>
</div>
<my:table_praktika/>
</body>
</html>