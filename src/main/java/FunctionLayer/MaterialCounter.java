/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Mellem
 */
public class MaterialCounter {
    private int oneByTwo = 0, twoByTwo = 0, FourByTwo = 0;

    public int get1x2() {
        return oneByTwo;
    }

    public int get2x2() {
        return twoByTwo;
    }

    public int get4x2() {
        return FourByTwo;
    }

    public void incr1x2() {
        this.oneByTwo ++;
    }

    public void incr2x2() {
        this.twoByTwo ++;
    }

    public void incr4x2() {
        this.FourByTwo ++;
    }

    public void addToo1x2(int toAdd) {
        this.oneByTwo += toAdd;
    }

    public void addTo2x2(int toAdd) {
        this.twoByTwo += toAdd;
    }

    public void addTo4x2(int toAdd) {
        this.FourByTwo += toAdd;
    }
    
    public void autoIncr(int whatToIncr){
        switch (whatToIncr) {
            case 4:
                this.incr4x2();
                break;
            case 2:
                this.incr2x2();
                break;
            case 1:
                this.incr1x2();
                break;
            default:
                // THROW ERROR HERE! <<<<<<<<<<<<<<
        }
    }

    @Override
    public String toString() {
        return "MaterialCounter{" + "oneByTwo=" + oneByTwo + ", twoByTwo=" + twoByTwo + ", FourByTwo=" + FourByTwo + '}';
    }
    
    
    
    
}
