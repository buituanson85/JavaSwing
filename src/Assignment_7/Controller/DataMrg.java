/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_7.Controller;

import Assignment_7.Model.Classs;
import Assignment_7.Model.Mark;
import Assignment_7.Model.Semester;
import Assignment_7.Model.Student;
import Assignment_7.Model.Subject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DataMrg {
    private static DataMrg instance = null;
        List<Classs> classList;
        List<Student> studentList;
        List<Semester> semesterList;
        List<Subject> subjectList;
        List<Mark> markList;
        private DataMrg(){
            classList = new ArrayList<>();
            studentList = new ArrayList<>();
            semesterList = new ArrayList<>();
            subjectList = new ArrayList<>();
            markList = new ArrayList<>();
        }

        public static DataMrg getInstance() {
            if (instance == null){
                instance = new DataMrg();
            }
            return instance;
        }

    public List<Classs> getClassList() {
        return classList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public List<Semester> getSemesterList() {
        return semesterList;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public List<Mark> getMarkList() {
        return markList;
    }

        
}
