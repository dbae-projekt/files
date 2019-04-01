package sql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import datenbankverbindung.DBConnect;

public class Statements {
	public Statements() {
		super();
	}
	//Funktion zum Registrieren auf der Seite. Ein Eintrag in die Tabellen accounts und studierende wird vorgenommen.
	public static void registrieren(String name, int matrikelnummer, String email, String passwort) {
		Connection db_con = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		try {
			//Erstellt ein Statement, was einen Eintrag in die Tabelle accounts erzeugt.
			pstmt = db_con.prepareStatement("INSERT INTO accounts VALUES (?,?,?,?,false);");
			//Ergänzung der Attribute, die in das Statement eingegeben werden sollen
			pstmt.setString(1,name);
			pstmt.setInt(2,matrikelnummer);
			pstmt.setString(3,email);
			pstmt.setString(4,passwort);
			pstmt.executeUpdate();
			
			//Zweites Statement erstellt den Eintrag in der Tabelle studierende
			PreparedStatement pstmt1 = db_con.prepareStatement("INSERT INTO studierende VALUES (?,?,?,"
					+ "null,null,null,0,null,null,null,null,null,null,null,null,null);");
			pstmt1.setString(1,name);
			pstmt1.setInt(2,matrikelnummer);
			pstmt1.setString(3,email);
			pstmt1.executeUpdate();
			db_con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//Methode mit einem Statement, was den Login prüft, indem die Matrikelnummer und das dazugehörige Passwort in der Datenbank gesucht werden
	//Gibt einen Boolean zurück, ob der Login erfolgreich war.
	public static boolean login(int matrikelnummer, String pw) {
		Connection db_con = DBConnect.getConnection();
		boolean login = false;
		try {
			PreparedStatement pstmt = db_con.prepareStatement("SELECT name FROM accounts WHERE matrikelnummer = ? AND passwort = ?;");
			pstmt.setInt(1,matrikelnummer);
			pstmt.setString(2,pw);
			ResultSet rs = pstmt.executeQuery();
			//Wenn ein Ergebnis gefunden wurde ist login wahr
			while(rs.next()) {
				login = true;
			}
			db_con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return login;
	}

	//Methode mit einem Statement, was die Matrikelnummer verwendet, um den Adminstatus der Person zu prüfen.
	//Gibt true oder false zurück. 
	public static boolean pruefeAdmin(int matrikelnummer) {
		Connection db_con = DBConnect.getConnection();
		boolean admin = false;
		try {
			PreparedStatement pstmt = db_con.prepareStatement("SELECT admin FROM accounts WHERE matrikelnummer = ?;");
			pstmt.setInt(1, matrikelnummer);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			if(rs.getBoolean(1)) {
				admin = true;
			}
			db_con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}	
	//Methode, die mit einem Statement alle mitgegebenen Parameter in der Tabelle studierende einfügt, wenn die übergebene Matrikelnummer übereinstimmt.
	public static void profilEingabe(String name, int matrikelnummer, String email, 
			String telefon, String beginn, String ende, int dauer,String unternehmen, 
			String abteilung, String kurztitel, String beschreibung, String einsatzort,
			String name_tutor, String email_tutor, String telefon_tutor, String vorschlag_mentor) {
		Connection db_con = DBConnect.getConnection();
		try {
			PreparedStatement pstmt = db_con.prepareStatement("UPDATE studierende" 
					+ "	SET email=?, telefon=?, beginn=?, ende=?, dauer=?, abteilung=?,"
					+ " unternehmen=?, kurztitel=?, beschreibung=?, einsatzort=?, name_tutor=?,"
					+ " email_tutor=?, telefon_tutor=?, vorschlag_mentor=?" 
					+ "	WHERE matrikelnummer = ?;");
			pstmt.setString(1,email);
			pstmt.setString(2,telefon);
			pstmt.setString(3,beginn);
			pstmt.setString(4,ende);
			pstmt.setInt(5,dauer);
			pstmt.setString(6,abteilung);
			pstmt.setString(7,unternehmen);
			pstmt.setString(8,kurztitel);
			pstmt.setString(9,beschreibung);
			pstmt.setString(10,einsatzort);
			pstmt.setString(11,name_tutor);
			pstmt.setString(12,email_tutor);
			pstmt.setString(13,telefon_tutor);
			pstmt.setString(14,vorschlag_mentor);
			pstmt.setInt(15,matrikelnummer);
			pstmt.executeUpdate();
			db_con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// Methode, die mit einem Statement eine Liste der Daten aus der Tabelle studierende zurückgibt, bei der die angegebene Matrikelnummer übereinstimmt.
	public static List<String> zeigeDaten(int matrikelnummer) {
		List<String> antwort = new ArrayList<String>();
		Connection db_con = DBConnect.getConnection();
		try {
			PreparedStatement pstmt = db_con.prepareStatement("SELECT * FROM studierende WHERE matrikelnummer = ?;");
			pstmt.setInt(1, matrikelnummer);
			ResultSet rs = pstmt.executeQuery();
	        rs.next();
			for(int i = 1; i < 17; i++) {
				antwort.add(rs.getString(i));
			}
			db_con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return antwort;
	}
	// Methode, die mit einem Statement eine Liste zurückgibt, die gesuchte Werte aus den Datenbank-Tabellen beinhaltet. Mit dem Modus-Parameter lässt sich das gewünschte Statement auswählen.
	public static List<String> zeigeDaten(String suche, int mode) {
		List<String> antwort = new ArrayList<String>();
		Connection db_con = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		try {
			if(mode == 1) {
				pstmt = db_con.prepareStatement("SELECT " + suche + " FROM accounts WHERE admin=false;");
			}
			else if(mode == 2) {
				pstmt = db_con.prepareStatement("SELECT " + suche + " FROM unternehmen;");
			}
			else if(mode == 3) {
				pstmt = db_con.prepareStatement("SELECT " + suche + " FROM praktika;");
			}
			else if(mode == 4) {
				pstmt = db_con.prepareStatement("SELECT " + suche + " FROM tutoren;");
			}
			else if(mode == 5) {
				pstmt = db_con.prepareStatement("SELECT " + suche + " FROM studierende;");
			}
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				antwort.add(rs.getString(1));
			}
			db_con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return antwort;
	}
    //Methode, mit der man Unternehmen neu erstellen(Modus1) oder bearbeiten(Modus2) kann. 
	public static void bearbeiteUnternehmen(String name, String url, String nickname, boolean aktiv, String beschreibung, int mode) {
		Connection db_con = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		try {
			if(mode==1) {
				pstmt = db_con.prepareStatement("INSERT INTO unternehmen VALUES(?,?,?,?,?)");
			}
			else if(mode == 2) {
				pstmt = db_con.prepareStatement("UPDATE unternehmen SET name=?, url=?, nickname=?, aktiv=?, beschreibung=? WHERE name = '" + name + "';");
			}
			pstmt.setString(1, name);
			pstmt.setString(2, url);
			pstmt.setString(3, nickname);
			pstmt.setBoolean(4, aktiv);
			pstmt.setString(5, beschreibung);
			pstmt.executeUpdate();
			db_con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//Methode, mit der man Praktika neu erstellen(Modus1) oder bearbeiten(Modus2) kann. 
	public static void bearbeitePraktika(int matrikelnummer, String name, String unternehmen, String angelegt_am, String tutor, String kolloquium, String vorschlag_mentor, String bemerkung, boolean aktiv, int mode) {
		Connection db_con = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		try {
			if(mode==1) {
				pstmt = db_con.prepareStatement("INSERT INTO praktika VALUES(?,?,?,?,?,?,?,?,?)");
			}
			else if(mode == 2) {
				pstmt = db_con.prepareStatement("UPDATE praktika SET matrikelnummer=?, name=?,"
						+ " unternehmen=?, angelegt_am=?, tutor=?, kolloquium=?, vorschlag_mentor=?, bemerkung=?, aktiv=? WHERE matrikelnummer = '" + matrikelnummer + "';");
			}
			pstmt.setInt(1, matrikelnummer);
			pstmt.setString(2, name);
			pstmt.setString(3, unternehmen);
			pstmt.setString(4, angelegt_am);
			pstmt.setString(5, tutor);
			pstmt.setString(6, kolloquium);
			pstmt.setString(7, vorschlag_mentor);
			pstmt.setString(8, bemerkung);
			pstmt.setBoolean(9, aktiv);
			pstmt.executeUpdate();
			db_con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//Methode, mit der man Tutoren neu erstellen(Modus1) oder bearbeiten(Modus2) kann. 	
	public static void bearbeiteTutor(String titel, String name,String email, String telefon, int mode) {
		Connection db_con = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		try {
			if(mode==1) {
				pstmt = db_con.prepareStatement("INSERT INTO tutoren VALUES(?,?,?,?)");
			}
			else if(mode == 2) {
				pstmt = db_con.prepareStatement("UPDATE tutoren SET titel=?, name=?, email=?, telefon=? WHERE name = '" + name + "';");
				//Wenn die Daten eines Tutors geändert werden, sollen diese auch in der Tabelle Studierende geändert werden, damit der Student auf dem neuesten Stand bleibt.
				pstmt2 = db_con.prepareStatement("UPDATE studierende SET name_tutor=?, email_tutor=?, telefon_tutor=? WHERE name_tutor = '" + name + "';");
				pstmt2.setString(1, name);
				pstmt2.setString(2, email);
				pstmt2.setString(3, telefon);
				pstmt2.executeUpdate();
			}
			pstmt.setString(1, titel);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, telefon);
			pstmt.executeUpdate();
			db_con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    // Überprüfung, ob die Schlüssel in den jeweiligen Tabellen vorhanden sind.
	public static boolean vorhanden(String schlüssel, int mode) {
		Connection db_con = DBConnect.getConnection();
		boolean vorhanden = false;
		PreparedStatement pstmt = null;
		try {
			if(mode == 1) {
				pstmt = db_con.prepareStatement("SELECT name FROM unternehmen WHERE name=?;");
				pstmt.setString(1, schlüssel);
			}
			else if(mode == 2) {
				pstmt = db_con.prepareStatement("SELECT matrikelnummer FROM praktika WHERE matrikelnummer=?;");
				pstmt.setInt(1, Integer.parseInt(schlüssel));
			}
			else if(mode == 3) {
				pstmt = db_con.prepareStatement("SELECT name FROM tutoren WHERE name=?;");
				pstmt.setString(1, schlüssel);
			}
			else if(mode == 4) {
				pstmt = db_con.prepareStatement("SELECT matrikelnummer FROM accounts WHERE matrikelnummer=?;");
				pstmt.setInt(1, Integer.parseInt(schlüssel));
			}
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				vorhanden = true;
			}
			db_con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vorhanden;
	}
	// Holt die Bemerkung des Studenten, dessen Matrikelnummer mit der Übergebenen übereinstimmt.
	public static String zeigeBemerkung(int matrikelnummer) {
        String antwort = null;
        Connection db_con = DBConnect.getConnection();
        try {
            PreparedStatement pstmt = db_con.prepareStatement("SELECT bemerkung FROM praktika WHERE matrikelnummer = ?;");
            pstmt.setInt(1,matrikelnummer);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            antwort = rs.getString(1);
            db_con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return antwort;
    }
    //Gibt eine Liste mit den Daten des Tutoren zurück, dessen Matrikelnummer mit der Übergebenen übereinstimmt.
	public static List<String> zeigeAngabenTutor(int matrikelnummer) {
		List<String> antwort = new ArrayList<String>();
		Connection db_con = DBConnect.getConnection();
		try {
			PreparedStatement pstmt = db_con.prepareStatement("SELECT tutoren.name, tutoren.email, tutoren.telefon, praktika.vorschlag_mentor FROM tutoren"
                + " INNER JOIN praktika ON tutoren.name = praktika.tutor WHERE matrikelnummer =?;");
			pstmt.setInt(1, matrikelnummer);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				for(int i = 1; i < 5; i++) {
					antwort.add(rs.getString(i));
				}
			}
			db_con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return antwort;
	}
    //Wenn in der Tabelle praktika der Tutor für einen Studenten geändert wird, werden die dazugehörigen Werte des neuen 
	//Tutors aus der Tabelle tutoren geholt und in studierende aktualisiert.
	public static void updateTutorangaben(int matrikelnummer) {
		Connection db_con = DBConnect.getConnection();
		try {
			PreparedStatement pstmt = db_con.prepareStatement("UPDATE studierende SET name_tutor=tutoren.name"
					+ " , email_tutor=tutoren.email, telefon_tutor=tutoren.telefon, vorschlag_mentor=praktika.vorschlag_mentor FROM"
					+ " praktika INNER JOIN studierende AS st ON praktika.matrikelnummer=st.matrikelnummer"
					+ " INNER JOIN tutoren ON praktika.tutor=tutoren.name  WHERE studierende.matrikelnummer = ? AND praktika.matrikelnummer = ?;");
			pstmt.setInt(1, matrikelnummer);
			pstmt.setInt(2, matrikelnummer);
			pstmt.executeUpdate();
			db_con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}	
}