<%@ page language="java" contentType="text/html; charset=UTF-8"
 import="java.util.*,com.mod.model.Mentor"    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
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
            width: 93%;
            margin-left: 45px;
           
            margin-top:80px;
        }
        .img {
            height: 50px;
            width: 80px;
            margin-top: 20px;
        }
        .ptext {
            margin-top: 60px;
        }
        .edit {
            width: 60px;
        }
.bords{
width:100%;
}
  .col {
            padding: 100px;
        }
.footer {
    width: auto;
    height: 50px;
    background-color:gray;
    bottom: 0;
    position: fixed;
}
    </style>
</head>
<body>

   <div class="head"><marquee>Mentor On Demand</marquee></div>
    <div class="bord"><br>

     
        <div class="topnav">
             <a  href="/searchMentor">Search Training</a>
          <a href="/searchMentorTime">Current Training</a>
          <a href="/adminmentorList">Completed Training</a>
          <a href="/mentorList">Search</a>
          <a href="login">Logout</a>
        </div><br>
     <br>  <h1 style="text-align:center">Mentor Details</h1><br><br>
<%
List mentorList=(List)request.getAttribute("mentorList");
System.out.println(mentorList);
%>
<div class="container">
                   
                     <br>
                     <section class="row">
                     <table>
                     <th style="padding-right:105px">Id</th>
                     <th style="padding-right:105px">Mentor Name</th>
                      <th style="padding-right:105px">Email</th>
                     <th style="padding-right:105px">Linkedln URL</th>
                     <th style="padding-right:105px">Contact Number</th>
                      <th style="padding-right:105px">Experience</th>
                       <th style="padding-right:105px">Tainings Completed</th>
                     
                     <% for(int i=0;i<mentorList.size();i++){
       Mentor e=(Mentor)mentorList.get(i);
       %>
    
           <tr> <td><p class="col-md-2 ptext"><%=e.getMentorId() %></p></td>
                           <td><p class="col-md-2 ptext"><%=e.getName() %></p></td>
                           <td><p class="col-md-2 ptext"><%=e.getEmail() %></p></td>
                           <td><p class="col-md-2 ptext"><%=e.getLinkedinUrl() %></p></td>
                           <td><p class="col-md-3 ptext"><%= e.getContactNumber() %></p></td>
                           <td><p class="col-md-3 ptext"><%= e.getExperience()%></p></td>
                           <td><p class="col-md-3 ptext"><%= e.getTrainingCompleted()%></p></td>
                           
                           </tr>
                           <% }%>
                           </table>
                     </section> 
              </div>
</body>
</html>