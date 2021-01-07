package Assignment12new;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public abstract class Person implements IElectricity {
    private enum TYPE{ //đối tượng khách hàng (sinh hoạt, kinh doanh, sản xuất)
        Living, Business, Manufacturing
    }

    final int price = 1500;
    final int quota = 100;
    private int id; //mã khách hàng
    private String name;
    private Date date;//ngày ra hóa đơn
    TYPE type;
    private float kw; //số lượng điện tiêu thụ
    private String phone;//phoneNumber
    private double wallet;

    public Person() {
    }

    public Person(int id, String name, Date date, TYPE type, float kw, String phone, double wallet) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.type = type;
        this.kw = kw;
        this.phone = phone;
        this.wallet = wallet;
    }

    public int getId() {
        return id;
    }

    public boolean setId(int id) {
        if (id > 0 ){
            this.id = id;
            return true;
        }else {
            System.err.println("Id is positive integer");
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if (name!= null && !name.contains(" ") && !name.isEmpty()){
            this.name = name;
            return true;
        }else {
            System.err.println("You have not entered a customer name");
            return false;
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public float getKw() {
        return kw;
    }

    public boolean setKw(float kw) {
        if (kw > 0){
            this.kw = kw;
            return true;
        }else {
            System.err.println("The electricity consumed must be greater than zero");
            return false;
        }
    }

    public String getPhone() {
        return phone;
    }

    public boolean setPhone(String phone) {
        if (phone.length() == 10 && !phone.contains(" ")){
            this.phone = phone;
            return true;
        }else {
            System.err.println("Phone number must enter 10 full numbers");
            return false;
        }
    }

    public double getWallet() {
        return wallet;
    }

    public boolean setWallet(double wallet) {
        if (wallet >= 0){
            this.wallet = wallet;
            return true;
        }else {
            System.err.println("The account balance must be greater than zero");
            return false;
        }
    }
    //Tạo hàm nhập thông tin khách hàng.

    public void inputInfo(){
        List<Person> peopleList = DataMrg.getInstance().getPeopleList();
        Scanner sc = new Scanner(System.in);
    //validate  ko được phép nhập trùng id.,nhập số nguyên dương
        System.out.println("Enter the customer id: ");
            while (true){
                int _id;
                while (true){
                    while (true){
                        try {
                            _id = Integer.parseInt(sc.nextLine());
                            break;
                        }catch(NumberFormatException e){
                            System.err.println("ID must be number !!!");
                        }
                        catch (Exception e) {
                            System.out.println(e.getMessage());
                            sc = new Scanner(System.in);
                        }
                    }
                    boolean check = setId(_id);
                    if (check){
                        break;
                    }
                }
                boolean isFind = false;
                for (Person person : peopleList) {
                    if (_id == person.getId()) {
                        isFind = true;
                        break;
                    }
                }
                if (!isFind){
                    break;
                }else {
                    System.err.println("Id already exists.");
                }
            }
        // y/c nhập tên ko có khoảng trắng và giá trị null
        System.out.println("Enter the customer name: ");
            while (true){
                String _name = sc.nextLine();
                boolean check = setName(_name);
                if (check){
                    break;
                }
            }

            //nhập định dạng dưới dạng MM//dd//yyyy
            //        System.out.println("Enter the invoice date: ");
            //            while (true){
            //                try {
            //                    date = sc.nextLine();
            //                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            //                    sdf.parse(date);
            //                    break;
            //                }catch(NumberFormatException e){
            //                    System.err.println(e.getMessage());
            //                }
            //                catch (Exception e) {
            //                    System.err.println("Input MM/dd/yyyy.");
            //                    sc = new Scanner(System.in);
            //                }
            //            }

        //type: đối tượng khách hàng (sinh hoạt, kinh doanh, sản xuất)
        System.out.println("Enter the customer audience: ");
            System.out.println("1.Enter living");
            System.out.println("2.Enter Business");
            System.out.println("3.Enter Manufacturing");
            System.out.println("Choose: ");
        int choose;
        while (true){
            try {
                choose = Integer.parseInt(sc.nextLine());
                break;
            }catch(NumberFormatException e){
                System.err.println("Choose must be number !!!");
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
                sc = new Scanner(System.in);
            }
        }
//        switch (choose) {
//            case 1 -> type = TYPE.Living;
//            case 2 -> type = TYPE.Business;
//            default -> type = TYPE.Manufacturing;
//        }
        // số điện tiêu thụ nhập phải >0 và không được phép nhập ký tự (nhập số)
        System.out.println("Enter the electricity consumed: ");
        while (true){
            float _kw;  //biến chung gian kiểm tra true mới truyền vào setkw
            while (true){
                try{
                    _kw = Float.parseFloat(sc.nextLine());
                    break;
                } catch (Exception e){
                    System.err.println("Enter the float");
                }
            }
            boolean check = setKw(_kw);
            if (check){
                break;
            }
        }
        //y/c Nhập đủ 10 số.
        System.out.println("Enter your phone number: ");
        //        while (!setPhone(sc.nextLine()));
        while (true){
            String _phone = sc.nextLine();
            boolean check = setPhone(_phone);
            if (check){
                break;
            }
        }
        //Số dư trong tk luôn >=0 và ko nhập ký tự;
        System.out.println("The amount in the account: ");

        while (true){
            double _wallet;
            while (true){
                try {
                    _wallet = Double.parseDouble(sc.nextLine());
                    break;
                } catch (Exception e){
                    System.err.println("Enter the integer");
                }
            }
            boolean check = setWallet(_wallet);
            if (check){
                break;
            }
        }

        date = new Date();
    }
    //hàm tự động lấy thời gian tại thời điểm tạo hóa đơn thanh toán
    public String getDateString(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(date);
    }

    //Tạo hàm hiển thị
    public void display(){
        System.out.printf("%-20d %-20s %-20s %-20s %-20f %-20s %-20f", id, name, type, getDateString(), kw, phone, wallet);
    }

    public abstract void displayPay();

}
