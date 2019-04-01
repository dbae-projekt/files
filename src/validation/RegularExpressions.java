package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*Für manche Ausdrücke wurde: "OWASP Validation Regex Repository" verwendet, da diese schon eine gewisse Sicherheit 
sorgen. URL: https://www.owasp.org/index.php/OWASP_Validation_Regex_Repository 
Welche von owasp stammen, steht nochmal extra drüber.*/
public class RegularExpressions {

	
	public RegularExpressions() {
		
		super();
	}
	
	//Passwort, Mail und Titel fehlt noch
	
	public static boolean correctNameUnternehmen(String name_unternehmen) {
		
		boolean correct = false;
		
		String regex = "^[a-zA-Z\\s]*$";
		
		Pattern re = Pattern.compile(regex);
		
		Matcher ma = re.matcher(name_unternehmen);
		
		if (ma.matches()) {
			
			correct = true;
		}
		
		return correct;
	}
	
	
	public static boolean correctUrl(String url_unternehmen) {
		
		boolean correct = false;
		
		//von owasp
		String regex = "^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$";
		
		Pattern re = Pattern.compile(regex);
		
		Matcher ma = re.matcher(url_unternehmen);
		
		if (ma.matches()) {
			
			correct = true;
		}
		
		return correct;
	}
	
	
	public static boolean correctText(String text) {
	
		boolean correct = false;
		
		//von owasp
		String regex = "^[\\p{L}.,\\s]*$";
		
		Pattern re = Pattern.compile(regex);
		
		Matcher ma = re.matcher(text);
		
		if (ma.matches()) {
			
			correct = true;
		}
	
		return correct;
	}
	
	public static boolean correctMatrikelnummer(CharSequence matrikelnummer) {
		
		boolean correct = false;
		//https://www.regextester.com/1923
		String regex = "^(\\(?\\+?[0-9]*\\)?)?[0-9_\\- \\(\\)]*{6,10}$";
		
		Pattern re = Pattern.compile(regex);
		
		Matcher ma = re.matcher(matrikelnummer);
		
		if (ma.matches()) {
			
			correct = true;
		}
		
		return correct;
	}
	
	public static boolean correctNameMensch(String name_student) {
		
		boolean correct = false;
		
		//https://stackoverflow.com/questions/15805555/java-regex-to-validate-full-name-allow-only-spaces-and-letters
		String regex = "^[\\p{L} .'-]+$";
		
		Pattern re = Pattern.compile(regex);
		
		Matcher ma = re.matcher(name_student);
		
		if (ma.matches()) {
			
			correct = true;
		}
		
		return correct;
	}
	
	public static boolean correctDate(String date) {
		
		boolean correct = false;
		//https://www.regextester.com/97612
		//Für Tag und monat entweder 1d oder 2d dann jeweils punkte und jahr mit 4d. nur nullen werden nicht zugelassen.
		String regex = "^\\s*(3[01]|[12][0-9]|0?[1-9])\\.(1[012]|0?[1-9])\\.((?:19|20)\\d{2})\\s*$";
		
		Pattern re = Pattern.compile(regex);
		
		Matcher ma = re.matcher(date);
		
		if (ma.matches()) {
			
			correct = true;
		}
		
		return correct;
	}
	
	public static boolean correctAkademischerTitel(String titel) {
		
		boolean correct = false;
		
		String regex = "";
		
		Pattern re = Pattern.compile(regex);
		
		Matcher ma = re.matcher(titel);
		
		if (ma.matches()) {
			
			correct = true;
		}
		
		return correct;
	}
	
	public static boolean correctMail(String email) {
		
		boolean correct = false;
		
		String regex = "";
		
		Pattern re = Pattern.compile(regex);
		
		Matcher ma = re.matcher(email);
		
		if (ma.matches()) {
			
			correct = true;
		}
		
		return correct;
	}
	
	public static boolean correctTelefon(String telefon) {
		
		boolean correct = false;
		
		String regex = "/(?:\\(\\+?\\d+\\)|\\+?\\d+)(?:\\s*[\\-\\/]*\\s*\\d+)+/$";
		
		Pattern re = Pattern.compile(regex);
		
		Matcher ma = re.matcher(telefon);
		
		if (ma.matches()) {
			
			correct = true;
		}
		
		return correct;
	}
	
	public static boolean correctZahl(CharSequence zahl) {
		
		boolean correct = false;
		
		String regex = "^[0-9]*$";
		
		Pattern re = Pattern.compile(regex);
		
		Matcher ma = re.matcher(zahl);
		
		if (ma.matches()) {
			
			correct = true;
		}
		
		return correct;
	}
	
	
	public static boolean correctPassword(String passwort) {
		
		boolean correct = false;
		
		//von owasp
		String regex = "";
		
		Pattern re = Pattern.compile(regex);
		
		Matcher ma = re.matcher(passwort);
		
		if (ma.matches()) {
			
			correct = true;
		}
		
		return correct;
	}
}





