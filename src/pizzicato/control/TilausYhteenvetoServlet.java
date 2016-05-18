package pizzicato.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pizzicato.model.Tilaus;


@WebServlet("/TilausYhteenveto")
public class TilausYhteenvetoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 /**Hakee kaikki tilauksen tiedot sessiosta ja välittää ne jsp:lle**/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/view/tilausyhteenveto.jsp";
		HttpSession session = request.getSession(true);
		Tilaus tilaus = (Tilaus) session.getAttribute("tilaus");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
