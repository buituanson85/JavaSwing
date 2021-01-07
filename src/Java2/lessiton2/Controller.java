package Java2.lessiton2;

import java.util.ArrayList;

public class Controller<E extends People> {
    ArrayList<E> list = new ArrayList<>();

    public Controller() {
    }

    public void add(E e){
        list.add(e);
    }

    public E get(int index){
        return list.get(index);
    }

}
