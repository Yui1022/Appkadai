package dao;

import java.sql.*;
import model.Login;
import model.User;

public class UserDao {
	 public User findByLogin(Login login) {
	        Connection conn = null;
	        User user = null;
	        try {
	            Class.forName("org.apache.derby.jdbc.ClientDriver");
	            String driverURL = "jdbc:derby://localhost:1527/db0818";
	            conn = DriverManager.getConnection(driverURL, "db", "db");

	            String sql = "SELECT USERID, PASS FROM USERS WHERE USERID = ? AND PASS = ?";
	            PreparedStatement pStmt = conn.prepareStatement(sql);
	            pStmt.setString(1, login.getUserId());
	            pStmt.setString(2, login.getPass());

	            ResultSet rs = pStmt.executeQuery();

	            if (rs.next()) {
	                String userId = rs.getString("USERID");
	                String pass = rs.getString("PASS");
	               

	                user = new User(userId, pass);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                    return null;

	                }
	            }
	        }
	        return user;
	    }
	    public boolean create(User user) {
	        System.out.println("create");
	        Connection conn = null;
	        try {

	            conn = DriverManager.getConnection(
	                    "jdbc:derby://localhost:1527/db0818", "db", "db");
	            

	            String sql = "INSERT INTO USERS(USERID, PASS) VALUES(?, ?)";
	            PreparedStatement pStmt = conn.prepareStatement(sql);
	         
	            pStmt.setString(1, user.getUserId());
	            pStmt.setString(2, user.getPass());

	            int result = pStmt.executeUpdate();

	            if (result != 1) {
	                return false;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        } finally {
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        return true;
	    }

}
