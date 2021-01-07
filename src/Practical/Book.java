/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Book implements Serializable{
    private String id;
    private String title;
    private String Author;
    private String price;

    public Book() {
    }

    public Book(String id, String title, String Author, String price) {
        this.id = id;
        this.title = title;
        this.Author = Author;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void display(){
        System.out.printf("%-20s %-20s %-20s %-20s " , id , title , Author , price); 
        System.out.println("");
    }
}
