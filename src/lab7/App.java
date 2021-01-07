/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Admin
 */
public class App {
    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.ITALY);
        Double d = 22222.222;
        String s = numberFormat.format(d);
        System.out.println(s);
    }
}
