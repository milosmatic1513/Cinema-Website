package sevlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mainpackage.Users;

/**
 * Servlet implementation class GetMovies
 */
@WebServlet("/GetMovies")
public class GetMovies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMovies() {
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
		ResultSet rs= Users.GetAllMovies();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("TopBar.jsp").include(request, response);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<style>.button {background-color: #4CAF50;color: white;padding: 14px 20px;margin: 8px 0; border: none;cursor: pointer;}.button:hover {opacity: 0.8;}</style>");
		out.println("<table>");
		out.println("<tr><td><b>Movie Title</b></td></tr>");
		try {
			while(rs.next())
			{
				out.println("<tr><td>"+rs.getString("movietitle")+"</td></tr>");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}
