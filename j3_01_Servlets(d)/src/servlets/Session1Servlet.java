package servlets;

import java.awt.Point;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name="session", urlPatterns="/session")//Alternativ zum web.xml-Eintrag
public class Session1Servlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8160719458808L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession session = req.getSession(true);
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html><head></head>");
		out.println("<body>");
		out.println("<h1>Hallo Servlet...</h1>");
		
		String vorname = req.getParameter("vorname"); // <input name="vorname"...
		
		String nachname = req.getParameter("nachname"); // <input name="nachname"...
		
		out.print(vorname+" "+nachname);
		
		
	
		out.print("<a href='/ServletTest/session2'>Weiter</a>");
		
		out.println("</body>");
		out.println("</html>");
		// Objekte in Session speichern (Schlüssel, Objekt)
		session.setAttribute("vorname", vorname);
		session.setAttribute("nachname", nachname);
		session.setAttribute("point", new Point(2, 3));// andere Objekte
		
		
		
	}

}
