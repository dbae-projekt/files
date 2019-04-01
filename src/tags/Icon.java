package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Icon extends SimpleTagSupport{
	public void doTag() throws JspException, IOException{
		JspWriter out = getJspContext().getOut();
		out.print("<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"pics/favicon.ico\">");
	}
}
