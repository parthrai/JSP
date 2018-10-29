package Posts.mvc.server.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

//********************************************************************************* ******************* *
//Project:                 Blogging System 
//* Assignment:         < assignment 2 >
//* Author(s):             sarbjeet 
//* Date:              2016-12-03   
//* Description:    The method "getFromPosts" takes postId and parameter to be returned for that particular post.  
//*********************************************************************************** *****************//
public class Posts {

	public static String getFromPosts(int id, String Parameter){
		
		
		try{

			 //loading drivers for mysql
		         Class.forName("com.mysql.jdbc.Driver");

		 	 //creating connection with the database 
		         Connection con=DriverManager.getConnection
		                        ("jdbc:mysql://localhost/comp3095","root","");
		         PreparedStatement ps =(PreparedStatement) con.prepareStatement
		                             ("select * from posts where id=?");
		         ps.setInt(1, id);
		         
		         ResultSet rs =ps.executeQuery();
					
		       

		         while(rs.next()){
		        	 
		        	 
		        	 
		        	 return rs.getString(Parameter);
					        	 
		         }
		         
	      }catch(Exception e)
	      {
	          e.printStackTrace();
	          
	      }

		return "Nothing found";
	}
	
	
}
