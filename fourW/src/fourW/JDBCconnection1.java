package fourW;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCconnection1 {
	private final static String URL_pass="jdbc:mysql://localhost:3306/namma_travels";
	private final static String USER_pass="root";
	private final static String PASSWORD_pass="Selv@mm758";
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
	    		con=DriverManager.getConnection(URL_pass, USER_pass, PASSWORD_pass);
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
 

