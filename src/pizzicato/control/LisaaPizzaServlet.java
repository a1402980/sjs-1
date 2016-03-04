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


@WebServlet("/LisaaPizzaServlet")
public class LisaaPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp ="/view/Lisaa_tai_muokkaa_pizza.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p_nimi = request.getParameter("p_nimi");
		String strP_hinta = request.getParameter("p_hinta");
		Double p_hinta = new Double(strP_hinta);
		
		Pizza pizza = new Pizza();
		PizzaDAO pizzadao = new PizzaDAO();
		try {
			pizzadao.addPizza(pizza);
		} catch (SQLException e) {
			System.out.println("Sovelluksessa tapahtui virhe "+ e.getMessage());
			e.printStackTrace();
		}
		response.sendRedirect("ListaaPizzatServlet");
		//testi2
	}

}
