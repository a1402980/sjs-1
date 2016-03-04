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
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp ="/view/lisaa_pizza.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNimi = request.getParameter("nimi");
		String strPHinta = request.getParameter("hinta");
		Double pHinta = new Double(strPHinta);
		String strPSaatavuus = request.getParameter("saatavuus");
		boolean pSaatavuus = Boolean.valueOf("strPSaatavuus");
		
		Pizza pizza = new Pizza(pNimi, pHinta, pSaatavuus);
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
