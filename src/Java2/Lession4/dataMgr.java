package Java2.Lession4;

import java.util.ArrayList;
import java.util.List;

public class dataMgr {
    List<Student> studentList = null;
    private static dataMgr instance;

    public dataMgr() {
        studentList = new ArrayList<>();
    }

    public static synchronized dataMgr getInstance() {
        if (instance == null) {
            instance = new dataMgr();
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
