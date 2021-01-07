package JavaII.Assignment5.Controller;

import JavaII.Assignment5.Model.Employee;

import java.util.ArrayList;
import java.util.List;

public class DataMrg {
    private static DataMrg instance = null;
    List<Employee> employeeList;
    private DataMrg(){
        employeeList = new ArrayList<>();
    }

    public static DataMrg getInstance() {
        if (instance == null){
            instance = new DataMrg();
        }
        return instance;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
