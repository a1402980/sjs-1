package pizzicato.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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
	static String idString;
	static int pizzaId = 0;
	static String syotettyNimi = null;
	static String syotettyHinta = null;
	static Double pHinta = 0.0;
	static String pSaatavuus = null;
	static Map<String, String> errors = new HashMap<String, String>();
    
   
	/**MuokkaaPizzaServletin doGet metodi hakee muokattavan pizzan tiedot tietokannasta PizzaDAOn metodilla ja luo käyttäjän näkymän selaimelle**/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/view/muokkaa_pizza.jsp";		
		
		String idString = request.getParameter("pizza_id");
		int pizzaId = new Integer(idString);
		PizzaDAO pizzadao = new PizzaDAO();
		Pizza pizza = pizzadao.findCertainPizza(pizzaId);
		request.setAttribute("pizza", pizza);
				
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
		
	}

	/**MuokkaaPizzaServletin doPost metodi hakee käyttäjän syöttämät tiedot selaimelta ja lähettää muokatt tiedot PizzaDAOon.**/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jsp = "/view/pizzalista_omistajalle.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);		
		
	      errors = validate(request);
	      if (!errors.isEmpty()) {
			  PizzaDAO modifiedPizzadao = new PizzaDAO();
			  Pizza pizza = (Pizza) request.getAttribute("pizza");
			  try {
					modifiedPizzadao.modifyPizza(pizza);
				} catch (SQLException e) {
					System.out.println("Sovelluksessa tapahtui virhe "+ e.getMessage());
					e.printStackTrace();
				}
		
	    	  response.sendRedirect("ListaaPizzat");
	         return;
	      }else{
	    	  response.sendRedirect("MuokkaaPizza");
	    	  System.out.println(errors);
	      }


	   }
	   
	   public static Map<String, String> validate(HttpServletRequest request)
	   {
	      Pizza pizza = new Pizza();
	      request.setAttribute("errors", errors);
	      request.setAttribute("pizza", pizza);

	      //id
	       idString = request.getParameter("pizza_id");
	       int pizzaId = new Integer(idString);
	       pizza.setPizzaId(pizzaId);	 
	      
	      // nimi
	      String syotettyNimi = request.getParameter("nimi");
	      if (syotettyNimi == null || syotettyNimi.trim().length() == 0)
	      {
	         errors.put("nimi", "Nimi vaaditaan.");
	      }
	      pizza.setpNimi(syotettyNimi);

	      // hinta
	      String syotettyHinta = request.getParameter("hinta");
	      syotettyHinta = syotettyHinta.replace(",", ".");
		  Double pHinta = new Double(syotettyHinta);
	      if (pHinta == null  || pHinta == 0 || pHinta > 100)
	      {
	    	 String strHinta = String.valueOf(pHinta);
	         errors.put("pHinta", "Hinta vaaditaan.");
	      }
	      pizza.setpHinta(pHinta);
	      
	      pSaatavuus = request.getParameter("valikoimassa");
	      if (pSaatavuus.equalsIgnoreCase("kyllä")){
	    	  pSaatavuus = "true";
	    	  pizza.setpSaatavuus(pSaatavuus);
	      }if (pSaatavuus.equalsIgnoreCase("ei")){
	    	  pSaatavuus = "false";
	    	  pizza.setpSaatavuus(pSaatavuus);
	      } else{
	    	  errors.put("pSaatavuus", "Saatavuus vaaditaan.");
	      }
	      return errors;
	   }
	
		
}
