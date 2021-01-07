package Java2.File;

import java.io.Serializable;

public class Student implements Serializable {
    String fullName;
    String adress;

    public Student() {
    }

    public Student(String fullName, String adress) {
        this.fullName = fullName;
        this.adress = adress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getFileLineFormat(){
        return fullName + " , " + adress;
    }

    public static String getHeaderFormat(){
        return "fullName,address";
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
