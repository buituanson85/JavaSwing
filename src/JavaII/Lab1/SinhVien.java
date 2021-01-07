package JavaII.Lab1;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private int id;
    private String name;

    public SinhVien(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public SinhVien() {
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
}
