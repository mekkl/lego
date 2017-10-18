/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer.Facades;

import DataAccessLayer.OrderMapper;
import FunctionLayer.Entities.OrderObject;
import FunctionLayer.Entities.User;
import FunctionLayer.LegoException;

/**
 *
 * @author Mellem
 */
public class OrderFacade {
    
    public OrderObject createOrder(int length, int width, User user) throws LegoException{
        OrderObject order = new OrderObject(length,width,user.getEmail());
        
        OrderMapper.createOrder(order);
        
        return order;
    }
    
}
