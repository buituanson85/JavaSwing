/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java2.FileII;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DataMgr {
    List<Student> studentList = null;
    private static DataMgr instance;

    public DataMgr() {
        studentList = new ArrayList<>();
    }

    public static synchronized DataMgr getInstance() {
        if (instance == null) {
            instance = new DataMgr();
        }
        return instance;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
