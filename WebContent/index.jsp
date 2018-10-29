<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.mysql.jdbc.PreparedStatement" %>
<%@page import="mvc.servlet.jsp.*" %>
   
   <%
   
   try{

		 Class.forName("com.mysql.jdbc.Driver");

	 	 Connection con=DriverManager.getConnection
	     ("jdbc:mysql://localhost/comp3095","root","");
	     PreparedStatement ps =(PreparedStatement) con.prepareStatement
	                             ("select * from posts order by id desc");
	         	         
	         ResultSet rs =ps.executeQuery();    	
	       
   
   %>
    


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>COMP3095 Assignment</title>
    
    <!-- Loading animation -->
    <script src="js/pace.min.js"></script>

    <!-- Bootstrap core CSS and Material Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/bootstrap-material-design.css" rel="stylesheet">
    <link href="css/ripples.min.css" rel="stylesheet">
    <link href="css/material-scrolltop.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/material-blog.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="navbar navbar-material-blog navbar-warning navbar-absolute-top navbar-overlay">

      <div class="navbar-image" style="background-image: url('img/fashion/unsplash-3.jpg');background-position: center 40%;"></div>

      <div class="navbar-wrapper container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.jsp"><i class="material-icons">&#xE871;</i> COMP3095 Blog</a>
        </div>
        <div class="navbar-collapse collapse navbar-responsive-collapse">
          <ul class="nav navbar-nav">
            <li class="active dropdown">
              <a href="#">Home <b class="caret"></b></a>
              
            </li>
            
            <li class="dropdown">
              <a href="#" data-target="#" class="dropdown-toggle" data-toggle="dropdown">Post <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="NewPost.jsp">Add New</a></li>
                <li><a href="index.jsp">List All</a></li>
              </ul>
            </li>
            
            
            
            
            
          </ul>
          <ul class="nav navbar-nav navbar-right">
          	<% if(session.getAttribute("UserId")==null) { %>
            	
            	<li><a href="login.jsp">Login</a></li>
            	<li><a href="registration.jsp">Register</a></li>
            	
            	<% } else { %>
            	
              	<li><a href="userprofile.jsp">Welcome ${firstname} !</a></li>
              	<li><a href="logout">Logout</a></li>
    			
    
            	
            	<% } %>
          </ul>
        </div>
      </div>
    </div>
   <div class="container blog-content">

      <div class="row">

        <div class="col-sm-12 blog-main">

          <div class="row">
          
          <% while(rs.next()){ %>
            <div class="col-sm-4">
              
              <section class="blog-post">
                <div class="panel panel-default">

                  
                  <div class="panel-body">
                    <div class="blog-post-meta">
                        <h2 class="blog-post-title"><%= rs.getString("title") %></h2>
                      
                      <span class="label label-light label-info">by <%=  Assets.UserName(rs.getInt("user")) %></span>
                      <span class="label label-light label-info"><%= rs.getDate("time") %></span>
                      <span class="label label-light label-info"><%= Assets.NoOfReplies(rs.getInt("id")) %> Replies</span>
                    </div>
                    <div class="blog-post-content">
                	
                      <p><%=  Assets.Trim(rs.getString("body"))       %></p>
                      <a class="btn btn-info" href='post.jsp?id=<%=rs.getInt("id") %>'>Read more</a>
                      <a class="blog-post-share pull-right" href="#">
                        <i class="material-icons">&#xE80D;</i>
                      </a>
                    </div>
                  </div>
                </div>
              </section><!-- /.blog-post -->
                        
             
            </div>
            
            <%} %>
           
          

        </div><!-- /.blog-main -->

      </div><!-- /.row -->

    </div><!-- /.container -->


    <footer class="blog-footer">

      <div id="links">
        <div class="container">
          <div class="row">
            <div class="col-sm-2">
            <i class="material-icons brand">&#xE871;</i>
            </div>

            <div class="col-sm-8 text-center offset">
              <ul class="list-inline">
                <li><a href="indexindex.jsp">Home</a></li>
                <li><a href="page-about.html">About</a></li>
                <li><a href="doc-buttons.html">Documentation</a></li>
                <li><a href="page-contact.html">Contact</a></li>
              </ul>
            </div>

            <div class="col-md-2 text-right offset">
              <ul class="list-inline">
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>

    </footer>

    <button class="material-scrolltop warning" type="button"></button>

    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/ripples.min.js"></script>
    <script src="js/material.min.js"></script>
    <script src="js/material-scrolltop.js"></script>
    <script src="js/main.js"></script>

    <script>
      $.material.init();
      $('body').materialScrollTop();
    </script>

  </body>
  
  <%
	 }catch(Exception e)
	      {  e.printStackTrace();

	      }  
  %>
</html>
