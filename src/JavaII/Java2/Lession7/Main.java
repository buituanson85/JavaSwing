package JavaII.Java2.Lession7;

public class Main {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        ThreadOne threadOne = new ThreadOne(sharedData);
        ThreadTwo threadTwo = new ThreadTwo(sharedData);
        ThreadThree threadThree = new ThreadThree(sharedData);

        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}
