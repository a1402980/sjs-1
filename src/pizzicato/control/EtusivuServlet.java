package pizzicato.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pizzicato.model.Kayttaja;
import pizzicato.model.Pizza;
import pizzicato.model.Tayte;
import pizzicato.model.dao.KayttajaDAO;
import pizzicato.model.dao.PizzaDAO;


@WebServlet("/Etusivu")
public class EtusivuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EtusivuServlet() {
        super();
    }

    /**Luodaan uusi PizzaDAO, käytetään PizzaDAOn findAllAsiakas -metodia ja laitetaan tiedot Arraylistiin. 
	requestiin annetaan pizzat - attribuutille arvo ja annetaan tiedot Pizzicato.jsp:lle.
   **/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PizzaDAO pizzadao = new PizzaDAO();
		ArrayList<Pizza> pizzat = pizzadao.findAllAsiakas();	
		
		request.setAttribute("pizzat", pizzat);	
		String jsp = "/view/Pizzicato.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

    /**Pizzicato.jsp:ltä saadaan requestilla tiedot käyttäjänimestä ja salasanasta.
     Tarkastetaan, löytyvätkö käyttäjätunnus ja salasana KayttajaDAOsta. Jos kirjautuminen onnistuu,
     luodaan sessio, jos ei niin näytetään etusivu. Tarkastetaan, onko käyttäjä omistaja, jolloin
     omistaja siirtyy omalle sivulleen.  **/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/view/Pizzicato.jsp";
				
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	    Kayttaja kayttaja = new KayttajaDAO().findByUsername(username);
	       if (kayttaja == null || !kayttaja.getUsername().equals(username) || password == null || !kayttaja.getPassword().equals(password) )
	       {
	    	   PizzaDAO pizzadao = new PizzaDAO();
	   			ArrayList<Pizza> pizzat = pizzadao.findAllAsiakas();	
	   			request.setAttribute("pizzat", pizzat);		
	    	   request.setAttribute("message", "Kirjautuminen epäonnistui!");
	         RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
	  		  dispather.forward(request, response);
	       } else {
	    	   HttpSession session = request.getSession();
		       session.setAttribute("kayttaja", kayttaja);
		    	   if(kayttaja.getUserRole().equals("omistaja"))
		    			   {
		      
		       response.sendRedirect("roolinvalitseminen");
	       }
		    	   else{
		    		   response.sendRedirect("Etusivu#pizzamenu"); 
		    	   }
		}
	       
	       
	}



	}