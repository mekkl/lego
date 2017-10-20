<%-- 
    Document   : customerorderspage
    Created on : 18-10-2017, 21:03:31
    Author     : ML
--%>

<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Entities.OrderObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <titleage</title>
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <% List<OrderObject> orders = (List<OrderObject>)request.getAttribute("orders"); %>
        
        <h1>My Orders</h1>
        
        <table class="table table-bordered">
            <thead>
                <tr>
                  <th>ID</th>
                  <th>Length</th> 
                  <th>Width</th>
                  <th>Height</th>
                  <th>Placed</th>
                  <th>Shipped</th>
                  <th>Built of Material</th>
                </tr>
            </thead>
            <% for (OrderObject order : orders) { %>
            <tr>
                <form>
                    <input type="hidden" name="command" value="orderbom">
                    <input type="hidden" name="id" value="<%= order.getId() %>">
                    <% request.setAttribute("id", order.getId()); %>
                    <td> <%= order.getId() %> </td>
                    <td> <%= order.getLength() %> </td>
                    <td> <%= order.getWidth() %> </td>
                    <td> <%= order.getHeight() %> </td>
                    <td> <%= order.getPlaced() %> </td>
                    <td> <%= order.getShipped() %> </td>
                    <td ><input type="submit" value="View list"> </td>
                </form>
            </tr>

            <% } %>
        </table>
        
        <form name="home" action="FrontController" method="POST">
            <input type="hidden" name="command" value="home">

            <br>
            <br>
            <input type="submit" value="Home">
        </form>
        
    </body>
</html>
