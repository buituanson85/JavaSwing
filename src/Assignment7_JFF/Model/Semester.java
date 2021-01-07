
package Assignment7_JFF.Model;
import java.util.regex.Pattern;

public class Semester extends Programa{
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
