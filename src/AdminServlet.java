

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String url = request.getParameter("url");
		HttpSession session=request.getSession();	
			if (Find.findFeed(url)==0)
			{
				Find.createRssFeed(title, url);
				request.setAttribute("message","New rss feed created successfully!");
				List<String> allFeeds=Find.rssFeeds();
				session.setAttribute("allRssFeeds",allFeeds);
			}
			else
			{
				request.setAttribute("message","This rss feed already exists.");
			}
		
		request.getRequestDispatcher("admin.jsp").include(request, response);
	
	}

}
