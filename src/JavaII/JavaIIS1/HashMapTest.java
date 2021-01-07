package JavaII.JavaIIS1;

import java.util.Collection;
import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, EmployeeData> hashMap = new HashMap<>();

        EmployeeData e1 = new EmployeeData("A");
        hashMap.put("e1", e1);
        EmployeeData e2 = new EmployeeData("B");
        hashMap.put("e2", e2);

        Collection<EmployeeData> o = hashMap.values();
        o.iterator();
        System.out.println(hashMap.get("e1"));
        System.out.println(o.iterator().next());
    }
}
