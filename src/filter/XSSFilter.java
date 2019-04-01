package filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Servlet Filter implementation class XSSFilter
 */
@WebFilter(urlPatterns= {"/print-filtered-text"})
public class XSSFilter extends BaseFilter implements Filter {
       
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		XSSRequestWrapper wrapper = new XSSRequestWrapper((HttpServletRequest) request);
		wrapper.getCookies();
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
}

class XSSRequestWrapper extends HttpServletRequestWrapper implements HttpServletRequest {
	
	public XSSRequestWrapper(HttpServletRequest request) {
		
		super(request);
	}
	
	public String getParameter(String str) {
		
		str = super.getParameter(str);
		
		if(str != null) {
			
			Pattern scriptPattern = null;
			scriptPattern = Pattern.compile("javascript: ", Pattern.CASE_INSENSITIVE);
			str = scriptPattern.matcher(str).replaceAll(" ");
			scriptPattern = Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE);
			str = scriptPattern.matcher(str).replaceAll(" ");
			scriptPattern = Pattern.compile("onmouseover=", Pattern.CASE_INSENSITIVE);
			str = scriptPattern.matcher(str).replaceAll(" ");
		}
		
		return str;
	}
}








