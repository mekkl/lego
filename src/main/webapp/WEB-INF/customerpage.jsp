<%-- 
    Document   : coshome
    Created on : Oct 12, 2017, 7:36:27 PM
    Author     : Mellem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Customerpage</h1>
        
        <form name="order" action="FrontController" method="POST">
            <input type="hidden" name="command" value="order">
            
            Length:<br>
            <input type="number" name="length" value="0">
            <br>
            Width:<br>
            <input type="number" name="width" value="0">
            <br>
            Height:<br>
            <input type="number" name="height" value="0">
            <br>
            
            <input type="submit" value="Order">
        </form>

        <form name="myorders" action="FrontController" method="POST">
            <input type="hidden" name="command" value="myorders">

            <br>
            <br>
            <input type="submit" value="My Orders">
        </form>
        
    </body>
</html>
