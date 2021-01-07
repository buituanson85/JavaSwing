package JavaII.Lab3;

public class Test {
    public static void main(String[] args) {
        MultipleThreads m1 = new MultipleThreads();
        MultipleThreads m2 = new MultipleThreads();
        m1.setName("Son");
        m2.setName("thanh");
        m1.start();
        m2.start();
        System.out.println("Number of threads running: " + Thread.activeCount());
    }
}
