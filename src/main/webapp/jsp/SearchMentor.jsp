<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Mentor On Demand</title>
<style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
	background-color:  #e0ebeb;
}

.topnav {
  overflow: hidden;
  background-color: #333;

 
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
   padding-right:170px;
   width:20%;
    background-color: #ff9900;
}

.topnav a:hover {
  background-color: brown;
  color: black;
}

.topnav a.active {
  background-color: brown;
     color: brown;
}
  .head{
		height:70px;
		width:100%;
		background-color:#5c96f2;
		text-align:center;
		font-size:30px;
		}



.bord {
	
	height: 600px;
	width: 100%;
	margin-left: 45px;
	
}


th{
padding-left:500px;
padding-bottom:20px;}
.bton{
padding-left:500px;
}
table#table1 {
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	width: 100px;
	margin-top: 70px;
}

</style>
</head>
<body>
	<div class="head">
		<marquee>Mentor On Demand</marquee>
	</div>
	<p style="text-align: center; font-size: 32px;">Search Mentor</p>
	<br>
	<div class="bord">
		
		<div class="topnav">
             <a  href="/searchMentor">Search Training</a>
          <a href="/searchMentorTime">Current Training</a>
          <a href="/adminmentorList">Completed Training</a>
          <a href="/mentorList">Search</a>
          <a href="login">Logout</a>
        </div><br>
		
	<form:form method="POST" action="/searchMentor" modelAttribute="c1"><br><br>
			<table id="#table1 ">
		
			<tr>
				<th>Technology Name:</th>
				<td style="padding-left:50px"><form:input path="technology" type="text" />
				<br>
				<form:errors path="technology" class="text-danger" /></td></tr>
			
			<tr>

			</table>
		<div class="bton"><input type="submit" name="submit"  value="submit"> </div>
		</form:form>
			
	
</body>
</html>

