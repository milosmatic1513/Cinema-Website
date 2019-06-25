package sevlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mainpackage.Admins;

/**
 * Servlet implementation class DeleteContent
 */
@WebServlet("/DeleteContent")
public class DeleteContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteContent() {
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
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("TopBar.jsp").include(request, response);

		try {
		Admins admin= new Admins();
		HttpSession session=request.getSession(false);  
		admin.setUsername(session.getAttribute("uname").toString());
		
		int id=Integer.parseInt(request.getParameter("userid") .toString());

		admin.DeleteConAdmin(id);
		
		response.setContentType("text/html");
		
		out.println("<h1>Successful</h1>");
		}
		catch(Exception e)
		{
			e.printStackTrace();;
			out.println("<h1>Failure</h1>");
		}
	}

}
