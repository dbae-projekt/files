package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sql.Statements;

/**
 * Servlet implementation class TutorenServlet
 */
@WebServlet("/TutorenServlet")
public class TutorenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TutorenServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(Statements.vorhanden(request.getParameter("name"), 3) == false) {
			if(request.getParameter("titel") != null) {
				Statements.bearbeiteTutor(request.getParameter("titel"),
				request.getParameter("name"),
				request.getParameter("email"),request.getParameter("telefon"), 1);
			}
		}
		else if(Statements.vorhanden(request.getParameter("name"), 3) == true) {
			Statements.bearbeiteTutor(request.getParameter("titel"),
					request.getParameter("name"),
					request.getParameter("email"),request.getParameter("telefon"), 2);
		}
		request.getRequestDispatcher("tutoren.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
