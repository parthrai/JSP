package logout.servlet;

//********************************************************************************* ******************* *
//Project:                 Student Login/Registration System 
//* Assignment:         < assignment 1 >
//* Author(s):             Parth Rai Sharma 100980424 / NavaRaj Joshi 100963324 / Robinder Paul / Chinmaya Railkar 
//* Date: * Description:     This servlet is for logout / deleting all the session cookies  
//*********************************************************************************** *****************// 


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public logout() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		HttpSession session=request.getSession();  
        session.invalidate();  
        
        request.getRequestDispatcher("login.jsp").forward(request,response);
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
