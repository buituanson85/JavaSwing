package JavaII.Assignment3;

import java.util.Scanner;

public class TestFlashLamp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Battery battery = new Battery();
        FlashLamp flashLamp = new FlashLamp();
        flashLamp.setBattery(battery);
        System.out.println("Nhập năng lượng theo loại pin lắp vào: ");
        int n = Integer.parseInt(sc.nextLine());
        battery.setEnergy(n);
        System.out.println("Nhập số lần tắt bật đèn: ");
        int _n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < _n; i++){
            flashLamp.turnOn();
            flashLamp.turnOff();
            System.out.println("Năng lượng còn lại trong pin:" + flashLamp.getBatteryInfo());
        }
    }
}
