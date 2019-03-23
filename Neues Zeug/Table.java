package tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import sql.Statements;


public class Table extends SimpleTagSupport {

	public void doTag() {
		JspWriter out = getJspContext().getOut();
		
		List<String> matrikelnummer = new ArrayList<String>();
		List<String> name = new ArrayList<String>();
		List<String> unternehmen = new ArrayList<String>();
		List<String> angelegt_am = new ArrayList<String>();
		List<String> tutor = new ArrayList<String>();
		List<String> kolloquium = new ArrayList<String>();
		List<String> bemerkung = new ArrayList<String>();
		
		matrikelnummer = Statements.zeigeDaten("matrikelnummer",3);
		name = Statements.zeigeDaten("name",3);
		unternehmen = Statements.zeigeDaten("unternehmen",3);
		angelegt_am = Statements.zeigeDaten("angelegt_am",3);
		tutor = Statements.zeigeDaten("tutor",3);
		kolloquium = Statements.zeigeDaten("kolloquium",3);
		bemerkung = Statements.zeigeDaten("bemerkung",3);
		
		String table = "<div class='table-responsive'>"
				+ "<table class='table'>"
				+ "<tr>"
				+ "<th>Bearbeiten</th>"
				+ "<th>Matrikelnummer</th>"
				+ "<th>Name</th>"
				+ "<th>Unternehmen</th>"
				+ "<th>Angelegt am</th>"
				+ "<th>Tutor</th>"
				+ "<th>Kolloquium</th>"
				+ "<th>Bemerkung</th>"
				+ "<tr>";
		for (int i = 0; i < matrikelnummer.size(); i++) {
			table+= "<tr>"
				+ "<td><input type=radio  onclick='change()' name='radio'></td>"
				+ "<td>" + matrikelnummer.get(i) + "</td>" 
				+ "<td>" + name.get(i) + "</td>"
				+ "<td>" + unternehmen.get(i) + "</td>"
				+ "<td>" + angelegt_am.get(i) + "</td>"
				+ "<td>" + tutor.get(i) + "</td>"
				+ "<td>" + kolloquium.get(i) + "</td>"
				+ "<td>" + bemerkung.get(i) + "</td>"
				+ "</tr>";
		}
		table+= "</table>"
				+ "</div>";
		
		table+= "<script>\r\n" + 
				"function change() {"
				//Clicked ereignis
				+"}"+
				"</script>";
		
		try {
			out.print(table);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
