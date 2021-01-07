package Java2.Lession5;

public class Test {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        ThreadOne t1 = new ThreadOne(sharedData);
        ThreadTwo t2 = new ThreadTwo(sharedData);

        t1.start();
        t2.start();
    }
}
