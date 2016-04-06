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
		ArrayList<Pizza> pizzat = pizzadao.findAll();	
		
		request.setAttribute("pizzat", pizzat);		
		
		String jsp = "/view/Pizzicato.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("jippii");
		String jsp = "/view/Pizzicato.jsp";
		
		String username = request.getParameter("username");
	    Kayttaja kayttaja = new KayttajaDAO().findByUsername(username);
	       if (username == null)
	       {
	          request.setAttribute("message", "Authentication failed.");
	        // jsp.forward(request, response);
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
