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
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/view/muokkaa_pizza.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNimi = request.getParameter("nimi");
		String strPHinta = request.getParameter("hinta");
		Double pHinta = new Double(strPHinta);
		String strPSaatavuus = request.getParameter("saatavuus");
		boolean pSaatavuus;
		if(strPSaatavuus.equalsIgnoreCase("kyllä")){
			pSaatavuus = true;
		}else{
			pSaatavuus = false;
		}
		
		Pizza pizza = new Pizza(pNimi, pHinta, pSaatavuus);
		PizzaDAO pizzadao = new PizzaDAO();
		try {
			pizzadao.modifyPizza(pizza);
		} catch (SQLException e) {
			System.out.println("Sovelluksessa tapahtui virhe "+ e.getMessage());
			e.printStackTrace();
		}
		response.sendRedirect("ListaaPizzat");
		
		/*Pizza pizza = new Pizza(pNimi, pHinta, pSaatavuus);
		PizzaDAO pizzadao = new PizzaDAO();
		pizzadao.modifyPizza(pizza);*/
	}

}
