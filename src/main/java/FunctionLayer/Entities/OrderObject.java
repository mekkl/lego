/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer.Entities;


/**
 *
 * @author ML
 */
public class OrderObject {
    
    private int id;
    private int length;
    private int width;
    private String user_email;

    public OrderObject(int length, int width, String user_email) {
        this.length = length;
        this.width = width;
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

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
    
    
    
}
