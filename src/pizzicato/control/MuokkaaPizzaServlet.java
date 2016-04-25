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

@WebServlet("/MuokkaaPizza")
public class MuokkaaPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * MuokkaaPizzaServletin doGet metodi hakee muokattavan pizzan tiedot
	 * tietokannasta PizzaDAOn metodilla ja luo käyttäjän näkymän selaimelle
	 **/
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/view/muokkaa_pizza.jsp";
		
		String idString = request.getParameter("pizza_id");
		int pizzaId = Integer.parseInt(idString);
		PizzaDAO pizzadao = new PizzaDAO();
		Pizza pizza = pizzadao.findCertainPizza(pizzaId);
		System.out.println("pizzan täytteet" + pizza);
		request.setAttribute("pizza", pizza);
		
		TayteDAO taytedao = new TayteDAO();
		ArrayList<Tayte> kaikkitaytteet = taytedao.findAll();
		request.setAttribute("kaikkitaytteet", kaikkitaytteet);	
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);

	}

	/**
	 * MuokkaaPizzaServletin doPost metodi hakee käyttäjän syöttämät tiedot
	 * selaimelta ja lähettää muokatt tiedot PizzaDAOon.
	 **/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jsp = "/view/muokkaa_pizza.jsp";
		
		Map<String, String> errors = validate(request);
		if (!errors.isEmpty()) {
			System.out.println("doPost "+errors);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);
			return;
		}
		
			Pizza pizza = (Pizza) request.getAttribute("pizza");
			PizzaDAO pizzadao = new PizzaDAO();
			try {
				pizzadao.deletePizza(pizza.getPizzaId());
				pizzadao.addPizza(pizza);	
				pizzadao.modifyPizza(pizza);
			} catch (SQLException e) {
				System.out.println("Sovelluksessa tapahtui virhe " + e.getMessage());
				e.printStackTrace();
			}

			response.sendRedirect("ListaaPizzat");
		}


	public static Map<String, String> validate(HttpServletRequest request) {
		Pizza pizza = new Pizza();
		HashMap<String, String> errors = new HashMap<String, String>();

		
		 //haetaan id 
		 String idString = request.getParameter("pizza_id"); 
		 int Id = new Integer(idString); 
		 pizza.setPizzaId(Id);

		// nimen validointi
		String syotettyNimi = request.getParameter("nimi");
		if (syotettyNimi == null || syotettyNimi.trim().length() < 2) {
			errors.put("nimi", "Nimi vaaditaan.");
		}
		pizza.setpNimi(syotettyNimi);

		// hinnan validointi
		String syotettyHinta = request.getParameter("hinta");
		syotettyHinta = syotettyHinta.replace(",", ".");
		Double pHinta = new Double(syotettyHinta);
		if (pHinta == null || pHinta < 5 || pHinta > 100) {
			errors.put("pHinta", "Hinta vaaditaan.");
		}
		pizza.setpHinta(pHinta);

		String pSaatavuus = request.getParameter("valikoimassa");
		
		if (pSaatavuus == null) {
			errors.put("pSaatavuus", " Saatavuus vaaditaan");
		} else {
			pizza.setpSaatavuus(pSaatavuus);
		}
		
		//täytteiden käsittely
				int tayteId;
				int maxlkm = 6;
					
				String valituttaytteet[] = request.getParameterValues("tayte");
				if (valituttaytteet.length < maxlkm){		
					for (int i = 0; i < valituttaytteet.length; i++){
						//muutetaan tayteId:t stringeistä inteiksi
						tayteId = new Integer(valituttaytteet[i]);
						//luodaan täyte olio ja lisätään täyteid:t niihin, täytedaosta haetaan muut täytteen tiedot
						Tayte tayte = new Tayte();
						TayteDAO taytedao = new TayteDAO();
						tayte = taytedao.findCertainTayte(tayteId);
							System.out.println(tayte);
						//lisätään täyte-oliot pizza-olion täytelistaan
						pizza.addTayte(tayte);	
					} 
				} else {
					errors.put("Täytteet", " Täytteitä voi lisätä korkeintaan 6.");
				}
		
		request.setAttribute("errors", errors);
		request.setAttribute("pizza", pizza);
		
		return errors;

	}

}
