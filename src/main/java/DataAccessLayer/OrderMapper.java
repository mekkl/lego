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
    
    public static OrderObject createOrder( OrderObject o ) throws LegoException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "INSERT INTO lego.order (length,width,height,user_email) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, Integer.toString(o.getLength()) );
            ps.setString( 2, Integer.toString(o.getWidth()) );
            ps.setString( 3, Integer.toString(o.getHeight()) );
            ps.setString( 4, o.getUser_email() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            
            OrderObject order = new OrderObject(o.getLength(),o.getWidth(),o.getHeight(),o.getUser_email());

            order.setId( id );
            
            return order;
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LegoException( ex.getMessage() );
        }
    }
    
    public static List<OrderObject> getOrders() throws LegoException {
        try {
            List<OrderObject> orders = new ArrayList<>();
            Connection con = DBConnector.connection();
            String SQL = "SELECT * FROM lego.order ";
            PreparedStatement ps = con.prepareStatement( SQL );
            ResultSet rs = ps.executeQuery();

            while ( rs.next() ) {
                int id = rs.getInt("id");
                int length = rs.getInt("length" );
                int width = rs.getInt( "width" );
                int height = rs.getInt("height" );
                String placed = (rs.getString("placed"));
                String shipped = (rs.getString("shipped"));
                String user_email  = (rs.getString( "user_email" ));
                OrderObject order = new OrderObject( length, width, height, placed, shipped, user_email );
                order.setId(id);
                orders.add(order);
            }
            return orders;
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LegoException(ex.getMessage());
        }
    }
    
    public static List<OrderObject> getOrders( User user ) throws LegoException {
        try {
            List<OrderObject> orders = new ArrayList<>();
            Connection con = DBConnector.connection();
            String SQL = "SELECT * FROM lego.order " + "WHERE user_email = ? ";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, user.getEmail() );
            ResultSet rs = ps.executeQuery();

            while ( rs.next() ) {
                int id = rs.getInt("id");
                int length = rs.getInt("length" );
                int width = rs.getInt( "width" );
                int height = rs.getInt("height" );
                String placed = (rs.getString("placed"));
                String shipped = (rs.getString("shipped"));
                String user_email  = (rs.getString( "user_email" ));
                OrderObject order = new OrderObject( length, width, height, placed, shipped, user_email );
                order.setId(id);
                orders.add(order);
            }
            return orders;
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LegoException(ex.getMessage());
        }
    }

    public static void shipOrder(int orderID) throws LegoException{
        try {
            int id = orderID;
            Connection conn = DBConnector.connection();
            String sql = "UPDATE lego.order SET shipped = CURRENT_TIMESTAMP WHERE id = ?";
            PreparedStatement userPstmt = conn.prepareStatement(sql);
            userPstmt.setInt(1, id);
            userPstmt.executeUpdate();
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LegoException(ex.getMessage());
        }
    }

    public static OrderObject getOrder(int id) throws LegoException{
        try {
            Connection con = DBConnector.connection();
            String SQL = "SELECT * FROM lego.order " + "WHERE id = ? ";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt( 1, id);
            ResultSet rs = ps.executeQuery();

            if ( rs.next() ) {
                int length = rs.getInt("length" );
                int width = rs.getInt( "width" );
                int height = rs.getInt("height" );
                String placed = (rs.getString("placed"));
                String shipped = (rs.getString("shipped"));
                String user_email  = (rs.getString( "user_email" ));
                OrderObject order = new OrderObject( length, width, height, placed, shipped, user_email );
                order.setId(id);
                return order;
            } else {
                throw new LegoException(" No order with specified ID ");
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LegoException(ex.getMessage());
        }
    }
    
    public static boolean isShipped(int id) throws LegoException{
        try {
            Connection con = DBConnector.connection();
            String SQL = "SELECT shipped FROM lego.order " + "WHERE id = ? ";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt( 1, id);
            ResultSet rs = ps.executeQuery();

            if ( rs.next() ) {
                String shipped = (rs.getString("shipped"));
                return shipped != null;
            } else {
                throw new LegoException(" No order with specified ID ");
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LegoException(ex.getMessage());
        }
    }
    
}
