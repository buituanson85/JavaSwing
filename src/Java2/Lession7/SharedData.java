package Java2.Lession7;

public class SharedData {
    int rad;
    int total; // biến tổng <200
    // để xác định dược luồng 2 và luồng 3 được chạy sau khi luồng 1 mở trạng thái notyfiall ta khai báo một biến index với giá trị:
    // ThreadOne --> 1,ThreadTwo --> 2,ThreadThree --> 3
    int index;
    public SharedData() {
        total = 0;
        index = 1;
    }

    public int getRad() {
        return rad;
    }

    public void setRad(int rad) {
        this.rad = rad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public synchronized void plus(int values){
        total +=values;
    }

    public synchronized boolean checkAvaiable(){
        if (total >= 2000){
            return false;
        }
        return true;
    }

}
