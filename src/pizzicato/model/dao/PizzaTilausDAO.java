package pizzicato.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public void addPizzaTilaus(PizzaTilaus pizzatil) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtInsert = null;		
		try {
			connection = getConnection();
			String sqlInsert = "INSERT INTO pizzatilaus(tilaus_id, pizza_id, lkm) VALUES ("+pizzatil.getTilausId()+","+pizzatil.getPizzaId()+","+pizzatil.getLkm()+");";
			stmtInsert = connection.prepareStatement(sqlInsert);		
			stmtInsert.executeUpdate();
					            
		}catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtInsert, connection); 
		}		
	}
	
	

}
