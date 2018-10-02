import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Users {

	public static void createUser(int iduser,String username, String password, String role, String name, String surname) {
		Connection con;
		try {
			con = DBHandler.openConnection();
			Statement stmt;
			stmt = con.createStatement();
			password=Hasher.hashPassword(password);
			String command = "INSERT INTO users (iduser,username,password,role,name,surname) VALUES "
					+ "("+ iduser +",'" + username + "','" + password + "','" + role + "','" + name + "','" + surname + "')";
			stmt.executeUpdate(command);		
			stmt.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	

	public static ArrayList<String> users()
	{
		ArrayList<String> showUsers=new ArrayList<>();		
		PreparedStatement ps;
		try {
			Connection con= DBHandler.openConnection();
			ps = con.prepareStatement("SELECT name,surname,username,role FROM users ORDER BY role");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				showUsers.add(rs.getString("name"));	
				showUsers.add(rs.getString("surname"));		
				showUsers.add(rs.getString("username"));		
				showUsers.add(rs.getString("role"));		

			}	
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return showUsers;
	}// end of method users
	
	
	public static int findLastId()
	{
		int lastId = 0;
		try {
			Connection con = DBHandler.openConnection();
			Statement ps=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=ps.executeQuery("SELECT iduser FROM users");
			if (rs.last()){
				lastId = rs.getInt("iduser");
			}
			ps.close();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return lastId;
	}
	
}
