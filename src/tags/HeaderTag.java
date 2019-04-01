package tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HeaderTag extends SimpleTagSupport  {

	public void doTag() {
		
		JspWriter out = getJspContext().getOut();
		
		try {
			out.println("<img class=\"float-left\" alt=\"Logo\" src=\"pics/uni_logo.jpg\">\r\n" + 
					"	<div class=\"jumbotron text-center\">\r\n" + 
					"		<h1>Praktikumsdatenbank</h1>\r\n" + 
					"	</div>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
