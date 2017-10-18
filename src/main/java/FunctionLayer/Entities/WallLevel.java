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
public class WallLevel {
    
    int level;
    ArrayList<Brick> bricks;
    ArrayList<Brick> underlyingBricks;
    int length;
    private final int wallFrameObject;

    public WallLevel(int level, int length, int wfo) throws LegoException {
        if (wfo < 0 || wfo > 2) throw new LegoException(" wallFrameObject must be bigger than or equal 0 and smaller than 3 ");
        if ((wfo == 1 || wfo == 2) && length < 8) throw new LegoException(" length of wall with window or door must be longer than 7 ");
        if ((wfo == 0) && length < 6) throw new LegoException(" length of wall without window or door must be longer than 5 ");
        
        this.level = level;
        this.bricks = new ArrayList();
        this.length = length;
        this.wallFrameObject = wfo; // <<<<<<< THROW ERROR IF WFO IS != 0-2
        this.underlyingBricks = null;
    }
    
    public WallLevel(int level, int length, int wfo, ArrayList<Brick> underlyingBricks) throws LegoException {
        if (wfo < 0 || wfo > 2) throw new LegoException(" wallFrameObject must be bigger than or equal 0 and smaller than 3 ");
        if (((wfo == 1 || wfo == 2) && length < 8)) throw new LegoException(" length of wall with window or door must be longer than 7 ");
        if ((wfo == 0) && length < 6) throw new LegoException(" length of wall without window or door must be longer than 5 ");
        
        this.level = level;
        this.bricks = new ArrayList();
        this.length = length;
        this.wallFrameObject = wfo; // <<<<<<< THROW ERROR IF WFO IS != 0-2
        this.underlyingBricks = underlyingBricks;
    }
    
    public void create(){
        this.bricks = new ArrayList<>();
        
        builtLevel(this.bricks);
    }
    
    // Recursive method
    private ArrayList<Brick> builtLevel(ArrayList<Brick> wall){
        boolean haveUnderLyingLevel;
        if (this.underlyingBricks == null) haveUnderLyingLevel = false;
        else haveUnderLyingLevel = true;
        
        int missingDots = length - bricks.size();

        if (missingDots == 0){
            return wall; // breaking out of recursion
        } else {
            if (wall.isEmpty()) {
                placeFirstBrick();
                placeDoor();
                placeWindow();
            } 
            else if ( !isLevelEven() && missingDots == 2){
                addEmptySpace();
            }
            else {
                addBrick(getBestBrick( haveUnderLyingLevel ));
            }
            // Recursion happends here
            builtLevel(wall);
        }
        return wall;
    }
    
    // should only happend for level 1-3
    private void placeDoor(){
        if (this.level < 4 && this.wallFrameObject == 1){
            if(isLevelEven()){
                this.addBrick(new Brick(2));
                this.addEmptySpace();
            } else {
                this.addEmptySpace();
                //this.addBrick(new Brick(2));
            }
        }
    }
    
    // should only happend for level 2-3
    private void placeWindow(){
        if (this.level < 4 && this.wallFrameObject == 2){
            if(isLevelEven()){
                this.addBrick(new Brick(2));
                this.addEmptySpace();
            } else if (!isLevelEven() && this.level > 1) {
                this.addEmptySpace();
                //this.addBrick(new Brick(2));
            }
        }
    }
    
    // same scenario for all levels
    private void placeFirstBrick(){
        if(isLevelEven()){
            this.addEmptySpace();
        } else {
            this.addBrick(new Brick(4));
        }
    }
    
    private boolean isLevelEven(){
        return level % 2 == 0;
    }
    
    private void addBrick( Brick brick ){
        for (int i = 0; i < brick.length(); i++) {
            this.bricks.add( brick );
        }
    }
    
    // size for empty space is 2
    private void addEmptySpace(){
        Brick emptySpace = new Brick(0);
        
        for (int i = 0; i < 2; i++) {
            this.bricks.add( emptySpace );
        }
    }
    
    private Brick getBestBrick(boolean fitUnderLyingLevel){
        int brickSize = 4;
        
        // calculating the length of the level to be filled with bricks
        int missingDots;
        if ( isLevelEven() ) missingDots = this.length - this.bricks.size();
        else missingDots = this.length - this.bricks.size() - 2;
        
        // fitting the brick to the end of the walllevel
        if (missingDots < 2) brickSize = 1;
        else if (missingDots < 4) brickSize = 2;

        if (fitUnderLyingLevel) brickSize = fitConnectedPattern(brickSize);

        return new Brick(brickSize);
    }
    
    private int fitConnectedPattern(int brickSize){
        int thisSize = this.bricks.size();
        int underSize = this.underlyingBricks.size();
        int size = brickSize;

        // the two underlying 'if' is testing if the bricksize should be minimized
        // so it would fit the connected pattern
        if (underSize > thisSize + size
                && this.underlyingBricks.get( thisSize + ( size - 1) ) != this.underlyingBricks.get( thisSize + size )
                && size == 4){
            size = 2;
        }
        if (underSize > thisSize + size
                && this.underlyingBricks.get( thisSize + ( size - 1) ) != this.underlyingBricks.get( thisSize + size )
                && size == 2){
            size = 1;
        }
        
        return size;
    }
    
    public BoM getBoM() throws LegoException{
        BoM mc = new BoM();
        Brick currBrick = null;
        
        for (Brick brick : bricks) {
            if (brick != currBrick && brick != null) {
                mc.autoIncr(brick.length());
                currBrick = brick;
            }
        }
        
        return mc;
    }
    
    @Override
    public String toString() {
        String returnString = "";
        
        for (Brick brick : bricks) {
            returnString += brick.length() + " ";
        }
        
        return returnString;
    }
    
    
}
