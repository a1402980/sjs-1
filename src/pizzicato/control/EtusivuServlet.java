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
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PizzaDAO pizzadao = new PizzaDAO();
		ArrayList<Pizza> pizzat = pizzadao.findAllAsiakas();	
		
		request.setAttribute("pizzat", pizzat);		
		
		String jsp = "/view/Pizzicato.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		String jsp = "/view/Pizzicato.jsp";
		
		String username = request.getParameter("username");
	    Kayttaja kayttaja = new KayttajaDAO().findByUsername(username);
	       if (kayttaja == null)
	       {
	    	   request.setAttribute("message", "Kirjautuminen epäonnistui");
	          RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
	  		  dispather.forward(request, response);
	  		  response.sendRedirect("Etusivu");
	          return;
	       }
	       if(!kayttaja.getUsername().equals(username))
	       {
	    	   request.setAttribute("message", "Kirjautuminen epäonnistui");
		       RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		       dispather.forward(request, response);
		       return;
	    	   
	  
	       }
	       
	       String password = request.getParameter("password");
	       if (password == null || !kayttaja.getPassword().equals(password))
	       {
	          request.setAttribute("message", "Kirjautuminen epäonnistui");
	          RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
	  		  dispather.forward(request, response);
	          return;
	       }
	       HttpSession session = request.getSession();
	       String kayttaja_rooli = kayttaja.getUserRole();
	       session.setAttribute("rooli", kayttaja_rooli);
	      
	       response.sendRedirect("ListaaPizzat");
	       
	}



	}