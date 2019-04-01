package tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Tab_Admin extends SimpleTagSupport {
	public void doTag() {
		JspWriter out = getJspContext().getOut();
		try {
			out.print("<nav class=\"navbar navbar-expand-sm bg-light\">\r\n" + 
					"  	<ul class=\"navbar-nav\">\r\n" + 
					"   		<li class=\"nav-item\">\r\n" + 
					"      		<a class=\"nav-link\" href=\"startseite.jsp\">Startseite</a>\r\n" + 
					"   		</li>\r\n" + 
					"    	<li class=\"nav-item\">\r\n" + 
					"      		<a class=\"nav-link\" href=\"unternehmen.jsp\">Unternehmen</a>\r\n" + 
					"    	</li>\r\n" + 
					"    	<li class=\"nav-item\">\r\n" + 
					"      		<a class=\"nav-link\" href=\"praktika.jsp\">Praktika</a>\r\n" + 
					"    	</li>\r\n" + 
					"    	<li class=\"nav-item\">\r\n" + 
					"      		<a class=\"nav-link\" href=\"tutoren.jsp\">Tutoren</a>\r\n" + 
					"    	</li>\r\n" + 
					"   	</ul>\r\n" + 
					"   	<ul class=\"navbar-nav ml-auto\">\r\n" + 
					"   		<li class=\"nav-item\">\r\n" + 
					"    			<form action='LogoutServlet' method='post'>" +
					"					<button class='btn btn-primary' type='submit' value='Submit'>Logout</button>" +
					"				</form>" + 
					"    	</li>\r\n" + 
					"    </ul>\r\n" + 
					"</nav>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
