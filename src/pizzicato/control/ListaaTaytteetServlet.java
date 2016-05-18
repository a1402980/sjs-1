package pizzicato.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzicato.model.Tayte;
import pizzicato.model.dao.TayteDAO;


@WebServlet("/ListaaTaytteet")
public class ListaaTaytteetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * Hakee täytedaon avulla täytteet täytetaulusta
	 * Asettaa täytelistan attribuutiksi
	 * Välittää selaimelle täytelistan ja ohjaa jsphen
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TayteDAO taytedao = new TayteDAO();
		ArrayList<Tayte> taytteet = taytedao.findAll();	
		
		request.setAttribute("taytteet", taytteet);		
			


		String jsp = "/view/listaa_taytteet_omistaja.jsp";

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}


}
