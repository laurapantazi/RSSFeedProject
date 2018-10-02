<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<title>News Feed</title>
</head>
<body>
	<!--Start Navigation -->
	<div class="navbar navbar-inverse top-navigation navbar-fixed-top">
		<div class="container">
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="client.jsp">Home</a></li>
					<li><a href="#editProfile">Edit Profile</a></li>
					<li><a href="index.jsp">Log Out</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!--End Navigation -->
	<!-- Top content -->
	<section id="editProfile">
	<div class="container">
		<div class="row">
			<div class="col-sm-8 col-sm-offset-2 form-box">
				<div class="form-top">
					<div class="form-top-left">
					 <input type="hidden" value="<%=session.getAttribute("iduser")%> ">
						<h3>Profile</h3>
						<p>Please fill the following form, according to your personal interests:</p>
					</div>
					<div class="form-top-right">
						<i class="fa fa-database"></i>
					</div>
				</div>
				<div class="form-bottom">
					<form method="post" action="/FinalProject/EditProfile" class="login-form">
						<input type="hidden" name="requestType" value="Insert"/>			
						
						<h4>Countries of interest (e.g. Europe,US,Africa,Asia,China,Middle East)</h4>					
						<div class="form-group row">
						<label class="col-xs-12">
					      <input type="text" class="form-control" name="p1">
					    </label>
						</div>
						<hr>		
						
							
						<h4>Main Topics (e.g. politics,economy,weather)</h4>
						<div class="form-group row">
						<label class="col-xs-12">
					      <input class="form-control" name="p2">
					    </label>
						</div>
						<hr>		
						
						<h4>Sports (e.g. football,tennis,basket,golf,horseracing,motorsport,sailing,skiing)</h4>
						<div class="form-group row">
						<label class="col-xs-12">
					      <input class="form-control" name="p3">
					    </label>
						</div>
						<hr>
						
						<h4>Travel (e.g. food,drinks,destinations,hotels) </h4>
						<div class="form-group row">
						<label class="col-xs-12">
					      <input class="form-control" name="p4">
					    </label>
						</div>				
						<hr>
						
						<h4>Style (e.g. fashion,design,architecture,arts,autos,luxury)</h4>
						<div class="form-group row">
						<label class="col-xs-12">
					      <input class="form-control" name="p5">
					    </label>
						</div>
						<hr>
						
						<h4>Other topics</h4>
						<div class="form-group row">
						<label class="col-xs-12">
					      <input  class="form-control" name="p6">
					    </label>
						</div>
						<button type="submit" class="btn">Save</button>						
					</form>
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