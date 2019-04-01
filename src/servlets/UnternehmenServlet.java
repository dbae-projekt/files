package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sql.Statements;
/**
 * Servlet implementation class UnternehmenServlet
 */
@WebServlet("/UnternehmenServlet")
public class UnternehmenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnternehmenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(Statements.vorhanden(request.getParameter("name"), 1) == false) {
			Statements.bearbeiteUnternehmen(request.getParameter("name"),
					request.getParameter("url"),
					request.getParameter("nickname"),
					Boolean.parseBoolean(request.getParameter("aktiv")), request.getParameter("beschreibung"), 1);
		}
		else if(Statements.vorhanden(request.getParameter("name"), 1) == true) {
			Statements.bearbeiteUnternehmen(request.getParameter("name"),
					request.getParameter("url"),
					request.getParameter("nickname"),
					Boolean.parseBoolean(request.getParameter("aktiv")), request.getParameter("beschreibung"), 2);
		}
		request.getRequestDispatcher("unternehmen.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
