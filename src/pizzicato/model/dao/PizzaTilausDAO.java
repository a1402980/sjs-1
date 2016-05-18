package pizzicato.model.dao;


import java.sql.ResultSet;
import java.sql.SQLException;

import pizzicato.model.Pizza;
import pizzicato.model.PizzaTilaus;


public class PizzaTilausDAO extends DataAccessObject {
	
	/** 
	 * Avaa tietokantayhteyden.
	 * Lukee tietokannasta pizzatilauksen tiedot tilausdaon kuskifindall metodia varten. 
	 * Sulkee tietokantayhteyden.
	 * **/
	public PizzaTilaus readPizzaTilausKuski(ResultSet rs) {
		try {
			int pizzatilId=rs.getInt("pizzatil_id");
			int tilausId=rs.getInt("tilaus_id");
			int pizzaId=rs.getInt("pizza_id");
			String pNimi=rs.getString("p_nimi");
			Pizza pizza = new Pizza(pizzaId, pNimi);
			return new PizzaTilaus(pizzatilId, tilausId, pizza);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/** 
	 * Avaa tietokantayhteyden.
	 * Lukee tietokannasta pizzatilauksen tiedot tilausdaon kokkifindall metodia  varten. 
	 * Sulkee tietokantayhteyden.
	 * **/
	public PizzaTilaus readPizzaTilausKokki(ResultSet rs) {
		try {
			int pizzatilId=rs.getInt("pizzatil_id");
			int tilausId=rs.getInt("tilaus_id");
			int pizzaId=rs.getInt("pizza_id");
			String oregano=rs.getString("oregano");
			String valkosipuli=rs.getString("valkosipuli");
			//String pNimi=rs.getString("p_nimi");			
			//Pizza pizza = new Pizza(pizzaId, pNimi);
			return new PizzaTilaus(pizzatilId, tilausId, oregano, valkosipuli, pizzaId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/** 
	 * Avaa tietokantayhteyden.
	 * Lukee tietokannasta pizzatilauksen tiedot tilausdaon omistajafindall metodia varten. 
	 * Sulkee tietokantayhteyden.
	 * **/
	public PizzaTilaus readPizzaTilausOmistaja(ResultSet rs) {
		try {
			int pizzatilId=rs.getInt("pizzatil_id");
			int tilausId=rs.getInt("tilaus_id");
			int pizzaId=rs.getInt("pizza_id");
			String oregano=rs.getString("oregano");
			String valkosipuli=rs.getString("valkosipuli");
			String pNimi=rs.getString("p_nimi");
			String pSaatavuus=rs.getString("p_saatavuus");
			double pHinta=rs.getDouble("p_hinta");
			Pizza pizza = new Pizza(pizzaId, pNimi, pHinta, pSaatavuus);
			return new PizzaTilaus(pizzatilId, tilausId, pizza, oregano, valkosipuli);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
