package pizzicato.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import pizzicato.model.Pizza;
import pizzicato.model.PizzaTilaus;
import pizzicato.model.Tayte;
import pizzicato.model.Tilaus;

public class TilausDAO extends DataAccessObject{
	
	private Tilaus readTilauksetKokki(ResultSet rs) {
		try {
			int tilausId=rs.getInt("tilaus_id");
			String status=rs.getString("status");
			Date tilAjankohta=rs.getTimestamp("til_ajankohta");
			System.out.println(tilAjankohta);
			return new Tilaus(tilausId, status, tilAjankohta);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Tilaus readTilauksetKuski(ResultSet rs) {
		try {
			int tilausId=rs.getInt("tilaus_id");
			String status=rs.getString("status");
			Date tilAjankohta=rs.getTimestamp("til_ajankohta");
			double yhtHinta=rs.getDouble("yht_hinta");
			String aSukunimi=rs.getString("a_sukunimi");
			String aPuh=rs.getString("a_puh");
			String aOsoite=rs.getString("a_osoite");
			int aPostiNro=rs.getInt("a_posti_nro");
			String aPostiTmp=rs.getString("a_posti_tmp");
			String cola=rs.getString("cola");
			String fanta=rs.getString("fanta");
			String sprite=rs.getString("sprite");
			return new Tilaus(tilausId, status, tilAjankohta, aSukunimi, aPuh, aOsoite, aPostiNro, aPostiTmp, cola, fanta, sprite, yhtHinta);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Tilaus readTilauksetOmistaja(ResultSet rs) {
		try {
			int tilausId=rs.getInt("tilaus_id");
			String status=rs.getString("status");
			Date tilAjankohta=rs.getTimestamp("til_ajankohta");
			double yhtHinta=rs.getDouble("yht_hinta");
			String cola=rs.getString("cola");
			String fanta=rs.getString("fanta");
			String sprite=rs.getString("sprite");
			return new Tilaus(tilausId, status, tilAjankohta, cola, fanta, sprite, yhtHinta);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void addTilaus(Tilaus tilaus) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtInsert = null;
		PreparedStatement stmtSelect = null;
		ResultSet rs = null;
		int lastId;
		try {
			connection = getConnection();
		    connection.setAutoCommit(false);
			String sqlInsert = "INSERT INTO tilaus(a_etunimi, a_sukunimi, a_puh, a_osoite, a_posti_nro, a_posti_tmp, cola, fanta, sprite, yht_hinta) VALUES ('"+tilaus.getaEtunimi()+"','"+tilaus.getaSukunimi()+"','"+tilaus.getaPuh()+"','"+tilaus.getaOsoite()+"',"+tilaus.getaPostiNro()+",'"+tilaus.getaPostiTmp()+"', '"+tilaus.getCola()+"', '"+tilaus.getFanta()+"','"+tilaus.getSprite()+"', "+tilaus.getYhtHinta()+");";
			String sqlSelect = "SELECT LAST_INSERT_ID();";
			
			stmtInsert = connection.prepareStatement(sqlInsert);
			stmtSelect = connection.prepareStatement(sqlSelect);		
			stmtInsert.executeUpdate();
			rs = stmtSelect.executeQuery();
			
			while(rs.next()){
				lastId = rs.getInt("last_insert_id()");
				tilaus.setTilausId(lastId);
			}
			
			for (int i=0; i < tilaus.getPizzaTilLkm(); i++){ 
				String sqlInsert2 = "INSERT INTO pizzatilaus(tilaus_id, pizza_id, oregano, valkosipuli) VALUES (?, ?, ?, ?);";
				stmtInsert = connection.prepareStatement(sqlInsert2);
				stmtInsert.setInt(1, tilaus.getTilausId());
				stmtInsert.setInt(2, tilaus.getPizzaTilaus(i).getPizza().getPizzaId());
				stmtInsert.setString(3, tilaus.getPizzaTilaus(i).getOregano());
				stmtInsert.setString(4, tilaus.getPizzaTilaus(i).getValkosipuli());
				stmtInsert.executeUpdate();
			    connection.commit();
			}
					            
		}catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtInsert, connection); 
		}
		
	}
	
	public Tilaus deleteTilaus(int tilausId){
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sqlDelete ="DELETE FROM tilaus WHERE tilaus_id= ?;";
			String sqlDelete2="DELETE FROM pizzatilaus WHERE tilaus_id= ?;";
			stmt=conn.prepareStatement(sqlDelete);
			stmt2=conn.prepareStatement(sqlDelete2);
			stmt.setInt(1, tilausId);
			stmt2.setInt(1, tilausId);
			rs=stmt2.executeQuery();
			rs=stmt.executeQuery();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs,stmt,conn);
		}
		return null;
		
	}
	
		
	public ArrayList<Tilaus> omistajaFindAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		ResultSet rs = null;
		ArrayList<Tilaus> tilaukset = new ArrayList<Tilaus>();
		Tilaus tilaus=null;
		//ArrayList<PizzaTilaus> pizzatilaukset = new ArrayList<PizzaTilaus>();
		PizzaTilausDAO pizzatildao = new PizzaTilausDAO();
		PizzaTilaus pizzatil;
		int edellinenTilausId=0;
		int nykyinenTilausId=0;
		try {
			conn = getConnection();
			String sqlSelect ="SELECT t.tilaus_id, status, til_ajankohta, pizzatil_id, pt.pizza_id, p_nimi, oregano, valkosipuli, p_saatavuus, p_hinta, cola, fanta, sprite, yht_hinta FROM tilaus t JOIN pizzatilaus pt ON t.tilaus_id = pt.tilaus_id INNER JOIN pizza p ON p.pizza_id = pt.pizza_id ORDER BY til_ajankohta;";
			
			stmt=conn.prepareStatement(sqlSelect);
			
			rs=stmt.executeQuery(sqlSelect);
			
			while(rs.next()) {
				nykyinenTilausId = rs.getInt("tilaus_id");
				if (nykyinenTilausId != edellinenTilausId) {
					tilaus = readTilauksetOmistaja(rs);
					tilaukset.add(tilaus);
					edellinenTilausId = nykyinenTilausId;
				}
				pizzatil = pizzatildao.readPizzaTilausOmistaja(rs);
				tilaus.addPizzaTilaus(pizzatil);
			}

		
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close2(rs,stmt,stmt2,conn);
		}
		
		return tilaukset;
	}
	
	
	public ArrayList<Tilaus> kuskiFindAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		ResultSet rs = null;
		ArrayList<Tilaus> tilaukset = new ArrayList<Tilaus>();
		Tilaus tilaus=null;
		//ArrayList<PizzaTilaus> pizzatilaukset = new ArrayList<PizzaTilaus>();
		PizzaTilausDAO pizzatildao = new PizzaTilausDAO();
		PizzaTilaus pizzatil;
		int edellinenTilausId=0;
		int nykyinenTilausId=0;
		try {
			conn = getConnection();
			String sqlSelect ="SELECT t.tilaus_id, a_sukunimi, a_puh, a_osoite, a_posti_nro, a_posti_tmp, status, til_ajankohta, pizzatil_id, pt.pizza_id, p_nimi, cola, fanta, sprite, yht_hinta FROM tilaus t INNER JOIN pizzatilaus pt ON t.tilaus_id = pt.tilaus_id INNER JOIN pizza p ON p.pizza_id = pt.pizza_id WHERE status= 'Paistettu' ORDER BY til_ajankohta;";
			
			stmt=conn.prepareStatement(sqlSelect);
			
			rs=stmt.executeQuery(sqlSelect);
			
			while(rs.next()) {
				nykyinenTilausId = rs.getInt("tilaus_id");
				if (nykyinenTilausId != edellinenTilausId) {
					tilaus = readTilauksetKuski(rs);
					tilaukset.add(tilaus);
					edellinenTilausId = nykyinenTilausId;
				}
				pizzatil = pizzatildao.readPizzaTilausKuski(rs);
				tilaus.addPizzaTilaus(pizzatil);
			}

		
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close2(rs,stmt,stmt2,conn);
		}
		
