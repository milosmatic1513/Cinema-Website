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
import javax.servlet.http.HttpSession;

import mainpackage.Users;

/**
 * Servlet implementation class ViewHistory
 */
@WebServlet("/ViewHistory")
public class ViewHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewHistory() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("TopBar.jsp").include(request, response);
		HttpSession session = request.getSession(false);
		Users user = new Users();
		user.setUsername(session.getAttribute("uname").toString());

		ResultSet rs = null;

		rs = user.GetReservationHistory();
		out.println("<table>");
		out.println(
				"<tr><td><b>Movie Title</b></td><td><b>Cinema name</b></td><td><b>Date</b></td><td><b>Seats</b></td></tr>");
		try {
			while (rs.next()) {
				out.println("<tr><td>" + rs.getString("movietitle") + "</td><td>" + rs.getString("cinemaname")
						+ "</td><td>" + rs.getString("provolidate") + "</td><td>" + rs.getInt("seatsreserved")
						+ "</td></tr>");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		out.println("</table>");
	}

}
