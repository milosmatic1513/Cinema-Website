package sevlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mainpackage.ContentAdmins;

/**
 * Servlet implementation class InsertProvoli
 */
@WebServlet("/InsertProvoli")
public class InsertProvoli extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProvoli() {
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
		ContentAdmins contentAdmin= new ContentAdmins();
		
		
		HttpSession session=request.getSession(false);  
		contentAdmin.setUsername(session.getAttribute("uname").toString());
		contentAdmin.SetProvoli(request.getParameter("cinema"),request.getParameter("movie"),request.getParameter("date"));
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("TopBar.jsp").include(request, response);
		out.println("<h1>Successfully Inserted Provoli</h1>");	
	}

}
