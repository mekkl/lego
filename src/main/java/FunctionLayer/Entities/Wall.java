/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer.Entities;

import FunctionLayer.LegoException;
import java.util.ArrayList;

/**
 *
 * @author ML
 */
public class Wall {
    int height;
    int length;
    ArrayList<WallLevel> wallLevel;
    private final int wallFrameObject; // 0 nothing, 1 door, 2 window
    
    
    public Wall(int height, int length, int wallFrameObject){
        this.wallLevel = new ArrayList<>();
        this.height = height;
        this.length = length;
        this.wallFrameObject = wallFrameObject; // <<<<<<< THROW ERROR IF WFO IS != 0-2
    }
    
    public void create() throws LegoException{
        WallLevel wl = new WallLevel(1,this.length,this.wallFrameObject);
        wl.create();
        wallLevel.add(wl);
        
        for (int i = 0; i < height - 1; i++) {
            wl = new WallLevel(i+2,this.length,this.wallFrameObject, this.wallLevel.get(i).bricks);
            wl.create();
            
            wallLevel.add(wl);
        }

    }

    @Override
    public String toString() {
        String returnString = "";
        
        for (int i = wallLevel.size()-1; i > -1; i--) {
            returnString += this.wallLevel.get(i).toString() + "\n";
        }
        
        return returnString;
    }
    
    
    
    

    
    
}
