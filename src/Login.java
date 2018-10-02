import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		session.invalidate();
		session=request.getSession(true);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String roleDB = " ";
		String loginNameDB = " ";
		String loginSurnameDB = " ";
		int iduser=0;

		try {
			Connection con = DBHandler.openConnection();
			Statement stmt = con.createStatement();
			PreparedStatement ps1=null;
			password=Hasher.hashPassword(password);
			ps1=con.prepareStatement(
					"select * from users where username='" + username + "' and password='" + password+"'");
			ResultSet rs=ps1.executeQuery();
			if (rs.next()) {
				iduser = rs.getInt("iduser");
				roleDB = rs.getString("role");
				loginNameDB = rs.getString("name");
				loginSurnameDB = rs.getString("surname");
				session.setAttribute("username", username);
				session.setAttribute("loginNameDB", loginNameDB);
				session.setAttribute("loginSurnameDB", loginSurnameDB);
				session.setAttribute("iduser", iduser);
				request.setAttribute("message","No changes saved yet.");
				if (roleDB.equals("admin")) {
					List<String> feedList=Find.rssFeeds();
					session.setAttribute("allRssFeeds",feedList);
					request.getRequestDispatcher("admin.jsp").include(request, response);
				} else if (roleDB.equals("client")) {
					request.getRequestDispatcher("/Home").include(request, response);
				} 
			} else {
				out.print("Wrong username or password!");
				request.getRequestDispatcher("index.jsp").include(request, response);
			}
			stmt.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		out.close();
	}
}