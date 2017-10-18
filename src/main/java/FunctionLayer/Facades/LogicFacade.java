package FunctionLayer.Facades;

import DataAccessLayer.UserMapper;
import FunctionLayer.LegoException;
import FunctionLayer.Entities.User;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LegoException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LegoException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }

}
