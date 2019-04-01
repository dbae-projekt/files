package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sql.Statements;

/**
 * Servlet implementation class PraktikaServlet
 */
@WebServlet("/PraktikaServlet")
public class PraktikaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PraktikaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Beim Ändern der Praktika-Daten wird der Datenbankeintrag, welcher mit der übergebenen Matrikelnummer übereinstimmt, aktualisiert.
		//Sollten keine Daten vorhanden sein, werden diese neu in die Datenbank eingetragen
		if(Statements.vorhanden(request.getParameter("matrikelnummern"), 2) == false) {
			Statements.bearbeitePraktika(Integer.parseInt(request.getParameter("matrikelnummern")),request.getParameter("name"),
					request.getParameter("unternehmen"),request.getParameter("angelegt_am"),
					request.getParameter("tutor"), request.getParameter("kolloquium"), request.getParameter("vorschlag_mentor"), request.getParameter("bemerkung"), 
					Boolean.parseBoolean(request.getParameter("aktiv")), 1);
		}
		else if(Statements.vorhanden(request.getParameter("matrikelnummern"), 2) == true) {
			Statements.bearbeitePraktika(Integer.parseInt(request.getParameter("matrikelnummern")),request.getParameter("name"),
					request.getParameter("unternehmen"),request.getParameter("angelegt_am"),
					request.getParameter("tutoren"), request.getParameter("kolloquium"), request.getParameter("vorschlag_mentor"), request.getParameter("bemerkung"),
					Boolean.parseBoolean(request.getParameter("aktiv")), 2);
			int matrikelnummer = Integer.parseInt(request.getParameter("matrikelnummern"));
			Statements.updateTutorangaben(matrikelnummer);
		}
		request.getRequestDispatcher("praktika.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
