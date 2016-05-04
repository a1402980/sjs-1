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
import pizzicato.model.dao.KayttajaDAO;
import pizzicato.model.dao.PizzaDAO;


@WebServlet("/TilaajanTiedot")
public class TilaajanTiedotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Ei valmis!
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/view/tilaajan_tiedot.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		request.getAttribute("errors");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PizzaDAO pizzadao = new PizzaDAO();
		Tilaus tilaus;
		PizzaTilaus pizzatilaus;
		Map<String, String> errors = validate(request);
		
		
		HttpSession session = request.getSession(true);
		tilaus = (Tilaus) session.getAttribute("tilaus");
		
		if (!errors.isEmpty()) {
			System.out.println(errors);
			
			response.sendRedirect("TilaajanTiedot");
		} else {
			
			response.sendRedirect("tilausvahvistus");
		}	
		
	}
	
	//Validointi kaipaa muokkausta, kopioin sen suoraan rekisteröitymisestä
	//Esim käyttäjän validointia ei tarvita	
	public static Map<String, String> validate(HttpServletRequest request) {
		Map<String, String> errors = new HashMap<String, String>();
		Kayttaja kayttaja = new Kayttaja();
		Asiakas asiakas = new Asiakas();
	
	
		String username = request.getParameter("kayttajatunnus");
		if (username == null || username.trim().length() < 2 ) {
			errors.put("nimi", " Nimen on oltava vï¿½hintï¿½ï¿½n 2 merkkiï¿½ pitkï¿½.");
		}else{
			kayttaja.setUsername(username);}
		if (username.trim().length() > 30 ){
			errors.put("nimi", " Nimen on oltava lyhyempi kuin 30 merkkiï¿½.");
		}else{
			kayttaja.setUsername(username);}
		if (username.matches("^[a-zA-Z0-9]*$")){
			kayttaja.setUsername(username);	
		}else{
			errors.put("nimi", " Nimessï¿½ ei saa olla erikoismerkkejï¿½.");
		}
		
		String password = request.getParameter("salasana");
		
		if (password == null || password.trim().length() < 8 ) {
			errors.put("salasana", " Salasanan on oltava vï¿½hintï¿½ï¿½n 8 merkkiï¿½ pitkï¿½.");
		}else{
			kayttaja.setPassword(password);
		}
		String userrole = "asiakas";
		kayttaja.setUserRole(userrole);
		request.setAttribute("kayttaja", kayttaja);
		
		// Asiakkaan tietojen validointi	
		
		String enimi = request.getParameter("etunimi");
		if (enimi == null || enimi.trim().length() < 2 ) {
			errors.put("enimi", " Nimen on oltava vÃ¤hintÃ¤Ã¤n 2 merkkiÃ¤ pitkÃ¤.");
		}else{
			 asiakas.setEtuNimi(enimi);}
		if (enimi.trim().length() > 30 ){
			errors.put("enimi", " Nimen on oltava lyhyempi kuin 30 merkkiÃ¤.");
		}else{
			asiakas.setEtuNimi(enimi);}
		if (enimi.matches("^[a-zÃ¥Ã¤Ã¶A-ZÃ…Ã„Ã–-]*$")){
			asiakas.setEtuNimi(enimi);
		}else{
			errors.put("enimi", " NimessÃ¤ ei saa olla numeroita tai erikoismerkkejÃ¤.");
		}
				
		String snimi = request.getParameter("sukunimi");
		if (snimi == null || snimi.trim().length() < 2 ) {
			errors.put("snimi", " Nimen on oltava vÃ¤hintÃ¤Ã¤n 2 merkkiÃ¤ pitkÃ¤.");
		}else{
			 asiakas.setSukuNimi(snimi);}
		if (snimi.trim().length() > 30 ){
			errors.put("snimi", " Nimen on oltava lyhyempi kuin 30 merkkiÃ¤.");
		}else{
			asiakas.setSukuNimi(snimi);}
		if (snimi.matches("^[a-zÃ¥Ã¤Ã¶A-ZÃ…Ã„Ã–-]*$")){
			asiakas.setSukuNimi(snimi);
		}else{
			errors.put("snimi", " NimessÃ¤ ei saa olla numeroita tai erikoismerkkejÃ¤.");
		}
				
		String puh = request.getParameter("puh");
		if (puh == null || puh.trim().length() < 7 ) {
			errors.put("puh", "Puhelinnumeron on oltava vÃ¤hintÃ¤Ã¤n 7 merkkiÃ¤");
		}else{
			asiakas.setPuh(puh);}
		if (puh.trim().length() > 16 ){
			errors.put("puh", " Puhelinnumeron oltava on oltava lyhyempi kuin 16 merkkiÃ¤.");
		}else{
			asiakas.setPuh(puh);}
		if (puh.matches("^[0-9]*$")){
			asiakas.setPuh(puh);
		}else{
			errors.put("puh", " Puhelinnumerossa ei saa olla kirjaimia tai erikoismerkkejÃ¤.");
		}
				
		String osoite = request.getParameter("osoite");
		if (osoite == null || osoite.trim().length() < 2 ) {
			errors.put("osoite", " Osoitteen on oltava vÃ¤hintÃ¤Ã¤n 2 merkkiÃ¤ pitkÃ¤.");
		}else{
			 asiakas.setOsoite(osoite);}
		if (osoite.trim().length() > 30 ){
			errors.put("osoite", " Osoitteen on oltava lyhyempi kuin 30 merkkiÃ¤.");
		}else{
			asiakas.setOsoite(osoite);}
		if (osoite.matches("^[a-z Ã¥Ã¤Ã¶A-ZÃ…Ã„Ã–0-9-]*$")){
			asiakas.setOsoite(osoite);
		}else{
			errors.put("osoite", "Osoitteessa ei saa olla erikoismerkkejÃ¤.");
		}
				
		String strPNro = request.getParameter("postinro");
		int pNro = new Integer(strPNro);
		if (strPNro == null || strPNro.trim().length() != 5 ) {
			errors.put("postinro", "Postinumeron on oltava 5 numeroa");
		}else{
			asiakas.setPostiNro(pNro);}
		if (strPNro.matches("^[0-9]*$")){
			asiakas.setPostiNro(pNro);
		}else{
			errors.put("postinro", " Postinumerossa ei saa olla kirjaimia tai erikoismerkkejä.");
		}
				
				
		String pTmp = request.getParameter("postitmp");
		if (pTmp == null || pTmp.trim().length() < 2 ) {
			errors.put("postitmp", " Postitoimipaikan on oltava vähintään 2 merkkiä pitkä.");
		}else{
			 asiakas.setPostiTmp(pTmp);}
		if (pTmp.trim().length() > 15 ){
			errors.put("postitmp", " Postitoimipaikan on oltava lyhyempi kuin 15 merkkiä.");
		}else{
			asiakas.setPostiTmp(pTmp);}
		if (pTmp.matches("^[a-z åäöA-ZÅÄÖ-]*$")){
			asiakas.setPostiTmp(pTmp);
		}else{
			errors.put("postitmp", "Postitoimipaikassa ei saa olla erikoismerkkejä.");
		}
				
		String sPosti = request.getParameter("sposti");
		if (sPosti == null || sPosti.trim().length() < 6 ) {
			errors.put("sposti", " Sähköpostin on oltava vähintään 6 merkkiä pitkä.");
		}else{
			 asiakas.setsPosti(sPosti);}
		if (sPosti.trim().length() > 50 ){
			errors.put("sposti", " Sähköpostin on oltava lyhyempi kuin 50 merkkiä.");
		}else{
			asiakas.setsPosti(sPosti);}
		if (sPosti.matches("^[a-zA-Z0-9@.]*$")){
			asiakas.setsPosti(sPosti);
		}else{
			errors.put("sposti", "SÃ¤hkÃ¶postissa ei saa olla erikoismerkkejÃ¤.");
		}
				
				request.setAttribute("asiakas", asiakas);
		
		return errors;
	}

}
