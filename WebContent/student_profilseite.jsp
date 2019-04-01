<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="WEB-INF/taglib/customtags.tld" prefix="my"%>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<my:icon/>
<title>Profil von </title>
</head>
<body>
<my:header_tag/>
<my:tab_admin/>

<div class="ml-1 p-3" style="width:50%;">
	<h1>Daten in der Übersicht</h1> 
	<label>Name:</label> ${liste.get(0)}<br>
	<label>Matrikelnummer:</label> ${liste.get(1)}<br>
	<label>E-Mail:</label> ${ liste.get(2)}<br>
	<label>Telefonnummer:</label> ${ liste.get(3)}<br>
	<label>Beginn des Praktikums:</label> ${ liste.get(4)}<br>
	<label>Ende des Praktikums:</label> ${ liste.get(5)}<br>
	<label>Dauer des Praktikums (in Wochen):</label> ${liste.get(6)}<br>
	<label>Name des Unternehmens:</label> ${liste.get(7)}<br>
	<label>Abteilung im Unternehmen:</label> ${liste.get(8)}<br>
	<label>Kurztitel des Unternehmens:</label> ${liste.get(9)}<br>
	<label>Inhalt des Praktikums:</label> ${liste.get(10)}<br>
	<label>Einsatzort (Standort vom Unternehmen):</label> ${liste.get(11)}<br>
	<h1>Angaben zu den Betreuern</h1> 
	<label>Name des Tutors:</label> ${liste.get(12)}<br>
	<label>Email des Tutors:</label> ${liste.get(13)}<br>
	<label>Telefonnummer des Tutors:</label> ${liste.get(14)}<br>
	<label>Vorschlag für einen Mentor:</label> ${liste.get(15)}	
</div>
</body>
</html>