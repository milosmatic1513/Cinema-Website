package sevlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mainpackage.Users;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
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
		String uname = request.getParameter("uname");
		String password = request.getParameter("pass");
		String fullname = request.getParameter("fname");

		Users customer = new Users();
		customer.setFullName(fullname);
		customer.setUsername(uname);
		customer.setPassword(password);
		int status = customer.insertUser();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("TopBar.jsp").include(request, response);

		out.println("<html>");
		out.println("<body>");
		
		out.println("<style>"+
			    ".button { "+ 
				"  background-color: #4CAF50;" + 
				"  color: white;" + 
				"  padding: 14px 20px;" + 
				"  margin: 8px 0;" + 
				"  border: none;" + 
				"  cursor: pointer;" + 
				"  align:center"+
				"}"+
				"</style>");
		
		if (status == 1) {
			out.println("<h1>Register Successfull</h1>");
		} else if (status == 2) {
			out.println("<h1>Register Failed</h1>");
		}
		out.println(
				"<button class = 'button' onclick=\"document.location.href='main_page.jsp';\">Return To Home </button>");
		out.println("</body>");
		out.println("</html>");

	}

}
