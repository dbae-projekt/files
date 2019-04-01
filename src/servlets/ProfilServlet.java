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
 * Servlet implementation class ProfilServlet
 */
@WebServlet("/ProfilServlet")
public class ProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("student") != null) {
			Nutzer nutzer = (Nutzer) session.getAttribute("student");
			
			try {
			Statements.profilEingabe(nutzer.getName(),nutzer.getMatrikelnummer(),request.getParameter("email"), 
					request.getParameter("telefonnummer"),request.getParameter("beginn"),
					request.getParameter("ende"),Integer.parseInt(request.getParameter("dauer")),request.getParameter("unternehmen"), 
					request.getParameter("abteilung"),request.getParameter("kurztitel"),request.getParameter("beschreibung"),
					request.getParameter("einsatzort"),nutzer.getName_tutor(),nutzer.getEmail_tutor(),
					nutzer.getTelefon_tutor(),nutzer.getVorschlag_mentor());
			
			nutzer.setEmail(request.getParameter("email"));
			nutzer.setTelefon(request.getParameter("telefonnummer"));
			nutzer.setBeginn(request.getParameter("beginn"));
			nutzer.setEnde(request.getParameter("ende"));
			nutzer.setDauer(Integer.parseInt(request.getParameter("dauer")));
			nutzer.setAbteilung(request.getParameter("abteilung"));
			nutzer.setUnternehmen(request.getParameter("unternehmen"));
			nutzer.setKurztitel(request.getParameter("kurztitel"));
			nutzer.setBeschreibung(request.getParameter("beschreibung"));
			nutzer.setEinsatzort(request.getParameter("einsatzort"));
			
			}
			
			catch (NullPointerException npe) {
			}
			request.setAttribute("student", nutzer);
			request.getRequestDispatcher("profil.jsp").forward(request, response);
			
		}
		else {
			int matrikelnummer  = Integer.parseInt(request.getParameter("matrikelnummern"));
			request.setAttribute("liste", Statements.zeigeDaten(matrikelnummer));
			
			request.getRequestDispatcher("student_profilseite.jsp").forward(request, response);
		}
	
	}

}
