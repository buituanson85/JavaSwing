package JavaII.BaiTap01;

import java.util.ArrayList;
import java.util.List;

public class StudentController<E extends Student> {
    List<E> arrayList;

    public StudentController() {
        this.arrayList = new ArrayList<>();
    }
    public void add(E e){
        arrayList.add(e);
    }

    public E get(int index){
        return arrayList.get(index);
    }
}
