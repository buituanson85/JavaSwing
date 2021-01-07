
package Assignment7_JFF.Model;

public class Mark extends Programa{
    private String idStudent;
    private String idSub;
    private String idSem;
    private float pga;
    private String nameStudent;
    private String nameClass;
    private String nameSem;
    private String nameSub;
    private String dateSem;

    public Mark( String nameClass, String idStudent, String nameStudent, float pga, String nameSub, String nameSem, String dateSem) {
        this.idStudent = idStudent;
        this.pga = pga;
        this.nameStudent = nameStudent;
        this.nameClass = nameClass;
        this.nameSem = nameSem;
        this.nameSub = nameSub;
        this.dateSem = dateSem;
    }
    
    public Mark() {
    }

    public Mark(String idStudent, String idSub, String idSem, float pga) {
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

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getNameSem() {
        return nameSem;
    }

    public void setNameSem(String nameSem) {
        this.nameSem = nameSem;
    }

    public String getNameSub() {
        return nameSub;
    }

    public void setNameSub(String nameSub) {
        this.nameSub = nameSub;
    }

    public String getDateSem() {
        return dateSem;
    }

    public void setDateSem(String dateSem) {
        this.dateSem = dateSem;
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
