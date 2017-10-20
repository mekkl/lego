<%-- 
    Document   : registerpage
    Created on : 20-10-2017, 14:24:37
    Author     : ML
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div style = "display: table; position: absolute; height: 100%; width: 100%;">
            <div style="border-bottom-width: 2px; padding: 10px; margin-top: 15%; margin-left: 37%;">
                
                <form name="register" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="register">
                    
                    <div class="input-group" style="margin: 10px; width: 30%; ">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                      <input id="email" type="email" class="form-control" name="email" placeholder="Email">
                    </div>
                    
                    <div class="input-group" style="margin: 10px; width: 30%; ">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                      <input id="password" type="password" class="form-control" name="password1" placeholder="Password">
                    </div>
                    
                    <div class="input-group" style="margin: 10px; width: 30%; ">
                      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                      <input id="password" type="password" class="form-control" name="password2" placeholder="Confirm Password">
                    </div>
                    
                    <input type="submit" class="btn btn-primary" value="register now" style="margin: 10px; width: 30%">
                    
                </form>
                
            </div>
        </div>
    </body>
</html>
