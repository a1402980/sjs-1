package pizzicato.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pizzicato.model.Asiakas;
import pizzicato.model.Kayttaja;
import pizzicato.model.PizzaTilaus;
import pizzicato.model.Tilaus;
import pizzicato.model.dao.AsiakasDAO;
import pizzicato.model.dao.KayttajaDAO;
import pizzicato.model.dao.PizzaDAO;


@WebServlet("/TilaajanTiedot")
public class TilaajanTiedotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/view/tilaajan_tiedot.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession(true);
		Tilaus tilaus = (Tilaus) session.getAttribute("tilaus");
		Kayttaja kayttaja = (Kayttaja) session.getAttribute("kayttaja");
		
		System.out.println("tilaus ennen asiakkaan tietoja: "+tilaus);
		
		if (kayttaja != null){
			AsiakasDAO asiakasdao = new AsiakasDAO();
			Asiakas asiakas = asiakasdao.findCertainAsiakas(kayttaja);
			session.setAttribute("asiakas", asiakas);
			
			System.out.println("asiakkaan tiedot sessioon: "+asiakas);
		} 
		
		Map<String, String> errors = validate(request);
		
		if (!errors.isEmpty()) {
			System.out.println(errors);
			
			response.sendRedirect("TilaajanTiedot");
		} else {
			
			response.sendRedirect("tilausvahvistus");
		}	
		
	}
	
	public static Map<String, String> validate(HttpServletRequest request) {
		Map<String, String> errors = new HashMap<String, String>();
		Tilaus tilaus = new Tilaus();

		// Asiakkaan tietojen validointi	
		
		String enimi = request.getParameter("etunimi");
		if (enimi.trim() == null) {
			errors.put("enimi", "Etunimi on pakollinen kenttä.");
		}else{
			 tilaus.setaEtunimi(enimi);}
		if (enimi.trim().length() > 30 ){
			errors.put("enimi", "Nimen on oltava lyhyempi kuin 30 merkkiä.");
		}else{
			tilaus.setaEtunimi(enimi);}
		if (enimi.matches("^[a-z åäöA-ZÅÄÖ-]*$")){
			tilaus.setaEtunimi(enimi);
		}else{
			errors.put("enimi", "Nimessä ei saa olla numeroita tai erikoismerkkejä.");
		}
				
		String snimi = request.getParameter("sukunimi");
		if (snimi.trim() == null) {
			errors.put("snimi", " Sukunimi on pakollinen kenttä.");
		}else{
			 tilaus.setaSukunimi(snimi);}
		if (snimi.trim().length() > 30 ){
			errors.put("snimi", " Nimen on oltava lyhyempi kuin 30 merkkiä.");
		}else{
			tilaus.setaSukunimi(snimi);}
		if (snimi.matches("^[a-z åäöA-ZÅÄÖ-]*$")){
			tilaus.setaSukunimi(snimi);
		}else{
			errors.put("snimi", " Nimessä ei saa olla numeroita tai erikoismerkkejä.");
		}
				
		String puh = request.getParameter("puh");
		if (puh.trim() == null || puh.trim().length() < 7 ) {
			errors.put("puh", "Puhelinnumeron on oltava vähintään 7 merkkiä.");
		}else{
			tilaus.setaPuh(puh);}
		if (puh.trim().length() > 16 ){
			errors.put("puh", " Puhelinnumeron oltava on oltava lyhyempi kuin 16 merkkiä.");
		}else{
			tilaus.setaPuh(puh);}
		if (puh.matches("^[0-9]*$")){
			tilaus.setaPuh(puh);
		}else{
			errors.put("puh", " Puhelinnumerossa ei saa olla kirjaimia tai erikoismerkkejä.");
		}
				
		String osoite = request.getParameter("osoite");
		if (osoite.trim() == null || osoite.trim().length() < 2 ) {
			errors.put("osoite", " Osoitteen on oltava vähintän 2 merkkiä pitkä.");
		}else{
			 tilaus.setaOsoite(osoite);}
		if (osoite.trim().length() > 30 ){
			errors.put("osoite", " Osoitteen on oltava lyhyempi kuin 30 merkkiä.");
		}else{
			tilaus.setaOsoite(osoite);}
		if (osoite.matches("^[a-z åäöA-ZÅÄÖ–0-9-]*$")){
			tilaus.setaOsoite(osoite);
		}else{
			errors.put("osoite", "Osoitteessa ei saa olla erikoismerkkejä.");
		}
				
		String strPNro = request.getParameter("postinro");
		int pNro = new Integer(strPNro);
		if (strPNro == null || strPNro.trim().length() != 5 ) {
			errors.put("postinro", "Postinumeron on oltava 5 numeroa");
		}else{
			tilaus.setaPostiNro(pNro);}
		if (strPNro.matches("^[0-9]*$")){
			tilaus.setaPostiNro(pNro);
		}else{
			errors.put("postinro", " Postinumerossa ei saa olla kirjaimia tai erikoismerkkejä.");
		}
				
				
		String pTmp = request.getParameter("postitmp");
		if (pTmp.trim() == null || pTmp.trim().length() < 2 ) {
			errors.put("postitmp", " Postitoimipaikan on oltava vähintään 2 merkkiä pitkä.");
		}else{
			 tilaus.setaPostiTmp(pTmp);}
		if (pTmp.trim().length() > 15 ){
			errors.put("postitmp", " Postitoimipaikan on oltava lyhyempi kuin 15 merkkiä.");
		}else{
			tilaus.setaPostiTmp(pTmp);}
		if (pTmp.matches("^[a-z åäöA-ZÅÄÖ-]*$")){
			tilaus.setaPostiTmp(pTmp);
		}else{
			errors.put("postitmp", "Postitoimipaikassa ei saa olla erikoismerkkejä.");
		}
						
		return errors;
	}

}
