package Java2.Lession3;

import java.util.Scanner;

public class Student {
    private String listName;
    private String author;
    private float price;
    private String dateTime;
    private String producer;

    public Student() {
    }

    public Student(String listName, String author, float price, String dateTime, String producer) {
        this.listName = listName;
        this.author = author;
        this.price = price;
        this.dateTime = dateTime;
        producer = producer;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        producer = producer;
    }

    @Override
    public String toString() {
        return "Student{" +
                "listName='" + listName + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", dateTime='" + dateTime + '\'' +
                ", Producer='" + producer + '\'' +
                '}';
    }

    public void input(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập tên sách: ");
        listName = sc.nextLine();

        System.out.println("Nhập tên tác giả");
        author = sc.nextLine();

        System.out.println("Nhập giá bán: ");
        price = Float.parseFloat(sc.nextLine());

        System.out.println("Ngày xuất bản: ");
        dateTime = sc.nextLine();

        System.out.println("Nhà xuất bản: ");
        producer = sc.nextLine();
    }

    public void display(){
        System.out.println(toString());
    }
}
