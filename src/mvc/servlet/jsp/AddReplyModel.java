package mvc.servlet.jsp;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.PreparedStatement;


//********************************************************************************* ******************* *
//Project:                 Blogging System 
//* Assignment:         < assignment 2 >
//* Author(s):             sarbjeet 100980424 
//* Date:              2016-12-03   
//* Description:     This model performs functions like validating and inserting reply to database.  
//*********************************************************************************** *****************// 


public class AddReplyModel {
	
	public boolean validate(String reply){
		
		if(reply.length()>0)
			return true;
		
		return false;
	}

	public boolean PostReply(String Reply, int user, int post){
		
		
		
		 try{
		        
		        //loading drivers for mysql
		        Class.forName("com.mysql.jdbc.Driver");

			//creating connection with the database 
		          Connection  con=DriverManager.getConnection
		                     ("jdbc:mysql://localhost/comp3095","root","");

		        PreparedStatement ps=(PreparedStatement) con.prepareStatement
		                  ("insert into replies values(?,?,?,?)");

		        ps.setString(1,null );
		        ps.setInt(2, user);
		        ps.setInt(3, post);
		        ps.setString(4, Reply);
		        
		        	        
		        
		        int i=ps.executeUpdate();
		        
		          if(i>0)
		          {
		        	 return true;
		  			
		          }
		        
		        }
		        catch(Exception se)
		        {
		            se.printStackTrace();
		        }

				
		 return false;
	}
	
	
	
	 
}
