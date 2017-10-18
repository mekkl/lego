/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author ML
 */
public class Brick {
    
    private final int length;
    private final int width = 2;

    Brick(int length){
        this.length = length;
    }
    
    public int length(){
        return length;
    }
}
