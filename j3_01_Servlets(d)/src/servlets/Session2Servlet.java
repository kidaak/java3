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


@WebServlet(name="session2", urlPatterns="/session2")//Alternativ zum üüüüüüweb.xml-Eintrag
public class Session2Servlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8160719458808L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession session = req.getSession();
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html><head></head>");
		out.println("<body>");
		out.println("<h1>Servlet 2</h1>");
		
		String vorname = String.valueOf(session.getAttribute("vorname")); 
		
		String nachname = String.valueOf(session.getAttribute("nachname")); 
		
		Point point = (Point) session.getAttribute("point");
		
		out.print(vorname+" "+nachname +" "+point);
		out.println("</body>");
		out.println("</html>");
		
	}

}
