import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Search {

	public static List<String> searchParameters(List<String> parameters) throws MalformedURLException {
		Map<String, String> returnfeeds= new HashMap<String, String>();		
		//ArrayList<String> returnlist= new ArrayList<String>();
		List<String> returnlist= new LinkedList<String>();
		
		List<String> list=readRssFeed();
    	
		for(int j=0;j<list.size();j++)
		{
			
			
	        RssFileReader parser = new RssFileReader(list.get(j));
	        RssFeed feed = parser.readFeed();	
	        for (RssFile message : feed.getMessages()) {
	        	//System.out.println(parameters.size()+"SIZEE");
	            for(int i=0;i<parameters.size();i++)
	            {
	        	if (message.containsText(parameters.get(i)))
	        		{//System.out.println("AAA"+parameters.get(i)+message);
	        		returnlist.add(message.getLink());
	        		
	        		}
	        	}	
	        }
		}   
        return returnlist;
	}
	
	
	
	
	
	public static List<Urls> searchFeeds(List<String> parameters) throws MalformedURLException {
		
		List<Urls> returnlist= new LinkedList<Urls>();
		
		List<String> list=readRssFeed();
    	
		for(int j=0;j<list.size();j++)
		{	
	        RssFileReader parser = new RssFileReader(list.get(j));
	        RssFeed feed = parser.readFeed();
	
	        for (RssFile message : feed.getMessages()) {
	            for(int i=0;i<parameters.size();i++)
	            {
	        	if (message.containsText(parameters.get(i)))
	        		{		
	        			Urls u1 = new Urls(message.getTitle(), message.getLink());
	        			returnlist.add(u1);   		
	        		}
	        	}
	
	        }
		}
		return returnlist;
	}
	public static List<String> readRssFeed()
	{
		List<String> list=new LinkedList<String>();
		int number;
		String title,url;

		try {
			Connection con = DBHandler.openConnection();
			Statement stmt = con.createStatement();
			PreparedStatement ps1=null;
			ps1=con.prepareStatement(
					"select * from rss_feed ");
			ResultSet rs=ps1.executeQuery();
			while (rs.next()) {
				//number = rs.getInt("idfeed");
				title = rs.getString("title");
				url = rs.getString("url");
				list.add(url);
			} 
			stmt.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}
