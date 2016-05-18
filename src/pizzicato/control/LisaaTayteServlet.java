package pizzicato.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzicato.model.Tayte;
import pizzicato.model.dao.TayteDAO;


@WebServlet("/LisaaTayte")
public class LisaaTayteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  /**
   * Ohjaa selaimen jsphen
   */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp ="/view/lisaa_tayte.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);
	}

	/**
	 * Hakee selaimelta täyteen tiedot, validoi
	 * Ottaa yhteyden täytedaoon, lisää täytteen tietokantaan.
	 * Ohjaa selaimen listaa  täytteet servletiin
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> errors = validate(request);
		Tayte tayte = (Tayte) request.getAttribute("tayte");
		
		if (!errors.isEmpty()) {
			System.out.println(errors);
			response.sendRedirect("LisaaTayte");
		} else {
			TayteDAO taytedao = new TayteDAO();
			try {
				taytedao.addTayte(tayte);
			} catch (SQLException e) {
				System.out.println("Sovelluksessa tapahtui virhe "+ e.getMessage());
				e.printStackTrace();
			}
			response.sendRedirect("ListaaTaytteet");
		}			
		
	}
	public static Map<String, String> validate(HttpServletRequest request) {
		Map<String, String> errors = new HashMap<String, String>();
		Tayte tayte = new Tayte();
		Double tHinta = null;
	
		String tNimi = request.getParameter("nimi");
		if (tNimi == null ||tNimi.trim().length() < 2) {
			errors.put("nimi", " Nimen on oltava vähintään 2 merkkiä pitkä.");
		}else{
			tayte.settNimi(tNimi);
		}
		
		String strTHinta = request.getParameter("hinta");
		try {
			 tHinta = Double.parseDouble(strTHinta.replace(",", "."));
		} catch (Exception e){
			errors.put("hinta", " Hinnan on oltava väliltä 0-20€.");
		}
		System.out.println(tHinta);
		if (tHinta == null || tHinta < 0 || tHinta > 20.0) {
			errors.put("pHinta", " Hinnan on oltava väliltä 0-20€.");
		}else{
			tayte.settHinta(tHinta);
		}
		request.setAttribute("tayte", tayte);
		return errors;
	}


}
