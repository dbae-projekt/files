package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Servlet Filter implementation class HtmlFilter
 */
@WebFilter( urlPatterns= {"/print-filtered-text"})
public class HtmlFilter extends BaseFilter implements Filter {
       
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HtmlRequestWrapper wrapper = new HtmlRequestWrapper((HttpServletRequest) request);
		wrapper.getCookies();
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
}
class HtmlRequestWrapper extends HttpServletRequestWrapper implements HttpServletRequest {
	
	public HtmlRequestWrapper(HttpServletRequest request) {
		
		super(request);
	}
	
	public String getParameter(String str) {
		
		return super.getParameter(str) == null ? "" :
			   super.getParameter(str).replaceAll("<(.|\n)*?>", "");
	}
}














