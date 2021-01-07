/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DanhMucSanPham;

/**
 *
 * @author Admin
 */
public class Product {
    private int id;
    private String nameProduct;
    private int price;
    private String description;
    private int idCategory;
    private String categoryName;

    public Product() {
    }

    public Product(int id, String nameProduct, int price, String description, int idCategory, String categoryName) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.description = description;
        this.idCategory = idCategory;
        this.categoryName = categoryName;
    }

    public Product(int id, String nameProduct, int price, String description, int idCategory) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.description = description;
        this.idCategory = idCategory;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", nameProduct=" + nameProduct + ", price=" + price + ", description=" + description + ", idCategory=" + idCategory + ", categoryName=" + categoryName + '}';
    }
}
