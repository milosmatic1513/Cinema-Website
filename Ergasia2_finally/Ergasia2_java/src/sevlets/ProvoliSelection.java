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
 * Servlet implementation class ProvoliSelection
 */
@WebServlet("/ProvoliSelection")
public class ProvoliSelection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProvoliSelection() {
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
		
		Users user=new Users();
		
		request.getRequestDispatcher("TopBar.jsp").include(request, response);
		
		request.getRequestDispatcher("DateSearch2.jsp").include(request, response);


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
		out.print("<form method = 'post' action = 'MakeReservation'>");
		out.println("<select name='provoli'>");
		
		try {
			while(rs.next())
			{
				if(start==null) 
				{
					out.println("<option value= "+rs.getInt("provoliid") +">"+rs.getString("cinemaname")+" "+rs.getString("movietitle")+" "+rs.getString("provolidate")+" | Seats Left : "+(user.seatsLeft(rs.getInt("provoliid")))+"</option>");
				}
				else
				{
					if(rs.getString("provolidate").compareTo(start)>=0  && rs.getString("provolidate").compareTo(end)<=0) 
					{
						out.println("<option value= "+rs.getInt("provoliid") +">"+rs.getString("cinemaname")+" "+rs.getString("movietitle")+" "+rs.getString("provolidate")+" | Seats Left : "+(user.seatsLeft(rs.getInt("provoliid")))+"</option>");
					}
				}
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		out.println("</select>");
		
		out.println("<select id='seats' name='seats'>");
		for (int seats =1 ;seats<=10; seats++)
		{
			out.println("<option value= "+ seats+">"+seats+"</option>");
			
		}
		
	
		
		
		out.println("</select>");
		out.println("<input type = 'submit'>");
		out.println("</form>");
	
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
