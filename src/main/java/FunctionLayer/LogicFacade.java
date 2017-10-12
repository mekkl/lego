package FunctionLayer;

import DataAccessLayer.UserMapper;

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
