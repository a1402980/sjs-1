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

import pizzicato.model.Tayte;
import pizzicato.model.dao.TayteDAO;


@WebServlet("/MuokkaaTayte")
public class MuokkaaTayteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp ="/view/muokkaa_tayte.jsp";
		
		String idString = request.getParameter("tayte_id");
		System.out.println(idString);
		int tayteId = Integer.parseInt(idString);
		System.out.println(tayteId);
		Tayte tayte = new TayteDAO().findCertainTayte(tayteId);
		System.out.println(tayte);
		request.setAttribute("tayte", tayte);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Map<String, String> errors = LisaaTayteServlet.validate(request);
		Tayte tayte = (Tayte) request.getAttribute("tayte");*/
		Map<String, String> errors = validate(request);
		Tayte tayte = (Tayte) request.getAttribute("tayte");
		
		/*String strId = request.getParameter("tayte_id");
		int tayteId = new Integer(strId);	
		tayte.setTayteId(tayteId);*/
		
		if (!errors.isEmpty()) {
			System.out.println(errors);
			response.sendRedirect("MuokkaaTayte");
		} else {
			TayteDAO taytedao = new TayteDAO();
			try {
				taytedao.modifyTayte(tayte);
			} catch (SQLException e) {
				System.out.println("Sovelluksessa tapahtui virhe "+ e.getMessage());
				e.printStackTrace();
			}
			response.sendRedirect("ListaaTaytteet");
			}
		}	
		
		public static Map<String, String> validate(HttpServletRequest request) {
			HashMap<String, String> errors = new HashMap<String, String>();
			Tayte tayte = new Tayte();
			
			String idString = request.getParameter("tayte_id");
			int id = new Integer(idString);
			tayte.setTayteId(id);
			
			//nimi
			String syotettyNimi = request.getParameter("nimi");
			if (syotettyNimi == null || syotettyNimi.trim().length() < 2 ) {
				errors.put("nimi", "Nimen pit‰‰ olla v‰hint‰‰n 2 merkki‰ pitk‰.");
			}
			tayte.settNimi(syotettyNimi);
			
			//hinta
			String syotettyHinta = request.getParameter("hinta");
			syotettyHinta = syotettyHinta.replace(",", ".");
			Double tHinta = new Double(syotettyHinta);
			if (tHinta == null || tHinta < 0.0 || tHinta > 50) {
				errors.put("tHinta", "Hinnan pit‰‰ olla v‰lilt‰ 0-50");
			} else {
				tayte.settHinta(tHinta);
			}
			
			request.setAttribute("errors", errors);
			request.setAttribute("tayte", tayte);
			
			return errors;
		
	}

}
