package JavaII.JavaIIS1;

public class EmployeeData {
    private String name;
    private float salary;

    public EmployeeData() {
    }

    public EmployeeData(String name){
        this.name = name;
        this.salary = 5600;
    }

    @Override
    public String toString() {
        return
                "[Name='" + name + '\'' +
                ", salary=" + salary +
                ']';
    }
}
