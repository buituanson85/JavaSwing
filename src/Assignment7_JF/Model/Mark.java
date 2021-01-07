/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7_JF.Model;

import java.util.List;

/**
 *
 * @author Admin
 */
public class Mark implements ISchool{
    List<ISchool> isList;
    private String idStudent;
    private String idSub;
    private String idSem;
    private float pga;
    private String nameStudent;
    private String nameSub;
    private String nameSem;
    private String nameClass;
    private String dateSem;
    public Mark() {
    }

    public Mark(String idStudent, String idSub, String idSem, float pga) {
        this.idStudent = idStudent;
        this.idSub = idSub;
        this.idSem = idSem;
        this.pga = pga;
    }

    public Mark(String nameClass, String idStudent, String nameStudent, float pga, String idSub, String idSem) {
        this.idStudent = idStudent;
        this.idSub = idSub;
        this.idSem = idSem;
        this.pga = pga;
        this.nameStudent = nameStudent;
        this.nameClass = nameClass;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getIdSub() {
        return idSub;
    }

    public void setIdSub(String idSub) {
        this.idSub = idSub;
    }

    public String getIdSem() {
        return idSem;
    }

    public void setIdSem(String idSem) {
        this.idSem = idSem;
    }

    public float getPga() {
        return pga;
    }

    public void setPga(float pga) {
        this.pga = pga;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getNameSub() {
        return nameSub;
    }

    public void setNameSub(String nameSub) {
        this.nameSub = nameSub;
    }

    public String getNameSem() {
        return nameSem;
    }

    public void setNameSem(String nameSem) {
        this.nameSem = nameSem;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getDateSem() {
        return dateSem;
    }

    public void setDateSem(String dateSem) {
        this.dateSem = dateSem;
    }

    @Override
    public String toString() {
        return "Mark{" + "idStudent=" + idStudent + ", idSub=" + idSub + ", idSem=" + idSem + ", pga=" + pga + ", nameStudent=" + nameStudent + ", nameSub=" + nameSub + ", nameSem=" + nameSem + ", nameClass=" + nameClass + '}';
    }

    @Override
    public boolean checkValidateRollNo(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
