package PresentationLayer;

import FunctionLayer.Entities.OrderObject;
import FunctionLayer.Facades.LogicFacade;
import FunctionLayer.LegoException;
import FunctionLayer.Entities.User;
import FunctionLayer.Facades.OrderFacade;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 The purpose of Login is to...

 @author kasper
 */
public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LegoException {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        
        User user = LogicFacade.login( email, password );
        
        HttpSession session = request.getSession();
        session.setAttribute( "user", user );
        session.setAttribute( "role", user.getRole() );
        
        if (user.getRole().equals("employee")) {
            List<OrderObject> orders = OrderFacade.viewOrders();
            request.setAttribute("orders", orders);
        }
        
        return user.getRole() + "page";
    }

}
