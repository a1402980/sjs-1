package pizzicato.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzicato.model.Pizza;
import pizzicato.model.Tayte;
import pizzicato.model.dao.PizzaDAO;
import pizzicato.model.dao.TayteDAO;


@WebServlet("/LisaaPizza")
public class LisaaPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**LisaaPizzaServletin doGet metodi luo k�ytt�j�n n�kym�n selaimeen.**/   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp ="/view/lisaa_pizza.jsp";
		TayteDAO taytedao = new TayteDAO();
		ArrayList<Tayte> kaikkitaytteet = taytedao.findAll();
		request.setAttribute("kaikkitaytteet", kaikkitaytteet);	
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);
	}
	
	/**LisaaPizzaServletin doPost metodi hakee k�ytt�j�n sy�tt�m�t tiedot selaimelta ja l�hett�� tiedot tietokantayhteysoliolle. (K�ytt�j�n sy�tt�mien tietojen mukaan PizzaDAOn metodi luo uuden Pizzaolion tietokantaan) **/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String> errors = validate(request);
		Pizza pizza = (Pizza) request.getAttribute("pizza");	
		
		if (!errors.isEmpty()) {
			System.out.println(errors);
			response.sendRedirect("LisaaPizza");
		} else {
			PizzaDAO pizzadao = new PizzaDAO();
			try {
				pizzadao.addPizza(pizza);							
			} catch (SQLException e) {
				System.out.println("Sovelluksessa tapahtui virhe "+ e.getMessage());
				e.printStackTrace();
			}

			response.sendRedirect("ListaaPizzat");
			
		}			
	}
	
	public static Map<String, String> validate(HttpServletRequest request) {
		Map<String, String> errors = new HashMap<String, String>();
		Pizza pizza = new Pizza();
		Double pHinta = null;
	
		String pNimi = request.getParameter("nimi");
		if (pNimi == null || pNimi.trim().length() < 2) {
			errors.put("nimi", " Nimen on oltava v�hint��n 2 merkki� pitk�.");
		}else{
			pizza.setpNimi(pNimi);
		}
		
		String strPHinta = request.getParameter("hinta");
		try {
			 pHinta = Double.parseDouble(strPHinta.replace(",", "."));
		} catch (Exception e){
			errors.put("hinta", " Hinnan on oltava v�lilt� 5-100�.");
		}
		System.out.println(pHinta);
		if (pHinta == null || pHinta < 5.0 || pHinta > 100.0) {
			errors.put("pHinta", " Hinnan on oltava v�lilt� 5-100�.");
		}else{
			pizza.setpHinta(pHinta);
		}
		
		String pSaatavuus = request.getParameter("valikoimassa");
		if (pSaatavuus == null) {
			errors.put("pSaatavuus", " Saatavuus vaaditaan");
		} else {
			pizza.setpSaatavuus(pSaatavuus);
		}
		
		//t�ytteiden k�sittely
		int tayteId;
		int maxlkm = 7;
			
		String valituttaytteet[] = request.getParameterValues("tayte");
		if (valituttaytteet.length < maxlkm){		
			for (int i = 0; i < valituttaytteet.length; i++){
				//muutetaan tayteId:t stringeist� inteiksi
				tayteId = new Integer(valituttaytteet[i]);
				//luodaan t�yte olio ja lis�t��n t�yteid:t niihin, t�ytedaosta haetaan muut t�ytteen tiedot
				Tayte tayte = new Tayte();
				TayteDAO taytedao = new TayteDAO();
				tayte = taytedao.findCertainTayte(tayteId);
					System.out.println(tayte);
				//lis�t��n t�yte-oliot pizza-olion t�ytelistaan
				pizza.addTayte(tayte);	
			} 
		} else {
			errors.put("T�ytteet", " T�ytteit� voi lis�t� korkeintaan 6.");
		}
		request.setAttribute("pizza", pizza);
		return errors;
	}
	

	

}
