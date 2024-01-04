import java.sql.*;

public class DbHelper {
	
	private String username = "root";
	private String password = "";
	
	
	
	private int port = 3306;
	private Connection con = null;
	
	public Connection getConnection() throws SQLException {
		String db_url = "jdbc:mysql://localhost:3306/araclar";
		return(Connection) DriverManager.getConnection(db_url, username, password);
		
		
	}
	public void ShowError(SQLException exception) {
		System.out.println("Error: " + exception.getMessage());
		System.out.println("Error Code: " + exception.getErrorCode());
		
	}
	
	
	

}
