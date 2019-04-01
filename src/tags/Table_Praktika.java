package tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import sql.Statements;


public class Table_Praktika extends SimpleTagSupport {

	public void doTag() {
		JspWriter out = getJspContext().getOut();
		
		List<String> matrikelnummer = new ArrayList<String>();
		List<String> name = new ArrayList<String>();
		List<String> unternehmen = new ArrayList<String>();
		List<String> angelegt_am = new ArrayList<String>();
		List<String> tutor = new ArrayList<String>();
		List<String> kolloquium = new ArrayList<String>();
		List<String> vorschlag_mentor = new ArrayList<String>();
		List<String> bemerkung = new ArrayList<String>();
		List<String> aktiv = new ArrayList<String>();
		
		matrikelnummer = Statements.zeigeDaten("matrikelnummer",3);
		name = Statements.zeigeDaten("name",3);
		unternehmen = Statements.zeigeDaten("unternehmen",3);
		angelegt_am = Statements.zeigeDaten("angelegt_am",3);
		tutor = Statements.zeigeDaten("tutor",3);
		kolloquium = Statements.zeigeDaten("kolloquium",3);
		vorschlag_mentor = Statements.zeigeDaten("vorschlag_mentor",3);
		bemerkung = Statements.zeigeDaten("bemerkung",3);
		aktiv = Statements.zeigeDaten("aktiv",3);
		
		for(int i = 0; i < aktiv.size(); i++) {
			if(aktiv.get(i).equals("t")) {
				aktiv.set(i, "Ja");
			}
			else {
				aktiv.set(i, "Nein");
			}
		}
		
		String table = "<div class='table-responsive'>"
				+ "<table id='tabelle_praktika' class='table'>"
				+ "<tr>"
				+ "<th>Bearbeiten</th>"
				+ "<th>Matrikelnummer</th>"
				+ "<th>Name</th>"
				+ "<th>Unternehmen</th>"
				+ "<th>Angelegt am</th>"
				+ "<th>Tutor</th>"
				+ "<th>Kolloquium</th>"
				+ "<th>Vorschlag Mentor</th>"
				+ "<th>Bemerkung</th>"
				+ "<th>Aktiv</th>"
				+ "<tr>";
		for (int i = 0; i < matrikelnummer.size(); i++) {
			table+= "<tr name='row'>"
				+ "<td><input type=radio  onclick='change()' name='radio'></td>"
				+ "<td>" + matrikelnummer.get(i) + "</td>" 
				+ "<td>" + name.get(i) + "</td>"
				+ "<td>" + unternehmen.get(i) + "</td>"
				+ "<td>" + angelegt_am.get(i) + "</td>"
				+ "<td>" + tutor.get(i) + "</td>"
				+ "<td>" + kolloquium.get(i) + "</td>"
				+ "<td>" + vorschlag_mentor.get(i) + "</td>"
				+ "<td>" + bemerkung.get(i) + "</td>"
				+ "<td>" + aktiv.get(i) + "</td>"
				+ "</tr>";
		}
		table+= "</table>"
				+ "</div>";
		
		try {
			
			table+="<script>"
					+ "function change() {"
					+ "var list = document.getElementsByName('row');"
					+ "for(var i = 0; i < list.length; i++) {\r\n" 
					+ "	if(list[i].cells[0].getElementsByTagName('input')[0].checked) {\r\n" 
					+ "document.getElementById('matrikelnummern').value = list[i].cells[1].innerHTML;"
					+ "document.getElementById('name').value = list[i].cells[2].innerHTML;"
					+ "document.getElementById('unternehmen').value = list[i].cells[3].innerHTML;"
					+ "document.getElementById('angelegt_am').value = list[i].cells[4].innerHTML;"
					+ "document.getElementById('tutoren').value = list[i].cells[5].innerHTML;"
					+ "document.getElementById('kolloquium').value = list[i].cells[6].innerHTML;"
					+ "document.getElementById('vorschlag_mentor').value = list[i].cells[7].innerHTML;"
					+ "document.getElementById('bemerkung').value = list[i].cells[8].innerHTML;"
					+ "document.getElementById('aktiv').value = true;"
					+ "}\r\n" 
					+ "}"
					+ "}"
					+ "</script>";
			out.print(table);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
