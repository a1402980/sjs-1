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

import pizzicato.model.Asiakas;
import pizzicato.model.Kayttaja;
import pizzicato.model.dao.KayttajaDAO;

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
		String jsp ="/view/rekisteroityminen.jsp";
		
		Map<String, String> errors = validate(request);
		Kayttaja kayttaja = (Kayttaja) request.getAttribute("kayttaja");	
		
		if (!errors.isEmpty()) {
			System.out.println(errors);
			
			RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
			dispather.forward(request, response);
			
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
		Asiakas asiakas = new Asiakas();
	
	
		String username = request.getParameter("kayttajatunnus");
		if (username == null || username.trim().length() < 2 ) {
			errors.put("nimi", " Nimen on oltava v�hint��n 2 merkki� pitk�.");
		}else{
			kayttaja.setUsername(username);}
		if (username.trim().length() > 15 ){
			errors.put("nimi", " Nimen on oltava lyhyempi kuin 15 merkki�.");
		}else{
			kayttaja.setUsername(username);}
		if (username.matches("^[a-zA-Z0-9]*$")){
			kayttaja.setUsername(username);	
		}else{
			errors.put("nimi", " Nimess� ei saa olla erikoismerkkej�.");
		}
		
		String password = request.getParameter("salasana");
		
		if (password == null || password.trim().length() < 8 ) {
			errors.put("salasana", " Salasanan on oltava v�hint��n 8 merkki� pitk�.");
		}else{
			kayttaja.setPassword(password);
		}
		String userrole = "asiakas";
		kayttaja.setUserRole(userrole);
		request.setAttribute("kayttaja", kayttaja);
		
		// Asiakkaan tietojen validointi	
		
				String enimi = request.getParameter("etunimi");
				if (enimi == null || enimi.trim().length() < 2 ) {
					errors.put("enimi", " Nimen on oltava vähintään 2 merkkiä pitkä.");
				}else{
					 asiakas.setEtuNimi(enimi);}
				if (enimi.trim().length() > 30 ){
					errors.put("enimi", " Nimen on oltava lyhyempi kuin 30 merkkiä.");
				}else{
					asiakas.setEtuNimi(enimi);}
				if (enimi.matches("^[a-zåäöA-ZÅÄÖ\b-]*$")){
					asiakas.setEtuNimi(enimi);
				}else{
					errors.put("enimi", " Nimessä ei saa olla numeroita tai erikoismerkkejä.");
				}
				
				String snimi = request.getParameter("sukunimi");
				if (snimi == null || snimi.trim().length() < 2 ) {
					errors.put("snimi", " Nimen on oltava vähintään 2 merkkiä pitkä.");
				}else{
					 asiakas.setSukuNimi(snimi);}
				if (snimi.trim().length() > 30 ){
					errors.put("snimi", " Nimen on oltava lyhyempi kuin 30 merkkiä.");
				}else{
					asiakas.setSukuNimi(snimi);}
				if (snimi.matches("^[a-zåäöA-ZÅÄÖ\b-]*$")){
					asiakas.setSukuNimi(snimi);
				}else{
					errors.put("snimi", " Nimessä ei saa olla numeroita tai erikoismerkkejä.");
				}
				
				String puh = request.getParameter("puh");
				if (puh == null || puh.trim().length() < 7 ) {
					errors.put("puh", "Puhelinnumeron on oltava vähintään 7 merkkiä");
				}else{
					asiakas.setPuh(puh);}
				if (puh.trim().length() > 16 ){
					errors.put("puh", " Puhelinnumeron oltava on oltava lyhyempi kuin 16 merkkiä.");
				}else{
					asiakas.setPuh(puh);}
				if (puh.matches("^[0-9+-\b]*$")){
					asiakas.setPuh(puh);
				}else{
					errors.put("puh", " Puhelinnumerossa ei saa olla kirjaimia tai erikoismerkkejä.");
				}
				
				String osoite = request.getParameter("osoite");
				if (osoite == null || osoite.trim().length() < 3 ) {
					errors.put("osoite", " Osoitteen on oltava vähintään 3 merkkiä pitkä.");
				}else{
					 asiakas.setOsoite(osoite);}
				if (osoite.trim().length() > 30 ){
					errors.put("osoite", " Osoitteen on oltava lyhyempi kuin 30 merkkiä.");
				}else{
					asiakas.setOsoite(osoite);}
				if (osoite.matches("^[a-zåäöA-ZÅÄÖ0-9]*$")){
					asiakas.setOsoite(osoite);
				}else{
					errors.put("osoite", "Osoitteessa ei saa olla erikoismerkkejä.");
				}
				
				String strPNro = request.getParameter("postinro");
				int pNro = new Integer(strPNro);
				if (strPNro == null || strPNro.trim().length() < 5 ) {
					errors.put("postinro", "Postinumeron on oltava 5 numeroa");
				}else{
					asiakas.setPostiNro(pNro);}
				if (strPNro.trim().length() > 5 ){
					errors.put("postinro", " Postinumeron oltava on oltava 5 numeroa.");
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
				if (pTmp.matches("^[a-zåäöA-ZÅÄÖ-]*$")){
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
					errors.put("sposti", "Sähköpostissa ei saa olla erikoismerkkejä.");
				}
				
				request.setAttribute("asiakas", asiakas);
		
		return errors;
	}
}
	
