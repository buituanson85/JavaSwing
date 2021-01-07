package JavaII.Assingment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee {
    private int id;
    private String name;
    private float salary;
    private float insurance;

    public Employee() {
    }

    public Employee(int id, String name, float salary, float insurance) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.insurance = insurance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getInsurance() {
        return insurance;
    }

    public void setInsurance(float insurance) {
        this.insurance = insurance;
    }

    public float CaculateSalaryOfMonth(int month,int numberOfDay){
        return (numberOfDay * salary * (1800000/22)) - insurance;
    }


    public static void main(String[] args) {
        List<Float> list = new ArrayList<>();
        List<Float> list1 = new ArrayList<>();
        Employee employee = new Employee(1, "Nguyễn văn Tèo", (float) 3.6, 500000);
        Employee employee1 = new Employee(2, "Nguyễn Văn Tí", (float) 5.1, 680000);
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số ngày làm việc trong 12 tháng của nhân viên " + employee.name);
        for (int i = 1; i <= 12; i++){
            System.out.format("Nhập tháng thứ %d", i);
            System.out.println(" ");
            int days = Integer.parseInt(sc.nextLine());
            float total = employee.CaculateSalaryOfMonth(i, days);
            list.add(total);
        }
        System.out.println("Nhập số ngày làm việc trong 12 tháng của nhân viên " + employee1.name);
        for (int i = 1; i <= 12; i++){
            System.out.format("Nhập tháng thứ %d", i);
            System.out.println(" ");
            int days = Integer.parseInt(sc.nextLine());
            float total2 = employee1.CaculateSalaryOfMonth(i, days);
            list1.add(total2);
        }
        System.out.println("Bảng lương nhân viên Tèo");
        System.out.println(list.toString());
        System.out.println("Bảng lương nhân viên Tý");
        System.out.println(list1.toString());
    }
}
