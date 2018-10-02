import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EditProfile")
public class ClientEditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int id=(Integer) session.getAttribute("iduser");
		List<String> sections=new LinkedList<String>();
		List<String> values=new LinkedList<String>();
		boolean empty=true;
		System.out.println(request.getParameter("p1"));
		if (((request.getParameter("p1"))!=null) && !(request.getParameter("p1").isEmpty())) 
		{String s =request.getParameter("p1");
		String[] arr = s.split(",");    

		 for ( String ss : arr) {
			 sections.add("countries");
			 values.add(ss);
		  }
		}
		
		
		if (((request.getParameter("p2"))!=null) && !(request.getParameter("p2").isEmpty())) {
			String s =request.getParameter("p2");
		String[] arr = s.split(",");    

		 for ( String ss : arr) {
			 sections.add("topics");
			 values.add(ss);
		  }}
		
		
		if (((request.getParameter("p3"))!=null) && !(request.getParameter("p3").isEmpty())) 
		{String s =request.getParameter("p3");
		String[] arr = s.split(",");    

		 for ( String ss : arr) {
			 sections.add("sports");
			 values.add(ss);
		  }}
		
		
		if (((request.getParameter("p4"))!=null) && !(request.getParameter("p4").isEmpty()))
		{String s =request.getParameter("p4");
		String[] arr = s.split(",");    

		 for ( String ss : arr) {
			 sections.add("travel");
			 values.add(ss);
		  }}
		
		
		if (((request.getParameter("p5"))!=null) && !(request.getParameter("p5").isEmpty())) 
		{String s =request.getParameter("p5");
		String[] arr = s.split(",");    

		 for ( String ss : arr) {
			 sections.add("style");
			 values.add(ss);
		  }}
		
		
		if (((request.getParameter("p6"))!=null) && !(request.getParameter("p6").isEmpty())) 
		{String s =request.getParameter("p6");
		String[] arr = s.split(",");    

		 for ( String ss : arr) {
			 sections.add("other");
			 values.add(ss);
		  }}
		
		//store interests of person with idCode id in database
		Interests.addInterests(id,sections,values);
		
		List<String> interests=Interests.users(id);
		List<String> urllist=new LinkedList<String>();
		if (!(interests.isEmpty()))
		{
			empty=false;
			List<Urls> urls = Search.searchFeeds(interests);
			List<String> titles=new LinkedList<String>(); 
			List<String> links= new LinkedList<String> (); 
			
			for (int i=0; i<urls.size(); i++){
				   Urls row = (Urls) urls.get(i);
				   titles.add(row.getTitle());
				   links.add(row.getUrl());
				   
			}	
			session.setAttribute("titles", titles);	
			session.setAttribute("links", links);
		}
		session.setAttribute("empty", empty);
		
		//session.setAttribute("urllist", urllist);		
		request.getRequestDispatcher("clientEditProfile.jsp").include(request, response);		
	}

}
