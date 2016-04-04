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

import pizzicato.model.Pizza;
import pizzicato.model.dao.PizzaDAO;


@WebServlet("/LisaaPizza")
public class LisaaPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**LisaaPizzaServletin doGet metodi luo käyttäjän näkymän selaimeen.**/   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp ="/view/lisaa_pizza.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);
	}
	
	/**LisaaPizzaServletin doPost metodi hakee käyttäjän syöttämät tiedot selaimelta ja lähettää tiedot tietokantayhteysoliolle. (Käyttäjän syöttämien tietojen mukaan PizzaDAOn metodi luo uuden Pizzaolion tietokantaan) **/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> errors = validate(request);
		Pizza pizza = (Pizza) request.getAttribute("pizza");
		System.out.println(pizza);
		
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
		HashMap<String, String> errors = new HashMap<String, String>();
		Pizza pizza = new Pizza();
		
		String pNimi = request.getParameter("nimi");
		if (pNimi == null || pNimi.trim().length() < 2) {
			errors.put("nimi", "Nimi vaaditaan.");
		}else{
			pizza.setpNimi(pNimi);
		}
		
		String strPHinta = request.getParameter("hinta");
		strPHinta = strPHinta.replace(",", ".");
		Double pHinta = new Double(strPHinta);
		if (pHinta == null || pHinta < 5 || pHinta > 100) {
			errors.put("pHinta", "Hinta vaaditaan.");
		}else{
			pizza.setpHinta(pHinta);
		}
		
		String pSaatavuus = request.getParameter("valikoimassa");
		if (pSaatavuus.equalsIgnoreCase("kyllä")) {
			pSaatavuus = "true";
			pizza.setpSaatavuus(pSaatavuus);
		} else if (pSaatavuus.equalsIgnoreCase("ei")) {
			pSaatavuus = "false";
			pizza.setpSaatavuus(pSaatavuus);
		}
		pizza.setpSaatavuus(pSaatavuus);
		
		request.setAttribute("pizza", pizza);
		return errors;
	}

}
