package pizzicato.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import pizzicato.model.Pizza;
import pizzicato.model.Tayte;
import pizzicato.model.dao.DataAccessObject;

public class PizzaDAO extends DataAccessObject {

		/** 
		 * Avaa yhteyden tietokantaan. Hakee pizza-olion tiedot.
		 *  Lis‰‰ pizza-olion tiedot tietokantaan. Sulkee yhteyden. 
		 *  @param pizza pizza-olio**/
		public void addPizza(Pizza pizza) throws SQLException {
			Connection connection = null;
			PreparedStatement stmtInsert = null;
			PreparedStatement stmtInsert2 = null;
			PreparedStatement stmtSelect = null;
			ResultSet rs = null;
			int lastId;
			try {
				connection = getConnection();
				String sqlInsert = "INSERT INTO pizza(p_nimi, p_hinta, p_saatavuus) VALUES (?, ?, ?);";
				String sqlSelect = "SELECT LAST_INSERT_ID();";
				
				stmtInsert = connection.prepareStatement(sqlInsert);
				stmtSelect = connection.prepareStatement(sqlSelect);
				
				
				stmtInsert.setString(1, pizza.getpNimi());
				stmtInsert.setDouble(2, pizza.getpHinta());
				stmtInsert.setString(3, pizza.getpSaatavuus());
				stmtInsert.executeUpdate();
				rs = stmtSelect.executeQuery();
				
				while(rs.next()){
					lastId = rs.getInt("last_insert_id()");
					pizza.setPizzaId(lastId);
				}
				for (int i=0; i < pizza.getTayteLkm(pizza.getPizzaId()); i++) {
				String sqlInsert2 = "INSERT INTO pizzatayte (pizza_id, tayte_id) VALUES ("+pizza.getPizzaId()+", "+pizza.getTayte(i).getTayteId()+");";
				stmtInsert2 = connection.prepareStatement(sqlInsert2);
				stmtInsert2.executeQuery(sqlInsert2);
				}
						            
			}catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				close(stmtInsert, connection); 
			}
			
		}
		
		
		/** 
		 * Avaa yhteyden tietokantaan. Hakee pizza-olion tiedot.
		 * Muokkaa haluttua pizzaa tietokannassa pizza Id:n perusteella. Sulkee yhteyden. 
		 * @param pizza pizza-olio**/
		public void modifyPizza(Pizza pizza) throws SQLException {
			Connection conn = null;
			PreparedStatement stmt = null;
			PreparedStatement stmt2 = null;
			ResultSet rs = null;
			try {
				conn = getConnection();
				
				String sqlUpdate = "UPDATE pizza SET p_nimi='"+pizza.getpNimi()+"', p_hinta="+pizza.getpHinta()+", p_saatavuus='"+pizza.getpSaatavuus()+"' WHERE pizza_id="+pizza.getPizzaId()+";";
				stmt = conn.prepareStatement(sqlUpdate);
				stmt.executeUpdate();
				String sqlDelete = "DELETE FROM pizzatayte WHERE pizza_id ="+pizza.getPizzaId()+";";
				stmt2=conn.prepareStatement(sqlDelete);
				rs=stmt.executeQuery(sqlDelete);
				for (int i=0; i < pizza.getTayteLkm(pizza.getPizzaId()); i++) {
					String sqlInsert = "INSERT INTO pizzatayte (pizza_id, tayte_id) VALUES ("+pizza.getPizzaId()+", "+pizza.getTayte(i).getTayteId()+");";
					stmt=conn.prepareStatement(sqlInsert);
					rs=stmt.executeQuery(sqlInsert);
					
				}
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}finally {
				close2(rs,stmt,stmt2,conn);
			}
		}
		/** 
		 * Avaa tietokantayhteyden. Alustaa pizzat-listan, johon voi sijoittaa pizza-olion.
		 * Hakee tietokannasta pizzan tiedot ja luo niist‰ uuden pizza-olion, joka lis‰t‰‰n
		 * pizzat-listaan. Sulkee tietokantayhteyden. 
		 * Palauttaa lopuksi koko pizzat-listan.
		 * Hakee kaikki listalla olevat pizzat tietokannasta 
		 * @param Pizza Pizza-olio
		 * @return Pizzat-lista
		 * **/
		public ArrayList<Pizza> findAll() {
			Connection conn = null;
			PreparedStatement stmt = null;
			PreparedStatement stmt2 = null;
			ResultSet rs = null;
			ArrayList<Pizza> pizzat = new ArrayList<Pizza>();
			Pizza pizza=null;
			//ArrayList<Tayte> taytteet = new ArrayList<Tayte>();
			TayteDAO taytedao = new TayteDAO();
			Tayte tayte;
			int edellinenPizzaId=0;
			int nykyinenPizzaId=0;
			try {
				conn = getConnection();
				String sqlSelect ="SELECT p.pizza_id, p_nimi, p_hinta, p_saatavuus, t.tayte_id, t_nimi, t_hinta FROM pizza p INNER JOIN pizzatayte pt ON p.pizza_id = pt.pizza_id INNER JOIN tayte t ON t.tayte_id = pt.tayte_id ORDER BY p_hinta;";
				
				stmt=conn.prepareStatement(sqlSelect);
				
				rs=stmt.executeQuery(sqlSelect);
				
				while(rs.next()) {
					nykyinenPizzaId = rs.getInt("pizza_id");
					if (nykyinenPizzaId != edellinenPizzaId) {
						pizza = readPizza(rs);
						pizzat.add(pizza);
						edellinenPizzaId = nykyinenPizzaId;
					}
					tayte = taytedao.readTayte(rs);
					pizza.addTayte(tayte);
				}

			
			} catch(SQLException e) {
				throw new RuntimeException(e);
			} finally {
				close2(rs,stmt,stmt2,conn);
			}
			
			return pizzat;
		}
		
		
		
		public ArrayList<Pizza> findAllAsiakas() {
			Connection conn = null;
			PreparedStatement stmt = null;
			PreparedStatement stmt2 = null;
			ResultSet rs = null;
			ArrayList<Pizza> pizzat = new ArrayList<Pizza>();
			Pizza pizza=null;
			//ArrayList<Tayte> taytteet = new ArrayList<Tayte>();
			TayteDAO taytedao = new TayteDAO();
			Tayte tayte;
			int edellinenPizzaId=0;
			int nykyinenPizzaId=0;
			try {
				conn = getConnection();
				String sqlSelect ="SELECT p.pizza_id, p_nimi, p_hinta, p_saatavuus, t.tayte_id, t_nimi, t_hinta FROM pizza p INNER JOIN pizzatayte pt ON p.pizza_id = pt.pizza_id INNER JOIN tayte t ON t.tayte_id = pt.tayte_id WHERE p_saatavuus = 'true' ORDER BY p_hinta;";
				
				stmt=conn.prepareStatement(sqlSelect);
				
				rs=stmt.executeQuery(sqlSelect);
				
				while(rs.next()) {
					nykyinenPizzaId = rs.getInt("pizza_id");
					if (nykyinenPizzaId != edellinenPizzaId) {
						pizza = readPizza(rs);
						pizzat.add(pizza);
						edellinenPizzaId = nykyinenPizzaId;
					}
					tayte = taytedao.readTayte(rs);
					pizza.addTayte(tayte);
				}

			
			} catch(SQLException e) {
				throw new RuntimeException(e);
			} finally {
				close2(rs,stmt,stmt2,conn);
			}
			
			return pizzat;
		}
		
		
		/** 
		 * Avaa tietokantayhteyden. 
		 * Hakee yhden pizzan tiedot tietokannasta kyseisen pizzan id:n perusteella 
		 * Sulkee tietokantayhteyden. Palauttaa lopuksi pizzan tiedot.
		 * @param pizzaId id tulee muokkaapizzaservletist‰, tietokannan automaattisesti luoma id
		 * @return Pizza -olio
		 * **/
		public Pizza findCertainPizza(int pizzaId) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			Pizza pizza=null;	
			TayteDAO taytedao = new TayteDAO();
			
			try {
				conn = getConnection();
				String sqlSelect ="SELECT p.pizza_id, p_nimi, p_hinta, p_saatavuus, t.tayte_id, t_nimi, t_hinta FROM pizza p INNER JOIN pizzatayte pt ON p.pizza_id = pt.pizza_id INNER JOIN tayte t ON t.tayte_id = pt.tayte_id WHERE pt.pizza_id="+pizzaId+";";
				stmt=conn.prepareStatement(sqlSelect);
				rs=stmt.executeQuery(sqlSelect);
				
				while(rs.next()) {
					pizza = readPizza(rs);
					System.out.println(pizza);
					while(rs.next()) {
						Tayte tayte = taytedao.readTayte(rs);
						pizza.addTayte(tayte);
					}
					
					System.out.println(pizza.getTaytteet());
				}
				System.out.println(pizza);
					
					
					//rs.first();
				
			} catch(SQLException e) {
				throw new RuntimeException(e);
			} finally {
				close(rs,stmt,conn);
			}
			
			return pizza;
		}
		/** 
		 * Avaa tietokantayhteyden.
		 * Lukee tietokannasta pizzalistan pizzat muita metodeita varten. 
		 * Sulkee tietokantayhteyden.
		 * **/
		private Pizza readPizza(ResultSet rs) {
			try {
				int pizzaId=rs.getInt("pizza_id");
				String pNimi=rs.getString("p_nimi");
				double pHinta=rs.getDouble("p_hinta");
				String pSaatavuus=rs.getString("p_saatavuus");						
					if (pSaatavuus.equalsIgnoreCase("true")){
						pSaatavuus = "kyll‰";
					}else if(pSaatavuus.equalsIgnoreCase("false")){
						pSaatavuus = "ei";
					}
				return new Pizza(pizzaId, pNimi, pHinta, pSaatavuus);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		/** 
		 * Avaa tietokantayhteyden.
		 * Poistaa tietokannasta yhden pizzan halutun pizzan id:n perusteella 
		 * Sulkee tietokantayhteyden.
		 * @param pizzaId id tulee poistapizzaservletist‰, tietokannan automaattisesti luoma id
		 * **/
		public Pizza deletePizza(int pizzaId){
			Connection conn = null;
			PreparedStatement stmt = null;
			PreparedStatement stmt2 = null;
			ResultSet rs = null;
			try {
				conn = getConnection();
				String sqlDelete ="DELETE FROM pizza WHERE pizza_id= ?;";
				String sqlDelete2="DELETE FROM pizzatayte WHERE pizza_id= ?;";
				stmt=conn.prepareStatement(sqlDelete);
				stmt2=conn.prepareStatement(sqlDelete2);
				stmt.setInt(1, pizzaId);
				stmt2.setInt(1, pizzaId);
				rs=stmt2.executeQuery();
				rs=stmt.executeQuery();
			} catch(SQLException e) {
				throw new RuntimeException(e);
			} finally {
				close(rs,stmt,conn);
			}
			return null;
			
		}
}
