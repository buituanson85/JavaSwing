
package Assignment7_JFF.Model;

import java.util.regex.Pattern;

public class Student extends Programa{
    private int ageStudent;
    private String dateStudent;
    private String genderStudent;
    private String addressStudent;
    private String phoneStudent;
    private String idClass;
    private String nameClass;

    public Student() {
    }

    public Student(String id, String name, int ageStudent, String dateStudent, String genderStudent, String addressStudent, String phoneStudent, String idClass, String nameClass) {
        super(id, name);
        this.ageStudent = ageStudent;
        this.dateStudent = dateStudent;
        this.genderStudent = genderStudent;
        this.addressStudent = addressStudent;
        this.phoneStudent = phoneStudent;
        this.idClass = idClass;
        this.nameClass = nameClass;
    }

    public Student(String id, String name, int ageStudent, String dateStudent, String genderStudent, String addressStudent, String phoneStudent, String nameClass) {
        super(id, name);
        this.ageStudent = ageStudent;
        this.dateStudent = dateStudent;
        this.genderStudent = genderStudent;
        this.addressStudent = addressStudent;
        this.phoneStudent = phoneStudent;
        this.nameClass = nameClass;
    }

    public int getAgeStudent() {
        return ageStudent;
    }

    public void setAgeStudent(int ageStudent) {
        this.ageStudent = ageStudent;
    }

    public String getDateStudent() {
        return dateStudent;
    }

    public void setDateStudent(String dateStudent) {
        this.dateStudent = dateStudent;
    }

    public String getGenderStudent() {
        return genderStudent;
    }

    public void setGenderStudent(String genderStudent) {
        this.genderStudent = genderStudent;
    }

    public String getAddressStudent() {
        return addressStudent;
    }

    public void setAddressStudent(String addressStudent) {
        this.addressStudent = addressStudent;
    }

    public String getPhoneStudent() {
        return phoneStudent;
    }

    public void setPhoneStudent(String phoneStudent) {
        this.phoneStudent = phoneStudent;
    }

    public String getIdClass() {
        return idClass;
    }

    public void setIdClass(String idClass) {
        this.idClass = idClass;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    

    @Override
    public boolean checkValidateRollNo(String id) {
        String patterm = "[F][P][T][0-9]{3}";
        boolean matches = Pattern.matches(patterm, id);
        return matches;
    }

    @Override
    public boolean checkName(String name) {
        return name.length() >= 2;
    }
}
