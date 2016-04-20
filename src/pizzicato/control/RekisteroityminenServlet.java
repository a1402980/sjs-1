package pizzicato.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzicato.model.Kayttaja;
import pizzicato.model.Pizza;
import pizzicato.model.Tayte;
import pizzicato.model.dao.KayttajaDAO;
import pizzicato.model.dao.PizzaDAO;
import pizzicato.model.dao.TayteDAO;

/**
 * Servlet implementation class RekisteroityminenServlet
 */
@WebServlet("/Rekisteroityminen")
public class RekisteroityminenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp ="/view/rekisteroityminen.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String> errors = validate(request);
		Kayttaja kayttaja = (Kayttaja) request.getAttribute("kayttaja");	
		
		if (!errors.isEmpty()) {
			System.out.println(errors);
			response.sendRedirect("Rekisteroityminen");
		} else {
			KayttajaDAO kayttajadao = new KayttajaDAO();
			kayttajadao.create(kayttaja);

			response.sendRedirect("Etusivu#pizzamenu");
		}
			
	}

	public static Map<String, String> validate(HttpServletRequest request) {
		Map<String, String> errors = new HashMap<String, String>();
		Kayttaja kayttaja = new Kayttaja();
	
	
		String username = request.getParameter("kayttajatunnus");
		if (username == null || username.trim().length() < 2 ) {
			errors.put("nimi", " Nimen on oltava vähintään 2 merkkiä pitkä.");
		}else{
			kayttaja.setUsername(username);}
		if (username.trim().length() > 15 ){
			errors.put("nimi", " Nimen on oltava lyhyempi kuin 15 merkkiä.");
		}else{
			kayttaja.setUsername(username);}
		if (username.matches("^[a-zA-Z0-9]*$")){
			errors.put("nimi", " Nimessä ei saa olla erikoismerkkejä.");	
		}else{
			kayttaja.setUsername(username);
		}
		
		String password = request.getParameter("salasana");
		
		if (password == null || password.trim().length() < 8 ) {
			errors.put("salasana", " Salasanan on oltava vähintään 2 merkkiä pitkä.");
		}else{
			kayttaja.setPassword(password);
		}
		request.setAttribute("kayttaja", kayttaja);
		return errors;
	}
}
	
