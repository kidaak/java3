package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(name = "session2", urlPatterns = "/session2") // alternativ zum
public class SessionServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();
		out.println("<html><head></head><body>");
		String email = String.valueOf(session.getAttribute("email"));
		String time = String.valueOf(session.getAttribute("time"));
		out.print("<h3>E-Mail: " + email + "</h3>");
		out.print("<h1>Time: " + time + "</h1>");
		out.print("<h2>Info</h2>");
		out.print("Session-Id: " + session.getId());
		out.print("<br>Creation Time: " + session.getCreationTime());
		out.println("<br><h2>Headerinfo: </h2>");
		printHeadersInfo(req, out);
		out.println("</body></html>");

		out.close();

	}

	private void printHeadersInfo(HttpServletRequest request, PrintWriter out) {

		Enumeration<?> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			out.print(key + ": " + value);
			out.print("<br>");
		}
	}
}
