package pizzicato.control;

import java.io.IOException;
import java.sql.SQLException;

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
       
   
	/**MuokkaaPizzaServletin doGet metodi hakee muokattavan pizzan tiedot tietokannasta PizzaDAOn metodilla ja luo k�ytt�j�n n�kym�n selaimelle**/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/view/muokkaa_pizza.jsp";		
		
		String strId = request.getParameter("pizza_id");
		int pizzaId = new Integer(strId);
		PizzaDAO pizzadao = new PizzaDAO();
		Pizza pizza = pizzadao.findCertainPizza(pizzaId);
		request.setAttribute("pizza", pizza);
				
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
		
	}

	/**MuokkaaPizzaServletin doPost metodi hakee k�ytt�j�n sy�tt�m�t tiedot selaimelta ja l�hett�� muokatt tiedot PizzaDAOon.**/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strId = request.getParameter("pizza_id");
		int pizzaId = new Integer(strId);	
		
		String syotettyNimi = request.getParameter("nimi");
		String syotettyHinta = request.getParameter("hinta");
		syotettyHinta = syotettyHinta.replace(",", ".");
		Double pHinta = new Double(syotettyHinta);
		String pSaatavuus = request.getParameter("valikoimassa");
		
		Pizza modifiedPizza = new Pizza(pizzaId, syotettyNimi, pHinta, pSaatavuus);
		PizzaDAO modifiedPizzadao = new PizzaDAO();
		
		try {
			modifiedPizzadao.modifyPizza(modifiedPizza);
		} catch (SQLException e) {
			System.out.println("Sovelluksessa tapahtui virhe "+ e.getMessage());
			e.printStackTrace();
		}
	
		response.sendRedirect("ListaaPizzat");		
		
	}

}
