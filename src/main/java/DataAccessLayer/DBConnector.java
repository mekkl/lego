/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ML
 */
public class DBConnector {
    private static final String url = "jdbc:mysql://46.101.253.149:3306/useradmin";
    private static final String username = "doorkeeper";
    private static final String password = "bank3*andyouarein";

    private static Connection connection;

    public static Connection connection() throws ClassNotFoundException, SQLException  {
        if ( connection == null ) {
            Class.forName( "com.mysql.jdbc.Driver" );
            connection = DriverManager.getConnection( url, username, password );
        }
        return connection;
    }
}
