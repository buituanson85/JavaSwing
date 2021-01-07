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
public class Subject extends Programa implements ISchool{

    public Subject() {
    }

    public Subject(String id, String name) {
        super(id, name);
    }

    @Override
    public boolean checkValidateRollNo(String id) {
        String patterm = "[M][H][0-9]{3}";
        boolean matches = Pattern.matches(patterm, id);
        return matches;
    }

    @Override
    public boolean checkName(String name) {
        if (name.length() > 4) {
            return true;
        }
        return false;
    }
}
