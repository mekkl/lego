<%-- 
    Document   : emphome
    Created on : Oct 12, 2017, 7:36:11 PM
    Author     : Mellem
--%>

<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Entities.OrderObject"%>
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
        
        <% List<OrderObject> orders = (List<OrderObject>)request.getAttribute("orders"); %>
        
        <h1>All Orders</h1>
        
        <table class="table table-bordered">
            <thead>
                <tr>
                  <th>ID</th>
                  <th>Customer</th>
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
                
                    <% request.setAttribute("id", order.getId()); %>
                    <td> <%= order.getId() %> </td>
                    <td> <%= order.getUser_email() %> </td>
                    <td> <%= order.getLength() %> </td>
                    <td> <%= order.getWidth() %> </td>
                    <td> <%= order.getHeight() %> </td>
                    <td> <%= order.getPlaced() %> </td>
                    <% if (!order.getShipped().equals("not shipped")) { %>
                    <td> <%= order.getShipped() %> </td>
                    <% } else { %>
                    <form>
                        <input type="hidden" name="command" value="ship">
                        <input type="hidden" name="id" value="<%= order.getId() %>">
                        
                        <td > <input type="submit" value="Ship"> </td>
                    </form>
                    <% } %>
                    <form>
                        <input type="hidden" name="command" value="orderbom">
                        <input type="hidden" name="id" value="<%= order.getId() %>">
                        
                        <td ><input type="submit" value="View list"> </td>
                    </form>
            </tr>
            <% } %>
        </table>
        
    </body>
</html>
