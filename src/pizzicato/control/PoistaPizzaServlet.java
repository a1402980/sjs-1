package pizzicato.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pizzicato.model.dao.PizzaDAO;


@WebServlet("/PoistaPizza")
public class PoistaPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**PoistaPizzaServletin doGet metodi hakee poistettavan pizzan pizzaIdn selaimelta ja l�hett�� tiedon PizzaDAOon (jonka metodi poistaa pizzan tietokannasta). **/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("pizza_id");
		int pizzaId = new Integer(strId);
		PizzaDAO pizzadao = new PizzaDAO();
		pizzadao.deletePizza(pizzaId);
	}

}
