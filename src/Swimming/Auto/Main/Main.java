package Swimming.Auto.Main;

import Swimming.Ticket;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++){
            Auto.autoGenerateCode();
            System.out.printf(Auto.code);
            System.out.println("");
        }
    }
}
