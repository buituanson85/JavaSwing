package JavaII.JavaIIS1;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("One");
        hashSet.add("Two");
        hashSet.add("Three");

        Iterator<String> it = hashSet.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
