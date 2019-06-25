package sevlets;

import mainpackage.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get User
		String uname = request.getParameter("uname");
		// get Password
		String password = request.getParameter("password");

		// Create user obj
		Users user = new Users();
		user.setUsername(uname);
		user.setPassword(password);
		// attempt login
		int status = user.login();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");

		// Style
		out.println("<style>" 
				+ ".button " 
				+ "{background-color: #4CAF50;" 
				+ "color: white;" 
				+ "padding: 14px 20px;"
				+ "margin: 8px 0; " 
				+ "border: none;" 
				+ "cursor: pointer;" 
				+ "} " 
				+ ".button:hover {opacity: 0.8;} "
				+ ".textbox " 
				+ "{" 
				+ "padding: 14px 20px" 
				+ ";margin: 8px 0; " 
				+ "}" 
				+ "</style>");

		// Place top bar
		request.getRequestDispatcher("TopBar.jsp").include(request, response);
		//No cache
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma","no-cache");
		response.setDateHeader ("Expires", 0);
		
		//create session
		HttpSession session=request.getSession();  
		// user is Client
		
		
		if (status == 1) {
			try 
			{
				session.setAttribute("uname",uname);  
				session.setAttribute("status","Client");  
				response.sendRedirect("succLogin.jsp");
			}catch(Exception e)
			{
				System.out.println(e);
			}  

		} 
		else if (status == 2) {
			
			out.println("<h1>Username password missmatch</h1>");
			
		}
		else if (status == 3) 
		{
			try 
			{
			
				session.setAttribute("uname",uname);  
				session.setAttribute("status","Content admin");  
				response.sendRedirect("succLogin.jsp");
				
			}catch(Exception e)
			{
				System.out.println(e);
			}  
		}
	    else if (status == 4) 
	    {
			try 
			{
				session.setAttribute("uname",uname);  
				session.setAttribute("status","Admin");  
				response.sendRedirect("succLogin.jsp");
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}  
		}
		else {
			out.println("<h1>User does not exist</h1>");
		}
	
			
		out.println("</body>");
		out.println("</html>");

	}

}
