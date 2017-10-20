/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Entities.BoM;
import FunctionLayer.Entities.OrderObject;
import FunctionLayer.Entities.User;
import FunctionLayer.Facades.OrderFacade;
import FunctionLayer.LegoException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mellem
 */
public class Order extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoException {

        int length = Integer.parseInt(request.getParameter( "length" ));
        int width = Integer.parseInt(request.getParameter( "width" ));
        int height = Integer.parseInt(request.getParameter( "height" ));
        
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute( "user" );
        
        OrderObject order = OrderFacade.createOrder(length, width, height, user);
        BoM[] bom = OrderFacade.viewBoM(order);
        
        request.setAttribute("order", order);
        request.setAttribute("bom", bom);
        
        return "bompage";
        
    }
    
}
