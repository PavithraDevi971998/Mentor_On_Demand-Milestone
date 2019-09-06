<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Mentor On Demand</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
body {
	background-color: lightgray;
}

.head {
	height: 70px;
	width: 100%;
	background-color: #5c96f2;
	text-align: center;
	font-size: 30px;
}

.card-header {
	text-align: center;
	font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	color: red;
	font-size: 25px;
}
</style>
</head>
<body>
	<div class="head">
		<marquee>Mentor On Demand</marquee>
	</div>
	<form:form method="POST" action="/addSkills" modelAttribute="skill">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<div class="card">
						<div class="card-header">Skills</div> Registration</div>
						<div class="card-body">

							<div class="form-group">
								<label for="name" class="cols-sm-2 control-label">Skill
									Name</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-user fa" aria-hidden="true"></i></span>
										<form:input type="text" class="form-control" name="skillName"
											path="skillName" id="skillName"
											placeholder="Enter the skill Name" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="email" class="cols-sm-2 control-label">Your
									Email</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-envelope fa" aria-hidden="true"></i></span>
										<form:input type="text" class="form-control" name="baseAmount"
											path="baseAmount" id="baseAmount"
											placeholder="Enter the base amount" />
									</div>
								</div>
							</div>
							<div class="form-group ">
								<input type="submit"
									class="btn btn-primary btn-lg btn-block login-button">
							</div>
						</div>
					</div>
				</div>
	</form:form>
</body>
</html>