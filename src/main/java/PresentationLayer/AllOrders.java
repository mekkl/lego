/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Entities.OrderObject;
import FunctionLayer.Facades.OrderFacade;
import FunctionLayer.LegoException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ML
 */
public class AllOrders extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoException {
        HttpSession session = request.getSession();
        
        List<OrderObject> orders = OrderFacade.viewOrders();
        
        request.setAttribute("orders", orders);
        
        return "allorderspage";
    }
    
}
