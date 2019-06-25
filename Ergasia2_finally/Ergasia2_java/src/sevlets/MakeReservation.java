package sevlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mainpackage.Users;

/**
 * Servlet implementation class MakeReservation
 */
@WebServlet("/MakeReservation")
public class MakeReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeReservation() {
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
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("TopBar.jsp").include(request, response);
		try {
			Users user = new Users();
			HttpSession session=request.getSession(false);  
			user.setUsername(session.getAttribute("uname").toString());
			
			int seats_to_reserve = Integer.parseInt(request.getParameter("seats"));
			int provoliid=Integer.parseInt(request.getParameter("provoli"));
			int seats_left = user.seatsLeft(provoliid);
			
			if(seats_to_reserve > seats_left)
			{
				out.println("<h1>Not Enough Seats Left</h1>");
			}
			else
			{
				user.Reserve(provoliid, seats_to_reserve);
				out.println("<h1>Successful Reservation</h1>");
			}
		}
		catch(Exception e) 
		{
			out.println("<h1>There has been an error</h1>");
		}
	}

}
