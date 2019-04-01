package tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import sql.Statements;

public class Table_Tutoren extends SimpleTagSupport {
	public void doTag() {
		JspWriter out = getJspContext().getOut();
		
		List<String> titel = new ArrayList<String>();
		List<String> name = new ArrayList<String>();
		List<String> email = new ArrayList<String>();
		List<String> telefon = new ArrayList<String>();
		
		titel = Statements.zeigeDaten("titel",4);
		name = Statements.zeigeDaten("name",4);
		email = Statements.zeigeDaten("email",4);
		telefon = Statements.zeigeDaten("telefon",4);
		
		String table = "<div class=\"table-responsive\">\r\n" + 
				"  <table id='tabelle_tutoren' class=\"table\">\r\n" + 
				"	<tr>\r\n" + 
				"    	<th>Bearbeiten</th>\r\n" + 
				"    	<th>Titel</th> \r\n" + 
				"    	<th>Name</th>\r\n" + 
				"    	<th>E-Mail</th> \r\n" + 
				"    	<th>Telefon</th>\r\n" + 
				"  	</tr>\r\n"; 
		for (int i = 0; i < email.size(); i++) {
			table+= "<tr name='row'>"
				+ "<td><input type=radio  onclick='change()' name='radio'></td>"
				+ "<td>" + titel.get(i) + "</td>"
				+ "<td>" + name.get(i) + "</td>"
				+ "<td>" + email.get(i) + "</td>"
				+ "<td>" + telefon.get(i) + "</td>"
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
					+ "document.getElementById('titel').value = list[i].cells[1].innerHTML;"
					+ "document.getElementById('name').value = list[i].cells[2].innerHTML;"
					+ "document.getElementById('email').value = list[i].cells[3].innerHTML;"
					+ "document.getElementById('telefon').value = list[i].cells[4].innerHTML;"
					+ "	}\r\n" 
					+ "}"
					+ "}"
					+ "</script>";
			out.print(table);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
