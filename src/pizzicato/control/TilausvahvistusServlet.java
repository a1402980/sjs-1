package pizzicato.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pizzicato.model.PizzaTilaus;
import pizzicato.model.Tilaus;
import pizzicato.model.dao.PizzaDAO;
import pizzicato.model.dao.PizzaTilausDAO;
import pizzicato.model.dao.TilausDAO;

@WebServlet("/tilausvahvistus")
public class TilausvahvistusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TilausvahvistusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/view/tilausvahvistus.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TilausDAO tilausdao = new TilausDAO();
		PizzaTilausDAO pizzatilausdao = new PizzaTilausDAO();
		PizzaDAO pizzadao = new PizzaDAO();
		Tilaus tilaus;
		PizzaTilaus pizzatilaus;
		
		HttpSession session = request.getSession(true);
		tilaus = (Tilaus) session.getAttribute("tilaus");
		try {
			tilausdao.addTilaus(tilaus);
		} catch (Exception e) {
			System.out.println("Sovelluksessa tapahtui virhe "+ e.getMessage());
			e.printStackTrace();
		}
		
		
		
	}

}
