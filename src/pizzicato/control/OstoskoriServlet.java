package pizzicato.control;

import java.io.IOException;
import java.util.Enumeration;

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
		Enumeration<String> parametrienNimet = request.getParameterNames();
		System.out.println(parametrienNimet);
		String jsp = "/view/pizzicato_ostoskori.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Heippa! olen doPost ostoskori");
		Enumeration<String> parametrienNimet = request.getParameterNames();
		System.out.println(parametrienNimet);
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
		}
		//luodaan pizzatilaus-olio
		pizzatilaus= new PizzaTilaus();
		//lis‰t‰‰n pt-oliolle aseta lkm, pizzaId, tilausId
		String StrLkm = request.getParameter("pizzamaara");
		int lkm = Integer.parseInt(StrLkm);
		pizzatilaus.setLkm(lkm);
		String StrPizzaId = request.getParameter("pizza_id");
		int pizza_id = Integer.parseInt(StrPizzaId);
		pizzatilaus.setPizzaId(pizza_id);
		
		//tilaus-olioon lis‰t‰‰n(add) pizzatilausolio
		tilaus.addPizzaTilaus(pizzatilaus);
		
		response.sendRedirect("ostoskori");
	}
	
}
