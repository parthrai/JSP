package mvc.servlet.jsp;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.mysql.jdbc.PreparedStatement;

//********************************************************************************* ******************* *
//Project:                 Blogging System 
//* Assignment:         < assignment 2 >
//* Author(s):             sarbjeet 100980424 
//* Date:              2016-12-03   
//* Description:     This is model perform actions like validating users data and inserting the post data into database.  
//*********************************************************************************** *****************// 

public class AddPostModel {
	
	
	public boolean validate(String post, String title){
		
		if(title.length()>0 ||post.length()>0)
			return true;
		
		
		return false;
		
	}
	
	
	public boolean addPost(String title,String post, int user){
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		System.out.println(dtf.format(localDate));
		
		 try{
		        
		        //loading drivers for mysql
		        Class.forName("com.mysql.jdbc.Driver");

			//creating connection with the database 
		          Connection  con=DriverManager.getConnection
		                     ("jdbc:mysql://localhost/comp3095","root","");

		        PreparedStatement ps=(PreparedStatement) con.prepareStatement
		                  ("insert into posts values(?,?,?,?,?)");

		        ps.setString(1,null );
		        ps.setInt(2, user);
		        ps.setString(3, title);
		        ps.setString(4, post);
		        ps.setString(5,dtf.format(localDate));
		        
		        
		        
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
