package JavaII.Assingment3_co;

public class Student {
    private int id;
    private String name;
    private int age;

    private Classs classs;

    public Classs getClasss() {
        return classs;
    }

    public void setClasss(Classs classs) {
        this.classs = classs;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "[Student id: " + id
                + ", name: " + name
                + ", age: " + age + "]";
    }
}
