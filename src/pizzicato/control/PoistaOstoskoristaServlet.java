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
       
	/**
	 * Hakee session ja hakee tilausattribuutin sessiosta
	 * Hakee rivinumeron ja poistaa sen perusteelle pizzan ostoskorista
	 * Ohjaa selaimen osotoskoriservletiin
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		Tilaus tilaus;
		tilaus = (Tilaus) session.getAttribute("tilaus");
		
		String StrRiviNro = request.getParameter("rivinro");
		int rivinro = Integer.parseInt(StrRiviNro);
		
		tilaus.removePizzaTilaus(rivinro);
	
		
		response.sendRedirect("ostoskori");
	}

}
