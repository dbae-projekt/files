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
	
	public static void registrieren(String name, int matrikelnummer, String email, String passwort) {
		
		Connection db_con = DBConnect.getConnection();
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = db_con.prepareStatement("INSERT INTO accounts VALUES (?,?,?,?,false);");
			
			pstmt.setString(1,name);
			pstmt.setInt(2,matrikelnummer);
			pstmt.setString(3,email);
			pstmt.setString(4,passwort);
			pstmt.executeUpdate();
			
			PreparedStatement pstmt1 = db_con.prepareStatement("INSERT INTO studierende VALUES (?,?,?,"
					+ "null,null,null,0,null,null,null,null,null,null,null,null,null);");
			
			pstmt1.setString(1,name);
			pstmt1.setInt(2,matrikelnummer);
			pstmt1.setString(3,email);
			
			pstmt1.executeUpdate();
			
			PreparedStatement pstmt2 = db_con.prepareStatement("INSERT INTO praktika VALUES (?,?,null,null,null,null,null);");
			pstmt2.setInt(1,matrikelnummer);
			pstmt2.setString(2,name);
			pstmt2.executeUpdate();
			
			
		} catch (SQLException e) {
	
			e.printStackTrace();
			System.out.print("Verbindung fehlgeschlagen");
		}
		
	}
	
	public static boolean login(int matrikelnummer, String pw) {
		Connection db_con = DBConnect.getConnection();
		boolean login = false;
		try {
			PreparedStatement pstmt = db_con.prepareStatement("SELECT name FROM accounts WHERE matrikelnummer = ? AND passwort = ?;");
			pstmt.setInt(1,matrikelnummer);
			pstmt.setString(2,pw);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				login = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print("Verbindung fehlgeschlagen");
		}
		return login;
	}
	
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
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
			
		} catch (SQLException e) {
			System.out.println("NEEE");
			e.printStackTrace();
		}
		return antwort;
		
	}
	
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
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				antwort.add(rs.getString(1));
			}
			
		} catch (SQLException e) {
			System.out.println("NEEE");
			e.printStackTrace();
		}
		return antwort;
		
	}
	
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return admin;
		
	}
	
	public static void bearbeiteUnternehmen(String name, String url, String nickname, boolean aktiv, int mode) {
		Connection db_con = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		try {
			if(mode==1) {
				pstmt = db_con.prepareStatement("INSERT INTO unternehmen VALUES(?,?,?,?)");
			}
			else if(mode == 2) {
				pstmt = db_con.prepareStatement("UPDATE unternehmen SET name=?, url=?, nickname=?, aktiv=? WHERE name = '" + name + "';");
			}
			pstmt.setString(1, name);
			pstmt.setString(2, url);
			pstmt.setString(3, nickname);
			pstmt.setBoolean(4, aktiv);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean unternehmenVorhanden(String name) {
		Connection db_con = DBConnect.getConnection();
		boolean vorhanden = false;
		try {
			PreparedStatement pstmt = db_con.prepareStatement("SELECT name FROM unternehmen WHERE name=?;");
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			if(rs.getString(1).equals(name)) {
				vorhanden = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vorhanden;
	}
	
}
