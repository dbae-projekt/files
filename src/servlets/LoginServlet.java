package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nutzerrollen.Nutzer;
import sql.Statements;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //Do Get wird mit übergebener Request und Response aufgerufen.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Wenn der Login erfolgreich ist, wird der Admin-Status des Nutzers geprüft. Sollte ein der Nutzer ein Admin sein,
		//wird ein Nutzerobjekt mit Namen admin erstellt, sollte dieser nicht bereits vorhanden sein.
	    try {
	    	Integer.parseInt(request.getParameter("matrikelnummer"));
	    } catch (NumberFormatException e) {
	    	request.getRequestDispatcher("login.jsp").forward(request, response);
	    }
		if (Statements.login(Integer.parseInt(request.getParameter("matrikelnummer")),request.getParameter("passwort"))) {
			if(Statements.pruefeAdmin(Integer.parseInt(request.getParameter("matrikelnummer")))) {
				Nutzer admin = null;
				HttpSession session = request.getSession();
				if(session.getAttribute("admin") == null) {
					admin = new Nutzer(Integer.parseInt(request.getParameter("matrikelnummer")));
				} else {
					admin = (Nutzer) session.getAttribute("admin");
				}
				session.setAttribute("admin", admin);
				request.getRequestDispatcher("startseite.jsp").forward(request, response);
			}
			else {
				//Sonst wird ein Nutzer mit Namen student mit den Daten des Nutzers aus der Tabelle studierende erstellt.
				//Sollte bereits ein Nutzer vorhanden sein, wird dieser aus der Session geholt
				Nutzer nutzer = null;
				HttpSession session = request.getSession();
				if (session.getAttribute("student") == null) {
					List<String> daten = new ArrayList<String>();
					daten = Statements.zeigeDaten(Integer.parseInt(request.getParameter("matrikelnummer")));
					nutzer = new Nutzer(daten.get(0),Integer.parseInt(daten.get(1)),
							daten.get(2),daten.get(3),daten.get(4),daten.get(5),Integer.parseInt(daten.get(6)),
							daten.get(7),daten.get(8),daten.get(9),daten.get(10),daten.get(11),daten.get(12),
							daten.get(13),daten.get(14),daten.get(15));
				}
				else {
					nutzer = (Nutzer) session.getAttribute("student");
				}
				session.setAttribute("student", nutzer);
				//Die Matrikelnummer des Nutzers wird aus der Request geholt und die Bemerkung des Admins,
				//sowie die zugeordneten Tutordaten werden aus der Datenbank geladen und in die Session gespeichert.
				int matrikelnummer = Integer.parseInt(request.getParameter("matrikelnummer"));
				
				//Wenn noch kein Praktikum vorhanden.
				if(Statements.zeigeBemerkung(matrikelnummer) == null) {
					List<String> liste = new ArrayList<String>();
					for(int i = 0; i < 4; i++) {
					liste.add("");
					}
					session.setAttribute("nachricht", "");
					session.setAttribute("tutordaten", liste);
				}
				//Wenn Praktikum erstellt wurde.
				else {
					session.setAttribute("nachricht", Statements.zeigeBemerkung(matrikelnummer));
					session.setAttribute("tutordaten", Statements.zeigeAngabenTutor(matrikelnummer));
				}
				request.getRequestDispatcher("startseite_student.jsp").forward(request, response);
			}
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
