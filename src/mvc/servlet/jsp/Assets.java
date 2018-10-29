package mvc.servlet.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

//********************************************************************************* ******************* *
//Project:                 Blogging System 
//* Assignment:         < assignment 2 >
//* Author(s):             Parth Rai Sharma 
//* Date:              2016-12-03   
//* Description:     This class performs some miscellaneous functionalities like 
//*                   1. Trimming the length of actual post so that they can be displayed on homepage.
//*					  2. UserName take user Id as input and return user's name.
//*					  3. NoOfReplies take post id as input and retuns no of replies for that post. 
//*********************************************************************************** *****************// 

public class Assets {

	public static String Trim(String post){
		
		if(post.length() > 20)
			return post.substring(0,post.length()/3)+".....";
		else 
			return post;
	}
	
	
	public static String UserName(int UserId){
		
		try{

			 //loading drivers for mysql
		         Class.forName("com.mysql.jdbc.Driver");

		 	 //creating connection with the database 
		         Connection con=DriverManager.getConnection
		                        ("jdbc:mysql://localhost/comp3095","root","");
		         PreparedStatement ps =(PreparedStatement) con.prepareStatement
		                             ("select * from users where id=?");
		         ps.setInt(1, UserId);
		         
		         ResultSet rs =ps.executeQuery();
					
		         String UserName="";

		         while(rs.next()){
		        		UserName=rs.getString("firstname")+" "+rs.getString("lastname");
			         	return UserName;    
		         }
		         
		              
			        
		      }catch(Exception e)
		      {
		          e.printStackTrace();
		          
		      }
			
			return "";
		

	}
	
	
	public static int NoOfReplies(int post){

		try{

		         Class.forName("com.mysql.jdbc.Driver");

		 	 //creating connection with the database 
		         Connection con=DriverManager.getConnection
		                        ("jdbc:mysql://localhost/comp3095","root","");
		         PreparedStatement ps =(PreparedStatement) con.prepareStatement
		                             ("select count(*) from replies where post_id=?");
		         ps.setInt(1, post);
		         ResultSet rs =ps.executeQuery();
		         
		
		         while(rs.next()){	        		
		        	 return rs.getInt("count(*)");
		         }
		      
		      		         
			}catch(Exception e)
			{
				e.printStackTrace();
			}	
    return 0;
	
	
	}

}