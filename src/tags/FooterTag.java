package tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FooterTag extends SimpleTagSupport {

	public void doTag() {
		JspWriter out = getJspContext().getOut();
		
		try {
			out.println("<div class='footer'"
					+ "<footer>"
			 + "<p>Erstellt von: Niklas Hock und Constantin Bettels in Form einer Projektarbeit"
			 + " für den Kurs Datenbankpraktikum im WiSe18/19 an der Universität Hildesheim."
			 + " Bei Anregungen o.Ä gerne bei <a href=mailto:bettelsc@uni-hildesheim.de>bettelsc@uni-hildesheim.de</a>"
			 + " oder <a href=mailto:hockni@uni-hildesheim.de>hockni@uni-hildesheim.de</a> melden. </p>"
			 + "<p>Falls Probleme oder Fragen jeglicher Natur auftauchen: "
			 + "<a href=mailto:hahne@uni-hildesheim.de>hahne@uni-hildesheim.de</a>.</p>"
			 + "</footer>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
