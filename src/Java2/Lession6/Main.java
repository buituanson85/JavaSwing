package Java2.Lession6;

public class Main {
    public static void main(String[] args) {
        //khởi tạo 3 luồng
        SharedData sharedData = new SharedData();

        ThreadOne threadOne = new ThreadOne(sharedData);
        ThreadTwo threadTwo = new ThreadTwo(sharedData);
        ThreadThree threadThree = new ThreadThree(sharedData);

        //cho 3 luông chạy
        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}
