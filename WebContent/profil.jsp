<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="WEB-INF/taglib/customtags.tld" prefix="my"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<my:icon/>
<meta charset="ISO-8859-1">
<title>Profilseite</title>
</head>
<body>

<my:header_tag/>
<my:tab_student/>
<div class="jumbotron">

	<div class="form">
		<form action="ProfilServlet" method="post">
		
			<h3>Persönliche Daten:</h3>
		<div class="form-group">
			<label>Name: </label>
			<input type="text" name="name" class="form-control" disabled="disabled" value="${student.name}"> <br>
		</div>
		<div class="form-group">
			<label>Matrikelnummer: </label>
			<input type="text" name="matrikelnummer" id='matrikelnummer' class="form-control" disabled="disabled" value="${student.matrikelnummer}"> <br>
		</div>
		<div class="form-group">
			<label>E-Mail: </label>
			<input type="email" name="email" class="form-control" value="${student.email}"> <br>
		</div>
		 <div class="form-group">
			<label>Telefonnummer: </label>
			<input type="text" name="telefonnummer" class="form-control" value="${student.telefon}">  <br>
		</div>
			<h3>Angaben zum Praktikum</h3>
		<div class="form-group">
			<label>Beginn: </label>
			<input type="text" name="beginn" class="form-control" value="${student.beginn}">  <br>
		</div>
		<div class="form-group">
			<label>Ende: </label>
			<input type="text" name="ende" class="form-control" value="${student.ende}">  <br>
		</div>
		<div class="form-group">
			<label>Dauer (in Wochen): </label>
			<input type="number" name="dauer" class="form-control" value="${student.dauer}">  <br>
		</div>
		<div class="form-group">
			<label>Unternehmen: </label>
			<my:dropdown auswahl="unternehmen"/>
		</div>
		<div class="form-group">
			<label>Abteilung: </label>
			<input type="text" name="abteilung" class="form-control" value="${student.abteilung}">  <br>
		</div>
		<div class="form-group">
			<label>Kurztitel: </label>
			<input type="text" name="kurztitel" class="form-control" value="${student.kurztitel}">  <br>
		</div>
		<div class="form-group">
			<label>Inhalt des Praktikums: </label>
			<input type="text" name="beschreibung" class="form-control" value="${student.beschreibung}">  <br>
		</div>
		<div class="form-group">
			<label>Einsatzort: </label>
			<input type="text" name="einsatzort" class="form-control" value="${student.einsatzort}">  <br>
		</div>
			<h3>Angaben zu Mentor und Tutor</h3>
		<div class="form-group">
			<label>Name des Tutors: </label>
			<input type="text" name="name_tutor" class="form-control" disabled="disabled" value="${tutordaten.get(0)}"> <br>
		</div>
		<div class="form-group">
			<label>E-Mail des Tutors: </label>
			<input type="email" name="email_tutor" class="form-control" disabled="disabled" value="${tutordaten.get(1)}"> <br>
		</div>
		<div class="form-group">
			<label>Telefon des Tutors: </label>
			<input type="text" name="telefon_tutor" class="form-control" disabled="disabled" value="${tutordaten.get(2)}"> <br>
		</div>
		<div class="form-group">
			<label>Vorschlag Mentor: </label>
			<input type="text" name="vorschlag_mentor" class="form-control" disabled="disabled" value="${tutordaten.get(3)}"> <br>
		</div>
			<button type="submit" class="btn btn-primary" value="Submit">Speichern</button>
		</form>
	</div>
</div>
<hr>
<my:footer_tag/>

</body>
</html>