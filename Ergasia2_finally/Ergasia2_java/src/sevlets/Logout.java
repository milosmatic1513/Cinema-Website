package sevlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        //gets current session
	        HttpSession session=request.getSession(false);  
	        //closes sessions
			request.getRequestDispatcher("TopBar.jsp").include(request, response);
			String status = (String) session.getAttribute("status");
			
			try{
				if(status!=null) {
					out.print("<h1>Successsfully logged out</h1>");
					out.close();  
			    

				}
				else {
					out.print("<h1 align='center'>Login first!</h1>");
					out.close();
			   

				}
		        session.invalidate();

			}
			catch(Exception e) {
				System.out.println(e);
			}
				
	          
	       
	}

}
