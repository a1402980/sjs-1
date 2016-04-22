package pizzicato.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pizzicato.model.Tilaus; 


@WebServlet("/ostoskori")
public class OstoskoriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jsp = "/view/pizzicato_ostoskori.jsp";
		
		/*Tilaus tilaus;
		//avataan uusi sessio
		HttpSession session = request.getSession(true);
		
		if(tilaus !=null) {
			tilaus=new Tilaus();
		}
		
		*/
		
	}

}
