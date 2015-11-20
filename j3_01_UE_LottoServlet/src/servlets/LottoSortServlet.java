package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.Lotto;


@SuppressWarnings("serial")
@WebServlet(name="lottoSortServlet",urlPatterns="/sort")
public class LottoSortServlet extends HttpServlet{



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<html><head></head>");
		out.println("<body>");
		out.println("<h1>Lotto Sort</h1>");


		
		Integer[] zahlen = (Integer[]) session.getAttribute("zahlen");
		
		Arrays.sort(zahlen);
	
		out.println("<table border='1'>");
		for (int i = 0; i < zahlen.length; i++) {
			out.println("<tr>");
			out.println("<td>"+(i+1)+"</td><td>"+zahlen[i]+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
	
		
		out.print("<a href='/LottoServlet/lottoForm.html'>Back</a>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
