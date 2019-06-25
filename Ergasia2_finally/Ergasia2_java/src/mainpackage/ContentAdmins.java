package mainpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.postgresql.util.PSQLException;

import com.mit.ConnectionProvider;

public class ContentAdmins extends Users {
	public ContentAdmins() {

	}

	public ContentAdmins(String fname, String user, String pass) {
		super(fname, user, pass);

	}

	public void insertFilm(String title) {
		Connection conn;
		PreparedStatement pst;
		conn = ConnectionProvider.getCon();
		try {
			pst = conn.prepareStatement("insert into movies(movietitle) values(?)");
			pst.setString(1, title);
			
			pst.executeQuery();
			conn.close();

		}

		catch (SQLException e) 
		{
			e.printStackTrace();
			return;
		}

	}

	public void SetProvoli(String cinemaid, String movieid, String date) {

		Connection conn;
		PreparedStatement pst;
		conn = ConnectionProvider.getCon();

		
		try {
			int cinemaidint = Integer.parseInt(cinemaid);
			int movieidint = Integer.parseInt(movieid);

			pst = conn.prepareStatement("insert into provoles(cinemaid,movieid,provolidate) values(?,?,cast(? as date))");
			pst.setInt(1, cinemaidint);
			pst.setInt(2, movieidint);
			pst.setString(3, date);
			pst.executeQuery();
			conn.close();

		}
		catch(PSQLException a)
		{
			System.out.println(a);
			return;
		}
		catch (Exception e) {
			System.out.println(e);
			return;
		}

	}
}
