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
public class OrderObject {
    
    private int id;
    private int length;
    private int width;
    private int height;
    private String placed;
    private String shipped;
    private String user_email;

    public OrderObject(int length, int width, int height, String user_email) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.user_email = user_email;
    }
    
    public OrderObject(int length, int width, int height, String placed, String user_email) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.placed = placed;
        this.user_email = user_email;
    }
    
    public OrderObject(int length, int width, int height, String placed, String shipped, String user_email) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.placed = placed;
        this.shipped = shipped;
        this.user_email = user_email;
    }

    public int getId() {
        return id;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    
    public void setHeight(int height){
        this.height = height;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getPlaced() {
        return placed;
    }

    public String getShipped() {
        if (this.shipped == null) return "not shipped";
        return shipped;
    }

    public void setPlaced(String placed) {
        this.placed = placed;
    }

    public void setShipped(String shipped) {
        this.shipped = shipped;
    }
    
    
    
    public BoM[] getBoM() throws LegoException{
        BoM[] bom = new BoM[4];
        
        Wall wall1 = new Wall(this.height,this.length,1);
        Wall wall2 = new Wall(this.height,this.width,0);
        Wall wall3 = new Wall(this.height,this.length,2);
        Wall wall4 = new Wall(this.height,this.width,0);
        
        wall1.create();
        wall2.create();
        wall3.create();
        wall4.create();
        
        bom[0] = wall1.getBoM();
        bom[1] = wall2.getBoM();
        bom[2] = wall3.getBoM();
        bom[3] = wall4.getBoM();
        
        return bom;
    }
    
}
