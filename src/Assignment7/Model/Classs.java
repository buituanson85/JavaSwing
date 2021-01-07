/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7.Model;

import java.util.regex.Pattern;


/**
 *
 * @author Admin
 */
public class Classs extends Programa implements ISchool{
    public Classs() {
    }

    public Classs(String id, String name) {
        super(id, name);
    }

    @Override
    public boolean checkValidateRollNo(String id) {
        String patterm = "[S][V][0-9]{3}";
        boolean matches = Pattern.matches(patterm, id);
        return matches;
    }
    @Override
    public boolean checkName(String name){
        String _patterm = "[CTS][0-9]{4}[E]";
        boolean _matches = Pattern.matches(_patterm, name);
        return _matches;
    }
}
