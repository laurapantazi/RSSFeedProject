<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.LinkedList" import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet"
	href="/FinalProject/Bootstrap/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/FinalProject/Bootstrap/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="/FinalProject/Bootstrap/css/form-elements.css">
<link rel="stylesheet" href="/FinalProject/Bootstrap/css/style.css">
<link rel="shortcut icon" href="/FinalProject/Bootstrap/ico/favicon.png">
<title>News Feed</title>
</head>
<body>
	<!--Start Navigation -->
	<div class="navbar navbar-inverse top-navigation navbar-fixed-top">
		<div class="container">
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#home">Home</a></li>
					<li><a href="#createFeed-section">Create Rss Feed</a></li>
					<li><a href="#showFeeds-section">View Rss Feeds</a></li>
					<li><a href="index.jsp">Log Out</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!--End Navigation -->
	<!-- Top content -->
	<section id="home">
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3 form-box">
				<div class="form-top">
					<div class="form-top-left">
						<h3>
							Welcome admin <i><%=session.getAttribute("loginNameDB")%><i> </i> <%=session.getAttribute("loginSurnameDB")%></i></h3>
						<p style="color:#FF9135;"><b><%=request.getAttribute("message")%></b></p>
					</div>
					<div class="form-top-right">
						<!--  εικονίδιο-->
						<i class="fa fa-user"></i>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
 
	
	

	<section id="createFeed-section">
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3 form-box">
				<div class="form-top">
					<div class="form-top-left">
						<h3>Create Rss Feed</h3>
						<p>Please fill the following form:</p>
					</div>
					<div class="form-top-right">
						<i class="fa fa-database"></i>
					</div>
				</div>
				<div class="form-bottom">
					<form method="post" action="/FinalProject/Admin"
						class="login-form">
						<input type="hidden" name="requestType" value="Insert" />
						<div class="form-group">
							<input type="text" name="title"
								placeholder="Enter title..."
								class="form-username form-control" id="form-username">
						</div>
						<div class="form-group">
							 <input type="text" name="url"
								placeholder="Enter url..."
								class="form-username form-control" id="form-username">
						</div>
						<button type="submit" class="btn">Create Rss Feed</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	</section>
	
	<section id="showFeeds-section">
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3 form-box">
				<div class="form-top">
					<div class="form-top-left">
						<h3>List of all Rss Feeds</h3>
					</div>
				</div>
				<div class="form-bottom">
					<% List<String> u = (LinkedList<String>) session.getAttribute("allRssFeeds");%>
						<% if (!(u.isEmpty())) { %>
							<table class="table">
								<tr>
									<th border="1"><b>Title</b></th>
									<th border="1"><b>Url</b></th>
								</tr>	
								<% for (int i = 0; i <  u.size(); i +=2) { %>	
								<tr>
									<td><%=u.get(i)%></td>
									<td><%=u.get(i+1)%></td>
								</tr>	
								<%}%>
						</table>
					<%}%>					
				</div>
			</div>
		</div>
	</div>
	</section>
	
	<!--End About Section -->

	<!-- Javascript -->
	<script src="/FinalProject/Bootstrap/js/jquery-1.11.1.min.js"></script>
	<script src="/FinalProject/Bootstrap/bootstrap/js/bootstrap.min.js"></script>
	<script src="/FinalProject/Bootstrap/js/jquery.backstretch.min.js"></script>
	<script src="/FinalProject/Bootstrap/js/scripts.js"></script>
</body>
</html>