/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DataMrg {
    private static DataMrg instance = null;
        List<ISchool> isList;
        private DataMrg(){
            isList = new ArrayList<>();
        }

        public synchronized static DataMrg getInstance() {
            if (instance == null){
                instance = new DataMrg();
            }
            return instance;
        }

    public List<ISchool> getIsList() {
        return isList;
    }
}
