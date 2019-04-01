package nutzerrollen;

//Eine Nutzer-Klasse mit Attributen
public class Nutzer{
	String name;
	int matrikelnummer;
	String email;
	String telefon;
	String beginn;
	String ende;
	int dauer;
	String abteilung;
	String unternehmen;
	String kurztitel;
	String beschreibung;
	String einsatzort;
	String name_tutor;
	String email_tutor;
	String telefon_tutor;
	String vorschlag_mentor;
	
	//Konstruktor für einen Nutzer
	public Nutzer(String name,int matrikelnummer,String email,String telefon,String beginn,String ende,int dauer,String abteilung,String unternehmen,String kurztitel,String beschreibung,String einsatzort,String name_tutor,String email_tutor,String telefon_tutor,String vorschlag_mentor) {
		this.name = name;
		this.matrikelnummer = matrikelnummer;
		this.email = email;
		this.telefon = telefon;
		this.beginn = beginn;
		this.ende = ende;
		this.dauer = dauer;
		this.abteilung = abteilung;
		this.unternehmen = unternehmen;
		this.kurztitel = kurztitel;
		this.beschreibung = beschreibung;
		this.einsatzort = einsatzort;
		this.name_tutor = name_tutor;
		this.email_tutor = email_tutor;
		this.telefon_tutor = telefon_tutor;
		this.vorschlag_mentor = vorschlag_mentor;
	}
	
	//Getter und Setter für den Nutzer
	public Nutzer(int matrikelnummer) {
		
		this.matrikelnummer = matrikelnummer;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMatrikelnummer() {
		return matrikelnummer;
	}

	public void setMatrikelnummer(int matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getBeginn() {
		return beginn;
	}

	public void setBeginn(String beginn) {
		this.beginn = beginn;
	}

	public String getEnde() {
		return ende;
	}

	public void setEnde(String ende) {
		this.ende = ende;
	}

	public int getDauer() {
		return dauer;
	}

	public void setDauer(int dauer) {
		this.dauer = dauer;
	}

	public String getAbteilung() {
		return abteilung;
	}

	public void setAbteilung(String abteilung) {
		this.abteilung = abteilung;
	}

	public String getUnternehmen() {
		return unternehmen;
	}

	public void setUnternehmen(String unternehmen) {
		this.unternehmen = unternehmen;
	}

	public String getKurztitel() {
		return kurztitel;
	}

	public void setKurztitel(String kurztitel) {
		this.kurztitel = kurztitel;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public String getEinsatzort() {
		return einsatzort;
	}

	public void setEinsatzort(String einsatzort) {
		this.einsatzort = einsatzort;
	}

	public String getName_tutor() {
		return name_tutor;
	}

	public void setName_tutor(String name_tutor) {
		this.name_tutor = name_tutor;
	}

	public String getEmail_tutor() {
		return email_tutor;
	}

	public void setEmail_tutor(String email_tutor) {
		this.email_tutor = email_tutor;
	}

	public String getTelefon_tutor() {
		return telefon_tutor;
	}

	public void setTelefon_tutor(String telefon_tutor) {
		this.telefon_tutor = telefon_tutor;
	}

	public String getVorschlag_mentor() {
		return vorschlag_mentor;
	}

	public void setVorschlag_mentor(String vorschlag_mentor) {
		this.vorschlag_mentor = vorschlag_mentor;
	}

}
