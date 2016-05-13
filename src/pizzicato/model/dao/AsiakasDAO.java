package pizzicato.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import pizzicato.model.Asiakas;
import pizzicato.model.Kayttaja;
import pizzicato.model.Tayte;
import pizzicato.model.Tilaus;

public class AsiakasDAO extends DataAccessObject {
	
	private Asiakas readAsiakas(ResultSet rs) {
		try {
			int asiakasId=rs.getInt("asiakas_id");
			String etuNimi=rs.getString("etunimi");
			String sukuNimi=rs.getString("sukunimi");
			String puh=rs.getString("puh");
			String osoite=rs.getString("osoite");
			int postiNro=rs.getInt("posti_nro");
			String postiTmp=rs.getString("posti_tmp");
			String sPosti=rs.getString("s_posti");
			return new Asiakas(asiakasId, etuNimi, sukuNimi, puh, osoite, postiNro, postiTmp, sPosti);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/*public void createAsiakas(Asiakas asiakas) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtInsert = null;
		
		try {
			connection = getConnection();
			String sqlInsert = "INSERT INTO asiakas(asiakas_id, etunimi, sukunimi, puh, osoite, posti_nro, posti_tmp, s_posti) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";		
			stmtInsert = connection.prepareStatement(sqlInsert);
						
			stmtInsert.setInt(1, asiakas.getAsiakasId());
			stmtInsert.setString(2, asiakas.getEtuNimi());
			stmtInsert.setString(3, asiakas.getSukuNimi());
			stmtInsert.setString(4, asiakas.getPuh());
			stmtInsert.setString(5, asiakas.getOsoite());
			stmtInsert.setInt(6, asiakas.getPostiNro());
			stmtInsert.setString(7, asiakas.getPostiTmp());
			stmtInsert.setString(8, asiakas.getsPosti());
			stmtInsert.setInt(9,  );
		
			stmtInsert.executeUpdate();
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtInsert, connection); 
		}
		
	}
	*/
	  public Asiakas findCertainAsiakas(Kayttaja kayttaja){
		    PreparedStatement statement = null;
		    Connection connection = null;
		    ResultSet rs = null;
		    Asiakas asiakas = null;
		    try {
			    connection = getConnection();
			    String sqlSelect = "SELECT * FROM asiakas WHERE kayttaja_id = ?";
			    statement = connection.prepareStatement(sqlSelect);		   
			    int id = kayttaja.getId();
			    statement.setInt(1, id);		   
			    rs = statement.executeQuery();
			   
			    while(rs.next()) {
					asiakas = readAsiakas(rs);
					
				}
				
		    } catch (Exception e) {
		    	throw new RuntimeException(e);
		    } finally {
		        close(statement, connection);
			}
		    
		    return asiakas;
		  }
	
	public void modifyAsiakas(Asiakas asiakas) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			String sqlUpdate =  "UPDATE asiakas SET etunimi='"+asiakas.getEtuNimi()+"', "
					+ "sukunimi='"+asiakas.getSukuNimi()+"', puh='"+asiakas.getPuh()+"', osoite='"+asiakas.getOsoite()+"', posti_nro='"+asiakas.getPostiNro()+"', "
							+ "posti_tmp='"+asiakas.getPostiTmp()+"', s_posti='"+asiakas.getsPosti()+"' WHERE asiakas_id="+asiakas.getAsiakasId()+";";
			stmt = conn.prepareStatement(sqlUpdate);
					
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			close(stmt,conn);
		}
	}
	
	public Asiakas deleteAsiakas(int asiakasId){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			String sqlDelete ="DELETE FROM asiakas WHERE asiakas_id="+asiakasId+";";
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
