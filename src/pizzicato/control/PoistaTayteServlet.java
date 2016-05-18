package pizzicato.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pizzicato.model.dao.TayteDAO;


@WebServlet("/PoistaTayte")
public class PoistaTayteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Hakee selaimelta täyte idn
     * Poistaa täytteen tietokannasta täytedaon avulla
     * Ohjaa selaimen listaataytteet servletiin
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("tayte_id");
		int tayteId = new Integer(strId);
		TayteDAO taytedao = new TayteDAO();
		taytedao.deleteTayte(tayteId);
		
		response.sendRedirect("ListaaTaytteet");
	}


}
