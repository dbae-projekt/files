package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nutzerrollen.Nutzer;
import sql.Statements;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(Statements.vorhanden(request.getParameter("matrikelnummer"), 4) == false) {
			Statements.registrieren(request.getParameter("name"), Integer.parseInt(request.getParameter("matrikelnummer")),
		    		request.getParameter("email"), (request.getParameter("passwort")));
		Nutzer nutzer = null;
		HttpSession session = request.getSession();
		if (session.getAttribute("student") == null) {
			nutzer = new Nutzer(request.getParameter("name"),Integer.parseInt(request.getParameter("matrikelnummer")),
					request.getParameter("email"),null,null,null,0,null,null,null,null,null,null,null,null,null);
		}
		else {
			nutzer = (Nutzer) session.getAttribute("student");
		}
		session.setAttribute("student", nutzer);
		request.getRequestDispatcher("startseite_student.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
