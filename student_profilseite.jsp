<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="WEB-INF/taglib/customtags.tld" prefix="my"%>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/style_startseite_student.css">
<my:icon/>
<title>Profil von </title>
</head>
<body>
<my:header_tag/>
<my:tab_admin/>
<div class="ml-1 p-3" style="width:50%;">
	<h1>Daten in der Übersicht</h1> 
	<label>Name:</label>  <br>
	<label>Matrikelnummer:</label>  <br>
	<label>E-Mail:</label>  <br>
	<label>Telefonnummer:</label>  <br>
	<label>Beginn des Praktikums:</label>  <br>
	<label>Ende des Praktikums:</label>  <br>
	<label>Dauer des Praktikums (in Wochen):</label>  <br>
	<label>Name des Unternehmens:</label>  <br>
	<label>Abteilung im Unternehmen:</label> <br>
	<label>Kurztitel des Unternehmens:</label> <br>
	<label>Inhalt des Praktikums:</label> <br>
	<label>Einsatzort (Standort vom Unternehmen):</label>  <br>
	<h1>Angaben zu den Betreuern</h1> 
	<label>Name des Tutors:</label> <br>
	<label>Email des Tutors:</label> <br>
	<label>Telefonnummer des Tutors:</label>  <br>
	<label>Vorschlag für einen Mentor:</label> 	
</div>
<hr>
<my:footer_tag/>
</body>
</html>