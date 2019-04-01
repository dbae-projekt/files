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
<my:header_tag/>
<my:tab_student/>
<div class="header1">
	<h1>Alle Unternehmen</h1>
</div>
<my:table_unternehmen/>
<script>
var liste = document.getElementsByName('bearbeiten');
for(var i = 0; i < liste.length; i++) {
	liste[i].style.display = 'none'; 
}
</script>
</body>
</html>