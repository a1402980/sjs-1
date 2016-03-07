package pizzicato.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pizzicato.model.Pizza;
import pizzicato.model.Tayte;
import pizzicato.model.dao.DataAccessObject;

public class PizzaDAO extends DataAccessObject {

		
		public void addPizza(Pizza pizza) throws SQLException {
			Connection connection = null;
			PreparedStatement stmtInsert = null;
		
			try {
				connection = getConnection();
				String sqlInsert = "INSERT INTO pizza(p_nimi, p_hinta, p_saatavuus) VALUES (?, ?, ?)";
				stmtInsert = connection.prepareStatement(sqlInsert);
				stmtInsert.setString(1, pizza.getpNimi());
				stmtInsert.setDouble(2, pizza.getpHinta());
				stmtInsert.setBoolean(3, pizza.ispSaatavuus());
				//lisää täyte ArrayList myöhemmin

				stmtInsert.executeUpdate();
			}catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				close(stmtInsert, connection); 
			}
			}
		
		public void modifyPizza(Pizza pizza) throws SQLException {
			Connection conn = null;
			PreparedStatement stmt = null;
			try {
				conn = getConnection();
				String sqlUpdate = "UPDATE pizza SET(p_nimi, p_hinta, p_saatavuus) VALUES (?, ?, ?)";
				stmt = conn.prepareStatement(sqlUpdate);
				stmt.setString(1, pizza.getpNimi());
				stmt.setDouble(2, pizza.getpHinta());
				stmt.setBoolean(3, pizza.ispSaatavuus());
				//lisää täyte ArrayList myöhemmin
				stmt.executeUpdate();
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public ArrayList<Pizza> findAll() {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			ArrayList<Pizza> pizzat = new ArrayList<Pizza>();
			Pizza pizza=null;
			try {
				conn = getConnection();
				String sqlSelect ="SELECT pizza_id, p_nimi, p_hinta, p_saatavuus FROM pizza;";
				stmt=conn.prepareStatement(sqlSelect);
				rs=stmt.executeQuery(sqlSelect);
				while(rs.next()) {
					pizza = readPizza(rs);
					pizzat.add(pizza);
				}
			} catch(SQLException e) {
				throw new RuntimeException(e);
			} finally {
				close(rs,stmt,conn);
			}
			
			return pizzat;
		}
		
		public Pizza findCertainPizza(int pizza_id) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			Pizza pizza=null;
			try {
				conn = getConnection();
				String sqlSelect ="SELECT pizza_id, p_nimi, p_hinta, p_saatavuus FROM pizza WHERE pizza_id='?';";
				stmt=conn.prepareStatement(sqlSelect);
				rs=stmt.executeQuery(sqlSelect);
				while(rs.next()) {
					pizza = readPizza(rs);
				}
			} catch(SQLException e) {
				throw new RuntimeException(e);
			} finally {
				close(rs,stmt,conn);
			}
			
			return pizza;
		}
		private Pizza readPizza(ResultSet rs) {
			try {
				int id=rs.getInt("pizza_id");
				String nimi=rs.getString("p_nimi");
				double hinta=rs.getDouble("p_hinta");
				boolean saatavuus=rs.getBoolean("p_saatavuus");
				ArrayList<Tayte> taytteet = new ArrayList<Tayte>();
				return new Pizza(id, nimi, hinta, saatavuus);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

	

}
