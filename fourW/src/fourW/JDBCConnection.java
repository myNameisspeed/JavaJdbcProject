package fourW;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	private final static String URL="jdbc:mysql://localhost:3306/namma_travels";
	private final static String USER="root";
	private final static String PASSWORD="Selv@mm758";
	
	
	
	static
    {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		
    	}
    	catch(ClassNotFoundException e){
    		e.printStackTrace();
    	}
    }
	
	 public static Connection getConnection() {
	    	Connection con=null;
	    	try {
	    		con=DriverManager.getConnection(URL, USER, PASSWORD);
	    	}
	    	catch(SQLException e) {
	    		System.out.println("Establishing Connection with DB is Failed");
	    		e.printStackTrace();
	    	}
			return con;
	    }
		    public static void closeConnection(Connection con) {
	    	if(con!=null) {
	    		try {
	    			con.close();
	    		}catch(SQLException e){
	    			e.printStackTrace();
	    		}
	    	}
	    }
	
}
