/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer.Facades;

import DataAccessLayer.OrderMapper;
import FunctionLayer.Entities.BoM;
import FunctionLayer.Entities.OrderObject;
import FunctionLayer.Entities.User;
import FunctionLayer.LegoException;

/**
 *
 * @author Mellem
 */
public class OrderFacade {
    
    public static OrderObject createOrder(int length, int width, int height, User user) throws LegoException{
        OrderObject order = new OrderObject(length,width,height,user.getEmail());
        
        order = OrderMapper.createOrder(order);
        
        return order;
    }
    
//    public static OrderObject shipOrder(int id){
//        OrderMapper.shipOrder(id);
//        
//        
//    }
    
    /**
     *
     * @param order
     * @return
     */
    public static BoM[] viewBoM(OrderObject order) throws LegoException{
        return order.getBoM();
    }
    
}
