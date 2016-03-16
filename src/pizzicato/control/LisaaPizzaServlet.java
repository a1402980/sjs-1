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
		String pNimi = request.getParameter("nimi");
		String strPHinta = request.getParameter("hinta");
		strPHinta = strPHinta.replace(",", ".");
		Double pHinta = new Double(strPHinta);
		String pSaatavuus = request.getParameter("valikoimassa");
		
		Pizza pizza = new Pizza(pNimi, pHinta, pSaatavuus);
		//*System.out.println(pizza);
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
