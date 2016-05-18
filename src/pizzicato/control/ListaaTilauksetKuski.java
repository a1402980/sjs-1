package pizzicato.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzicato.model.Tilaus;
import pizzicato.model.dao.TilausDAO;

@WebServlet("/ListaaTilauksetKuski")
public class ListaaTilauksetKuski extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	/**
	 * Hakee tilausdaon avulla tilaukset tietokannasta
	 * Tarkistaa colan, fantan ja sprite tiedot ja muuntaa kyllä/ei muotoon
	 * Asettaa tilaukset attribuutiksi ja välittää tilaukset listan selaimelle. Ohjaa jsphen
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TilausDAO tilausdao = new TilausDAO();
				
		ArrayList<Tilaus> tilaukset = tilausdao.kuskiFindAll();
		
		String cola;
		String fanta;
		String sprite;
		for(int i=0; i<tilaukset.size();i++){
			cola = tilaukset.get(i).getCola();
			fanta = tilaukset.get(i).getFanta();
			sprite =tilaukset.get(i).getSprite();
			if(cola == null||cola.equals(false)|| cola.equals(" ")){
				cola = "ei";
				tilaukset.get(i).setCola(cola);
			}else{
				cola = "kyllä";
				tilaukset.get(i).setCola(cola);
			}
			if(fanta == null ||fanta.equals(false) || fanta.equals(" ")){
				fanta = "ei";
				tilaukset.get(i).setFanta(fanta);
			}else{
				fanta = "kyllä";
				tilaukset.get(i).setFanta(fanta);
			}
			if(sprite == null || sprite.equals(false) || sprite.equals(" ")){
				sprite = "ei";
				tilaukset.get(i).setSprite(sprite);
			}else{
				sprite = "kyllä";
				tilaukset.get(i).setSprite(sprite);
			}
		}
		
		request.setAttribute("tilaukset", tilaukset);	
		
		String jsp = "/view/tilaukset_kuskille.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

	/**
	 * Jos toimitettu nappia painetaan selain ohjautuu dopostiin.
	 * Muuttaa tilausdaon avulla tilauksen statuksen tietokantaan
	 * Ohjaa selaimen takaisin kuskin näkymään
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TilausDAO tilausdao = new TilausDAO();
		String strTilId = request.getParameter("nappi");
		int tilausId = new Integer(strTilId);
		try {
			tilausdao.modifyStatusKuski(tilausId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		response.sendRedirect("ListaaTilauksetKuski");
	}

}
