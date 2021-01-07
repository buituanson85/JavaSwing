/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7.Model;

/**
 *
 * @author Admin
 */
public class Mark2 implements ISchool{
    private String idStudent;
    private String idSub;
    private String idSem;
    private float pga;

    public Mark2() {
    }

    public Mark2(String idStudent, String idSub, String idSem, float pga) {
        this.idStudent = idStudent;
        this.idSub = idSub;
        this.idSem = idSem;
        this.pga = pga;
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

    @Override
    public boolean checkValidateRollNo(String id) {
        return true;
    }

    @Override
    public boolean checkName(String name) {
        return true;
    }
    
    
}
