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
 * Servlet implementation class GetProvoles
 */
@WebServlet("/GetProvoles")
public class GetProvoles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProvoles() {
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
		
		ResultSet rs= Users.GetAllProvoles();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("TopBar.jsp").include(request, response);
		request.getRequestDispatcher("DateSearch.jsp").include(request, response);

		
		
		String start= request.getParameter("start_date");

		String end= request.getParameter("end_date");
		
		out.println("<html>");
		out.println("<body>");
		if(start!=null) 
		{
		out.println("<script>"
				+ "document.getElementById('start').value = '"+start+"';" 
		
				+ "document.getElementById('end').value = '"+end+"';" 
			
		
			
				+ "</script>");
		}
		
		out.println("<style>.button {background-color: #4CAF50;color: white;padding: 14px 20px;margin: 8px 0; border: none;cursor: pointer;}.button:hover {opacity: 0.8;}</style>");
		out.println("<table style=\"border: 1px solid black;\">");
		out.println("<tr><td><b>Provoli ID</b></td><td><b>Cinema Name</b></td><td><b>Movie Title</b></td><td><b>Date</b></td></tr>");
		
		
		try {
			while(rs.next())
			{
				if(start==null) 
				{
					out.println("<tr><td>"+rs.getString("provoliid")+"</td><td>"+rs.getString("cinemaname")+"</td>"+"<td>"+rs.getString("movietitle")+"</td><td>"+"<td>"+rs.getString("provolidate")+"</td>");
				}
				else
				{
					if(rs.getString("provolidate").compareTo(start)>=0  && rs.getString("provolidate").compareTo(end)<=0) 
					{
						out.println("<tr><td>"+rs.getString("provoliid")+"</td><td>"+rs.getString("cinemaname")+"</td>"+"<td>"+rs.getString("movietitle")+"</td><td>"+"<td>"+rs.getString("provolidate")+"</td><td>");
					}
				}
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}
