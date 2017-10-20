<%-- 
    Document   : orderpage
    Created on : Oct 12, 2017, 9:00:33 PM
    Author     : Mellem
--%>

<%@page import="FunctionLayer.Entities.BoM"%>
<%@page import="FunctionLayer.Entities.OrderObject"%>
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
        <% OrderObject oo = (OrderObject)request.getAttribute("order"); %>
        <% BoM[] bom = (BoM[])request.getAttribute("bom"); %>
        
        <% int w11 = bom[0].get1x2(); %>
        <% int w12 = bom[0].get2x2(); %>
        <% int w14 = bom[0].get4x2(); %>
        <% int w21 = bom[1].get1x2(); %>
        <% int w22 = bom[1].get2x2(); %>
        <% int w24 = bom[1].get4x2(); %>
        <% int w31 = bom[2].get1x2(); %>
        <% int w32 = bom[2].get2x2(); %>
        <% int w34 = bom[2].get4x2(); %>
        <% int w41 = bom[3].get1x2(); %>
        <% int w42 = bom[3].get2x2(); %>
        <% int w44 = bom[3].get4x2(); %>
        
        <h1> Order ID: <%= oo.getId() %> </h1>
        
        <table class="table table-bordered">
            <thead>
                <tr>
                  <th>Type</th>
                  <th>Wall 1</th> 
                  <th>Wall 2</th>
                  <th>Wall 3</th>
                  <th>Wall 4</th>
                  <th>Total</th>
                </tr>
            </thead>
            <tr>
              <td>2x4</td>
              <td> <%= w14 %> </td> 
              <td> <%= w24 %> </td> 
              <td> <%= w34 %> </td> 
              <td> <%= w44 %> </td> 
              <td> <%= w14 + w24 + w34 + w44%> </td> 
            </tr>
            <tr>
              <td>2x2</td>
              <td> <%= w12 %> </td> 
              <td> <%= w22 %> </td> 
              <td> <%= w32 %> </td> 
              <td> <%= w42 %> </td> 
              <td> <%= w12 + w22 + w32 + w42%> </td> 
            </tr>
            <tr>
              <td>2x1</td>
              <td> <%= w11 %> </td> 
              <td> <%= w21 %> </td> 
              <td> <%= w31 %> </td> 
              <td> <%= w41 %> </td> 
              <td> <%= w11 + w21 + w31 + w41%> </td> 
            </tr>
        </table>

        <form name="myorders" action="FrontController" method="POST">
            <input type="hidden" name="command" value="myorders">

            <br>
            <br>
            <input type="submit" value="My Orders">
        </form>
            
        <form name="home" action="FrontController" method="POST">
            <input type="hidden" name="command" value="home">

            <br>
            <br>
            <input type="submit" value="Home">
        </form>
            
    </body>
</html>
