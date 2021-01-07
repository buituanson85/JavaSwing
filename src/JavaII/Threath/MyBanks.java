package JavaII.Threath;

public class MyBanks {
    int monney;

    public MyBanks(int monney) {
        this.monney = monney;
    }

    public MyBanks() {
    }

    public int getMonney() {
        return monney;
    }

    public void setMonney(int monney) {
        this.monney = monney;
    }

    public synchronized void withDraw(int monney,String threadName){
        if (monney <= this.monney){
            System.out.println("Số tiền cần rút: " + monney + ", Luồng: " + threadName);
            this.monney -= monney;
        }else {
            System.out.println("số tiền cần rút vượt quá số tiền hiện tại" + ", Luồng: " + threadName);
        }
        System.out.println("số tiền hiện tại:" + this.monney);
    }
}
