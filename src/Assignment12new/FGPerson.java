package Assignment12new;

import java.util.Scanner;

public class FGPerson extends Person {
    private String nation;
    private String nationalId;

    public FGPerson() {
    }

    public String getNation() {
        return nation;
    }

    public boolean setNationalId(String nationalId) {
        if (nationalId!= null && !nationalId.contains(" ") && !nationalId.isEmpty()){
            this.nationalId = nationalId;
            return true;
        }else {
            System.err.println("You have not entered a customer nationaId");
            return false;
        }
    }

    public boolean setNation(String nation) {
        if (nation!= null && !nation.contains(" ") && !nation.isEmpty()){
            this.nation = nation;
            return true;
        }else {
            System.err.println("You have not entered a customer nation");
            return false;
        }
    }

    @Override
    public void inputInfo() {
        Scanner sc = new Scanner(System.in);

        super.inputInfo();
        System.out.println("Enter the country name: ");
        while (true){
            String _nation = sc.nextLine();
            boolean check = setNation(_nation);
            if (check){
                break;
            }
        }
        System.out.println("Enter the country code: ");
        while (true){
            String _nationalId = sc.nextLine();
            boolean check = setNationalId(_nationalId);
            if (check){
                break;
            }
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("%-20s %-20s", nation, nationalId);
        System.out.printf("%.2f", invoice());
    }

    @Override
    public float invoice() {
        if (getKw() <= quota){
            return (float)(getKw() * price * 2.5);
        }else {
            return (float)(price * quota + (getKw() - quota) * price * 1.5 * 2.5);
        }
    }

    @Override
    public float pay() {
        return (float) (getWallet() - invoice());
    }

    @Override
    public String retrievePhoneNumber() {
            return "+00" + getPhone();
    }

    //Hàm hiển thị Só điện thoại sau lấy lại + số tiền trong tk nh + số tiền điện + số dư tk sau thanh toán
    @Override
    public void displayPay(){
//        super.displayPay();
        System.out.printf("%-20s %-20f %-20f %-20f", retrievePhoneNumber(), getWallet(), invoice(), pay());
        if (pay() >=0){
            System.out.printf("%-20s","Payable account");
        }else {
            System.out.printf("%-20s", "The account does not have enough money");
        }
    }
}
