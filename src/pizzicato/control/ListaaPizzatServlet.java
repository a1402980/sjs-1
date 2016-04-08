package pizzicato.control;

import javax.servlet.RequestDispatcher;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzicato.model.Pizza;
import pizzicato.model.Tayte;
import pizzicato.model.dao.PizzaDAO;


@WebServlet("/ListaaPizzat")
public class ListaaPizzatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**ListaaPizzatServletin doGet metodi hakee PizzaDAON metodilla kaikki pizzat tietokannasta Arraylistaan ja luo käyttäjän näkymän selaimella**/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PizzaDAO pizzadao = new PizzaDAO();
		ArrayList<Pizza> pizzat = pizzadao.findAll();
		ArrayList<Tayte> taytteet = pizzadao.findAllTaytteet(pizzaId);
		
		request.setAttribute("pizzat", pizzat);		
			
		String jsp = "/view/pizzalista_omistajalle.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

	
}
