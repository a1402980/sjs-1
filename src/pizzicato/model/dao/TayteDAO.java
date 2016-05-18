package pizzicato.model.dao;

import pizzicato.model.dao.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pizzicato.model.Pizza;
import pizzicato.model.Tayte;

public class TayteDAO extends DataAccessObject{
	
	/** 
	 * Avaa tietokantayhteyden.
	 * Lukee tietokannasta täytetaulun täytteet muita metodeita varten. 
	 * Sulkee tietokantayhteyden.
	 * **/
	public Tayte readTayte(ResultSet rs) {
		try {
			int tayteId=rs.getInt("tayte_id");
			String tNimi=rs.getString("t_nimi");
			double tHinta=rs.getDouble("t_hinta");
			return new Tayte(tayteId, tNimi, tHinta);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/** 
	 * Avaa tietokantayhteyden.
	 * Lukee tietokannasta täytetaulun täytteet pizzadaon findcertainpizzakokki metodia varten. 
	 * Sulkee tietokantayhteyden.
	 * **/
	public Tayte readTayteKokki(ResultSet rs){
		try {
			int tayteId=rs.getInt("tayte_id");
			String tNimi=rs.getString("t_nimi");
			return new Tayte(tayteId, tNimi);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/** 
	 * Avaa tietokantayhteyden. Alustaa täytteet-listan, johon voi sijoittaa täyte-olion.
	 * Hakee tietokannasta täytteen tiedot ja luo niistä uuden täyte-olion, joka lisätään
	 * täytteet-listaan. Sulkee tietokantayhteyden. 
	 * Palauttaa lopuksi koko täytteet-listan.
	 * Hakee kaikki listalla olevat täytteet tietokannasta 
	 * @param Täyte Täyte-olio
	 * @return Taytteet-lista
	 * **/
	public ArrayList<Tayte> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Tayte> taytteet = new ArrayList<Tayte>();
		Tayte tayte=null;
		try {
			conn = getConnection();
			String sqlSelect ="SELECT tayte_id, t_nimi, t_hinta FROM tayte ORDER BY t_hinta;";
			stmt=conn.prepareStatement(sqlSelect);
			rs=stmt.executeQuery(sqlSelect);
			while(rs.next()) {
				tayte = readTayte(rs);
				taytteet.add(tayte);
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs,stmt,conn);
		}
		
		return taytteet;
	}
	
	/** 
	 * Avaa tietokantayhteyden. 
	 * Hakee yhden täytteen tiedot tietokannasta kyseisen täytteen id:n perusteella 
	 * Sulkee tietokantayhteyden. Palauttaa lopuksi täytteen tiedot.
	 * @param tayteId id tulee muokkaatayteservletistä, tietokannan automaattisesti luoma id
	 * @return Tayte -olio
	 * **/
	public Tayte findCertainTayte(int tayteId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Tayte tayte=null;
		try {
			conn = getConnection();
			String sqlSelect ="SELECT tayte_id, t_nimi, t_hinta FROM tayte WHERE tayte_id='"+tayteId+"';";
			stmt=conn.prepareStatement(sqlSelect);
			rs=stmt.executeQuery(sqlSelect);
			while(rs.next()) {
				tayte = readTayte(rs);
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs,stmt,conn);
		}
		
		return tayte;
	}
	
	/** 
	 * Avaa yhteyden tietokantaan. Hakee täyte-olion tiedot.
	 * Muokkaa haluttua täytettä tietokannassa täyte Id:n perusteella. Sulkee yhteyden. 
	 * @param tayte täyte-olio**/
	public void modifyTayte(Tayte tayte) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			String sqlUpdate =  "UPDATE tayte SET t_nimi='"+tayte.gettNimi()+"', t_hinta="+tayte.gettHinta()+" WHERE tayte_id="+tayte.getTayteId()+";";
			stmt = conn.prepareStatement(sqlUpdate);
					
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			close(stmt,conn);
		}
	}
	
	/** 
	 * Avaa yhteyden tietokantaan. Hakee pizza-olion tiedot.
	 *  Lisää täyte-olion tiedot tietokantaan. Sulkee yhteyden. 
	 *  @param tayte täyte-olio**/
	public void addTayte(Tayte tayte) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtInsert = null;
	
		try {
			connection = getConnection();
			String sqlInsert = "INSERT INTO tayte(t_nimi, t_hinta) VALUES (?,?);";
			stmtInsert = connection.prepareStatement(sqlInsert);
			stmtInsert.setString(1, tayte.gettNimi());
			stmtInsert.setDouble(2, tayte.gettHinta());
			stmtInsert.executeUpdate();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtInsert, connection); 
		}
	}
	
	/** 
	 * Avaa tietokantayhteyden.
	 * Poistaa tietokannasta yhden täytteen halutun täytteen id:n perusteella 
	 * Sulkee tietokantayhteyden.
	 * @param tayteId id tulee poistatayteservletistä, tietokannan automaattisesti luoma id
	 * **/
	public Tayte deleteTayte(int tayteId){
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sqlDelete ="DELETE FROM tayte WHERE tayte_id="+tayteId+";";
			String sqlDelete2 ="DELETE FROM pizzatayte WHERE tayte_id="+tayteId+";";
			stmt=conn.prepareStatement(sqlDelete);
			stmt2=conn.prepareStatement(sqlDelete2);
			rs=stmt2.executeQuery(sqlDelete2);
			rs=stmt.executeQuery(sqlDelete);
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs,stmt,conn);
		}
		return null;
		
	}

}
