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
	private Pizza readPizza(ResultSet rs) {
		try {
			int pizzaId=rs.getInt("tayteid");
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
		while(rs.next()) {
			tayte = readPizza(rs);
		}
	} catch(SQLException e) {
		throw new RuntimeException(e);
	} finally {
		close(rs,stmt,conn);
	}
	
	return pizza;
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
