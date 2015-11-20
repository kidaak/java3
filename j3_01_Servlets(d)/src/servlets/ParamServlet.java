package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8160719458808L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<html><head></head>");
		out.println("<body>");
		out.println("<h1>Hallo Servlet...</h1>");
		
		String vorname = req.getParameter("vorname"); // <input name="vorname"...
		
		String nachname = req.getParameter("nachname"); // <input name="nachname"...
		
		out.print(vorname+" "+nachname);
		
	
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
