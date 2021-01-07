package Assignment5.Model;

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


}
