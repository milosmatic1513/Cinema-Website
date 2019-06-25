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

import mainpackage.Admins;
import mainpackage.Users;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Profile() {
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
		

		//No cache
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.
		
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);

		request.getRequestDispatcher("TopBar.jsp").include(request, response);
		
		try {
			String status = (String) session.getAttribute("status");
			String username = (String) session.getAttribute("uname");
			if (username != null) {
				out.println("<html>");
				
				out.println("<style>");
				out.println(
					    ".button { "+ 
						"  background-color: #4CAF50;" + 
						"  color: white;" + 
						"  padding: 14px 20px;" + 
						"  margin: 8px 0;" + 
						"  border: none;" + 
						"  cursor: pointer;" + 
						"  align:center"+
						"}");
				out.println(
					    ".textfield { "+  
						"  padding: 14px 20px;" + 
						"  margin: 8px 0;" + 
						"  cursor: pointer;" + 
						"  align:center"+
						"}");
				
				
				out.println("</style>");
				
				out.println("<body>" + "<h2>Userame : " + username + "</h2>" + "<h2>Privileges : " + status
						+ " </h2>");
				
				out.println("<hr><form action = 'GetMovies' method = 'post'>"
						+ "<input class = 'button' type = 'submit' value = 'Search Movies'>" + "</form><hr>"
	
				);
				out.println("<hr><form action = 'GetProvoles' method = 'post'>"
						+ "<input class = 'button' type = 'submit' value = 'Search Viewings'>" + "</form><hr>"
	
				);
				// select provoli
				out.println("<hr><form action = 'ProvoliSelection' method = 'post'>"
						+ "<input class = 'button' type = 'submit' value = 'Select Viewing'>" + "</form><hr>"
	
				);
				out.println("<hr><form action = 'ViewHistory' method = 'post'>"
						+ "<input class = 'button' type = 'submit' value = 'View History'>" + "</form><hr>"
	
				);
				if (status.equals("Content admin")) {
					// insert movie
					out.println("<hr><form action = 'InsertMovie' method = 'post'>"
							+ "<input class = 'button' type = 'submit' value = 'Insert Movies'>"
							+ "<input class='textfield' type = 'text' name = 'film' placeholder='movie' required >" + "</form><hr>"
	
					);
	
					ResultSet movies = null;
					ResultSet cinemas = null;
	
					movies = Users.GetAllMovies();
					cinemas = Users.GetAllCinemas();
	
					// insert provoli
					out.println("<hr>" + "<form action='InsertProvoli' method='post'>" + "<p>" + "Movie :"
							+ "<select id='movie' name='movie'>");
	
					try {
						while (movies.next()) {
							out.println("<option value = '" + movies.getInt("movieid") + "'>");
							String movie = movies.getString("MovieTitle");
							out.println(movie);
							out.println("</option>");
						}
					} catch (SQLException e) {
						out.println(e);
						out.println("<option>No Movies Found</option>");
					}
	
					out.println("</select>" + "</p>" + "<p>Cinema :"
	
							+ "<select id='cinema' name='cinema'>");
	
					try {
						while (cinemas.next()) {
							out.println("<option value = " + cinemas.getInt("cinemaid") + ">");
							String cinema = cinemas.getString("cinemaname");
							out.println(cinema);
							out.println("</option>");
						}
					} catch (SQLException e) {
						out.println(e);
						out.println("<option>No Cinemas Found</option>");
					}
	
					out.println("</select></p>" +
	
							"<p>3d : <input id='3d' name='3d' type='checkbox' /></p>" +
	
							"<p>Date : <input type='date' name ='date' required/></p>" +
	
							"<p><input class = 'button' type='submit' value='Insert Provoli' /></p>" +
	
							"</form><hr>");
				} else if (status.equals("Admin")) {
					
					Admins admin= new Admins();
					admin.setUsername(session.getAttribute("uname").toString());
					ResultSet rs= admin.GetAllUsers();
					
					out.println("<form action = 'PromoteUser' method='post'>");
					
					out.println("<select name='userid'>");
					
					try {
						while(rs.next())
						{
							out.println("<option value = "+rs.getInt("clientid")+">"+rs.getString("clientname")+"</option>");
						}
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					out.println("</select>");
					out.println("<select name='status'>");
					out.println("<option value = 'ContentAdmin'>Content Admin</option>");
					out.println("<option value = 'Admin'>Admin</option>");
					out.println("</select>");
					
					
					out.println("<input class = 'button' name = 'content' type='submit' value ='Promote' >");
	
	
					out.println("</form>");
					
					
					out.println("<hr>");
					out.println("<form action = 'DeleteContent' method='post'>");
					
					out.println("<select name='userid'>");
					ResultSet allcontent= admin.GetAllContent();
					try {
						while(allcontent.next())
						{
							out.println("<option value = "+allcontent.getInt("clientid")+">"+allcontent.getString("clientname")+"</option>");
						}
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					out.println("</select>");
					
					
					out.println("<input class = 'button' type='submit' value ='Delete Content Admin' >");
	
	
					out.println("</form>");
					
					
				}
	
				out.println("</body>");
	
			}
	
			else 
			{
				out.println("<h1 align='center'>Login first!</h1>");
			}
	
			}
		catch(NullPointerException e)
		{
			out.println("<h1 align='center'>Login first!</h1>");
		}
	}

}
