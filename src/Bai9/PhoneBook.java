package Bai9;

import java.util.ArrayList;
import java.util.Collections;

public class PhoneBook extends Phone
        implements Comparable<PhoneBook> {
    private String name;
    private String phone;

    public PhoneBook() {
    }

    public PhoneBook(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    ArrayList phoneList = new ArrayList();

    @Override
    void insertPhone(String name, String phone) {
        boolean checktrung = false;
        for(int i = 0; i < phoneList.size(); i++) {
            PhoneBook pb = (PhoneBook)phoneList.get(i);
            if(pb.name.equalsIgnoreCase(name)) {
                // trung ten co trong danh ba
                if(pb.phone.contains(phone)) {
                    // sdt da co --> ko lam gi
                    System.err.println("đã có số đt này");
                } else {
                    // sdt chua co, them vao duoi
                    pb.phone = pb.phone + ";" + phone;
                }
                checktrung = true;
                break;
            }
        }//end for
        if(checktrung == false) {
            // khong co nguoi trung ten trong db
            PhoneBook pb = new PhoneBook();
            pb.name = name;
            pb.phone = phone;
            phoneList.add(pb);
        }
        // ket thuc ham
    }

    @Override
    void removePhone(String name) {
        for(int i = 0; i < phoneList.size(); i++) {
            PhoneBook pb = (PhoneBook) phoneList.get(i);
            if (pb.name.equalsIgnoreCase(name)) {
                phoneList.remove(pb);
                break;
            }
        }
    }

    @Override
    void updatePhone(String name, String phone) {
        for(int i = 0; i < phoneList.size(); i++) {
            PhoneBook pb = (PhoneBook) phoneList.get(i);
            if (pb.name.equalsIgnoreCase(name)) {
                pb.phone = pb.phone + ";" + phone;
                break;
            }
        }
    }

    @Override
    void searchPhone(String name) {
        for(int i = 0; i < phoneList.size(); i++) {
            PhoneBook pb = (PhoneBook) phoneList.get(i);
            if (pb.name.equalsIgnoreCase(name)) {
                System.out.println(pb.phone);
                break;
            }
        }
    }

    @Override
    void sort() {
        //Collections.sort(phoneList);
        Collections.sort(phoneList,
                new PhoneBookSortPhone());
    }

    @Override
    public int compareTo(PhoneBook o) {
        return this.name.compareTo(o.name);
    }

    public String getPhone() {
        return phone;
    }


    public void show(){
        for(int i = 0; i < phoneList.size(); i++) {
            PhoneBook pb = (PhoneBook) phoneList.get(i);
            System.out.println(pb.name + " " + pb.phone);
        }
    }


}
