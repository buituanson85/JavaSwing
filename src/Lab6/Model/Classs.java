/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6.Model;

/**
 *
 * @author Admin
 */
public class Classs {
    private int idClass;
    private String nameClass;
    private int ageClass;

    public Classs() {
    }

    public Classs(int idClass, String nameClass, int ageClass) {
        this.idClass = idClass;
        this.nameClass = nameClass;
        this.ageClass = ageClass;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public int getAgeClass() {
        return ageClass;
    }

    public void setAgeClass(int ageClass) {
        this.ageClass = ageClass;
    }

    @Override
    public String toString() {
        return "Classs{" + "idClass=" + idClass + ", nameClass=" + nameClass + ", ageClass=" + ageClass + '}';
    }
    
}
