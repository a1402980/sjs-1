package pizzicato.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import pizzicato.model.Kayttaja;
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

//Näitä metodeita ei tällä hetkellä tarvita

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
		   String sql = "insert into kayttaja " + "(username, password, userrole) " + "values (?, ? ?)";
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
   
}


