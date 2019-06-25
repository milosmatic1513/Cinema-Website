package mainpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mit.ConnectionProvider;
import com.mit.MD5;

public class Users {
	private String fullName, username, password;

	public Users() {
		fullName = "NotSet";
		username = "NotSet";
		password = "NotSet";

	}

	public Users(String fname, String u, String p) {

		fullName = fname;
		username = u;
		password = p;

	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String GetData() {
		return "Full Name : " + fullName + " Username : " + username + " Password : " + password;
	}

	protected int getId() 
	{
		
		Connection conn;
		PreparedStatement pst;
		conn = ConnectionProvider.getCon();

		try
		{
			pst = conn.prepareStatement("select clientid from clients where clientuser=?");
			pst.setString(1, this.getUsername());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) 
			{
				return rs.getInt("clientid");
			}
		}
		catch (Exception e )
		{
			return -1;
		}
		return -1;
	}
	
	public int login() {
		Connection conn;
		PreparedStatement pst;
		ResultSet results = null;
		try {

			conn = ConnectionProvider.getCon();
			pst = conn.prepareStatement("select salt,hashpass from clients where clientuser=?");
			pst.setString(1, this.getUsername());
			results = pst.executeQuery();

			while (results.next()) {
				byte[] clients_salt = results.getBytes("salt");
				// Get value sales from cursor
				String clients_hash = results.getString("hashpass");
				// Print values

				// password check

				String password = this.getPassword();

				String current_hassed_pass = MD5.make_hash(password, clients_salt);

				if (current_hassed_pass.equals(clients_hash)) {
					int status =1 ;  //--- Customer
					
					//Content Admin========================================================================================================
					pst = conn.prepareStatement("select * from clients inner join contentadmins on(clients.clientid=contentadmins.clientid) where hashpass= ? and clientuser=?;");
					
					pst.setString(1, clients_hash);
					
					pst.setString(2, username);
					
					results = pst.executeQuery();
					
					
					while(results.next())
					{
						status =3 ;  //--- Content Admin
					}
					
					//Admin========================================================================================================
					pst = conn.prepareStatement("select * from clients inner join admins on(clients.clientid=admins.clientid) where hashpass= ? and clientuser=?;");
					
					pst.setString(1, clients_hash);
					
					pst.setString(2, username);
					
					results = pst.executeQuery();
					
					
					while(results.next())
					{
						status =4 ;  //--- Admin
					}
					
					conn.close();
					return status;
					
				} else {

					conn.close();
					return 2;  //--- Password Missmatch
				}

			}

		}

		catch (Exception ex) {
			System.out.println(ex);
		}
		return 0;
	}

	public int Reserve(int provoliId,int seats) {
		Connection conn;
		PreparedStatement pst;
		ResultSet results = null;
		try {

			conn = ConnectionProvider.getCon();
			pst = conn.prepareStatement("insert into reservations(provoliid,clientid,seatsreserved) values(?,?,?)");
			pst.setInt(1, provoliId);
			pst.setInt(2, this.getId());
			pst.setInt(3, seats);

			results = pst.executeQuery();

			
		}

		catch (Exception ex) {
			System.out.println(ex);
		}
		return 0;
	}

	public int seatsLeft(int provoliid) 
	{
		Connection conn;
		PreparedStatement pst;
		ResultSet results = null;
		try {

			conn = ConnectionProvider.getCon();
			pst = conn.prepareStatement("select reservations.provoliid  , cinemaseats-sum(seatsreserved)as seatsleft,sum(seatsreserved) as seatsreseved from reservations " + 
					"inner join provoles on(reservations.provoliid = provoles.provoliid) " + 
					"inner join cinemas on(cinemas.cinemaid = provoles.cinemaid)"+
				    "where provoles.provoliid=? group by reservations.provoliid  , cinemaseats" );
			pst.setInt(1, provoliid);
			results = pst.executeQuery();
			while(results.next())
			{
				
				return results.getInt("seatsleft");
			}
			
			pst= conn.prepareStatement("select cinemaseats from cinemas inner join provoles on (cinemas.cinemaid=provoles.cinemaid) where provoliid =?");
			pst.setInt(1, provoliid );
			results = pst.executeQuery();
		
			while(results.next())
			{
				return results.getInt("cinemaseats");
			}
			return -1;
			
		}

		catch (Exception ex) {
			System.out.println(ex);
			

		}
		return -1;
	}
	
	public ResultSet GetReservationHistory()
	{
		
		Connection conn;
		PreparedStatement pst;
		ResultSet results = null;
		try {

			conn = ConnectionProvider.getCon();
			pst = conn.prepareStatement("select movietitle ,cinemaname ,provolidate ,seatsreserved   " + 
					"from reservations inner join provoles on (reservations.provoliid = provoles.provoliid)" + 
					"inner join movies on( provoles.movieid = movies.movieid)" + 
					"inner join cinemas on( provoles.cinemaid = cinemas.cinemaid) where clientid = ?");
			pst.setInt(1, this.getId());
			

			results = pst.executeQuery();
			return results;
			
		}

		catch (Exception ex) {
			System.out.println(ex);
			return results;

		}

	}
	
	public static ResultSet GetAllMovies() {
		ResultSet results = null;
		PreparedStatement pst;
		Connection conn;
		try {
			conn = ConnectionProvider.getCon();
			pst = conn.prepareStatement("select movietitle , movieid from movies ");
			results = pst.executeQuery();
			conn.close();
			return results;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}
	
	public static ResultSet GetAllProvoles() {
		ResultSet results = null;
		PreparedStatement pst;
		Connection conn;
		try {
			conn = ConnectionProvider.getCon();
			pst = conn.prepareStatement("select provoliid,cinemaname,movietitle,provolidate,cinemaseats  from provoles  " + 
					"inner join cinemas on (provoles.cinemaid = cinemas.cinemaid)" + 
					"inner join movies on (provoles.movieid = movies.movieid);");
			results = pst.executeQuery();
			conn.close();
			return results;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}
	
	public static ResultSet GetAllCinemas() {
		ResultSet results = null;
		PreparedStatement pst;
		Connection conn;
		try {
			conn = ConnectionProvider.getCon();
			pst = conn.prepareStatement("select cinemaname , cinemaid ,is3d from cinemas ");
			results = pst.executeQuery();
			conn.close();
			return results;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}
	
	public int insertUser() {
		int status = 0;
		PreparedStatement pst;
		Connection conn;
		try {

			byte[] salt = MD5.generate_salt();
			String salt_hash = MD5.make_hash(this.getPassword(), salt);

			conn = ConnectionProvider.getCon();
			pst = conn.prepareStatement("insert into clients(hashpass,salt, clientname, clientuser) values (?,?,?,?)");
			pst.setString(4, this.getUsername());
			pst.setString(3, this.getFullName());
			pst.setString(1, salt_hash);
			pst.setBytes(2, salt);

			status = pst.executeUpdate();
			conn.close();

			status = 1;

		}

		catch (Exception ex) {
			System.out.println(ex);

			status = 2;
		}
		return status;
	}
}
