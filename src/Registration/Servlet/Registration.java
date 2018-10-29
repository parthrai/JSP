package Registration.Servlet;

//********************************************************************************* ******************* *
//Project:                 Student Login/Registration System 
//* Assignment:         < assignment 1 >
//* Author(s):             Parth Rai Sharma 100980424 / NavaRaj Joshi 100963324 / Robinder Paul / Chinmaya Railkar 
//* Date: * Description:     This servlet is for registering user/ storing user details in database  
//*********************************************************************************** *****************// 



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;


@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Registration() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.setContentType("text/html");
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		
		PrintWriter pw= response.getWriter();
		
		String firstname= request.getParameter("firstname");	
		String lastname= request.getParameter("lastname");
		String email= request.getParameter("email");
		String confirm_email= request.getParameter("confirm_email");
		String phone= request.getParameter("phone");
		String year= request.getParameter("year");
		String major= request.getParameter("major");
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		String confirm_password= request.getParameter("confirm_password");
		
		if(!checkstring(email,confirm_email)){
			request.setAttribute("email_error","Emails does not match");
			request.getRequestDispatcher("registration.jsp").forward(request,response);
		}
			
			
		if(!checkstring(password,confirm_password)){
			request.setAttribute("password_error","Passwords does not match");
			request.getRequestDispatcher("registration.jsp").forward(request,response);
		}
		
		
		 try{
		        
		        //loading drivers for mysql
		        Class.forName("com.mysql.jdbc.Driver");

			//creating connection with the database 
		          Connection  con=DriverManager.getConnection
		                     ("jdbc:mysql://localhost/comp3095","root","");

		        PreparedStatement ps=(PreparedStatement) con.prepareStatement
		                  ("insert into users values(?,?,?,?,?,?,?,?,?)");

		        ps.setString(1,null );
		        ps.setString(2, firstname);
		        ps.setString(3, lastname);
		        ps.setString(4, email);
		        ps.setString(5, phone);
		        ps.setString(6, year);
		        ps.setString(7, major);
		        ps.setString(8, username);
		        ps.setString(9, password);
		        
		        int i=ps.executeUpdate();
		        
		          if(i>0)
		          {
		        	  request.setAttribute("user", firstname+" "+lastname);
		  			request.getRequestDispatcher("registration_confirmation.jsp").forward(request,response);
		          }
		        
		        }
		        catch(Exception se)
		        {
		            se.printStackTrace();
		        }
	}
	
	
	public boolean checkstring(String s1, String s2){
		
		boolean result = false;
		
		if(s1.equals(s2))
			result=true;
		
		return result;
	}

}
