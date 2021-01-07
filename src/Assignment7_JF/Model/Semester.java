/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7_JF.Model;
import java.util.regex.Pattern;
/**
 *
 * @author Admin
 */
public class Semester extends Programa implements ISchool{
    private String dateSem;

    public Semester() {
    }

    public Semester(String dateSem) {
        this.dateSem = dateSem;
    }

    public Semester(String id, String name,String dateSem) {
        super(id, name);
        this.dateSem = dateSem;
    }

    public String getDateSem() {
        return dateSem;
    }

    public void setDateSem(String dateSem) {
        this.dateSem = dateSem;
    }

    @Override
    public boolean checkValidateRollNo(String id) {
        String patterm = "[H][K][0-9]{3}";
        boolean matches = Pattern.matches(patterm, id);
        return matches;
    }

    @Override
    public boolean checkName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
