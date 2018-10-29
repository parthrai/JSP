package mvc.servlet.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//********************************************************************************* ******************* *
//Project:                 Blogging System 
//* Assignment:         < assignment 2 >
//* Author(s):             sarbjeet 100980424  
//* Date:              2016-12-03   
//* Description:     This is servlet is a controller for adding post which interacts with AddPostModel to provide logical results.  
//*********************************************************************************** *****************// 


@WebServlet("/AddPostController")
public class AddPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddPostController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		RequestDispatcher dispatcher;
		HttpSession session= request.getSession();
		
		int UserId= (int) session.getAttribute("UserId");
		
		
		AddPostModel add= new AddPostModel();
	
		String title= request.getParameter("title");
		String post= request.getParameter("post");
		
		
		if(!add.validate(post,title)){
			request.setAttribute("Error", "Please provide valide data");
			dispatcher= request.getRequestDispatcher("NewPost.jsp");
			System.out.println("herer");
			dispatcher.forward(request, response);
			
			return;
		}
		
		if(add.addPost(title, post, UserId)){
			dispatcher= request.getRequestDispatcher("index.jsp");
			System.out.println("yahn pe");
		}
		else{ dispatcher=request.getRequestDispatcher("userprofile.jsp");}
		
		
		dispatcher.forward(request, response);
	}

}
