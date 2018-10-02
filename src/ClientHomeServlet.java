import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Home")
public class ClientHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String countries="";
	String sports="";
	String topics="";
	String travel="";
	String style="";
	String other="";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean empty=true;
		HttpSession session=request.getSession();
		int id=(Integer) session.getAttribute("iduser");
		
		List<InterestSections> islist=Interests.interests(id);
		for (int i=0; i<islist.size(); i++){
			InterestSections row = (InterestSections) islist.get(i);
			if (row.getSection().equals(countries))
			{
				if (!countries.isEmpty()) countries=countries.concat(",");
				countries=countries.concat(row.getValue());
			}
			else if (row.getSection().equals(sports))
			{
				if (!sports.isEmpty()) sports=sports.concat(",");
				sports=sports.concat(row.getValue());
			}
			else if (row.getSection().equals(travel))
			{
				if (!travel.isEmpty()) travel=travel.concat(",");
				travel=travel.concat(row.getValue());
			}
			else if (row.getSection().equals(style))
			{
				if (!style.isEmpty()) style=style.concat(",");
				style=style.concat(row.getValue());
			}
			else if (row.getSection().equals(topics))
			{
				if (!topics.isEmpty()) topics=topics.concat(",");
				topics=topics.concat(row.getValue());
			}
			else if (row.getSection().equals(other))
			{
				if (!other.isEmpty()) other=other.concat(",");
				other=other.concat(row.getValue());
			}
		}

		
		//get a list with the client interests from database 
		List<String> interests=Interests.users(id);
		//ArrayList<String> urllist=new ArrayList<String>();
		//List<String> urllist=new LinkedList<String>();
		List<String> links=new LinkedList<String>();
		List<String> titles=new LinkedList<String>();

		List<Urls> urls = new LinkedList<Urls>();		
		if (!(interests.isEmpty()))
		{
			empty=false;
			urls=Search.searchFeeds(interests);		
			for (int i=0; i<urls.size(); i++){
				   Urls row = (Urls) urls.get(i);
				   titles.add(row.getTitle());
				   links.add(row.getUrl());
				   
				}
		}
		session.setAttribute("countries", countries);
		session.setAttribute("sports", sports);
		session.setAttribute("travel", travel);
		session.setAttribute("style", style);
		session.setAttribute("topics", topics);
		session.setAttribute("other", other);
		
		session.setAttribute("empty", empty);
		session.setAttribute("links", links);
		session.setAttribute("titles", titles);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		request.getRequestDispatcher("client.jsp").include(request, response);	
		
	}

}
