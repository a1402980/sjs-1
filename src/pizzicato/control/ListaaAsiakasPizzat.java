package pizzicato.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzicato.model.Pizza;
import pizzicato.model.dao.PizzaDAO;


@WebServlet("/ListaaAsiakasPizzat")
public class ListaaAsiakasPizzat extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	/**
	 * Hakee pizzadaon avulla pizzat pizzataulusta
	 * Asettaa pizzalistan attribuutiksi
	 * Välittää selaimella pizzalistan ja ohjaa jsphen
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PizzaDAO pizzadao = new PizzaDAO();
		ArrayList<Pizza> pizzat = pizzadao.findAll();	
		
		request.setAttribute("pizzat", pizzat);		
			
		String jsp = "/view/pizzalista_asiakkaalle.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

	
	

}
