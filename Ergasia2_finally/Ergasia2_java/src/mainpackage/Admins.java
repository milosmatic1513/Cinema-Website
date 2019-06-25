package mainpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.postgresql.util.PSQLException;

import com.mit.ConnectionProvider;

public class Admins extends Users {
	
	
	public Admins() 
	{
	}
	public Admins(String fname, String user, String pass)
	{
		super(fname,user,pass);
		
	}
	
	public  String promoteUserTo(int userid,String status)
	{
	    Connection conn;
		PreparedStatement pst;
		conn = ConnectionProvider.getCon();
		if (status.equals("ContentAdmin"))
		{
			try {
				pst = conn.prepareStatement("insert into contentadmins values(?)");
				pst.setInt(1, userid);
				pst.executeQuery();
			} catch (PSQLException a) {
				if(a.getSQLState().equals("23505"))
				{
					return "User Is Already Content Admin";
				}
				else if(a.getSQLState().equals("02000"))
				{
					return "Successful Promotion to Content Admin";
				}
				else 
				{
					return "Oh my what happened???";
				}
				
				
			}catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		else if(status.equals("Admin"))
		{
			try {
				pst = conn.prepareStatement("insert into admins values(?)");
				pst.setInt(1, userid);
				pst.executeQuery();
			} 
			catch (PSQLException a) {
				if(a.getSQLState().equals("23505"))
				{
					return "User Is Already Admin";
				}
				else if(a.getSQLState().equals("02000"))
				{
					return "Successful Promotion to Admin";
				}
				else 
				{
					return "Oh my what happened???";
				}
			}catch (SQLException e) {
				e.printStackTrace();
				
			}
			
		}
		return "error";
		
	}
	
	public ResultSet GetAllUsers() {
		ResultSet results = null;
	    Connection conn;
		PreparedStatement pst;
		
		conn = ConnectionProvider.getCon();
		try {
			pst = conn.prepareStatement("select * from clients where clientid != ? ");
			pst.setInt(1, this.getId());
			results = pst.executeQuery();
			conn.close();
			return results;
		} 
		catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

	}
	
	public ResultSet GetAllContent() {
		ResultSet results = null;
	    Connection conn;
		PreparedStatement pst;
		
		conn = ConnectionProvider.getCon();
		try {
			pst = conn.prepareStatement("select clients.clientid as clientid, clientname from clients inner join contentadmins on (clients.clientid = contentadmins.clientid) ");
		
			results = pst.executeQuery();
			conn.close();
			return results;
		} 
		catch (SQLException e) {

			e.printStackTrace();
			return null; 
		}

	}
	public void DeleteConAdmin(int id) {
	    Connection conn;
		PreparedStatement pst;
		
		conn = ConnectionProvider.getCon();
		try {
			pst = conn.prepareStatement("delete from contentadmins where clientid=?");
			pst.setInt(1, id);
			pst.executeQuery();
			conn.close();
			
		} 
		catch (SQLException e) {

			e.printStackTrace();
		}

	}
}

