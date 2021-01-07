package Assignment12new;

public class MenuController {
    private static MenuController instance = null;

    public MenuController() {
    }

    public synchronized static MenuController getInstance() {
        if (instance == null){
            instance = new MenuController();
        }
        return instance;
    }

    public void showMenu(){
        System.out.println("==============Enter electricity bill payment information==============="); //Menu nhập hóa đơn tiền điện khách hàng
        System.out.println("1.Enter information of Vietnamese customers"); //khách trong ngước
        System.out.println("2.Call and collect a series of electricity bills from customers");// khách nước ngoài
        System.out.println("0.Finish importing changes to display"); //kết thúc phần nhập chuyển sang phần hiển thị
        System.out.println("========================================================================");
    }

    public void showMenuPay(){
        System.out.println("=======================Display customer information=====================");//menu hiển thị hóa đơn tiền điên khách hàng
        System.out.println("1.In the Customer details information and the moneyization information"); //hiển thị toàn bộ hóa đơn khách hàng (trong nước + nước ngoài)
        System.out.println("2.Enter information of foreign customers"); //hiển thị Só điện thoại sau lấy lại + số dư tk ngân hàng + số tiền điện phải đóng + số dư tk kh sau thanh toán + kiểm tra khách hàng có khả năng thanh toán hay ko
        System.out.println("3.Average revenue from foreign customers");//trung bình doanh thu từ khách hàng nước ngoài
        System.out.println("4.Back to the information entry page");//trở về Menu nhập Hóa đơn
        System.out.println("0.Exit the program");  //thoát chương trình
        System.out.println("========================================================================");
    }

    public void Exit(){
        System.out.println("GoodBye");
        System.exit(0);
    }

    public void InputInfoVn(){
        VNPerson vnPerson = new VNPerson();
        vnPerson.inputInfo();
        DataMrg.getInstance().getPeopleList().add(vnPerson);
        System.out.println("You have finished importing");
    }

    public void InputInfoFg(){
        FGPerson fgPerson = new FGPerson();
        fgPerson.inputInfo();
        DataMrg.getInstance().getPeopleList().add(fgPerson);
        System.out.println("You have finished importing");
    }

    public  void display(){
        System.out.println("Customers save detailed and electric bill information: ");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s",
                "Id", "Name", "Type", "Date", "Kw", "Phone Number", "Wallet", "Nation", "NationalId", "Electric bill");
        System.out.println();
        for (Person person : DataMrg.getInstance().getPeopleList()) {
            person.display();
            person.invoice();
            System.out.println();
        }
    }

    public void displayPay(){
        System.out.printf("%-20s %-20s %-20s %-20s %-20s", "PhoneNumber", "Wallet", "Invoice", "Pay", "Result");
        System.out.println(" ");
        for (Person person : DataMrg.getInstance().getPeopleList()) {
            person.displayPay();
            System.out.println(" ");
        }
    }

    public void total(){
        System.out.println("Average revenue from foreign customers.");
        float averageRevenue;
        float sum = 0;
        int count = 0;
        for (Person person : DataMrg.getInstance().getPeopleList()) {
            if (person.retrievePhoneNumber().contains("+00")) {
                sum += person.invoice();
                count++;
            }
        }
        if (count != 0) {
            averageRevenue = sum / count;
            System.out.println("Total: " + averageRevenue);
        } else {
            System.err.println("Does not exist outside the row");
        }
    }
}
