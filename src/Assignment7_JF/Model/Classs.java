
package Assignment7_JF.Model;

import java.util.regex.Pattern;

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
