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

		/** 
		 * Avaa yhteyden tietokantaan. Hakee pizza-olion tiedot.
		 *  Lisää pizza-olion tiedot tietokantaan. Sulkee yhteyden. 
		 *  @param pizza pizza-olio**/
		public void addPizza(Pizza pizza) throws SQLException {
			Connection connection = null;
			PreparedStatement stmtInsert = null;
		
			try {
				connection = getConnection();
				String sqlInsert = "INSERT INTO pizza(p_nimi, p_hinta, p_saatavuus) VALUES (?, ?, ?)";
				stmtInsert = connection.prepareStatement(sqlInsert);
				stmtInsert.setString(1, pizza.getpNimi());
				stmtInsert.setDouble(2, pizza.getpHinta());
				stmtInsert.setString(3, pizza.getpSaatavuus());
				//lisää täyte ArrayList myöhemmin

				stmtInsert.executeUpdate();
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
			try {
				conn = getConnection();
				String sqlUpdate = "UPDATE pizza SET p_nimi='"+pizza.getpNimi()+"', p_hinta="+pizza.getpHinta()+", p_saatavuus='"+pizza.getpSaatavuus()+"' WHERE pizza_id="+pizza.getPizzaId();
				stmt = conn.prepareStatement(sqlUpdate);
				//lisää täyte ArrayList myöhemmin
			
				stmt.executeUpdate();
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}finally {
				close(stmt,conn);
			}
		}
		/** 
		 * Avaa tietokantayhteyden. Alustaa pizzat-listan, johon voi sijoittaa pizza-olion.
		 * Hakee tietokannasta pizzan tiedot ja luo niistä uuden pizza-olion, joka lisätään
		 * pizzat-listaan. Sulkee tietokantayhteyden. 
		 * Palauttaa lopuksi koko pizzat-listan.
		 * Hakee kaikki listalla olevat pizzat tietokannasta 
		 * @param Pizza Pizza-olio
		 * @return Pizzat-lista
		 * **/
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
		/** 
		 * Avaa tietokantayhteyden. 
		 * Hakee yhden pizzan tiedot tietokannasta kyseisen pizzan id:n perusteella 
		 * Sulkee tietokantayhteyden. Palauttaa lopuksi pizzan tiedot.
		 * @param pizzaId id tulee muokkaapizzaservletistä, tietokannan automaattisesti luoma id
		 * @return Pizza -olio
		 * **/
		public Pizza findCertainPizza(int pizzaId) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			Pizza pizza=null;
			try {
				conn = getConnection();
				String sqlSelect ="SELECT pizza_id, p_nimi, p_hinta, p_saatavuus FROM pizza WHERE pizza_id='"+pizzaId+"';";
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
				//ArrayList<Tayte> taytteet = new ArrayList<Tayte>();			
					if (pSaatavuus.equalsIgnoreCase("true")){
						pSaatavuus = "kyllä";
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
		 * @param pizzaId id tulee poistapizzaservletistä, tietokannan automaattisesti luoma id
		 * **/
		public Pizza deletePizza(int pizzaId){
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				conn = getConnection();
				String sqlDelete ="DELETE FROM pizza WHERE pizza_id=' "+pizzaId+"';";
				stmt=conn.prepareStatement(sqlDelete);
				rs=stmt.executeQuery(sqlDelete);
			} catch(SQLException e) {
				throw new RuntimeException(e);
			} finally {
				close(rs,stmt,conn);
			}
			return null;
			
		}

	

}
