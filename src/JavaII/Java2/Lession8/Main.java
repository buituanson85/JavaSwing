package JavaII.Java2.Lession8;

public class Main {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        ThreadOne threadOne = new ThreadOne(sharedData);
        ThreadTwo threadTwo = new ThreadTwo(sharedData);

        threadTwo.start();
        threadOne.start();

    }
}
