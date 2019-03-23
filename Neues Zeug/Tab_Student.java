package tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Tab_Student extends SimpleTagSupport {
	
	public void doTag() {
		
		JspWriter out = getJspContext().getOut();
		
		try {
			out.println("<nav class=\"navbar navbar-expand-sm bg-light\">\r\n" + 
					"  	<ul class=\"navbar-nav\">\r\n" + 
					"   		<li class=\"nav-item\">\r\n" + 
					"      		<a class=\"nav-link\" href=\"startseite_student.jsp\">Übersicht</a>\r\n" + 
					"   		</li>\r\n" + 
					"    	<li class=\"nav-item\">\r\n" + 
					"      		<a class=\"nav-link\" href=\"profil.jsp\">Daten ändern</a>\r\n" + 
					"    	</li>\r\n" + 
					"    	<li class=\"nav-item\">\r\n" + 
					"      		<a class=\"nav-link\" href=\"hilfe_student.jsp\">Hilfe</a>\r\n" + 
					"    	</li>\r\n" + 
					"   	</ul>\r\n" + 
					"   	<ul class=\"navbar-nav ml-auto\">\r\n" + 
					"   		<li class=\"nav-item\">\r\n" + 
					"    		<a class=\"nav-link\" href=\"logout.jsp\">Logout</a>\r\n" + 
					"    	</li>\r\n" + 
					"    </ul>\r\n" + 
					"</nav>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
