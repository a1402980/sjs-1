package pizzicato.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pizzicato.model.Asiakas;
import pizzicato.model.Pizza;
import pizzicato.model.PizzaTilaus;
import pizzicato.model.Tilaus;

public class PizzaTilausDAO extends DataAccessObject {
	
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
	
	public PizzaTilaus readPizzaTilausKokki(ResultSet rs) {
		try {
			int pizzatilId=rs.getInt("pizzatil_id");
			int tilausId=rs.getInt("tilaus_id");
			int pizzaId=rs.getInt("pizza_id");
			String oregano=rs.getString("oregano");
			String valkosipuli=rs.getString("valkosipuli");
			String pNimi=rs.getString("p_nimi");			
			Pizza pizza = new Pizza(pizzaId, pNimi);
			return new PizzaTilaus(pizzatilId, tilausId, pizza, oregano, valkosipuli);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
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
	
	
	
	public void addPizzaTilaus(PizzaTilaus pizzatil) throws SQLException {
		Connection conn = null;
		PreparedStatement stmtInsert = null;		
		try {
			conn = getConnection();
			String sqlInsert = "INSERT INTO pizzatilaus(tilaus_id, pizza_id, oregano, valkosipuli) VALUES ("+pizzatil.getTilausId()+","+pizzatil.getPizza().getPizzaId()+",'"+pizzatil.getOregano()+"','"+pizzatil.getValkosipuli()+"');";
			stmtInsert = conn.prepareStatement(sqlInsert);		
			stmtInsert.executeUpdate();
					            
		}catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtInsert, conn); 
		}		
	}
	
	public PizzaTilaus deletePizzafromTilaus(PizzaTilaus pizzatil){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sqlDelete ="DELETE FROM pizzatilaus WHERE pizzatil_id="+pizzatil.getPizzatil_id()+";";
			stmt=conn.prepareStatement(sqlDelete);
			rs=stmt.executeQuery();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs,stmt,conn);
		}
		return null;
		
	}
	
	
	
	
	
	
	
	
	/**public PizzaTilaus deletePizzafromTilaus(PizzaTilaus pizzatil){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sqlDelete ="DELETE FROM pizzatilaus WHERE tilaus_id="+pizzatil.getTilausId()+" AND pizza_id="+pizzatil.getPizza().getPizzaId()+";";
			stmt=conn.prepareStatement(sqlDelete);
			rs=stmt.executeQuery();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs,stmt,conn);
		}
		return null;
		
	}
	
	public void modifyPizzaLkm(PizzaTilaus pizzatil) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			String sqlUpdate =  "UPDATE pizzatilaus SET lkm="+pizzatil.getLkm()+" WHERE tilaus_id="+pizzatil.getTilausId()+" AND pizza_id="+pizzatil.getPizza().getPizzaId()+";";
			stmt = conn.prepareStatement(sqlUpdate);
					
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			close(stmt,conn);
		}
	}**/
	
}
