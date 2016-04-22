package pizzicato.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import pizzicato.model.PizzaTilaus;
import pizzicato.model.Tilaus;

public class PizzaTilausDAO extends DataAccessObject {
	
	public PizzaTilaus readPizzaTilaus(ResultSet rs) {
		try {
			int tilausId=rs.getInt("tilaus_id");
			int pizzaId=rs.getInt("pizza_id");
			int lkm=rs.getInt("lkm");
			return new PizzaTilaus(tilausId, pizzaId, lkm);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
