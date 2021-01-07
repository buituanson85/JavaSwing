package Java2.Lession5;

public class SharedData {
    public int x = 0;
    public int rad = 0;
    public synchronized void add(int plus){
        x += plus;
        System.out.println("\ndãy số x: " + x);
        for (int i = 0; i < x; i++){
            System.out.print(" " + i);
        }
    }
}
