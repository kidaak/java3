package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.Lotto;


@WebServlet(name="lottoServlet",urlPatterns="/lotto")
public class LottoServlet extends HttpServlet{


	private static final long serialVersionUID = 8160719458808L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<html><head></head>");
		out.println("<body>");
		out.println("<h1>Lotto</h1>");
		Lotto lotto = new Lotto();
		int anz = Integer.parseInt(req.getParameter("anz"));
		int max = Integer.parseInt(req.getParameter("max"));
		
		
		Integer[] zahlen = lotto.getLottozahlen(anz, max);
		
		out.println("<table border='1'>");
		
		for (int i = 0; i < zahlen.length; i++) {
			out.println("<tr>");
			out.println("<td>"+(i+1)+"</td><td>"+zahlen[i]+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
	
		
		out.print("<a href='/LottoServlet/sort'>sortieren</a>");
		out.println("</body>");
		out.println("</html>");
		
		session.setAttribute("zahlen", zahlen);
		
	}

}
