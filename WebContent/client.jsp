<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList" import="java.util.HashMap" import=" java.util.LinkedList" 
    import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<link rel="shortcut icon" href="/FinalProject/WebContent/Bootstrap/ico/favicon.png">
<link href="/FinalProject/BootstrapFormHelpersCountries/dist/css/bootstrap-formhelpers.min.css" rel="stylesheet">
<title>News Feed</title>
</head>
<body>
	<!--Start Navigation -->
	<div class="navbar navbar-inverse top-navigation navbar-fixed-top">
		<div class="container">
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#home">Home</a></li>
					
					<li><a href="clientEditProfile.jsp">Edit Profile</a></li>
					
					<li><a href="index.jsp">Log Out</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!--End Navigation -->
	<!-- Top content -->
	<section>
	<div class="container">
		<div class="row">
			<div class="col-sm-8 col-sm-offset-2 form-box">
				
			</div>
		</div>
	</div>
	</section>	
	
	<section id="home">
	<div class="container">
		<div class="row">
			<div class="col-sm-8 col-sm-offset-2 form-box">
				<form method="get" action="/FinalProject/Home" >
					<input type="hidden" value="<%=session.getAttribute("iduser")%> ">
					
					<% boolean empty=(Boolean)session.getAttribute("empty");%>
					<% if (empty!=true) {%>
					<div class="form-top">
					<div class="form-top-left">
						<h3>News that you may find interesting</h3>
					</div>
					</div>
					<div class="form-bottom">
					<% List<String> x = (LinkedList<String>) session.getAttribute("titles");%>	
					<% List<String> y = (LinkedList<String>) session.getAttribute("links");%>	
									
					<% if (!(x.isEmpty())) { %>
						<table class="table">
							<% for(int i=0;i<x.size();i++) { %>

								<tr>
								<td><a href="<%=y.get(i)%>"><%=x.get(i)%></a></td>
								</tr>
								
								<%}%>	
							<%}%>
					<%}else{ %>
					<div class="form-top">
					<div class="form-top-left">
						<h3>There is no information about your interests </h3>
					</div>
					</div>
						
					<%}%>
							
					</table>
				
					
					
					
					
				</div>
			</form>
				
			</div>
		</div>
	</div>
	</section>
	<!--End About Section -->

	<!-- Javascript -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="/FinalProject/BootstrapFormHelpersCountries/dist/js/bootstrap-formhelpers.min.js"></script>
	<script src="/FinalProject/Bootstrap/js/jquery-1.11.1.min.js"></script>
	<script src="/FinalProject/Bootstrap/bootstrap/js/bootstrap.min.js"></script>
	<script src="/FinalProject/Bootstrap/js/jquery.backstretch.min.js"></script>
	<script src="/FinalProject/Bootstrap/js/scripts.js"></script>
</body>
</html>