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
<title>Praktikumsdaten für die Studiengänge WInf/IMIT</title>
<script type="text/JavaScript">
//Serverseitig prüfen
function validateForm() {
    
    var error = "";
    var name_regex = /^[a-zA-Z,.-]*$/i;
    var name = document.forms["sign_up_form"]["name"].value;
    var mtrk_regex = /\d{6,10}/;
    var mtrk = document.forms["sign_up_form"]["matrikelnummer"].value;
    var email_regex = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    var email = document.forms["sign_up_form"]["email"].value;
    var pw_regex = /(?=^.{6,10}$)(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&amp;*()_+}{&quot;:;?/&gt;.&lt;,])(?!.*\s).*$/;
    var pw = document.forms["sign_up_form"]["passwort"].value;
    var pw_2nd = document.forms["sign_up_form"]["passwort_2nd"].value;
        
    if(!name.match(name_regex)) {
        
        error += "Bitte keine Zahlen oder sonstigen Nonsense eingeben für den Namen eingeben! \n";
    }
    
    if (!mtrk.match(mtrk_regex)) {
        
        error += "Für die Matrikelnummer mindestens 6, maximal 10 Zahlen! \n";
    
    }
    
    if (!email.match(email_regex)) {
        
        error += "Die Email entspricht nicht dem Format! \n";
        
    }
    
    if(!pw.match(pw_regex)) {
    
        error += "Passwort muss mindestens 6 Zeichen lang und maximal 10 Zeichen lang sein und mindestens einen Großbuchstaben, eine Zahl und ein Sonderzeichen enthalten! \n";
        
    }
    
    if(pw_2nd != pw) {
    
        error += "Passwörter stimmen nicht überein. \n";
    }
    if (error != null | error != "") {
        
        alert(error);
        return false;
    } else {
        
        return true;
    }
}   
</script>
</head>
<body>
	<my:header_tag/>
	<div class="jumbotron">
		<h2 class="header">Einloggen</h2>
		<div class="form">
			<form action="LoginServlet" method="post">
			<div class="form-group">
				<label>Matrikelnummer</label>
				<input name="matrikelnummer" class="form-control" required>
			</div>
			<div class="form-group">
				<label>Passwort</label>
				<input type="password" class="form-control" name="passwort" required>
			</div>
			<button type="submit" formaction="LoginServlet" class="btn btn-primary" value="Submit">Login</button>
			</form>
		</div>
	</div>
	<div class="jumbotron">
		<h2 class="header">Registrieren</h2>
		<div class="form">
			<form action="RegistrationServlet" method="post" name="sign_up_form" onsubmit="return validateForm()">
			<div class="form-group">
				<label>Name</label>
				<input name="name" class="form-control" id="name" required>
			</div>
			<div class="form-group">
				<label>Matrikelnummer</label>
				<input name="matrikelnummer" class="form-control" id="matrikelnummer" required>
			</div>
			<div class="form-group">
				<label>E-Mail</label>
				<input type="email" name="email" class="form-control" id="email" required>
			</div>
			<div class="form-group">
				<label>Passwort</label>
				<input type="password" name="passwort" class="form-control" id="passwort" required>
			</div>
			<div class="form-group">
				<label>Passwort nochmal eingeben:</label>
				<input type="password" name="passwort" class="form-control" id="passwort_2nd" required>
			</div>
				<button type="submit" formaction="RegistrationServlet" class="btn btn-primary" value="Submit">Registrieren</button>
			</form>
		</div>
	</div>
	<my:footer_tag/>
</body>
</html>