<%-- 
    Document   : orderpage
    Created on : Oct 12, 2017, 9:00:33 PM
    Author     : Mellem
--%>

<%@page import="FunctionLayer.Entities.OrderObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% OrderObject oo = (OrderObject)request.getAttribute("order"); %>
        <% int w11 = oo.getBoM()[0].get1x2(); %>
        <% int w12 = oo.getBoM()[0].get2x2(); %>
        <% int w14 = oo.getBoM()[0].get4x2(); %>
        <% int w21 = oo.getBoM()[1].get1x2(); %>
        <% int w22 = oo.getBoM()[1].get2x2(); %>
        <% int w24 = oo.getBoM()[1].get4x2(); %>
        <% int w31 = oo.getBoM()[2].get1x2(); %>
        <% int w32 = oo.getBoM()[2].get2x2(); %>
        <% int w34 = oo.getBoM()[2].get4x2(); %>
        <% int w41 = oo.getBoM()[3].get1x2(); %>
        <% int w42 = oo.getBoM()[3].get2x2(); %>
        <% int w44 = oo.getBoM()[3].get4x2(); %>
        
        <table>
            <tr>
              <th>Type</th>
              <th>Wall 1</th> 
              <th>Wall 2</th>
              <th>Wall 3</th>
              <th>Wall 4</th>
              <th>Total</th>
            </tr>
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

            
    </body>
</html>
