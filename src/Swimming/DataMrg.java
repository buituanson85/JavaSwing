/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swimming;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DataMrg {
    List<Simmingpool> simmingpools;
    private static DataMrg instance = null;
       
        private DataMrg(){
            simmingpools = new ArrayList<>();
        }
        public synchronized static DataMrg getInstance() {
            if (instance == null){
                instance = new DataMrg();
            }
            return instance;
        }

    public List<Simmingpool> getSimmingpools() {
        return simmingpools;
    }
}
