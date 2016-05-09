package pizzicato.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pizzicato.model.PizzaTilaus;
import pizzicato.model.Tilaus;
import pizzicato.model.dao.TilausDAO;

@WebServlet("/PoistaOstoskorista")
public class PoistaOstoskoristaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		PizzaTilaus pizzatilaus;
		pizzatilaus = (PizzaTilaus) session.getAttribute("tilaus_id");
		
		Tilaus tilaus;
		
		String StrLkm = request.getParameter("pizzamaara");
		int lkm = Integer.parseInt(StrLkm);
		
		
		
		//session.removeAttribute("tilaus_id");
		for (int i = 0; i < lkm; i++) {
			
		}
			tilaus.addPizzaTilaus(pizzatilaus);
		
		response.sendRedirect("ostoskori");
	}

}
