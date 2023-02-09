package fourW;

import java.sql.SQLException;
import java.util.Scanner;

public class mainBooking {
     public static void main(String[] args) throws SQLException  {
    	 bookingDTO dto=new bookingDTO();
    	 passBooking dao=new passBooking();
 
    	 Scanner scanner=new Scanner(System.in);
		System.out.println("welcome to Namma Travels....!!\n");
		dao.busDetailsfro();
		
		
		while(true) {
			System.out.println("Do you wanna book ticket if yes type 'book' \nIf you want to type cancel 'Cancel' \nIf you want your bus detail type 'Mydetail' \nif you want to exit type 'Exit'  ");
			String entry=scanner.next().toLowerCase();
			switch(entry) 
			{
			case "book":
				
			             System.out.println("Enter your Name : ");
			             String name=scanner.next();
		             	 System.out.println("Enter your Phone Number : ");
		              	 String pnum=scanner.next();
			             System.out.println("Enter your Departure place : ");
		         	     String dplace=scanner.next().toLowerCase();
			             System.out.println("Enter your Destiny place : ");
			             String place=scanner.next();
			             System.out.println("Enter your Gender : ");
			             String gender =scanner.next();
			             System.out.println("Enter your Age : ");
			             int age=scanner.nextInt();
			             dto.setpName(name);
			             dto.setpPhNO(pnum);
			             dto.setfLoc(dplace);
			             dto.settLoc(place);
			             dto.setGender(gender);
			             dto.setAge(age);
			
			            try {
				           if(dao.addPassenger(dto)) {
					       System.out.println("Ticket booked Succesfully....\n");
					       dao.busDetails(dplace);
				       }
				           
			             } catch (SQLException e) {
			            	 
			            	 System.out.println("Something wrong with your input please check....!!");
			             
		      	}
			            
			    break;
			    
			case "cancel":	System.out.println("Enter your Name : ");
				            name=scanner.next();
				            if(dao.removePassenger(name)) {
				             	System.out.println("your cancellation is completed....\n");
				             }
			         	   
			           	    break;
			           	    
			case "mydetail": System.out.println("Enter your Name : ");
                             name=scanner.next();
                             System.out.println("Enter your Departure place : ");
    		         	     dplace=scanner.next().toLowerCase();
                             dao.busDetails(dplace);
                             System.out.println("\n");
       	    break;
		
			case "exit":
				 System.out.println("Thank you using our Travels....!!!");
				 System.exit(0);
				 break;
			}
		}
		
		
		
		
	}
}
