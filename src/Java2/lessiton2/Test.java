package Java2.lessiton2;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        //Gênreric cách tạo
       Controller<Student> controller = new Controller<>();
       controller.add(new Student("R3", "BTS"));
       controller.add(new Student("R4", "NQV"));
        System.out.println(controller.get(0).rollNo);
    }
}
