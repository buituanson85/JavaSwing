package Assignment12new;

import java.util.ArrayList;
import java.util.List;

public class DataMrg {
    private static DataMrg instance = null;
    List<Person> peopleList;
    private DataMrg(){
        peopleList = new ArrayList<>();
    }

    public static DataMrg getInstance() {
        if (instance == null){
            instance = new DataMrg();
        }
        return instance;
    }

    public List<Person> getPeopleList() {
        return peopleList;
    }
}
