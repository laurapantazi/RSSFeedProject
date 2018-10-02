<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	<!-- Top content -->
	<div class="top-content">
		<p>
			<i>News Feed</i>
		</p>
		<div class="inner-bg">
			<div class="container">
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">
						<div class="form-top">
							<div class="form-top-left">
							<p><i><%=session.getAttribute("message")%></i></p>
								<h3>Welcome User</h3>
								<p>Please, fill the following form:</p>
							</div>
							<div class="form-top-right">
								<i class="fa fa-user"></i>
							</div>
						</div>
						<div class="form-bottom">
							<form method="post" action="/FinalProject/SignUp"
								class="login-form">
								<input type="hidden" name="requestType" value="Insert" />
								<div class="form-group">
									<input type="text" name="name" placeholder="Enter name..."
										class="form-username form-control" id="form-username" >
								</div>
								<div class="form-group">
									<input type="text" name="surname" placeholder="Enter surname..."
										class="form-username form-control" id="form-username" >
								</div>
								<div class="form-group">
									<input type="text" name="username" placeholder="Enter username..."
										class="form-username form-control" id="form-username" >
								</div>
								<div class="form-group">
										<input type="password" name="password"
										placeholder="Enter password..."
										class="form-password form-control" id="form-password">
								</div>
								<button type="submit" class="btn">Sign Up</button>
							</form>
							<p>Already a member?  <a href="index.jsp">Login</a></p>			
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Javascript -->
	<script src="/FinalProject/Bootstrap/js/jquery-1.11.1.min.js"></script>
	<script src="/FinalProject/Bootstrap/bootstrap/js/bootstrap.min.js"></script>
	<script src="/FinalProject/Bootstrap/js/jquery.backstretch.min.js"></script>
	<script src="/FinalProject/Bootstrap/js/scripts.js"></script>
</body>
</html>