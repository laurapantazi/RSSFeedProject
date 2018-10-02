import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class Interests {

	
	
	public static void addInterests(int iduser,List<String> sections,List<String> interests) {
		Connection con;
		try {
			con = DBHandler.openConnection();
			Statement stmt;
			stmt = con.createStatement();
			
			for (int i=0;i<(interests.size()-1);i++)
			{
				String command = "INSERT INTO interests VALUES "
						+ "("+ iduser +",'" + sections.get(i) +"','" + interests.get(i)+ "')";
				stmt.executeUpdate(command);
			}
			
			
			stmt.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<String> users(int iduser)
	{
		List<String> allInterests=new LinkedList<>();		
		PreparedStatement ps;
		try {
			Connection con= DBHandler.openConnection();
			ps = con.prepareStatement("SELECT value FROM interests WHERE client="+iduser);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				allInterests.add(rs.getString("value"));
			}	
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return allInterests;
	}// end of method users
	
	
	public static List<InterestSections> interests(int iduser)
	{
		List<InterestSections> allInterests=new LinkedList<>();		
		PreparedStatement ps;
		try {
			Connection con= DBHandler.openConnection();
			ps = con.prepareStatement("SELECT section,value FROM interests WHERE client="+iduser);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				InterestSections is = new InterestSections(rs.getString("section"),rs.getString("value"));
				allInterests.add(is);
			}	
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return allInterests;
	}// end of method users
	
}
