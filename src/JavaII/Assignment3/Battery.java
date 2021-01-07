package JavaII.Assignment3;

public class Battery {
    int energy;

    Battery() {
        this.energy = 10;
    }

     int getEnergy() {
        return energy;
    }

     void setEnergy(int energy) {
        this.energy = energy;
    }

    void decreaseEnergy(){
        energy -= 2;
    }
}
