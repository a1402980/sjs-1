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
import pizzicato.model.Tilaus;
import pizzicato.model.dao.PizzaDAO;
import pizzicato.model.dao.PizzaTilausDAO;
import pizzicato.model.dao.TilausDAO;


@WebServlet("/ListaaTilauksetOmistaja")
public class ListaaTilauksetOmistaja extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TilausDAO tilausdao = new TilausDAO();
		//PizzaDAO pizzadao = new PizzaDAO();
		//PizzaTilausDAO pizzatildao = new PizzaTilausDAO();
		
		
		ArrayList<Tilaus> tilaukset = tilausdao.omistajaFindAll();
		
		
		request.setAttribute("tilaukset", tilaukset);		
			
		String jsp = "/view/tilaukset_omistajalle.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
		
	}
	
	
}
