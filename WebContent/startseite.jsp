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
<title>Start</title>
</head>
<body>

<my:header_tag/>
<my:tab_admin/>
<div class="row">
  <div class="col"><a class="nav-link" href="unternehmen.jsp">Unternehmen</a></div>
  <div class="col"><a class="nav-link" href="praktika.jsp">Praktika</a></div>
  <div class="col"><a class="nav-link" href="tutoren.jsp">Tutoren</a></div>
</div>

</body>
</html>