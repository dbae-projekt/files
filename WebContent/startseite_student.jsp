<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="WEB-INF/taglib/customtags.tld" prefix="my"%>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Startseite</title>
<my:icon/>
</head>
<body>
<my:header_tag/>
<my:tab_student/>
<div class="bemerkung">
	<h2>Anmerkungen des Tutors</h2>
	<textarea rows="10" cols="50" readonly>${nachricht}</textarea>
</div>
<div class="card" style="width:50%">
	<div class="card-body">
	<h1>Angaben zu ihren Betreuern</h1> 
		<label><b>Name ihres Tutors:</b></label> ${tutordaten.get(0)} <br>
		<label><b>Email ihres Tutors:</b></label> ${tutordaten.get(1)} <br>
		<label><b>Telefonnummer ihres Tutors:</b></label> ${tutordaten.get(2)} <br>
		<label><b>Ihr Vorschlag für einen Mentor:</b></label> ${tutordaten.get(3)} <br>
	<h1>Ihre Daten in der Übersicht</h1> 
		<label><b>Name:</b></label> ${student.name} <br>
		<label><b>Matrikelnummer:</b></label> ${student.matrikelnummer} <br>
		<label><b>E-Mail:</b></label> ${student.email} <br>
		<label><b>Telefonnummer:</b></label> ${student.telefon} <br>
		<label><b>Beginn des Praktikums:</b></label> ${student.beginn} <br>
		<label><b>Ende des Praktikums:</b></label> ${student.ende} <br>
		<label><b>Dauer des Praktikums (in Wochen):</b></label> ${student.dauer} <br>
		<label><b>Name des Unternehmens:</b></label> ${student.unternehmen} <br>
		<label><b>Abteilung im Unternehmen:</b></label> ${student.abteilung} <br>
		<label><b>Kurztitel des Unternehmens:</b></label> ${student.kurztitel} <br>
		<label><b>Inhalt des Praktikums:</b></label> ${student.beschreibung} <br>
		<label><b>Einsatzort (Standort vom Unternehmen):</b></label> ${student.einsatzort} <br>
	</div>
</div>
</body>
</html>