package pizzicato.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pizzicato.model.Asiakas;
import pizzicato.model.VierasAsiakas;

public class VierasAsiakasDAO extends DataAccessObject {
	public void createVierasAsiakas(VierasAsiakas vieras) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtInsert = null;
		
		try {
			connection = getConnection();
			String sqlInsert = "INSERT INTO vieras_asiakas(etunimi, sukunimi, puh, osoite, posti_nro, posti_tmp, s_posti) VALUES (?, ?, ?, ?, ?, ?, ?);";		
			stmtInsert = connection.prepareStatement(sqlInsert);
						
			stmtInsert.setString(1, vieras.getEtuNimi());
			stmtInsert.setString(2, vieras.getSukuNimi());
			stmtInsert.setString(3, vieras.getPuh());
			stmtInsert.setString(4, vieras.getOsoite());
			stmtInsert.setInt(5, vieras.getPostiNro());
			stmtInsert.setString(6, vieras.getPostiTmp());
			stmtInsert.setString(7, vieras.getsPosti());
		
			stmtInsert.executeUpdate();
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtInsert, connection); 
		}
		
	}
	
	public void deleteAsiakas(int vierasId){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			String sqlDelete ="DELETE FROM vieras_asiakas WHERE vieras_id="+vierasId+";";
			stmt=conn.prepareStatement(sqlDelete);
			rs=stmt.executeQuery(sqlDelete);
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs,stmt,conn);
		}
		
	}
}
