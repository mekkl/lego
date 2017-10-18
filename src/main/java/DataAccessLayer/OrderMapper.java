/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import FunctionLayer.LegoException;
import FunctionLayer.Entities.OrderObject;
import FunctionLayer.Entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ML
 */
public class OrderMapper {
    
    public static void createOrder( OrderObject order ) throws LegoException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "INSERT INTO lego.order (length,width,height,user_email) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, Integer.toString(order.getLength()) );
            ps.setString( 2, Integer.toString(order.getWidth()) );
            ps.setString( 3, Integer.toString(order.getHeight()) );
            ps.setString( 4, order.getUser_email() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            order.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LegoException( ex.getMessage() );
        }
    }
    
    public static List<OrderObject> getOrders( User user ) throws LegoException {
        try {
            List<OrderObject> orders = new ArrayList<>();
            Connection con = DBConnector.connection();
            String SQL = "SELECT * FROM user " + "WHERE email=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, user.getEmail() );
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
                int id = Integer.parseInt(rs.getString( "id" ));
                int length = Integer.parseInt(rs.getString( "length" ));
                int width = Integer.parseInt(rs.getString( "width" ));
                int height = Integer.parseInt(rs.getString( "height" ));
                String user_email  = (rs.getString( "user_email" ));
                OrderObject order = new OrderObject( length, width, height, user_email );
                order.setId(id);
                orders.add(order);
            }
            return orders;
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LegoException(ex.getMessage());
        }
    }
    
}
