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
 * Servlet implementation class SetProvoli
 */
@WebServlet("/SetProvoli")
public class SetProvoli extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SetProvoli() {
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
		ResultSet rs = Users.GetAllMovies();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// ==============================================style===============================================================================================================================

		out.println("<html>");
		out.println("<body>");
		out.println(
				"<style>.button {background-color: #4CAF50;color: white;padding: 14px 20px;margin: 8px 0; border: none;cursor: pointer;}.button:hover {opacity: 0.8;}</style>");
		out.println("<form method='post' action = 'InsertProvoli'>");
		// ==============================================movies===============================================================================================================================

		out.println("Movie<select  name ='movieid'>");
		
		try {
			while (rs.next()) {
				out.println(
						"<option value='" + rs.getInt("movieid") + "' >" + rs.getString("movietitle") + "</option>");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		out.println("</select>");

		

	
		// ==============================================cinemas===============================================================================================================================

		rs = Users.GetAllCinemas();
		out.println("Cinema<select  name ='cinemaid'>");
		
		try {
			while (rs.next()) {
				out.println(
						"<option  value='" + rs.getInt("cinemaid") + "' >" + rs.getString("cinemaname") + "</option>");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		out.println("</select>");

		

	
		// ==============================================date===============================================================================================================================
		
		// ==============================================date===============================================================================================================================
		
		
		out.println("<input type=\"date\" name='date' required>"  );
		out.println("<input id = 'movieId' name='movieid'   hidden>");
		out.println("<input id = 'cinemaid' name='cinemaid' hidden>");
		out.println("<input name='contentid' value = '"+request.getParameter("name")+"' hidden>");
		out.println("<input type = 'submit'>");
		out.println("</form>");
		
		
		out.println("</body>");
		out.println("</html>");
	}

}
