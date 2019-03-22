package tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import sql.Statements;

public class Table_Unternehmen extends SimpleTagSupport {
	public void doTag() {
		JspWriter out = getJspContext().getOut();
		
		List<String> namen = new ArrayList<String>();
		List<String> url = new ArrayList<String>();
		List<String> nicknames = new ArrayList<String>();
		List<String> aktiv = new ArrayList<String>();
		
		
		namen = Statements.zeigeDaten("name",2);
		url = Statements.zeigeDaten("url",2);
		nicknames = Statements.zeigeDaten("nickname",2);
		aktiv = Statements.zeigeDaten("aktiv",2);
		
		//Ändern der Anzeige von Aktiv zu Ja und Nein
		for(int i = 0; i < aktiv.size(); i++) {
			if(aktiv.get(i).equals("t")) {
				aktiv.set(i, "Ja");
			}
			else {
				aktiv.set(i, "Nein");
			}
		}
				
		String table = "<div id='tabelle'>"
				+ " <table>" 
				+ "			<tr>"
				+ "             <th>Bearbeiten</th>" 
				+ "				<th>Name</th>" 
				+ "				<th>URL</th>" 
				+ "				<th>Nickname</th>" 
				+ "				<th>Aktiv</th>"
				+ "			</tr>";
		for(int i = 0; i < namen.size();i++) {
			table+="<tr name='row'>"
					+ "<td><input type='radio' onclick=change() name='radio'></td>"
					+ "<td>" + namen.get(i) + "</td>"
					+ "<td>" + url.get(i) + "</td>"
					+ "<td>" + nicknames.get(i) + "</td>"
					+ "<td>" + aktiv.get(i) + "</td>"
					+ "</tr>";
		}
		table+="</table>"
				+ "</div>";
		
		
		try {
			out.print(table);
			out.print("<script>"
					+ "function change() {"
					+ "var list = document.getElementsByName('row');"
					+ "for(var i = 0; i < list.length; i++) {\r\n" 
					+ "	if(list[i].cells[0].getElementsByTagName('input')[0].checked) {\r\n" 
					+ "document.getElementById('name').value = list[i].cells[1].innerHTML;"
					+ "document.getElementById('url').value = list[i].cells[2].innerHTML;"
					+ "document.getElementById('nickname').value = list[i].cells[3].innerHTML;"
					+ "document.getElementById('aktiv').value = list[i].cells[4].innerHTML;"
					+ "	}\r\n" + 
					"}"
					
					+ "}"
					+ "</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
