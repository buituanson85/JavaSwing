/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gym;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DataMrg {
    List<IInputOutPut> iiopList;
    private static DataMrg instance = null;
       
        private DataMrg(){
            iiopList = new ArrayList<>();
        }
        public synchronized static DataMrg getInstance() {
            if (instance == null){
                instance = new DataMrg();
            }
            return instance;
        }
    public List<IInputOutPut> getIiopList() {
        return iiopList;
    } 
}
