package pizzicato.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import pizzicato.model.Asiakas;
import pizzicato.model.Kayttaja;
import pizzicato.model.Tayte;
import pizzicato.model.dao.DataAccessObject;

public class KayttajaDAO extends DataAccessObject {
   private static KayttajaDAO instance = new KayttajaDAO();

   public static KayttajaDAO getInstance() {
      return instance;
   }
   
   private Kayttaja read(ResultSet rs) throws SQLException
   {
	   int id = new Integer(rs.getInt("kayttaja_id"));
	   String username = rs.getString("username");
	   String password = rs.getString("password");
	   String userrole = rs.getString("userrole");
	   Kayttaja kayttaja = new Kayttaja();
	   kayttaja.setId(id);
	   kayttaja.setUsername(username);
	   kayttaja.setPassword(password);
	   kayttaja.setUserRole(userrole);
	   return kayttaja;
   }
   
   public Kayttaja find(int id) {
	   ResultSet rs = null;
	   PreparedStatement statement = null;
	   Connection connection = null;
	   try {
		   connection = getConnection();
		   String sql = "select * from kayttaja where kayttaja_id=?";
		   statement = connection.prepareStatement(sql);
		   statement.setInt(1, id);
		   rs = statement.executeQuery();
		   if (!rs.next()) {
			   return null;
		   }
		   return read(rs);
	   }
		catch (Exception e) {
		throw new RuntimeException(e);
	}
	finally {
		close(rs, statement, connection);
	}
   }
   
   public Kayttaja findByUsername (String username) {
	   ResultSet rs = null;
	   PreparedStatement statement = null;
	   Connection connection = null;
	   try {
		   connection = getConnection();
		   String sql = "select * from kayttaja where username=?";
		   statement = connection.prepareStatement(sql);
		   statement.setString(1, username);
		   rs = statement.executeQuery();
		   if (!rs.next())
	         {
	            return null;
	         }
	         return read(rs);
		
	} catch (Exception e) {
		throw new RuntimeException(e);
	}
	   finally {
	         close(rs, statement, connection);
	   }
   }

//N�it� metodeita ei t�ll� hetkell� tarvita

		public ArrayList<Kayttaja> findAll() {
			ArrayList<Kayttaja> kayttajat = new ArrayList<Kayttaja>();
			ResultSet rs = null;
			PreparedStatement statement = null;
			Connection connection = null;
			try {
	    	  connection = getConnection();
	          String sql = "select * from kayttaja order by id";
	          statement = connection.prepareStatement(sql);
	          rs = statement.executeQuery();
	          while (rs.next()) {
	        	  Kayttaja kayttaja = read(rs);
	              kayttajat.add(kayttaja);
	          }
	          return kayttajat;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	      finally {
	    	  close(rs, statement, connection);
	      }
   }
   
   
   public void update(Kayttaja kayttaja) {
	   PreparedStatement statement = null;
	   Connection connection = null;
	   try {
		   connection = getConnection();
	         String sql = "update kayttaja set " + "password=? where id=?";
	         statement = connection.prepareStatement(sql);
	         statement.setString(1, kayttaja.getPassword());
	         statement.setLong(2, kayttaja.getId());
	         statement.executeUpdate();
	   } catch (SQLException e) {
	         throw new RuntimeException(e);
	      } finally {
	         close(statement, connection);
	      }
   }
   
   public void create(Kayttaja kayttaja) {
	   PreparedStatement statement = null;
	   Connection connection = null;
	   try {
		   connection = getConnection();
		   String sql = "insert into kayttaja (username, password, userrole) values (?, ?, ?)";
		   statement = connection.prepareStatement(sql);
	       statement.setString(1, kayttaja.getUsername());
	       statement.setString(2, kayttaja.getPassword());
	       statement.setString(3, kayttaja.getUserRole());
	       statement.executeUpdate();
	} catch (Exception e) {
		throw new RuntimeException(e);
	} finally {
        close(statement, connection);
	}
   }
   
   public void createAsiakas(Kayttaja kayttaja, Asiakas asiakas) {
	    PreparedStatement statement = null;
	    Connection conn = null;
	    PreparedStatement stmtSelect = null;
	    ResultSet rs = null;
	    int lastId = 0;
	    try {
	    	conn = getConnection();
		    conn.setAutoCommit(false);
		    String sqlInsert = "insert into kayttaja (username, password, userrole) values (?, ?, ?)";
		    String sqlSelect = "SELECT LAST_INSERT_ID();";
		    statement = conn.prepareStatement(sqlInsert);
		    stmtSelect = conn.prepareStatement(sqlSelect);
		    statement.setString(1, kayttaja.getUsername());
		    statement.setString(2, kayttaja.getPassword());
		    statement.setString(3, kayttaja.getUserRole());
		    statement.executeUpdate();
		    rs = stmtSelect.executeQuery();
	   	  
		    while(rs.next()) {
			    lastId = rs.getInt("last_insert_id()");
				kayttaja.setId(lastId);
		    } 
	      
	      	String sqlInsert2 = "INSERT INTO asiakas(etunimi, sukunimi, puh, osoite, posti_nro, posti_tmp, s_posti, kayttaja_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";		
			statement = conn.prepareStatement(sqlInsert2);
								
			statement.setString(1, asiakas.getEtuNimi());
			statement.setString(2, asiakas.getSukuNimi());
			statement.setString(3, asiakas.getPuh());
			statement.setString(4, asiakas.getOsoite());
			statement.setInt(5, asiakas.getPostiNro());
			statement.setString(6, asiakas.getPostiTmp());
			statement.setString(7, asiakas.getsPosti());
			statement.setInt(8, kayttaja.getId());
			statement.executeUpdate();
		    conn.commit();
			
	    	} catch (Exception e) {
	    		try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.println("Jokin meni pieleen.");
				}
	    		throw new RuntimeException(e);
	    	} finally {
	    		close(statement, conn);
	    	}
	   	}
   
   public void delete(Kayttaja kayttaja){
	   PreparedStatement statement = null;
	   Connection connection = null;
	   try {
	      connection = getConnection();
	      String sql = "delete from user where id=?";
	      statement = connection.prepareStatement(sql);
	      int id = kayttaja.getId();
	      statement.setInt(1, id);
	      statement.executeUpdate();
	} catch (Exception e) {
		throw new RuntimeException(e);
	} finally {
        close(statement, connection);
	}
   }
   
   public void deleteAsiakas(Kayttaja kayttaja){
	    PreparedStatement statement = null;
	    PreparedStatement stmt2 = null;
	    Connection connection = null;
	    ResultSet rs = null;
	    try {
		    connection = getConnection();
		    String sql = "delete from user where id=?";
		    String sqlDelete2="DELETE FROM asiakas WHERE asiakas_id= "+kayttaja.getId()+";";
		    statement = connection.prepareStatement(sql);
		    stmt2=connection.prepareStatement(sqlDelete2);
		    int id = kayttaja.getId();
		    statement.setInt(1, id);
		    rs=stmt2.executeQuery();
		    statement.executeUpdate();
	    } catch (Exception e) {
	    	throw new RuntimeException(e);
	    } finally {
	        close(statement, connection);
		}
	  }
     
}


