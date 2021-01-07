/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7.international;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Admin
 */
public class demo {
    public static void main(String[] args) {
        String lang = "vi";
        String country = "VN";
        
        Locale locale = new Locale(lang, country);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("MessagesBundle", locale);
        String hello = resourceBundle.getString("greetings");
        System.out.println(hello);
    }
}
