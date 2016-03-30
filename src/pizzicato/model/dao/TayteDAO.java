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
	private Tayte readTayte(ResultSet rs) {
		try {
			int tayteId=rs.getInt("tayte_id");
			String tNimi=rs.getString("t_nimi");				
			return new Tayte(tayteId, tNimi);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

public Tayte findByName(String tNimi) {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	Tayte tayte=null;
	try {
		conn = getConnection();
		String sqlSelect ="SELECT tayte_id, t_nimi FROM tayte WHERE t_nimi=?;";		
		stmt=conn.prepareStatement(sqlSelect);
		stmt.setString(1, tayte.gettNimi());		
		rs=stmt.executeQuery(sqlSelect);
		if(rs.next()) {
			tayte = readTayte(rs);
		}
	} catch(SQLException e) {
		throw new RuntimeException(e);
	} finally {
		close(rs,stmt,conn);
	}
	
	return tayte;
}
	
	public void addTayte(Tayte tayte) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtInsert = null;
	
		try {
			connection = getConnection();
			String sqlInsert = "INSERT INTO tayte(t_nimi) VALUES (?)";
			stmtInsert = connection.prepareStatement(sqlInsert);
			stmtInsert.setString(1, tayte.gettNimi());			
			stmtInsert.executeUpdate();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtInsert, connection); 
		}
	}

}
