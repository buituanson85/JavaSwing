
package Assignment7_JFF.Model;

import java.util.regex.Pattern;

public class Subject extends Programa{

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
        return name.length() >= 1;
    }
}
