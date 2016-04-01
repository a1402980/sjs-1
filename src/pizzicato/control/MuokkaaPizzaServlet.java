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
		System.out.println(idString);
		int pizzaId = Integer.parseInt(idString);
		System.out.println(pizzaId);
		Pizza pizza = new PizzaDAO().findCertainPizza(pizzaId);
		System.out.println(pizza);
		request.setAttribute("pizza", pizza);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(jsp);
		dispatcher.forward(request, response);

	}

	/**
	 * MuokkaaPizzaServletin doPost metodi hakee käyttäjän syöttämät tiedot
	 * selaimelta ja lähettää muokatt tiedot PizzaDAOon.
	 **/
	protected void doPost(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, String> errors = validate(req);
		if (!errors.isEmpty()) {
			System.out.println("doPost "+errors);
			response.sendRedirect("MuokkaaPizza");
			return;
		} else {
			Pizza pizza = (Pizza) req.getAttribute("pizza");
			PizzaDAO modifiedPizzadao = new PizzaDAO();
			try {
				modifiedPizzadao.modifyPizza(pizza);
			} catch (SQLException e) {
				System.out.println("Sovelluksessa tapahtui virhe "
						+ e.getMessage());
				e.printStackTrace();
			}
			response.sendRedirect("ListaaPizzat");
		}

	}

	public static Map<String, String> validate(HttpServletRequest request) {
		Pizza pizza = new Pizza();
		HashMap<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);
		request.setAttribute("pizza", pizza);

		/*
		 * /haetaan id String idString = request.getParameter("pizza_id"); int
		 * Id = new Integer(idString); pizza.setPizzaId(Id)
		 */

		// nimen validointi
		String syotettyNimi = request.getParameter("nimi");
		if (syotettyNimi == null || syotettyNimi.trim().length() == 2) {
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
		if (pSaatavuus.equalsIgnoreCase("kyllä")) {
			pSaatavuus = "true";
			pizza.setpSaatavuus(pSaatavuus);
		} else if (pSaatavuus.equalsIgnoreCase("ei")) {
			pSaatavuus = "false";
			pizza.setpSaatavuus(pSaatavuus);
		}
		pizza.setpSaatavuus(pSaatavuus);
		return errors;

	}

}
