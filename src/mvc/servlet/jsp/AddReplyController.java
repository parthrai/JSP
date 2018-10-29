package mvc.servlet.jsp;

import java.io.IOException;

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
//* Description:     This is servlet is a controller for replying to posts, this controller interacts with AddReplyModel.  
//*********************************************************************************** *****************// 

@WebServlet("/AddReplyController")
public class AddReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AddReplyController() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);
		 
RequestDispatcher dispatcher;
		
		HttpSession session= request.getSession();
		
		int user= (int) session.getAttribute("UserId");
		int post= Integer.parseInt(request.getParameter("post"));
		String reply = request.getParameter("reply");
		
		
		
		AddReplyModel addreply=new AddReplyModel();
	
		if(!addreply.validate(reply)){
			request.setAttribute("Error", "Please provide valide data");
			dispatcher= request.getRequestDispatcher("post.jsp?id="+post);
			System.out.println("herer");
			dispatcher.forward(request, response);
			return;
			
		}
		
		
		if(addreply.PostReply(reply, user, post))
			dispatcher= request.getRequestDispatcher("post.jsp?id="+post);
		
		else{ dispatcher=request.getRequestDispatcher("index.jsp");}
		
		
		dispatcher.forward(request, response);


		
				
	}

}
