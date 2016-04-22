package pizzicato.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pizzicato.model.Tilaus; 
import pizzicato.model.PizzaTilaus; 
import pizzicato.model.dao.TilausDAO; 
import pizzicato.model.dao.PizzaTilausDAO; 



@WebServlet("/ostoskori")
public class OstoskoriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/view/pizzicato_ostoskori.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jsp = "/view/pizzicato_ostoskori.jsp";
		
		TilausDAO tilausdao = new TilausDAO();
		PizzaTilausDAO pizzatilausdao = new PizzaTilausDAO();
		Tilaus tilaus;
		PizzaTilaus pizzatilaus;
		
		//avataan uusi sessio
		HttpSession session = request.getSession(true);
		tilaus = (Tilaus) session.getAttribute("tilaus");
		
		//jos tilausta ei ole, luodaan uusi tilaus
		if(tilaus ==null) {
			tilaus=new Tilaus();
			session.setAttribute("tilaus", tilaus);
		} /*else {
			tilaus.addPizzaTilaus(pizzatilaus);
			try {
				pizzatilausdao.addPizzaTilaus(pizzatilaus);
			} catch (Exception e) {
				System.out.println("Sovelluksessa tapahtui virhe "+ e.getMessage());
				e.printStackTrace();
			}
			
			
		}*/
		
		
		
	}

}
