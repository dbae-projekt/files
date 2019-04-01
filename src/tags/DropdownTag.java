package tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import nutzerrollen.Nutzer;
import sql.Statements;

public class DropdownTag extends SimpleTagSupport {
	
	String auswahl = null;
	public void setAuswahl( String auswahl){
        this.auswahl = auswahl;
    }
	
	public void doTag() {
		JspWriter out = getJspContext().getOut();
		Nutzer nutzer = (Nutzer)getJspContext().findAttribute("student");
		String liste = null;
		
		if(auswahl == "matrikelnummern") {
			List<String> matrikelnummern = new ArrayList<String>();
			matrikelnummern = Statements.zeigeDaten("matrikelnummer",5);
			liste = "<select id='matrikelnummern' name='matrikelnummern'>"; 
			for(int i = 0; i < matrikelnummern.size(); i++)	{
				if(i == 0) {
					liste+= "<option selected>" + matrikelnummern.get(i) + "</option>";
				}
				else {
				liste+= "<option>" + matrikelnummern.get(i) + "</option>";
				}
			}
			liste+= "</select>";
		}
		
		if(auswahl == "tutoren") {
			List<String> tutoren = new ArrayList<String>();
			tutoren = Statements.zeigeDaten("name",4);
			liste = "<select id='tutoren' name='tutoren'>"; 
			for(int i = 0; i < tutoren.size(); i++)	{
				if(i == 0) {
					liste+= "<option selected>" + tutoren.get(i) + "</option>";
				}
				else {
				liste+= "<option>" + tutoren.get(i) + "</option>";
				}
			}
		liste+= "</select>";
		}
		
		if(auswahl == "unternehmen") {
			List<String> namen = new ArrayList<String>();
			namen = Statements.zeigeDaten("name",2);
			
			liste = "<select id='unternehmen' name='unternehmen'>"; 
			for(int i = 0; i < namen.size(); i++)	{
				if(namen.get(i).equals(nutzer.getUnternehmen())) {
					liste+= "<option selected>" + namen.get(i) + "</option>";
				}
				else {
				liste+= "<option>" + namen.get(i) + "</option>";
				}
			}
			liste+= "</select>";
		}
		
		try {
			out.print(liste);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
