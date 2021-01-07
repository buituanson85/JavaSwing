package JavaII.Assignment3;

public class FlashLamp {
    boolean status;
    Battery battery;

    FlashLamp() {
        status = false;
        battery = null;
    }

    int getBatteryInfo() {
        return battery.getEnergy();
    }

    void setBattery(Battery b) {
        this.battery = b;
    }

    void turnOn(){
        status = true;
        if (battery.getEnergy() > 0){
            System.out.println("Đèn sáng");
            battery.decreaseEnergy();
        }
    }

    void turnOff(){
        status = false;
            System.out.println("Đèn tắt");
    }
}

