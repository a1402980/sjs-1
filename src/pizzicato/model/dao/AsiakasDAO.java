package pizzicato.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pizzicato.model.Asiakas;
import pizzicato.model.Tayte;

public class AsiakasDAO extends DataAccessObject {

	public void createAsiakas(Asiakas asiakas) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtInsert = null;
		
		try {
			connection = getConnection();
			String sqlInsert = "INSERT INTO asiakas(asiakas_id, etunimi, sukunimi, puh, osoite, posti_nro, posti_tmp, s_posti, kayttaja_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";		
			stmtInsert = connection.prepareStatement(sqlInsert);
						
			stmtInsert.setInt(1, asiakas.getAsiakasId());
			stmtInsert.setString(2, asiakas.getEtuNimi());
			stmtInsert.setString(3, asiakas.getSukuNimi());
			stmtInsert.setString(4, asiakas.getPuh());
			stmtInsert.setString(5, asiakas.getOsoite());
			stmtInsert.setInt(6, asiakas.getPostiNro());
			stmtInsert.setString(7, asiakas.getPostiTmp());
			stmtInsert.setString(8, asiakas.getsPosti());
			stmtInsert.setInt(9, asiakas.getKayttaja_id());
			stmtInsert.executeUpdate();
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtInsert, connection); 
		}
		
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
