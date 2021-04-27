package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * Connection for MySQL and Java
 */
public class DBConnection {
	public static Connection  getConnection() {
		Connection conn = null;
	    try {
	     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/artgallery","(username)","(password"); 
		 System.out.println("Connected With the database successfully");
		 
		 } catch (SQLException e) {
		 
		 System.out.println("Failed connecting to database." + e);
		 
		 }
	    return conn;
	 }
	
	public static void main(String[]args) {
		getConnection();
	}
}
