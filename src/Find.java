import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class Find {
	public static int findUser(String username){
		int user=0;
		Connection con;
		ResultSet rs;
		try {
			con = DBHandler.openConnection();
			Statement stmt;
			stmt = con.createStatement();
			rs = stmt.executeQuery(	"SELECT * FROM users WHERE username='" + username + "'");
			if (rs.next())   
			{
				user=rs.getInt("idUser");		
			}
			stmt.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return user;		
	}
	
	public static void findInterests(int userId){
		Connection con;
		ResultSet rs;
		try {
			con = DBHandler.openConnection();
			Statement stmt;
			stmt = con.createStatement();
			rs = stmt.executeQuery(	"SELECT * FROM interests WHERE idclientinterests=" + userId + "");
			while (rs.next())   
			{
				//user=rs.getInt("idUser");		
			}
			stmt.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		//return user;		
	}
	
	
	public static void createRssFeed(String title, String url) {
		Connection con;
		try {
			con = DBHandler.openConnection();
			Statement stmt;
			stmt = con.createStatement();			
			String command = "INSERT INTO rss_feed (title,url) VALUES ('" + title + "','"
						+ url + "')";
			stmt.executeUpdate(command);
			stmt.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static int findFeed(String url)
	{
		int feedid=0;
		Connection con;
		try {
		con = DBHandler.openConnection();
		Statement stmt;
		ResultSet rs;
		stmt = con.createStatement();
		rs = stmt.executeQuery(	"SELECT * FROM rss_feed WHERE url='" + url + "'");
		if (rs.next())   
		{
			feedid=rs.getInt("idfeed");
		}	
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return feedid;
	}
	
	public static List<String> rssFeeds()
	{
		List<String> showfeeds=new LinkedList<String>();
		Connection con;
		try {
		con = DBHandler.openConnection();
		Statement stmt;
		ResultSet rs;
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT title,url FROM rss_feed");
		while(rs.next()){
				//showfeeds.add(rs.getString("idfeed"));	
				showfeeds.add(rs.getString("title"));	
				showfeeds.add(rs.getString("url"));	

			}	
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return showfeeds;
	}
	
}
