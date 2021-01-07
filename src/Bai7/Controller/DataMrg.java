/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai7.Controller;

import Bai7.Model.ISchool;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DataMrg {
    List<ISchool> iSchoolList;
    private static DataMrg instance = null;
       
        private DataMrg(){
            iSchoolList = new ArrayList<>();
        }
        public synchronized static DataMrg getInstance() {
            if (instance == null){
                instance = new DataMrg();
            }
            return instance;
        }

    public List<ISchool> getiSchoolList() {
        return iSchoolList;
    }
}
