<%-- 
    Document   : index
    Created on : 11-10-2017, 11:51:14
    Author     : ML
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form name="login" action="FrontController" method="POST">
            <input type="hidden" name="command" value="login">
            Email:<br>
            <input type="text" name="email" value="someone@nowhere.com">
            <br>
            Password:<br>
            <input type="password" name="password" value="sesam">
            <br>
            <input type="submit" value="Submit">
        </form>
        
    </body>
</html>
