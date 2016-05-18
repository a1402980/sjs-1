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
import pizzicato.model.Tilaus;
import pizzicato.model.dao.AsiakasDAO;

/**Tallennetaan ostoskori-sivulla valitut juomat sessioon ja näytetään tilaajatietolomake**/
@WebServlet("/TilaajanTiedot")
public class TilaajanTiedotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Tilaus tilaus = (Tilaus) session.getAttribute("tilaus");
		
		//jos tilausta ei ole, luodaan uusi tilaus
		if(tilaus ==null) {
			tilaus=new Tilaus();
			session.setAttribute("tilaus", tilaus);
		}

		
		//talletetaan valitut juomat sessioon
		String cola = request.getParameter("cola");
		if (cola != null && cola.trim().length() != 0) {
			tilaus.setCola("true");
		} else {
			tilaus.setCola("false");
		}
		String fanta = request.getParameter("fanta");
		if (fanta != null && fanta.trim().length() != 0) {
			tilaus.setFanta("true");
		} else {
			tilaus.setFanta("false");
		}
		String sprite = request.getParameter("sprite");
		if (sprite != null && sprite.trim().length() != 0) {
			tilaus.setSprite("true");
		} else {
			tilaus.setSprite("false");
		}
		
		//näytetään tilaaja-lomake
		String jsp = "/view/tilaajan_tiedot.jsp";
		Kayttaja kayttaja = (Kayttaja) session.getAttribute("kayttaja");
		if (kayttaja != null){
			AsiakasDAO asiakasdao = new AsiakasDAO();
			Asiakas asiakas = asiakasdao.findCertainAsiakas(kayttaja);
			session.setAttribute("asiakas", asiakas);
		} 
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

	/**Pyydetään errors-lista asiakkaan syöttämistä tiedoista. Jos lista on tyhjä, päästetään
	 * käyttäjä tilausyhteenvetoon. Muutoin lähetetään virheilmoitukset jsp:lle ja pidetään käyttäjä sivulla. **/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		
		Map<String, String> errors = validate(request);
		
		if (!errors.isEmpty()) {
			System.out.println(errors);	
			String jsp = "/view/tilaajan_tiedot.jsp";
			request.setAttribute("errors", errors);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
			dispatcher.forward(request, response);
			
			return;
		} else {
			response.sendRedirect("TilausYhteenveto");
		}	
		
	}
	
	/**Haetaan tilaajan syöttämät tiedot ja validoidaan ne. 
	 * Lisätään tiedot sessioon ja mahdolliset virheet errors-listaan.**/
	public static Map<String, String> validate(HttpServletRequest request) {
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);
		HttpSession session = request.getSession(true);
		Tilaus tilaus = (Tilaus) session.getAttribute("tilaus");
		
		// Asiakkaan tietojen validointi	
		
		String enimi = request.getParameter("etunimi");
		if (enimi == null || enimi.trim().length() < 2 || enimi == "") {
			errors.put("enimi", "Etunimi on pakollinen kenttä.");
		}else{
			 tilaus.setaEtunimi(enimi);
		}
		if (enimi.trim().length() > 50 ){
			errors.put("enimi", "Nimen on oltava lyhyempi kuin 50 merkkiä.");
		}else{
			tilaus.setaEtunimi(enimi);
		}
		if (enimi.matches("^[a-z åäöA-ZÅÄÖ-]*$")){
			tilaus.setaEtunimi(enimi);
		}else{
			errors.put("enimi", "Nimessä ei saa olla numeroita tai erikoismerkkejä.");
		}

		String snimi = request.getParameter("sukunimi");
		if (snimi == null || snimi.trim().length() < 2 || snimi == "") {
			errors.put("snimi", " Sukunimi on pakollinen kenttä.");
		}else{
			 tilaus.setaSukunimi(snimi);}
		if (snimi.trim().length() > 50 ){
			errors.put("snimi", " Nimen on oltava lyhyempi kuin 50 merkkiä.");
		}else{
			tilaus.setaSukunimi(snimi);}
		if (snimi.matches("^[a-z åäöA-ZÅÄÖ-]*$")){
			tilaus.setaSukunimi(snimi);
		}else{
			errors.put("snimi", " Nimessä ei saa olla numeroita tai erikoismerkkejä.");
		}
				
		String puh = request.getParameter("puh");
		if (puh == null || puh.trim().length() < 7 || puh == "") {
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
		if (osoite.trim() == null || osoite.trim().length() < 2 || osoite == "") {
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

		if (strPNro == null || strPNro.trim().length() != 5 || strPNro == "" ||  strPNro == "" && !strPNro.matches("^[0-9]*$")) {
			errors.put("postinro", "Postinumeron on oltava 5 numeroa.");
		}else{
			int pNro = new Integer(strPNro);
			tilaus.setaPostiNro(pNro);
		}
								
		String pTmp = request.getParameter("postitmp");
		if (pTmp.trim() == null || pTmp.trim().length() < 2 || pTmp == "") {
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
