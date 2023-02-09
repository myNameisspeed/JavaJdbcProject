package fourW;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class passBooking {
	
	public boolean addPassenger(bookingDTO dto) throws SQLException  {
	
		boolean res =true;
	
		Connection con=JDBCconnection1.getConnection();
		
		PreparedStatement pstmt=con.prepareStatement("insert into passengerbooking values(?,?,?,?,?,?)");
		
		pstmt.setString(1,dto.getpName());
	    pstmt.setString(2, dto.getpPhNO());
			
		pstmt.setString(3, dto.getfLoc());
		pstmt.setString(4,dto.gettLoc());
		pstmt.setString(5,dto.getGender());
		pstmt.setInt(6, dto.getAge());
		
		int num=pstmt.executeUpdate();
		if(num != 1)
			  res=false;
		  
		  JDBCConnection.closeConnection(con);
		  return res;
		  }
		
		
		
	public boolean removePassenger(String name) throws SQLException {
		boolean res =true;
		Connection con=JDBCconnection1.getConnection();
		
		PreparedStatement pstmt=con.prepareStatement("delete from passengerbooking where passenger_name=?");
		
		pstmt.setString(1, name);
		
		int num=pstmt.executeUpdate();
		if(num != 1)
			  res=false;
		  
		  JDBCConnection.closeConnection(con);
		  
			return res;
	}
	public void busDetails(String floc) throws SQLException {
		bookingDTO dto=null;
		Connection con=JDBCConnection.getConnection();
		
	    String query="select * from busdetails where from_location='"+floc+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		if(rs.next()) {
			System.out.println("Your bus details");
		    dto =new bookingDTO();
			System.out.println("Your bus Number : "+rs.getInt(1)); 
			if(rs.getInt(3)==0)
			    System.out.println("Seat + Non AC");
			else
				System.out.println("Sleeper + AC");
			System.out.println(rs.getString(4));
			System.out.println(rs.getString(5));
			System.out.println("Your bus fare : "+rs.getInt(7));
			
		}
		  
		  JDBCConnection.closeConnection(con);
			
	}	
	public void busDetailsfro() throws SQLException {
		
		  Connection con=JDBCConnection.getConnection();		  
		  PreparedStatement pstmt=con.prepareStatement("select * from busdetails"); 
		  ResultSet rs =pstmt.executeQuery();
	
		  System.out.println("Our Travels bus details....!!!");
		while(rs.next()) {
		  
			System.out.println("bus Number : "+rs.getInt(1)); 
			if(rs.getInt(3)==0)
			    System.out.println("Seat + Non AC");
			else
				System.out.println("Sleeper + AC");
			System.out.println("From location "+rs.getString(4));
			System.out.println("To location"+ rs.getString(5));
			System.out.println("bus fare : "+rs.getInt(7)+"\n");
			
		}
		  
		  JDBCConnection.closeConnection(con);
			
	}	

	
}
//	public int capacity(String loc) throws SQLException {
//		bookingDTO dto=new bookingDTO();
//		Connection con=JDBCConnection.getConnection();
//		PreparedStatement pstmt=con.prepareStatement("select busdetails.capacity from busdetails inner join passengerbooking on busdetails.from_location = passengerbooking.from_loc where busdetails.from_location='"+loc+"'");
//		ResultSet rs = pstmt.executeQuery();
//		
//		return rs.getInt(2);
//		
//	}


//	public boolean isAvailable() throws SQLException{
//		bookingDTO dto=new bookingDTO();
//		int capacity=getCapacity(dto.getBusNo());
//		int booked=getBookCount(dto.getbFloc());
//		return booked<capacity?true:false;
//	}
//	public static int getCapacity(int busno) throws SQLException {
//		String query="select capacity from busdetails where bus_no ="+busno+"";
//		Connection con=JDBCConnection.getConnection();
//		Statement st=con.createStatement();	
//	    ResultSet rs=st.executeQuery(query);
//	    rs.next();
//	    return rs.getInt(2);
//}
//	
//	public int getBookCount(String floc) throws SQLException {
//		String query="select count(passenger_name) from passengerbooking where from_location="+"'floc'"+"";
//		Connection con=JDBCconnection1.getConnection();
//		PreparedStatement pst=con.prepareStatement(query);
//		ResultSet rs=pst.executeQuery();
//		rs.next();
//		return rs.getInt(1);
//	}
//	public int fLoc(String floc) throws SQLException {
//		
//		Connection con=JDBCConnection.getConnection();
//		String query="select bus_no from busdetails where fromlocation="+floc+"";
//		Statement pstmt=con.createStatement();
//		ResultSet rs=pstmt.executeQuery(query);
//		
//		return rs.getInt(1);
//		
//	}
//	public int ticketCount(int bno) throws SQLException {
//		bookingDTO dto=null;
//		int rs1=0;
//		dto =new bookingDTO();
//		 Connection con=JDBCConnection.getConnection();		  
//		 String query="select capacity from busdetails where bus_no="+bno+"";
//		  Statement stmt=con.createStatement();
//		  ResultSet rs =stmt.executeQuery(query);
//		 if( rs.next())
//		        rs1 = rs.getInt(2);	 
//		 return rs1;
//	}

	
