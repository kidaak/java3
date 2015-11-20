package servlet;

import java.awt.Point;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Timestamp;
import java.time.LocalTime;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(name="session",urlPatterns="/session")// alternativ zum Web.xml-Eintrag
public class SessionServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession(true);// erzeugt eine Session, wenn noch keine vorhanden
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html><head></head><body>");
		
		printSessionAttributes(session, out);
		
		
		String email = req.getParameter("email");
		session.setAttribute("email", email);
		out.println("E-Mail: "+email);
	
		if(session.isNew()){
			session.setAttribute("time", LocalTime.now());
		}
		
		String url="/ServletSession/session2";
		if(!req.isRequestedSessionIdFromCookie()) {
			url= resp.encodeURL("/ServletSession/session2");
			// hängt eine Session-ID an die URL
			// wenn keine Cookies im Browser aktiviert sind
			// URL-Rewriting
			//;jsessionid=7FE7F8AF9009C1F1CB79CC50D66FE464
		}
		
		out.println("<a href='"+url+"'>weiter</a>");
		out.println("</body></html>");
		out.close();
	}
	
	private void printSessionAttributes(HttpSession session, PrintWriter out) {
		Enumeration<?> attributeName = session.getAttributeNames();
		while (attributeName.hasMoreElements()) {
			String name = (String) attributeName.nextElement();
			
			out.print(name+"<br>");
		}
	}

}
