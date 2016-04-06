package pizzicato.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pizzicato.model.Kayttaja;
import pizzicato.model.dao.KayttajaDAO;


@WebServlet("/TestiServlet")
public class TestiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/view/testi.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/view/testi.jsp";
		
		String username = request.getParameter("username");
	    Kayttaja kayttaja = new KayttajaDAO().findByUsername(username);
	       if (kayttaja == null)
	       {
	    	 
	          request.setAttribute("message", "Kirjautuminen epäonnistui");
	          RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
	  		  dispather.forward(request, response);
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
	          request.setAttribute("message", "Authentication failed.");
	          RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
	  		  dispather.forward(request, response);
	          return;
	       }

	       HttpSession session = request.getSession();
	       int kayttaja_id = kayttaja.getId();
	       session.setAttribute("kayttaja_id", kayttaja_id);
	       String url = "ListaaPizzat";
	       response.sendRedirect(url);
	}

}
