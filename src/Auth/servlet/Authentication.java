package Auth.servlet;

//********************************************************************************* ******************* *
//Project:                 Student Login/Registration System 
//* Assignment:         < assignment 1 >
//* Author(s):             Parth Rai Sharma 100980424 / NavaRaj Joshi 100963324 / Robinder Paul / Chinmaya Railkar 
//* Date: * Description:     This servlet is for user authentication / email and password validation / creating session cookies 
//*********************************************************************************** *****************// 

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.mysql.jdbc.PreparedStatement;


@WebServlet("/Authentication")
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Authentication() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		PrintWriter pw= response.getWriter();
		
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		
		
		if(checkauth(username, password)){
			
			String value = request.getParameter("remember");
			boolean rememberMe = false;
			if(value != null && value.equalsIgnoreCase("on")){
			    rememberMe = true;
			}
			if (rememberMe) {           //If your checkbox value is true
			
				 Cookie c = new Cookie("username", username);
				    c.setMaxAge(24*60*60);
				    response.addCookie(c); 
			}
			
			
			
			HttpSession session = request.getSession(true);
			try{

				 //loading drivers for mysql
			         Class.forName("com.mysql.jdbc.Driver");

			 	 //creating connection with the database 
			         Connection con=DriverManager.getConnection
			                        ("jdbc:mysql://localhost/comp3095","root","");
			         PreparedStatement ps =(PreparedStatement) con.prepareStatement
			                             ("select * from users where username=?");
			         ps.setString(1, username);
			         
			         ResultSet rs =ps.executeQuery();
						
			       

			         while(rs.next()){
			        	 
			        	 session.setAttribute("username", rs.getString("username"));
			        	 session.setAttribute("firstname", rs.getString("firstname"));
			        	 session.setAttribute("lastname", rs.getString("lastname"));
			        	 session.setAttribute("UserId", rs.getInt("id"));
			        	 session.setAttribute("email", rs.getString("email"));
			        	 session.setAttribute("major", rs.getString("major"));
			        	 session.setAttribute("year", rs.getString("year"));
			        	 session.setAttribute("phone", rs.getString("phone"));
						
			        	 
			         }
			         
			         
			         
			        
			      }catch(Exception e)
			      {
			          e.printStackTrace();
			          pw.println("error");
			      }

			request.getRequestDispatcher("index.jsp").forward(request,response);

		}
		
		else{
			request.setAttribute("message","Invalid Account");
			request.getRequestDispatcher("login.jsp").forward(request,response);

			
		}
	
	}
	
	
	public static boolean checkauth(String username, String password){
		
		 boolean status = false;
	      try{

		 //loading drivers for mysql
	         Class.forName("com.mysql.jdbc.Driver");

	 	 //creating connection with the database 
	         Connection con=DriverManager.getConnection
	                        ("jdbc:mysql://localhost/comp3095","root","");
	         PreparedStatement ps =(PreparedStatement) con.prepareStatement
	                             ("select * from users where username=? and password=?");
	         ps.setString(1, username);
	         ps.setString(2, password);
	         ResultSet rs =ps.executeQuery();
	         status = rs.next();
	        
	      }catch(Exception e)
	      {
	          e.printStackTrace();
	          
	      }
	         return status;             
	}

}
