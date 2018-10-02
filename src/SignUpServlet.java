import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SignUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		session.invalidate();
		session=request.getSession(true);
		int id = Users.findLastId()+1;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = "client";
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");

			if (Find.findUser(username)==0)
			{
				Users.createUser(id,username,password,role,name,surname);
				request.getRequestDispatcher("index.jsp").include(request, response);
			}		
			else
			{
				session.setAttribute("message", "This username is already in use.Please use another one");
				request.getRequestDispatcher("signup.jsp").include(request, response);

			}
			out.close();

		} 

}
