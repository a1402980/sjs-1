package pizzicato.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pizzicato.model.Omistaja;
import pizzicato.model.dao.DataAccessObject;

public class UserDAO extends DataAccessObject {
   private static UserDAO instance = new UserDAO();

   public static UserDAO getInstance() {
      return instance;
   }
   
   private Omistaja read(ResultSet rs) throws SQLException
   {
	   int id = new Integer(rs.getInt("id"));
	   String username = rs.getString("username");
	   String password = rs.getString("password");
	   Omistaja omistaja = new Omistaja();
	   omistaja.setId(id);
	   omistaja.setUsername(username);
	   omistaja.setPassword(password);
	   return omistaja;
   }
   
   public Omistaja find(int id) {
	   ResultSet rs = null;
	   PreparedStatement statement = null;
	   Connection connection = null;
	   try {
		   connection = getConnection();
		   String sql = "select * from omistaja where id=?";
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
   
   public Omistaja findByUsername (String username) {
	   ResultSet rs = null;
	   PreparedStatement statement = null;
	   Connection connection = null;
	   try {
		   connection = getConnection();
		   String sql = "select * from omistaja where username=?";
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
/*   
   public List<User> findAll() {
	   LinkedList<User> users = new LinkedList<User>();
	   ResultSet rs = null;
	      PreparedStatement statement = null;
	      Connection connection = null;
	      try {
	    	  connection = getConnection();
	          String sql = "select * from user order by id";
	          statement = connection.prepareStatement(sql);
	          rs = statement.executeQuery();
	          while (rs.next()) {
	        	  User user = read(rs);
	              users.add(user);
	          }
	          return users;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	      finally {
	    	  close(rs, statement, connection);
	      }
   }
   */
   
   public void update(Omistaja omistaja) {
	   PreparedStatement statement = null;
	   Connection connection = null;
	   try {
		   connection = getConnection();
	         String sql = "update user set " + "password=? where id=?";
	         statement = connection.prepareStatement(sql);
	         statement.setString(1, omistaja.getPassword());
	         statement.setLong(2, omistaja.getId());
	         statement.executeUpdate();
	   } catch (SQLException e) {
	         throw new RuntimeException(e);
	      } finally {
	         close(statement, connection);
	      }
   }
   public void create(Omistaja omistaja) {
	   //Long id = getUniqueId();
	   int id = omistaja.getId();
	   omistaja.setId(id);
	   PreparedStatement statement = null;
	   Connection connection = null;
	   try {
		   connection = getConnection();
		   String sql = "insert into user " + "(id, username, password) " + "values (?, ? ?)";
		   statement = connection.prepareStatement(sql);
	       statement.setLong(1, omistaja.getId());
	       statement.setString(2, omistaja.getUsername());
	       statement.setString(3, omistaja.getPassword());
	       statement.executeUpdate();
	} catch (Exception e) {
		throw new RuntimeException(e);
	} finally {
        close(statement, connection);
	}
   }
   
   public void delete(Omistaja omistaja){
	   PreparedStatement statement = null;
	   Connection connection = null;
	   try {
	      connection = getConnection();
	      String sql = "delete from user where id=?";
	      statement = connection.prepareStatement(sql);
	      int id = omistaja.getId();
	      statement.setLong(1, id);
	      statement.executeUpdate();
	} catch (Exception e) {
		throw new RuntimeException(e);
	} finally {
        close(statement, connection);
	}
   }
}
   


