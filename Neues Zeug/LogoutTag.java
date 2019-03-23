package tags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class LogoutTag extends SimpleTagSupport {
	public void doTag() {
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext) getJspContext(); 
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest(); 
		HttpSession session = request.getSession();
		
		session.invalidate();
		try {
			out.print("<script>"
			+ "window.location='login.jsp';"
			+ "</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
