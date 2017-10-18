/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer.Entities;

import FunctionLayer.LegoException;

/**
 *
 * @author ML
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // 
        Wall wall = new Wall(8,8,1);
        try{
        wall.create();
        }
        catch(LegoException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println(wall.wallLevel.get(4).getMatList().toString());
        
        System.out.println(wall);

//        WallLevel wl1 = new WallLevel(1,9,2);
//        wl1.create();
//        
//        WallLevel wl2 = new WallLevel(2,9,2,wl1.bricks);
//        wl2.create();
//        
//        WallLevel wl3 = new WallLevel(3,9,2,wl2.bricks);
//        wl3.create();
//        
//        WallLevel wl4 = new WallLevel(4,9,2,wl3.bricks);
//        wl4.create();
//        
//        WallLevel wl5 = new WallLevel(5,9,2,wl4.bricks);
//        wl5.create();
//        
//        WallLevel wl6 = new WallLevel(6,9,2,wl5.bricks);
//        wl6.create();
//        
//        System.out.println(wl6.toString());
//        System.out.println(wl5.toString());
//        System.out.println(wl4.toString());
//        System.out.println(wl3.toString());
//        System.out.println(wl2.toString());
//        System.out.println(wl1.toString());
        
        
    }
    
}