		return tilaukset;
	}
	
	public ArrayList<Tilaus> kokkiFindAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		ResultSet rs = null;
		ArrayList<Tilaus> tilaukset = new ArrayList<Tilaus>();
		Tilaus tilaus=null;
		//ArrayList<PizzaTilaus> pizzatilaukset = new ArrayList<PizzaTilaus>();
		PizzaTilausDAO pizzatildao = new PizzaTilausDAO();
		PizzaTilaus pizzatil;
		int edellinenTilausId=0;
		int nykyinenTilausId=0;
		try {
			conn = getConnection();
			String sqlSelect ="SELECT t.tilaus_id, status, til_ajankohta, pizzatil_id, pt.pizza_id, p_nimi, oregano, valkosipuli FROM tilaus t JOIN pizzatilaus pt ON t.tilaus_id = pt.tilaus_id INNER JOIN pizza p ON p.pizza_id = pt.pizza_id WHERE status= 'Odottaa' ORDER BY til_ajankohta;";
			
			stmt=conn.prepareStatement(sqlSelect);
			
			rs=stmt.executeQuery(sqlSelect);
			
			while(rs.next()) {
				nykyinenTilausId = rs.getInt("tilaus_id");
				if (nykyinenTilausId != edellinenTilausId) {
					tilaus = readTilauksetKokki(rs);
					tilaukset.add(tilaus);
					edellinenTilausId = nykyinenTilausId;
				}
				pizzatil = pizzatildao.readPizzaTilausKokki(rs);
				tilaus.addPizzaTilaus(pizzatil);
			}

		
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close2(rs,stmt,stmt2,conn);
		}
		
		return tilaukset;
	}
	
	public void modifyStatusKokki(int tilausId) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			String sqlUpdate =  "UPDATE tilaus SET status='Paistettu' WHERE tilaus_id="+tilausId+";";
			stmt = conn.prepareStatement(sqlUpdate);
					
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			close(stmt,conn);
		}
	}
	
	public void modifyStatusKuski(int tilausId) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			String sqlUpdate =  "UPDATE tilaus SET status='Toimitettu' WHERE tilaus_id="+tilausId+";";
			stmt = conn.prepareStatement(sqlUpdate);
					
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			close(stmt,conn);
		}
	}
	


}
